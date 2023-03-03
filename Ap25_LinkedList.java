package com.krushnaDSA;

// Linked List
public class Ap25_LinkedList {
    class  Node{
        int data ;
        Node next ;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public  static  int size ;
    public  static  Node head ;
    public static  Node tail ;

    public void addFirst(int data ){
        Node newNode= new Node(data);
        size++;
        if (head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head ;
        head = newNode;
    }
    public void  addLast(int data){
        Node newNode = new Node(data);
        size++;
        if (head==null){
            head=tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    // add element at middle
    public  void add(int data , int index ){
        if (index==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;

        Node temp = head ;
        int i=0;
        while (i< index -1){
            temp= temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode ;


    }
    // Remove the First element
    public int removeFirst(){
//        if (size==0){
//            System.out.println("LinkedList is empty !!");
//            return  Integer.MAX_VALUE ;
//        }
        if (size==1){
            int val = head.data;
            head= tail= null;
            size--;
            return  val;
        }
        int val = head.data;
        head=head.next ;
//        size--;
        return  val ;

    }
    // remove last Index
    public  int removeLast(){
        if (size==0){
            System.out.println("LinkedList is empty !!");
            return  Integer.MAX_VALUE ;
        }
        if (size==1){
            int val = head.data;
            head= tail= null;
            size--;
            return  val;
        }
        Node prev = head ;

        while (prev.next.next != null){
            prev= prev.next ;
        }
        int val = tail.data;
        prev.next=null;
        tail= prev ;
        return  val ;
    }
    // Search element
    public int search(int key){
        int index = 0;
        Node temp = head ;
        while (temp!=null){
            if (temp.data == key){
                return index;
            }
            index++;
            temp= temp.next;
        }
        return -1;
    }
    // Search recursively
    public  int searchRecursively(int key ){

        return helper(head , key );
    }
    // helper
    public  int helper(Node head , int key){
        if (head==null){
            return -1;
        }
        if(head.data==key){
            return  0;
        }
        int indx = helper(head.next , key);
        if (indx ==1){
            return -1;
        }
        return   indx+1;
    }

    // reverse LinkedList
    public void reverse(){
        Node prev = null ;
        Node curr= tail = head ;
        Node next ;
        while (curr!= null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        head= prev ;
    }
    // Remove Nth element from the end  {nth element = size - nth 1}
    public  void removeNthEndelement(int nth){
       int sz =0;
       Node temp = head;
       while (temp!= null){
           temp = temp.next ;
           sz++;
       }

       if (sz==nth){
         head = head.next;
         return;
       }
       int i=1;
       int iToFind= sz - nth ;
       Node prev = head ;
       while (i< iToFind){
           prev= prev.next ;
       }
       prev.next = prev.next.next;
    }
    //Check Pallendrom
    public boolean pallindrome(){
        // base case
        if(head== null || head.next == null ){
            return  true ;
        }
        // step 1  find mid node
        Node mid = midNode(head);
        // reverse the 2 half Node
        Node prev = null ;
        Node curr = mid ;
        Node next;
        while (curr!= null ){
            next= curr.next ;
            curr.next = prev;
            prev = curr ;
            curr= next ;
        }
        Node rightHead = prev ;
        Node leftHead = head ;
        while (rightHead!= null){
            if (rightHead.data != leftHead.data){
                return  false ;
            }
            rightHead= rightHead.next;
            leftHead = leftHead.next ;
        }

        return true ;

    }
    // Mid Node finder for pallindrum number
    public  Node midNode(Node head ){
        Node slow=head ;
        Node fast=head  ;
        while (fast.next != null && fast.next.next != null){
            slow= slow.next; // +1
            fast = fast.next.next ; //+2

        }
        return slow ;

    }
    // Printing the Linked List
    public void print(){
        if (head==null){
            System.out.println("LinkedList is empty !");
            return;
        }
        Node temp = head ;
        while (temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next ;

        }
        System.out.println("null");


    }
    // Cyclic LinkedList
    public static  boolean isCycle(){
        Node slow = head ;
        Node fast = head ;
        while (fast !=null && fast.next!=null){
            slow =slow.next ;
            fast = fast.next.next ;
            if (slow == fast ){
                return true ;
            }
        }
        return  false ;
    }
    // Remove a loop / cycle in a linkedList
    public  static  void removeCycle(){
        Node slow = head ;
        Node fast = head ;
        boolean cycle = false ;
        while (fast !=null && fast.next!=null){
            slow =slow.next ;
            fast = fast.next.next ;
            if (slow == fast ){
                cycle = true ;
                break;

            }
        }
        if(cycle== false ){
            return;
        }
        slow = head ;
        Node prev = null ;
        while (slow !=fast){
            prev = fast ;
            slow = slow .next ;
            fast = fast.next ;
        }
        prev.next = null ;

    }

 public Node  mergeSort(Node head ){
        // base case
     if(head== null || head.next == null){
         return head ;
     }
     // find Mid
     Node mid = findMid(head);
     // left and right merge

     Node rightHead = mid.next ;
     mid.next = null;
     Node newleft= mergeSort(head);
     Node newright = mergeSort(rightHead);
     // merge return
     return  merge(newleft , newright);
 }
 // find Mid
    private  Node findMid(Node head ){
        Node slow = head  ;
        Node fast = head.next ;
        while (fast!= null && fast.next != null){
            slow= slow.next;
            fast= fast.next.next ;
        }
        return  slow ;
    }

    // Merge Function for the mergesort
    private  Node merge(Node head1 , Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL ;
        while (head1 != null && head2 != null){
            if (head1.data <= head2.data)
            {
                temp.next = head1;
                head1 = head1.next;
                temp=temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp=temp.next;
            }
        }
        while (head1 != null ){
            temp.next = head1;
            head1 = head1.next;
            temp=temp.next;

        }
        while (head2 != null ){
            temp.next = head2;
            head2 = head2.next;
            temp=temp.next;
        }
        return mergeLL.next ;
    }
 // Node zigZack
    public void zigZag(){
        Node slow = head ;
        Node fast = head.next ;
        while (fast!=null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        // Mid of the LinkedList
        Node mid = slow ;
        // Divide into two part
        Node curr=  mid.next ;
        mid.next = null;
        // Reverse the 2nd half of the LinkedList
        Node prev= null ;
        Node next ;
        while (curr!=null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        Node lh = head ;
        Node rh = prev ;
        Node nextL , nextR ;
        while (lh!= null && rh!= null){
            nextL=lh.next ;
            lh.next = rh ;
            nextR = rh.next ;
            rh.next= nextL ;

            // Update
            lh = nextL ;
            rh = nextR ;
        }


    }
    public static void main(String[] args) {


        Ap25_LinkedList ll = new Ap25_LinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
//        ll.mergeSort(head);
        ll.zigZag();
        ll.print();

//         head = new Node(1);


//        Ap25_LinkedList ll = new Ap25_LinkedList();
//
//       ll.addLast(1);
//        ll.addLast(2);
//        ll.addLast(3);
//        ll.addLast(2);
//        ll.addLast(3);
//        System.out.println(ll.pallindrome());
//        ll.print();
//        ll.print();
//        ll.addFirst(5);
//        ll.addFirst(2);
//        ll.addLast(6);
//        ll.add(4,3);
//        ll.print();
//        ll.removeNthEndelement(3);
//        ll.removeLast();
//
//        ll.print();
//        ll.reverse();
////        System.out.println(ll.size);
//        ll.print();
//

    }
}
