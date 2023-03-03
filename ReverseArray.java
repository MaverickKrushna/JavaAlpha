package com.krushnaDSA;

public class ReverseArray {

    public static  void reverseArray(int array[]){
        int start = 0 , end = array.length -1 ;
        while (start < end){
            int temp ;
            temp = array[start];
            array[start] = array[end];
            array[end] = temp ;
            start ++ ;
            end -- ;
        }
    }

    public static  void pairArray(int array[]){
        for (int i=0 ; i<  array.length ; i++ ){
            for (int j = i+1 ; j < array.length ; j++){
                System.out.print("("+ array[i] + "," + array[j]+ ")");
            }
            System.out.println();
        }
    }


    

    public static  void printArray(int array[]){
        for (int i =0 ; i < array.length ; i++){
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int element[] = {1,2,8,6,3,7,5,65,653,123} ;
        System.out.println("Reverse of Array ");
//        reverseArray(element);
        printArray(element);
        System.out.println("Printing the pair of the elements ");
        pairArray(element);
    }
}
