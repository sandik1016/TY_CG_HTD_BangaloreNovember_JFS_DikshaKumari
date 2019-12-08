package datastructure;

public class InsertionSort {
       
	void insertSort(int arr[]) {
		int n= arr.length;
		for(int i=1;i<n-1;i++) {
			int key =  arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
	}
}
