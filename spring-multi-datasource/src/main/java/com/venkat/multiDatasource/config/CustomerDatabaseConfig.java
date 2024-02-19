package com.venkat.multiDatasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "customerEntityManagerFactory",
        basePackages = {"com.venkat.multiDatasource.customer.repository"},
        transactionManagerRef = "customerTransactionManager"
)
public class CustomerDatabaseConfig {

    @Primary
    @Bean(name = "customerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.customer")
    public DataSource customerDataSource(){
        return DataSourceBuilder
                .create()
                .build();
    }

    @Primary
    @Bean(name="customerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(@Qualifier("customerDataSource") DataSource dataSource){

        Map<String,Object> properties = new HashMap<>();
        //if there is no table, table is created
        properties.put("hibernate.hbm2ddl.auto", "update");
        //properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.ejb.persistenceUnit", "customer");
        properties.put("hibernate.ejb.persistenceProvider", "org.hibernate.jpa.HibernatePersistenceProvider");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaPropertyMap(properties);
        factoryBean.setPackagesToScan("com.venkat.multiDatasource.customer");
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        //factoryBean.setPersistenceUnitName("customer");
        return factoryBean;
    }

    @Primary
    @Bean(name = "customerTransactionManager")
    public PlatformTransactionManager customerTransactionManager(@Qualifier("customerEntityManagerFactory")
                                                                     LocalContainerEntityManagerFactoryBean entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}
