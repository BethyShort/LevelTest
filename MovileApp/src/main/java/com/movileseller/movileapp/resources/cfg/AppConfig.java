package com.movileseller.movileapp.resources.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

/**
 * 
 * @author EXCC0100
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.movilseller", "com.movileSeller.MovileApp"})
public class AppConfig {

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
     
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUsername("mysqluser");
//        dataSource.setPassword("mysqlpass");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/myDb?createDatabaseIfNotExist=true"); 
         
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
       LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//       em.setDataSource(dataSource());
//       em.setPackagesToScan(new String[] { "org.baeldung.persistence.model" });
//  
//       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//       em.setJpaVendorAdapter(vendorAdapter);
//       em.setJpaProperties(additionalProperties());
  
       return em;
    }
}
