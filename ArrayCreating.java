package com.krushnaDSA;

public class ArrayCreating {
    public  static  void swapNumber(int a , int b ){
        int temp ;
        temp =a ;
        a=b ;
        b=temp ;
    }
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

    public static  void printArray(int array[]){
        for (int i =0 ; i < array.length ; i++){
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }
    public  static  int largestNumber(int array []){
        int largest = Integer.MIN_VALUE ;
        for(int i=0 ; i < array.length ; i++ ){
            if(array[i]> largest){
                largest = array[i];
            }
        }
        return  largest ;
    }
    public static void main(String[] args) {
        // creating array
        // for maximum Integer.MIN
        int marks[] = new int[50];
        // dataType  arrayName [] = new dataType[size] ;
        int element[] = {1,2,8,6,3,7,5,65,24,12,32,57,31,25,74,65,32,213,564,231,741,653,123} ;
       bubbleSort(element);
//        printArray(element);
        System.out.println("The largest Number of the : " +largestNumber(element));


    }
}
