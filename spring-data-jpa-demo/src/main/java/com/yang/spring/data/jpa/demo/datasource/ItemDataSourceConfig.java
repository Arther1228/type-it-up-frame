package com.yang.spring.data.jpa.demo.datasource;

import com.yang.spring.data.jpa.demo.config.MultipleDataSourceProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.yang.springdatajpademo.repository.item",
        entityManagerFactoryRef = "itemEntityManager",
        transactionManagerRef = "itemTransactionManager"
)
public class ItemDataSourceConfig {

    private final MultipleDataSourceProperties properties;

    public ItemDataSourceConfig(MultipleDataSourceProperties properties) {
        this.properties = properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean itemEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(itemDataSource());
        em.setPackagesToScan("com.yang.springdatajpademo.model");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(properties.getItem().getHibernate().getProperties());

        return em;
    }

    @Bean
    @ConfigurationProperties("multi-datasource.item")
    public DataSource itemDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public PlatformTransactionManager itemTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(itemEntityManager().getObject());
        return transactionManager;
    }
}