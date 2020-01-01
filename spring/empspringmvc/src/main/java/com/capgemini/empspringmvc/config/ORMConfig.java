package com.capgemini.empspringmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ORMConfig {
@Bean
public LocalEntityManagerFactoryBean getLocalEntityManagerFcatoryBean() {
	LocalEntityManagerFactoryBean  bean = new LocalEntityManagerFactoryBean();
	bean.setPersistenceUnitName("employee-unit");//meeting point of hibernate and spring mvc
	return bean;
}

}
