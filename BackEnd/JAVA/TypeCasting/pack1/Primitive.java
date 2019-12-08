package com.tyss.typecasting.pack1;

public class Primitive {
    byte a=4;
    short b=a;
    int c=b;
    float d=c;
    double f=d;
    void values()
    {
    	System.out.println("byte value is "+a);
    	System.out.println("short value is "+b);
    	System.out.println("int value is "+c);
    	System.out.println("float value is "+d);
    	System.out.println("double value is "+f);//implicit
    }
    double pi=3.142;
    int i=(int)pi;//explicit
    void details()
    {
    	
    	System.out.println("int value is "+i);
    	
    	System.out.println("double value is "+pi);
    }
}
