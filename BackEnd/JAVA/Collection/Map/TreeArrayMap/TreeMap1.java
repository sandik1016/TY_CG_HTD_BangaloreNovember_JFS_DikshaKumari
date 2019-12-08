package com.capgemin.map.TreeArrayMap;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {

	public static void main(String args[]) {
	TreeMap<String,ArrayList<Student>>  t1=new TreeMap<String,ArrayList<Student>>();
	ArrayList <Student> a1=new ArrayList<Student>();
	
			a1.add(new Student("divya",23));
			a1.add(new Student("hosur",27));
			a1.add(new Student("nenu",25));
			
			t1.put("eng 1st yr",a1);
			t1.put("eng 2nd yr",a1);
			t1.put("eng 3rd yr",a1);
			System.out.println(t1.get("eng 1st yr"));//a1 type we are passing and there are 3 objects output
			
			Set<Map.Entry<String, ArrayList<Student>>> s1= t1.entrySet();
			for(Map.Entry<String, ArrayList<Student>> entry:s1)
			{
				System.out.println(entry.getKey());
				System.out.println(entry.getValue());
				System.out.println("--------------------");
			}
			
	}

}
