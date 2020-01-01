package com.capgemini.productspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ORMConfig {
@Bean
public LocalEntityManagerFactoryBean getLocalEntityManagerFactoryBean() {
	LocalEntityManagerFactoryBean  bean = new LocalEntityManagerFactoryBean();
	bean.setPersistenceUnitName("product-unit");//meeting point of hibernate and spring mvc
	return bean;
}

}
