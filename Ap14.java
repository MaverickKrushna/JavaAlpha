package com.krushnaDSA;

import java.util.Scanner;

public class Ap14 {
    public  static  boolean search(int matrixe[][] , int key ){
        for (int i=0 ; i< matrixe.length ; i++){
            for (int j=0 ;j< matrixe[0].length ; j++){
               if(matrixe[i][j]== key){
                   System.out.println("Element found :" + i +" " + j);
                   return  true;
               }
            }

        }
        System.out.println("Not found");
        return false;

    }
    public  static  void printSpriral(int matrix[][]){
        int startCol=0;
        int endCol =matrix[0].length -1;
        int startRow =0;
        int endRow = matrix.length-1;
        while (startRow<= endRow && startCol <= endCol){
            // TOP  column
            for (int j = startCol; j <=endCol ; j++){
                System.out.print( matrix[startRow][j] +" ");
            }
            // Right Row
            for (int i=startRow+1 ; i<=endRow ;i++){
                System.out.print(matrix[i][endCol]+" ");
            }
            // Bottom Column
            for (int j = endCol-1; j >=startCol ; j--){
                if (startCol==endCol){
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            }
            // left Row
            for (int i=endRow-1 ; i>=startRow ; i--){
                if (startRow== endRow){
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }
            startCol++ ;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }


    public static  int digonalSum(int matrix[][]){
        int sum=0;
        int n = matrix.length ;
        for (int i=0 ; i< n ;i++){
            sum+= matrix[i][i];
            if (i!= (n-i-1)){
                sum+= matrix[i][n-1-i];
            }
        }

        return sum ;

    }
    public static boolean searchElement(int array[][], int key){
        int row =0 ;
        int col= array[0].length-1;
        while (row< array.length && col>=0){
            if (array[row][col]==key){
                System.out.println("Element found at ("+ row +","+col+")");
                return true;
            }
            else if (array[row][col]>key){
                col--;
            }
            else {
                row ++ ;
            }
        }
        System.out.println("Element not found !!");
        return  false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int matrixe[][] =  {{1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}} ;
//        for (int i=0 ; i< matrixe.length ; i++){
//            for (int j=0 ;j< matrixe[0].length ; j++){
//                matrixe[i][j]= scan.nextInt();
//            }
//        }
//        for (int i=0 ; i< matrixe.length ; i++){
//            for (int j=0 ;j< matrixe[0].length ; j++){
//                System.out.print(matrixe[i][j]);
//            }
//            System.out.println();
//        }
//        search(matrixe,5);


  printSpriral(matrixe);
        System.out.println("The sum of the diagonal is : "+ digonalSum(matrixe));
        searchElement(matrixe,1);

    }
}
