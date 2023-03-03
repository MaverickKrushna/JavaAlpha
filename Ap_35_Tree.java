package com.krushnaDSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ap_35_Tree {
    static class  Node{
        int data ;
        Node left ;
        Node right ;
        Node(int data){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }

    }
    // lever order traversal
    public static void  levelOrder(Node root){
        if (root== null){
//                System.out.print(-1 + " ");
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node currNode = q.remove();
            if (currNode==null){
                System.out.println();
                if (q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");
                if (currNode.left != null){
                    q.add(currNode.left);
                }
                if (currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

    }

    // creating the balance BST
    public  static  Node createBalanceBST(int arr[] , int start , int end ){
        if (start> end){
            return  null ;
        }
        int mid = start + (end - start)/2 ;
        Node root = new Node(arr[mid]);
        root.left = createBalanceBST(arr, start , mid-1);
        root.right= createBalanceBST( arr , mid+1 , end);
        return  root ;
    }

    // inorder traversal
    public  static void inOrder(Node root){
        if (root== null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
//     convert BST to balance BST
    public  static  Node convertBalanceBST(ArrayList<Integer> arr , int start , int end ){
        if (start> end){
            return  null ;
        }
        int mid = start + (end - start)/2 ;
        Node root = new Node(arr.get(mid));
        root.left = convertBalanceBST(arr, start , mid-1);
        root.right= convertBalanceBST( arr , mid+1 , end);
        return  root ;
    }

    // creating the sorted the ArrayList
    public  static void getInOrder(Node root , ArrayList<Integer> arr){
        if (root== null){
            return ;
        }
        getInOrder(root.left , arr);
        arr.add(root.data);
        getInOrder(root.right , arr);
    }


    /// Size Of the BST In BT
    public static  class Info{
        boolean isBST ;
        int size ;
        int min ;
        int max ;
      public   Info(boolean isBST , int size , int min , int max){
            this.isBST = isBST ;
            this.size = size ;
            this.min = min ;
            this.max = max ;

        }
    }
    public  static  int maxBST =0 ;
    public  static  Info largestBST(Node root ){
        // base case ----
        if (root == null){
            return new Info(true , 0 , Integer.MAX_VALUE , Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size+1;
        int min = Math.min(root.data,  Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data,  Math.max(leftInfo.max, rightInfo.max));
        if (root.data <= leftInfo.max || root.data >= rightInfo.size){
            return  new Info(false , size , min , max);
        }
        if (leftInfo.isBST && rightInfo.isBST){
            maxBST= Math.max(maxBST , size);
            return  new Info(true , size , min , max);
        }
        return  new Info(false , size , min , max) ;
    }
    // Two ArraysList merge
    public  static  void merge(ArrayList<Integer> inorder1,ArrayList<Integer> inorder2 ,ArrayList<Integer> inOrder){
        int i =0  ;
        int j = inorder1.size()-1 ;
        int ii=0 ;
        int jj = inorder2.size()-1;
        int k=0;

        while (i<=j && ii<= jj){
            if (inorder1.get(i)< inorder2.get(ii)){
                inOrder.add(inorder1.get(i));
                i++;
            }else{
                inOrder.add(inorder2.get(ii));
                ii++;
            }
        }
        while (i<=j){
            inOrder.add(inorder1.get(i));
            i++;
        }
        while (ii<=jj){
            inOrder.add(inorder2.get(ii));
            ii++;

        }

    }
    // merge 2 BST ___



    public static void main(String[] args) {
        // BST-1
        Node root1=new Node(2);
        root1.left =new Node(1);
        root1.right = new Node(4);
        ArrayList<Integer> inorder1 = new ArrayList<>();
        inOrder(root1);
        // BST -2
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        ArrayList<Integer> inorder2 = new ArrayList<>();
        inOrder(root2);
        // merge BST
        ArrayList<Integer> inOrder = new ArrayList<>();
        merge(inorder1, inorder2 , inOrder);
        Node root = convertBalanceBST(inOrder , 0, inOrder.size()-1);
        inOrder(root);



        // size of largest BST
//        Node root = new Node(50);
//        root.left = new Node(30);
//        root.left.left = new Node(5);
//        root.left.right = new Node(20);
//        root.right = new Node(60);
//        root.right.left = new Node(45);
//        root.right.right = new Node(70);
//        root.right.right.left= new Node(65);
//        root.right.right.right = new Node(80);
//        Info info = largestBST(root);
//        System.out.println(maxBST);


//        Node root = new Node(8);
//        root.left = new Node(6);
//        root.left.left = new Node(5);
//        root.left.left.left = new Node(3);
//        root.right = new Node(10);
//        root.right.right = new Node(11);
//        root.right.right.right = new Node(12);
//        ArrayList<Integer> arr = new ArrayList<>();
//        sortedArrayList(root, arr);
//        int sz = arr.size();
//        root = convertBalanceBST(arr , 0, sz-1);
//        levelOrder(root);



//        int arr[]={3,5,6,8,10,11,12};
//        Node root = createBalanceBST(arr , 0 , arr.length-1);
//        inOrder(root);
//        System.out.println();
//        levelOrder(root);


    }
}
