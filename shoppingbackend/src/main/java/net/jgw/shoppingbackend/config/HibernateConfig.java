package net.jgw.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/******
 * 
 * @author jgwilliams
 * @Configuration -Indicates that a class declares one or more @Bean methods and
 *                may be processed by the Spring container to generate bean
 *                definitions and service
 * @ComponentScan - Base packages to scan for annotated components
 * @EnableTransactionManagement - Enables Spring's annotation-driven transaction
 *                              management capability
 *******/

@Configuration
@ComponentScan(basePackages = { "net.jgw.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
    
	
	/*****
	 * configure the datasource for connection to the database
	 *****/
	@Bean
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();      
		datasource.setUrl(DATABASE_URL);
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);

		return datasource;
	}

	
	/*****
	 * configure the sessionfactory using the datasouce configured above
	 *****/
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getProperties());
		builder.scanPackages("net.jgw.shoppingbackend.dto");

		return builder.buildSessionFactory();
	}

	
	
    //set the hibernate properties we want to invoke	
	private Properties getProperties() {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);	
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);

		return properties;
	}
	
	
	/*****
	 * Needed inorder to use @transactional in the entity class
	 * The delegate the transaction management to the spring framework 
	 * using hibernate.
	 *****/
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	
	
	}


