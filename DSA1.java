package com.krushnaDSA;

import java.util.Scanner;

public class DSA1 {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the cost of Pencil :");
//        float pencil = scan.nextFloat();
//        System.out.println("Enter the cost of Pen :");
//        float pen = scan.nextFloat();
//        System.out.println("Enter the cost of eraser  :");
//        float eraser = scan.nextFloat();
//
//        float totalCost = (pencil + pen + eraser );
//        float withGst = totalCost + (0.18f * totalCost);
//        System.out.println("The Total cost with GST is = " + withGst);
        Scanner scan = new Scanner(System.in);
//        int a = scan.nextInt();
//        if (a>= 0){
//            System.out.println("This is the positive Number ");
//        }
//        else {
//            System.out.println("This is the negative Number ");
//        }


        // leap year

//        int year = scan.nextInt();
//       if (year%4==0 && ((year%100!=0 ) || (year%100 ==0 && year%400==0))){
//           System.out.println("This is leap year !!");
//       }
//       else{
//           System.out.println("This is not leap year ");
//       }

        // factorial of the number
        int n = scan.nextInt();
        int i =1 ;
        int fact=1;
        while(i<=n && i!=0){

            fact*=i ;
            i++ ;
        }
        System.out.println(fact);
    }
}
