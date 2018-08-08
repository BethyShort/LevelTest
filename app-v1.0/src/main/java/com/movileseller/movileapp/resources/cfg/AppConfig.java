package com.movileseller.movileapp.resources.cfg;

import javax.sql.DataSource;

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
 * @author EXCC0100
 *
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.movilseller"})
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
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("ROJO@@soreldperez35");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ejemplos?verifyServerCertificate=false&useSSL=false&requireSSL=false"); 
        return dataSource;
    }
    
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
    	LocalEntityManagerFactoryBean emfb=new LocalEntityManagerFactoryBean();
    	emfb.setPersistenceUnitName("PhoneEntities");
    	return emfb;
    }
    
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//    	
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
////        factory.setPackagesToScan("com.movileseller.movileapp.layer.data.entities.jpa");
//        factory.setPackagesToScan("com.movileseller");        
//        factory.setDataSource(dataSource());
//        factory.afterPropertiesSet();
//        return factory.getObject();    	
//    }
    
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//      JpaTransactionManager txManager = new JpaTransactionManager();
//      txManager.setEntityManagerFactory(entityManagerFactoryBean());
//      return txManager;
//    }
}
