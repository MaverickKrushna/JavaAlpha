package com.krushnaDSA;

import java.util.Scanner;

public class Factorial {
    public static int factorialOfNumber(int a){
        if (a==1 && a==0){
            return 1 ;
        }
        int fact = 1  ;
      while (a>0){
          fact*=a ;
          a-- ;
      }
       return fact ;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int  n= scan.nextInt();
//        System.out.println("factorial of the input number is  : "+ factorialOfNumber(a));
        double sum =0;
        for (int i=1 ; i<=n ; i++){
            double fact =1 ;
            int c=1 ;
            while (c<=i){
                fact=fact*c ;
                c++;
            }
            sum = sum + (1/ fact ) ;
        }



        System.out.println("Print :" + sum);
    }
}
