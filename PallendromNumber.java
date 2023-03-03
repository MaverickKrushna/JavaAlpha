package com.krushnaDSA;

import java.util.Scanner;

public class PallendromNumber {
    public static  boolean checkPallendrom(int n ){
        int x , p=0 , a=n;
        while(a>0){
            x= a%10 ;
            p= (p*10) + x ;
            a/=10 ;
        }
        if (p==n){
            return true ;
        }
        return  false ;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int a = scan.nextInt();
        System.out.println("Is number is pallendrom : "+ checkPallendrom(a));

    }
}
