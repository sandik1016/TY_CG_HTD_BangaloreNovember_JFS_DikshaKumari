package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.Hello;

public class LifecycleTest {
public static void main(String[] args) {
	//ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");dont upcast change to classpath class because close() is present in classpath not in application interface
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Hello hello = context.getBean(Hello.class);
	System.out.println(hello.getMsg());
	context.close();
}
}
