package com.krushnaDSA;

import java.util.Scanner;

public class isEven {
    public static boolean checkIsEven(int n ){
        if (n%2==0){
            return true ;
        }
        return false ;
    }

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int a = scan.nextInt();
        System.out.println("Is number is even : "+ checkIsEven(a));




    }


}
