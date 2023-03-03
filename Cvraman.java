package com.krushnaDSA;
public class Cvraman {
    public static void main(String[] args) {
        int n=5;
        int i = n-1;
       do{

            int p=n;

       int j = n;
        do{
            System.out.print(" ");
            j--;
        }while(j>i);
        int k = 0;
             do{
                System.out.print( p+ " ");
                p--;
                k++;
            }while(k<=i);

            i--;
            System.out.println();
        } while (i>=0);
    }
}





