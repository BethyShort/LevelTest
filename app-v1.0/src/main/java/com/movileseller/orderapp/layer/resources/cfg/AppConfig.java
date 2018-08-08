package com.movileseller.orderapp.layer.resources.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * Spring configuration properties. 
 * Mainly database connection and persistence properties
 * 
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.movilseller"})
public class AppConfig {

	@Value("${database.driverClassName}")
	private String databaseDriver;

	@Value("${database.username}")
	private String databaseUser;

	@Value("${database.password}")
	private String databaseUserPassword;

	@Value("${database.url}")
	private String databaseUrl;
	
	@Value("${persistenceUnitName}")
	private String persistenceUnitName;
	/**
	 * 
	 * @return
	 */
    @Bean
    public PersistenceAnnotationBeanPostProcessor paPostProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();
    }
    
    /**
     * 
     * @return
     */
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseDriver);
        dataSource.setUsername(databaseUser);
        dataSource.setPassword(databaseUserPassword);
        dataSource.setUrl(databaseUrl); 
        return dataSource;
    }
    
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
    	LocalEntityManagerFactoryBean emfb=new LocalEntityManagerFactoryBean();
    	emfb.setPersistenceUnitName(persistenceUnitName);
    	return emfb;
    }
}
