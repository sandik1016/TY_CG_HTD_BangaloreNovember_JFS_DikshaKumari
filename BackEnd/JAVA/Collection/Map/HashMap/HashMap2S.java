package com.capgemin.map.hasmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMap2S {

	public static void main(String[] args) {
		HashMap<Integer,Student> hs=new HashMap<Integer,Student>();
		hs.put(34,new Student(8,"suresh"));
		hs.put(45,new Student(4, "ramesh"));
		//hs.put(45,new Student(4, "ramesh"));//no duplicate key but duplicate value is allowed
		hs.put(null,new Student(45, "samush"));
		hs.put(34, new Student(89,"suresh"));
		//hs.put(null,new Student(4, "ramesh"));//only one null key but it may be more than one null value
		hs.put(null, null);
		Collection<Student> c1=hs.values();//key is unique and value is duplicated
		for(Student s1:c1) {
			System.out.println(s1);

		}
		System.out.println("------------------");
		Set<Integer> s1 = hs.keySet();
		for(Integer i1:s1) {
			System.out.println(i1);
			
		}
		
		System.out.println(hs.isEmpty());
		System.out.println(hs.size());
		System.out.println(hs.containsKey(34));
		System.out.println(hs.containsValue(new Student(22,"suresh")));

	}

}
