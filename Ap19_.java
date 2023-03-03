package com.krushnaDSA;

public class Ap19_ {

// Merge SOrting O(nlongn)
    public static  void mergeSort(int arr[] , int start , int end ){
        if(end<= start){
            return;
        }

            int mid = start + (end - start)/2 ;
            // MergeSort left
            mergeSort(arr , start, mid);
            // MergeSort Right
            mergeSort(arr , mid+1 , end);
            // Merge the element
            merge(arr , start , mid , end );

    }
    // merge
    public  static  void merge(int arr[], int start , int mid , int end ){
        int temp[]= new int[end-start +1];
        int i = start ; // left iterator
        int j = mid+1 ;  // Right iterator
        int k = 0; // temp array iterator
        while (i<=mid && j<= end){
            if (arr[i]< arr[j]){
                temp[k]= arr[i];
                i++;
            }else{
                temp[k]= arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid ){
            temp[k++]= arr[i++];
                    }
        while (j<=end){
            temp[k++]= arr[j++];

        }
        for (k = 0 , i= start ; k< temp.length ; k++, i++){
            arr[i]=temp[k];
        }
    }


    // Quick Sort  O(nlogn)
     public static  void quickSort(int arr[], int start , int end  ){

        if (start>=end) {
            return;
        }
            int pI = patition(arr , start , end);
            quickSort(arr , start , pI-1);
            quickSort(arr, pI+1, end);


     }
     // paerition Index
    public static  int patition(int   arr[] , int start , int end  ){
        int pivot =arr[end];
        int i= (start -1 );
        for (int j=start ; j< end ; j++){
           if(arr[j]<=pivot){
               i++;
               int temp = arr[j];
               arr[j]= arr[i];
               arr[i]= temp ;
           }

        }
        i++;
        int temp = arr[i];
        arr[i]= arr[end];
        arr[end]= temp;

        return  i;

    }
   // Search in Rotated Sorted Array ___
    public static int searchRoted(int arr[], int target , int start , int end ){
        if (start> end){
            return -1 ;
        }
        int mid = start + (end - start )/2 ;
        if (arr[mid]== target){
            return mid ;

        }
        // Target in L1
        if(arr[start]<= arr[mid]){
            if(arr[start]<= target && target<= arr[mid]){
                return  searchRoted(arr, target, start , mid-1);
            }
            else{
                return searchRoted(arr , target , mid+1 , end);
            }
        }
        // Target in L2
        else{
            if (arr[mid]<=target && target <= arr[end]){
                return  searchRoted(arr , target , mid+1 , end);
            }
            else{
                return searchRoted(arr, target , start ,mid-1);
            }

        }

    }


    public static void main(String[] args) {
        int arr[]={1,5,6,8,2,4,3,8,56,1,52,36,48,364,45,2,345,11,22,33,42,32, -1,-2};
//        mergeSort(arr, 0, arr.length-1);
//        quickSort(arr, 0, arr.length-1);
//        for (int j : arr) {
//            System.out.print(j + " ");
//        }

        int roteredSortedArr[]={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(searchRoted(roteredSortedArr , target , 0 , roteredSortedArr.length-1));

    }
}
