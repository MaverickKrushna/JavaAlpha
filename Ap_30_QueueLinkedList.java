package com.krushnaDSA;

public class Ap_30_QueueLinkedList {
    static class  Node{
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
    public static class Queue{
        static  Node head = null ;
        static Node tail = null ;
        public  static boolean isEmpty(){
            return head==null && tail== null ;
        }
        // Add function in Queue
        public static void add(int data){
           Node newNode = new Node(data);
           if (head==null){
               head = tail = newNode;
           }
           tail.next = newNode ;
           tail = newNode ;

        }
        // Remove Function in Queue
        public static int remove(){
           if (isEmpty()){
               System.out.println("Queue is empty !!");
               return -1;
           }

           int val = head.data ;
            if (tail==head){
                tail=head=null ;
            }else {
                head = head.next ;
            }
           return  val ;
        }
        // Peek function in Queue ...
        public  static  int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty !!");
                return -1 ;
            }
            return head.data;
        }
    }


    public static void main(String[] args) {
        Queue q = new Queue() ;
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }



    }

}
