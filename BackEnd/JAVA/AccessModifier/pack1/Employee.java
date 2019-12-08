package com.tyss.access.pack1;

public class Employee {//default class is visible only inside the package
   String ename;
   public Employee(String ename){//default is not visible outside package
	   this.ename=ename;
   }
   void details() {
	   System.out.println(ename);
   }
}
