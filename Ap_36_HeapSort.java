package com.krushnaDSA;

public class Ap_36_HeapSort {
    // heapify ---
    public  static  void heapify(int arr[] , int i , int size ){
        int left = 2*i +1 ;
        int right = 2*i +2 ;
        int maxdInd = i ;
        if ((left < size) && (arr[maxdInd] < arr[left])){
            maxdInd= left ;
        }
        if ((right < size )&& (arr[maxdInd] < arr[left])){
            maxdInd =right ;
        }
        if (maxdInd!=i){
            int temp = arr[maxdInd];
            arr[maxdInd]=arr[left];
            arr[maxdInd]=temp;
            heapify(arr,maxdInd , size);
        }
    }


    public  static void heapSort(int arr[]){
        // step-1 build maxHeap
        int n= arr.length;
        for (int i=n/2 ; i>=0 ; i--){
            heapify(arr,i,n);
        }
        // step-2 push largest end
        for (int i=n-1 ; i>0 ; i--){
            int temp= arr[0];
            arr[0]= arr[i];
            arr[i]=temp ;
            heapify(arr, 0 , i);
        }

    }

    public static void main(String[] args) {
        int arr[]={2,5,6,7,3,14,23,56,12,10,45};
        heapSort(arr);
        for (int j: arr){
            System.out.print(j + " ");
        }

    }
}
