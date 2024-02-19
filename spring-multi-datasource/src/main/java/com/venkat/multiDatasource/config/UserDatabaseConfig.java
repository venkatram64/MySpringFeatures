package com.venkat.multiDatasource.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
        entityManagerFactoryRef = "userEntityManagerFactory",
        basePackages = {"com.venkat.multiDatasource.user.repository"},
        transactionManagerRef = "userTransactionManager"
)
public class UserDatabaseConfig {

    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    public DataSource userDataSource(){
        return DataSourceBuilder
                .create()
                .build();
    }

    @Bean(name="userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(@Qualifier("userDataSource") DataSource dataSource){

        Map<String,Object> properties = new HashMap<>();
        //if there is no table, table is created
        properties.put("hibernate.hbm2ddl.auto", "update");
        //properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.ejb.persistenceUnit", "user");
        properties.put("hibernate.ejb.persistenceProvider", "org.hibernate.jpa.HibernatePersistenceProvider");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaPropertyMap(properties);
        factoryBean.setPackagesToScan("com.venkat.multiDatasource.user");
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        //factoryBean.setPersistenceUnitName("user");

        return factoryBean;
    }

    @Bean(name = "userTransactionManager")
    public PlatformTransactionManager userTransactionManager(@Qualifier("userEntityManagerFactory")
                                                                 LocalContainerEntityManagerFactoryBean entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}
