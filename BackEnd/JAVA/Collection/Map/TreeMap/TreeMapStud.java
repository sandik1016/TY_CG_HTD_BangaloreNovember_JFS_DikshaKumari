package com.capgemin.map.TreeMap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapStud {

	public static void main(String[] args) {
		
		StudentName s2= new StudentName();
		TreeMap<Student,String> t1= new TreeMap<Student,String>(s2);//new StudentName() we can pass as refrence here
		t1.put(new Student("Miya",29),"1501292149");
		t1.put(new Student("divya",22),"1501292190");
		t1.put(new Student("Riya",25),"1501292167");
		t1.put(new Student("Piya",27),"1501292189");
		
		
		Set<Map.Entry<Student,String>> s1=t1.entrySet();
		for(Map.Entry<Student, String> e1:s1)
		{
			System.out.println(e1.getKey());
			System.out.println(e1.getValue());
			System.out.println("--------------------");
		}
		
        System.out.println(t1.get(new Student("Miya",29)));
	}

}
