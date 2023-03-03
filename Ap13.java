package com.krushnaDSA;

// Sorting Technique
public class Ap13 {
    //printing Array
    public static  void printArray(int[] array){
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
    // Bubble Sort
    public  static  void bubbleSort(int MyArray[]){
        int n = MyArray.length;
        for (int i=0 ; i< n ; i++){
            for (int j=0 ; j< (n-i -1) ; j++){
                if (MyArray[j]> MyArray[j+1]){
                    int temp = MyArray[j];
                    MyArray[j]= MyArray[j+1];
                    MyArray[j+1]= temp ;
                }
            }
        }

    }
    // Selection Sorting
    public static  void selectionSort(int MyArray[]){
        int n = MyArray.length , smallest ;
        for (int i=0 ; i < n ; i++){
            smallest = i;
            for (int j= i+1 ; j < n ; j++){
                if(MyArray[smallest]> MyArray[j]){
                    smallest = j ;
                }
            }
            int temp = MyArray[i];
            MyArray[i]= MyArray[smallest];
            MyArray[smallest]= temp ;

        }

    }


// Insertion Sorting ___
    public static  void insertionSorting(int MyArray[]){
        int n = MyArray.length;
        for (int i=1 ; i< n ; i++){
            int current = MyArray[i];
            int prev = i-1 ;
            while (prev>=0 && MyArray[prev] > current ){
                MyArray[prev+1]= MyArray[prev];
                prev-- ;
            }

            MyArray[prev+1]= current;
        }

    }

// count Sorting
    public  static  void countSorting(int MyArray[]){
        int lagest = Integer.MIN_VALUE ;
        for (int i=0 ; i< MyArray.length ; i++){
            lagest = Math.max(lagest , MyArray[i]);
        }
        int count []= new int[lagest+1];
        for (int i=0 ; i< lagest+1; i++){
            count[i]=0 ;
        }
        for (int i=0 ; i< MyArray.length ; i++){
            count[MyArray[i]]++;
        }

        // sorting Path
        int j=0 ;
        for (int i=0 ; i< count.length ; i++){
            while (count[i]>0){
                MyArray[j]=i;
                j++;
                count[i]--;
            }
        }

    }

    public static void main(String[] args) {
        int MyArray[]={1,4,6,58,23,12,43,65,59,652,40,21,5,33,48,75,96,32,46,20,30,45,41};
//        bubbleSort(MyArray);
//        selectionSort(MyArray);
//        insertionSorting(MyArray);
        countSorting(MyArray);

        System.out.println("The Bubble Sorting :");
        printArray(MyArray);

    }
}
