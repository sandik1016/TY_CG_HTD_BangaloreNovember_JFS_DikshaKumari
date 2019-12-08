  
 package com.capgemin.map.linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMap4 {

	public static void main(String[] args) {
		LinkedHashMap<Integer,Employee> l1=new LinkedHashMap<Integer,Employee>();
		l1.put(34, new Employee(230000,"Ramesh"));
		l1.put(56, new Employee(34000,"Divya"));
		l1.put(89, new Employee(560002,"Shree"));
		
		System.out.println(l1.get(56));
		
		Set<Map.Entry<Integer,Employee>> s1=l1.entrySet();
		for(Map.Entry<Integer,Employee> e1:s1) {
			System.out.println(e1.getKey());
			System.out.println(e1.getValue());
			System.out.println("----------------");
			
		}
		System.out.println(l1.containsKey(34));
		System.out.println(l1.containsValue(new Employee(3400000,"Divya")));
	}

}
