package com.venkat.multiDatasource.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "postEntityManagerFactory",
        basePackages = {
                "com.venkat.multiDatasource.post.*",
                "com.venkat.multiDatasource.config"}
)
public class PostDatabaseConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.post")
    public DataSourceProperties postDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.post.hikari")
    public DataSource postDataSource(){
        return postDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }


    @Bean(name="postEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean postEntityManagerFactory(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(postDataSource())
                .packages("com.venkat.multiDatasource.post.*")
                .build();

    }

    @Bean(name = "postTransactionManager")
    @Primary
    public PlatformTransactionManager postTransactionManager(@Qualifier("postEntityManagerFactory")
                                                                 LocalContainerEntityManagerFactoryBean entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }

    @Bean(name = "postJdbcTemplate")
    @Primary
    public JdbcTemplate jdbcTemplate(@Qualifier("postDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(){
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }
}
