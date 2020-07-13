package collections.arrays;

import java.util.Arrays;

//Given two unsorted arrays, find all pairs whose sum is x
/*
Input : arr1[] = {1, 2, 4, 5, 7} 
arr2[] = {5, 6, 3, 4, 8}  
x = 9
Output : 1 8
 4 5
 5 4*/
//https://www.geeksforgeeks.org/given-two-unsorted-arrays-find-pairs-whose-sum-x/
public class TwoArraysSum {

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 4, 5, 7, 0, 10 };
		int arr2[] = { 5, 6, 3, 4, 8, 9, -1, -2,-3 };
		int x = 9;

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int icount= arr1.length;
		int jcount=arr2.length;

		for (int i=0; i<icount; i++) {
			for (int j=jcount-1; j>=0; j--) { //reverse -- decending
				int s = arr1[i]+arr2[j];
				if(s<x) {
					System.out.println("--breaking loop at:"+arr1[i]+" -- "+arr2[j]);
					break;
				}
				if(s==x) {
					System.out.println(arr1[i]+" -- "+arr2[j]);
				}

			}
		}
	}

}
