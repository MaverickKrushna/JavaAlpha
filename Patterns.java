package com.krushnaDSA;

import java.util.Scanner;

public class Patterns {
    public static void  hollowrectangular(int row , int col){
        for(int i = 1 ; i<= row ; i++){
            for(int j=1 ; j<=col ; j++){
                if (i==1 || i== row || j==1 || j== col){
                    System.out.print(" * ");
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public  static  void reversePyrimide(int row ){
        for(int i = 1 ; i<= row ; i++){
            for(int j=1 ; j<=(row-i) ; j++){
                System.out.print(" ");
            }
            for(int k= (row-i+1); k<=row ; k++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
    public static  void invertedHalfPyrimide(int row ){
       for(int i=row  ; i>=1 ; i--){
           int indicator =1 ;
           for(int j=row ; j>= (row-i +1); j--){
               System.out.print(" "+ indicator + "");
               indicator++ ;
           }
           System.out.println();
       }
//
       for(int i = 1 ; i<= row ; i++){
           int ind = 1;
           for(int j=1 ; j<=(row-i+1); j++){
               System.out.print(" "+ ind + "");
               ind++ ;
           }
           System.out.println();
       }
    }



    public static  void floydsTringle(int row ){
        int floyd=1 ;
       for(int i=1 ; i<=row ; i++ ){
           for(int j=1 ; j<=i ; j++){
               System.out.print(" "+ floyd+" ");
               floyd++ ;
           }
           System.out.println();
       }
    }
    public static  void zeroOneTringle(int row ){

        for(int i=1 ; i<=row ; i++ ){
            for(int j=1 ; j<=i ; j++){
                if((i+j)%2 ==0){
                    System.out.print(" 1 ");
                }
                else{
                    System.out.print(" 0 ");
                }

            }
            System.out.println();
        }
    }

    public static void butterFly(int row){
        for(int i=1 ; i<=row ; i++ ){

            for(int j=1 ; j<=i ; j++){
                System.out.print("*");
            }
            for (int k=1 ; k<=(2*(row-i)) ; k++){
                System.out.print(" ");
            }
            for(int l=1 ; l<=i ; l++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=row-1 ; i>=1; i-- ){

            for(int j=1 ; j<=i ; j++){
                System.out.print("*");
            }
            for (int k=1 ; k<=(2*(row-i)) ; k++){
                System.out.print(" ");
            }
            for(int l=1 ; l<=i ; l++){
                System.out.print("*");
            }
            System.out.println();
        }

    }


    public static  void rumbos(int row){
        for (int i=1 ; i<=row ; i++){
            for(int j=1 ; j<=(row -i) ; j++){
                System.out.print(" ");
            }
            for (int k=1 ; k<= row ; k++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
    public static  void hollowRumbus(int row){
        for (int i=1 ; i<=row ; i++){
            for(int j=1 ; j<=(row -i) ; j++){
                System.out.print(" ");
            }
            for (int k=1 ; k<= row ; k++){
                if(i==1 || i==row  || k==1 || k==row){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public  static void dimond(int row){
        for( int i = 1 ; i<= row ; i++){
            for(int j=1 ; j<=(row-i) ; j++){
                System.out.print(" ");
            }
            for(int k= (row-i+1); k<=row ; k++){
                System.out.print("*");
            }
            for (int l=1 ; l<i ; l++){
                System.out.print("*");
            }

            System.out.println();
        }
        for( int i = row-1 ; i>=1 ; i--){
            for(int j=1 ; j<=(row-i) ; j++){
                System.out.print(" ");
            }
            for(int k= (row-i+1); k<=row ; k++){
                System.out.print("*");
            }
            for (int l=1 ; l<i ; l++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static  void numberPyrimid(int row){
      for(int i=1 ; i<= row ; i++){
          for (int j= 1 ; j<=(row-i); j++){
              System.out.print(" ");
          }
          for(int k= (row-i+1); k<=row ; k++){
             if(i%2!=0){
                 System.out.print("");
                 System.out.print(i);
             }
          }

          System.out.println();
      }
    }
    public  static  void numberSystem(int row){
        for( int i = 1 ; i<= row ; i++){
            int count = row ;
            int leftCount =2 ;
            for(int j=1 ; j<=(row-i) ; j++){
                System.out.print(" ");
                count--;
            }
            for(int k= (row-i+1); k<=row ; k++){
                System.out.print(count);
                count--;
            }
            for (int l=1 ; l<i ; l++){
                System.out.print(leftCount);
                leftCount++ ;
            }

            System.out.println();
        }
    }





    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of row and columns ");
//        int row = scan.nextInt();
//        int col = scan.nextInt();
        int row =5 , col =5 ;
        System.out.println("The HollowRectangular Pyrimide ");
        hollowrectangular(row , col);
        System.out.println("The reverse Pyrimide ");
        reversePyrimide(row);
        System.out.println("Interveted HalfPyrimide ");
        invertedHalfPyrimide(row);
        System.out.println("Floyd's Tringle :");
        floydsTringle(row);
        System.out.println("1-0 Trigle Pyrimide :");
        zeroOneTringle(row);
        System.out.println("ButterFly Pattern :");
        butterFly(row);
        System.out.println("The rombus Pyrimide :");
        rumbos(row);
        System.out.println("The hollow Rumbus");
        hollowRumbus(row);
        System.out.println("The Dimond Pattern :");
        dimond(row);
        System.out.println("Number Pyramide ");
        numberPyrimid(row);
        System.out.println("The Number system");
        numberSystem(row);
    }
}
