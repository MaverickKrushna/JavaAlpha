package com.krushnaDSA;

public class Ap17_classesAndObjects {
    static  void numberPrinting(int n){
        if (n==0){
            return;
        }
        System.out.print(n + " ");
        numberPrinting(n-1);

    }
   static  void incPrint(int n){

        if (n==0){
            return;
        }
       incPrint(n-1);
       System.out.println(n);

   }


    public static void main(String[] args) {
        numberPrinting(10);
        System.out.println();
        incPrint(10);
    }
}
