package com.krushnaDSA;

import java.util.Scanner;

public class SumOfDigit {
    public static  int sumOfDigit(int n ){
        int sum = 0 , store;
        while(n>0){
            store = n%10 ;
            sum += store ;
            n/=10 ;

        }
        return  sum ;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int a = scan.nextInt();
        System.out.println("Is number is even : "+ sumOfDigit(a));
    }
}
