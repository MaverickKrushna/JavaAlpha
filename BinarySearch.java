package com.krushnaDSA;

public class BinarySearch {
    public static void bubbleSort(int array[]) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++)

            for (int j = 0; j < size - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }

    }
    public static int binarySearch(int array[] , int ele){


        int low = 0 ;
        int high = array.length -1 ;

       while (low<= high){
           int mid = (low +high )/ 2 ;
           if (array[mid]== ele){
               return  mid ;
           }
           else if (array[mid]< ele){
               low = mid+1 ;
           }
           else {
               high = mid-1 ;
           }
       }


        return  -1 ;
    }
    public static  void printArray(int array[]){
        for (int i =0 ; i < array.length ; i++){
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int element[] = {1,2,8,6,3,7,5,65,24,12,32,57,31,25,74,65,32,213,564,231,741,653,123} ;
        bubbleSort(element);
        printArray(element);

        System.out.println(binarySearch(element , 45612));
    }
}
