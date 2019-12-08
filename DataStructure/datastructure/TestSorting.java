package datastructure;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;

public class TestSorting {

	public static void main(String[] args) {

		Scanner s =  new Scanner(System.in);
		BubbleSort b = new BubbleSort();
		SelectionSort s1 = new SelectionSort();
		InsertionSort i1 =  new InsertionSort();
		MergeSort m = new MergeSort();

		System.out.println("Enter the size of an array");
		int n = s.nextInt();
		int a[] =  new int[n];
		System.out.println("Enter the elements of an array");
		for(int i=0;i<a.length;i++)
		{
			a[i] = s.nextInt();

		}

		while(true) {


			System.out.println("Enter option for sorting");
			System.out.println("Press 1 for bubble sorting");
			System.out.println("Press 2 for insertion sorting");
			System.out.println("Press 3 for selection sorting");
			System.out.println("Press 4 for quick sorting");
			System.out.println("Press 5 for merge sorting");
			int choice = s.nextInt();
			switch(choice)
			{
			case 1: 
				Instant start = Instant.now();
				System.out.println("Bubble Sorting");
				b.bubbleSort(a);
				Instant end=Instant.now();
				long duration =Duration.between(start, end).toMillis();
				double seconds =duration / 1000.0;
				System.out.println("time atken to sort by bubble sort:"+seconds+"seconds");
				break;
			case 2:Instant start1 = Instant.now(); 
			System.out.println("Insertion Sorting");
			i1.insertSort(a);
			Instant end1=Instant.now();
			long duration1 =Duration.between(start1, end1).toMillis();
			double seconds1 =duration1 / 1000.0;
			System.out.println("time taken to sort by insertion sort:"+seconds1+"seconds");
			break;
			case 3:System.out.println("Selection Sorting");
			s1.selectSort(a);
			break;
			case 4:System.out.println("Quick Sorting");
			QuickSort.quickSort(a, 0, a.length);
			break;
			case 5:System.out.println("Merge Sorting");
			m.mergeSort(a, 0, a.length);
			break;
			default :System.out.println("Invalid Choice");


			}


			System.out.println("Sorted elements are : ");

			for(int i=0;i<a.length;i++)
			{
				System.out.print(a[i]+ " ");

			}


		}


	}




}


