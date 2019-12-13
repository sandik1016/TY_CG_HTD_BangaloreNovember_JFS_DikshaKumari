package com.capgemini.junit.junit_five;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TestCalculator {
	Calculator c =null;
	
	@BeforeEach
	void createObject() {
		c= new Calculator();
	}
    @Test
    
	void myTest() {
		Calculator c= new Calculator();
		int i =c.add(10, 5);
		assertEquals(i,15 );
	}
    @Test
    void testAddForNegtve() {
    	Calculator c = new Calculator();
    	int i= c.add(-3, 5);
    	assertEquals(i,2);
    }
    @Test
    void testMultiply() {
    	Multiply m = new Multiply();
    	int i= m.multiply(-3, 8);
    	assertEquals(i,-24);
    }
    @Test
    void testDivision() {
    	Division d = new Division();
    	int i= d.division(45, 5);
    	assertEquals(i,9);
    }
    @Test
    void testDivisionWithArithmeticException() {
    	Division c= new Division();
    	assertThrows(ArithmeticException.class,
    			()->{
    				c.division(10, 0);
    			});
    }
   
@Test
    void testFindLength() {
    	FindLength c= new FindLength();
    	int res=c.findLength("piya");
    	assertEquals(4,res);
    }
    void testFindLengthForNull() {
    	FindLength c= new FindLength();
    	assertThrows(NullPointerException.class,
    			()->{
    				c.findLength(null);
    			});
    
    	
    }
}
