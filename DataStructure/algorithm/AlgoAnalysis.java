package com.capgemini.dsa.algorithm;

import java.time.Duration;
import java.time.Instant;

public class AlgoAnalysis {
	public static void main(String[] args) {
		countingDuration2(); //it is best becoz it takes less time and less space
		countingDuration1();

	}
	public static long addUpto(Long number) {//1
		long total = 0L;//2
		for(long i=0;i<=number;i++) {//3
			total=total+i;//4

		}
		return total;//5 memory,<=,++,+  operation
	}
	public static long addUptoQuick(Long number)//1
	{
		return number*(number+1)/2;//*+/ operation
	}
	public static void countingDuration1() {
		long number=9999999L;
		Instant start = Instant.now();
		System.out.println("addUpto:"+addUpto(number));
		Instant end=Instant.now();
		long duration =Duration.between(start, end).toMillis();
		double seconds =duration / 1000.0;
		System.out.println("addUpto time:"+seconds+"seconds");

	}
	public static void countingDuration2() {
		long number=9999999L;
		Instant start = Instant.now();
		System.out.println("addUpto:"+addUptoQuick(number));
		Instant end=Instant.now();
		long duration =Duration.between(start, end).toMillis();
		double seconds =duration / 1000.0;
		System.out.println("addUptoQuick time:"+seconds+"seconds");

	}
	
	
}




