package com.krushnaDSA;

import java.util.Queue;

// ____________________Queue _____________________
public class Ap_30 {
    static  class Queue{
        static int arr[];
        static int size;
        static  int rear ;
        Queue(int n){
            arr= new int[n];
            size=n ;
            rear =-1 ;
        }
        public  static boolean isEmpty(){
            return rear==-1 ;
        }
        // Add function in Queue
       public static void add(int data){
            if (rear == size-1){
                System.out.println("Queue is full !!");
                return;
            }
            rear = rear+1;
            arr[rear]= data ;

        }
        // Remove Function in Queue
        public static int remove(){
            if (rear==-1){
                System.out.println("Queue is empty !!");
                return -1 ;
            }
            int val = arr[0];
            for (int i=0 ; i<rear ;i++ ){
                arr[i]=arr[i+1];
            }
            rear--;
            return  val ;
        }
        // Peek function in Queue ...
        public  static  int peek(){
            if (rear==-1){
                System.out.println("Queue is empty !!");
                return -1 ;
            }
            return arr[0];
        }

    }

 // circular queue
 static  class Queuec{
     static int arr[];
     static int size;
     static  int rear ;
     static  int front ;
     Queuec(int n){
         arr= new int[n];
         size=n ;
         rear =front=-1 ;

     }
     public  static boolean isEmpty(){
         return rear==-1 && front==-1 ;
     }
     public  static  boolean isFull(){
         return (rear+1)%size == front ;
     }
     // Add function in Queue
     public static void add(int data){
         if (isFull()){
             System.out.println("Queue is full !!");
             return;
         }
         if (front==-1){
             front=0;
         }
         rear = (rear+1)%size;
         arr[rear]= data ;

     }
     // Remove Function in Queue
     public static int remove(){
         if (isEmpty()){
             System.out.println("Queue is empty !!");
             return -1 ;
         }
         front = (front+1)%size ;
         int val = arr[front];
         if (rear==front){
             rear=front=-1 ;
         }

         return  val ;
     }
     // Peek function in Queue ...
     public  static  int peek(){
         if (isEmpty()){
             System.out.println("Queue is empty !!");
             return -1 ;
         }
         return arr[front];
     }

 }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(2);
        q.add(1);
        q.add(3);
        q.add(4);
        q.add(5);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }


    }
}
