package com.krushnaDSA;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AP_30_Queue {
    public static  class  Queue2Stack{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        public boolean isEmpty(){
            return  s1.isEmpty();
        }
        // Add
        public  void add(int data){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        // remove
        public  int remove(){
            if (isEmpty()){
                System.out.println("Queue is empty !!");
                return -1;
            }

            return s1.pop() ;
        }
        public  int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty !!");
                return -1;
            }
            return s1.peek() ;
        }

    }
    public  static class Stack2Queue {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // Push
        public void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }
        // pop
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty !!");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }

            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);

                }

            }
            return top;
        }
        //pop end

        // Peek
        public  int peek(){
            if (isEmpty()) {
                System.out.println("Stack is empty !!");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }

            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);

                }

            }
            return top;

        }
    }
    // first non-repeating letter in a string of the characters
    public  static void  firstNonRepeating(String str){
        int freq[]= new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i= 0 ; i< str.length() ; i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch -'a']++ ;
            while (!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove() ;
            }
            if (q.isEmpty()){
                System.out.print(-1 + " ");
            }else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }
    // Interleave 2 haves of a queue (Even lenght )
    public  static void queueEvenLenght(Queue<Integer> base ){

        int n = base.size()/2;
        Queue<Integer> temp = new LinkedList<>();
        for (int i=0 ; i< n ; i++){
            temp.add(base.remove());
        }
        while (!temp.isEmpty() ){
            base.add(temp.remove());
            base.add(base.remove());
        }
        while (!base.isEmpty()){
            System.out.print(base.peek() + " ");
            base.remove() ;
        }
        System.out.println();

    }
    // reverse the queue
    public static  void reverseTheQueue(Queue<Integer> q ){
        Stack<Integer> s = new Stack<>() ;
        while (!q.isEmpty()){
            s.push(q.remove());
        }
        while (!s.isEmpty()){
            System.out.print(s.pop() +" ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Deque<Integer> de = new LinkedList<>();
        de.addFirst(12);
        de.addFirst(13);
        de.addLast(10);
        System.out.println(de);


//        Queue<Integer > q = new LinkedList<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.add(8);
//        q.add(9);
//        q.add(10);
//        queueEvenLenght(q);
//        reverseTheQueue(q);
//
//
//
//
//
//        firstNonRepeating("aabccxb");



//        Stack2Queue s = new Stack2Queue();
//        s.push(2);
//        s.push(3);
//        s.push(4);
//        s.push(5);
//        s.push(6);
//        s.push(7);
//        s.push(8);
//        while (!s.isEmpty()){
//            System.out.println(s.peek());
//            s.pop();
//        }



//        Queue<Integer> q1 = new LinkedList<>(); // ArrayDeque
//        Queue<Integer> q2 = new ArrayDeque<>();
//        Queue2Stack q = new Queue2Stack();
//
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.add(8);
//        while (!q.isEmpty()){
//            System.out.println(q.peek());
//            q.remove();
//        }
//
//



    }
}
