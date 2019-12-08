package com.capgemin.map.hasmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap1 {
	public static void main(String[] args) {
		HashMap<Integer,String> hs=new HashMap<Integer,String>();
		hs.put(8,"suresh");
		hs.put(4, "ramesh");
		hs.put(2, "dinesh");
		hs.put(6,"ganesh");
		hs.put(80, "dinesh");
		Set<Map.Entry<Integer,String>> s1=hs.entrySet();
		for(Map.Entry<Integer, String> e1:s1)
		{
			System.out.println(e1.getKey());
			System.out.println(e1.getValue());
			System.out.println("--------------------------");
			}
	}
	
}
