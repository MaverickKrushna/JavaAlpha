package com.krushnaDSA;

import java.util.Scanner;

public class maxNumber {
    public static double avergeOfNumber(float a , float b , float c){
        return (a+b+c)/3 ;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the 1 st number ");
        float a = scan.nextFloat();
        System.out.println("Enter the 2nd number ");
        float b = scan.nextFloat();

        System.out.println("Enter the 3 rd number ");
        float c = scan.nextFloat();
        System.out.println("The average of the 3 number is = " + avergeOfNumber(a , b ,c ));
    }
}
