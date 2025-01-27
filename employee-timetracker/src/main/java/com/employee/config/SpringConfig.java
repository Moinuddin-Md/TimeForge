package com.employee.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.employee")
public class SpringConfig implements WebMvcConfigurer{

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	
		registry.addResourceHandler("/CSS/**").addResourceLocations("/CSS/");
		registry.addResourceHandler("/JS/**").addResourceLocations("/JS/");
	}
	
	private DriverManagerDataSource getDataSource() {
		DriverManagerDataSource source=new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/employeetimetracker?createDatabaseIfNotExist=true");
		source.setUsername("root");
		source.setPassword("root");
		return source;
	}
	
	private Properties getProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}
	
	@Bean
	LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(getProperties());
		factory.setPackagesToScan("com.employee.entities");
		return factory;
	}
	
	@Bean
	InternalResourceViewResolver getResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
