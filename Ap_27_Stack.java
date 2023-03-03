package com.krushnaDSA;

import java.util.ArrayList;
import java.util.Stack;

public class Ap_27_Stack {

    static class StackL{
        class  Node{
            int data ;
            Node next ;
            Node(int data){
                this.data = data;
                this.next = null;
            }
        }
        public  static  int size ;
        public  static Node head ;
        public static Node tail ;
        // Is empty
        boolean isEmpty(){
            if(head == null){
                return true;
            }
            return false;
        }
        //Push --
        public void push(int data ){
            Node newNode= new  Node(data);
            size++;
            if (head==null){
                head=tail=newNode;
                return;
            }
            newNode.next=head ;
            head = newNode;
        }
        // pop
        public int pop(){
            if (size==1){
                int val = head.data;
                head= tail= null;
                return  val;
            }
            int val = head.data;
            head=head.next ;
            return  val ;
        }
    }
    static class Stack{
        ArrayList<Integer> stack = new ArrayList<>();
        // is Empty
        boolean isEmpty(){
            if(stack.size()==0){
                return true;
            }
            return false;
        }
        // push
        void push(int data){
            stack.add(data);
        }
        // pop
        int pop(){
            if(isEmpty()){
                return  -1 ;
            }
            int top = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return  top ;
        }
        // peek
        int peek(){
            if(isEmpty()){
                return  -1 ;
            }
            return stack.get(stack.size()-1);
        }


    }
    // Q1

    // Q2
    public static  String reverserString(String str){
        java.util.Stack s = new java.util.Stack<>();
        int i=0;
        while (i!=str.length()){
            s.push(str.charAt(i));
            i++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()){
            result.append(s.pop());
        }


        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverserString("KrushnaChandraSahu"));

        Stack s = new Stack();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(12);

        while (!s.isEmpty()){
            System.out.println(s.pop());
        }



    }
}
