package com.krushnaDSA;
import  java.util.LinkedList;
// Java collection Class

public class Ap26_DoublyLinkedList {
     class Node{
         int data ;
         Node next ;
         Node prev ;
         Node(int data ){
                this.data = data ;
                this.next= null ;
                this.prev = null ;
         }

     }

    public  static  int size ;
    public  static Node head ;
    public static Node tail ;

    // addFirst
    public void  addFirst(int data ){
        Node newNode = new Node(data);
        size++;
        if (head==null){
            head = tail = newNode;
            return;
        }
        newNode.next = head ;
        head.prev = newNode ;
        head = newNode;
    }
    // addLast
    public  void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if (head==null){
            head = tail = newNode;
            return;
        }
        Node temp = head ;
        while (temp.next!= null){
            temp = temp.next;
        }
        temp.next = newNode ;
        newNode.prev = temp ;
        tail = newNode;

    }
    // RemoveFirst
    public int removeFirst(){
        int val = head.data;
        head= head.next ;
        head.prev = null ;
        return  val ;
    }
    // Remove Last
    public int removeLast(){
        Node temp = head ;
        while (temp.next.next!= null){
            temp = temp.next;
        }

        int val = temp.next.data;
        temp.next = null ;
//        temp.next.prev = null ;

        return  val;

    }

    // reverse LinkedList
    public  void reverse(){
        Node curr= head ;
        Node prev = null ;
        Node next ;
        while (curr!= null){
            next = curr.next ;
            curr.next = prev ;
            curr.prev = next ;

            prev= curr ;
            curr = next ;
        }
        head = prev ;

    }

    // Print Doubley LinkedList
    public void print(){
        if (head==null){
            System.out.println(" Double LinkedList is empty !");
            return;
        }
        Node temp = head ;
        System.out.print("null<->");
        while (temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next ;

        }
        System.out.println("null");


    }

    public static void main(String[] args) {
        Ap26_DoublyLinkedList  dl = new Ap26_DoublyLinkedList();
        dl.addFirst(1);
        dl.addFirst(2);
        dl.addFirst(3);
        dl.addFirst(4);
        dl.addFirst(5);
        dl.addFirst(6);
        dl.addFirst(7);
        dl.addLast(8);
        dl.print();
        dl.reverse();
        dl.print();
        System.out.println(dl.removeFirst());
        System.out.println(dl.removeLast());
        dl.print();



    }
}
