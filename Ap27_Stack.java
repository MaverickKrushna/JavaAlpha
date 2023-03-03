package com.krushnaDSA;

import java.util.*;

public class Ap27_Stack {
    public  static  void pushAtButtom(Stack<Integer> s , int data ){
        // base case
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top =  s.pop();
        pushAtButtom(s , data);
        s.push(top);

    }
    // Reverse the Stack
    public  static  void reverseStack(Stack<Integer> s){
        //base case
        if (s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtButtom(s , top);

    }
    // StockSpan
    public  static  void stockSpan(int stock [] , int span []){
        Stack<Integer> s = new Stack<>();
        span[0]=1;
        s.push(0);
        for (int i=1 ; i< stock.length ; i++){
            int currentPrice = stock[i];
            while (!s.isEmpty() && currentPrice > stock[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                span[i]= i+1 ;
            }
            else {
                int prevHigh = s.peek();
                span[i]= i - prevHigh ;
            }
            s.push(i);
        }


    }
    // Next  Greater
    public static  void nextGreater(int arr[] , int nextGreater []){
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length -1; i>=0 ; i--){
            while (!s.isEmpty() && s.peek() <= arr[i] ){
                s.pop();
            }
            if (s.isEmpty()){
                nextGreater[i]=-1;
            }
            else{
                nextGreater[i]= s.peek();
            }
            s.push(arr[i]);

        }

    }


    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        int nextGreater [] = new int[arr.length];
        nextGreater(arr , nextGreater);


//        for (int i: nextGreater ) {
//            System.out.print(i + " ");
//        }
        int stock[]={100,80,60,70,60,85,100};
        int span[] = new int[stock.length];
        stockSpan(stock , span);
        for (int i: span ) {
            System.out.print(i + " ");
        }

    }
}
