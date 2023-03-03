package com.krushnaDSA;

import java.util.Scanner;

public class SWapNumber {
    public static void main(String[] args) {
        int digit[] = {1,2,3,4,5,6,7,8,9,0};
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number :");
        int n = scan.nextInt();
        int result = 0 , last , x=n;
        while(x>0){
            last =  x% 10;
            for (int i=0 ; i< digit.length ; i++){
                if(last == digit[i]){
                    result =result*10 + last ;
                    digit[i]=22 ;
                }
            }
            x/=10;
        }
        int newResult = result ;
        result =0;
        while (newResult>0){
            last = newResult %10 ;
            result = result*10 + last ;
            newResult/=10 ;
        }
        System.out.println("The result :" + result);

    }
}
