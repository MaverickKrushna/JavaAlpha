package com.krushnaDSA;

import java.util.Scanner;

public class TableOfN {
    public static  void  multipleTable (int n ){
        for (int i=1 ; i<=10 ; i++){
            System.out.println( n +"*" + i + "= "+ (n*i));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int a = scan.nextInt();
        System.out.println("The Multiple Table of the given number is :");
        multipleTable(a);
    }
}
