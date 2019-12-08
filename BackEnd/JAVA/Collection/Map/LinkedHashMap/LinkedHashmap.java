package com.capgemin.map.linkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.capgemin.map.hasmap.Student;

public class LinkedHashmap {
	public static void main(String[] args) {
		LinkedHashMap<String,Integer> l1=new LinkedHashMap<String,Integer>();
		l1.put("BTM",560089);
		l1.put("OAR", 560026);
		l1.put("BTR", 564099);
		l1.put("BTR", 564099);
		l1.put("BTR", null);
		l1.put(null, 564099);
		l1.put(null,null);
		l1.remove("BTM");
		Set<Map.Entry<String,Integer>> s1=l1.entrySet();
				for(Map.Entry<String, Integer> e1:s1) {
					
					System.out.println(e1.getKey());
					System.out.println(e1.getValue());
					System.out.println("-----------------");
				}
				System.out.println(l1.isEmpty());
				System.out.println(l1.size());
				System.out.println(l1.containsKey("Hebbal"));
				System.out.println(l1.containsValue(560026));
				Set<String> s2 = l1.keySet();
				for(String i1:s2) {
					System.out.println(i1);
					
				}

}
}
