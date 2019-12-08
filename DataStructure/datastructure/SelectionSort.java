package datastructure;

public class SelectionSort {
	void selectSort(int arr[]) {
		int n= arr.length;
		//one by one move boundary of unsorted subarray
		for(int i=0;i<n-1;i++) {
			int index =i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[index]) {
					index=j;
				}
			}
			int smallest =  arr[index];
			arr[index] = arr[i];
			arr[i] = smallest;
		}
	}
		

}
