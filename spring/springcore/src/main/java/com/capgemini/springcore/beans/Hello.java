package com.capgemini.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello implements InitializingBean,DisposableBean{
   private String msg;

public String getMsg() {
	return msg;
}

public Hello(String msg) {
	super();
	this.msg = msg;
}

public Hello() {
	System.out.println("object created");
}

public void setMsg(String msg) {
	this.msg = msg;
}
@PostConstruct
public void init() {
	System.out.println("init method");
}
@Override
@PreDestroy
public void destroy() {//it is for destroy
	System.out.println("destroy method");
}
@Override
	public void afterPropertiesSet() throws Exception {//this is for init 
		System.out.println("afterpropertiesset");
		
	}
}
