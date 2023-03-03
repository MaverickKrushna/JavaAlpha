package com.krushnaDSA;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Ap_32Tree {
    // sub Tree
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
    // isIdentical Function
    public  static  boolean isIdentical(Node root , Node subRoot){
        // base case
        if (root ==null && subRoot ==null){
            return  true ;
        }else if (root==null || subRoot== null || root.data != subRoot.data){
            return false ;
        }
        // checking the condition for
        // left of the tree and subTree
        if(!isIdentical(root.left , subRoot.left)){
            return  false ;
        }
        if (!isIdentical(root.right , subRoot.right)){
            return  false ;
        }
        return true ;
    }

    // isSubTree Function
    public  static  boolean isSubTree(Node root , Node subRoot){
        // base case
        if (root == null){
            return false ;
        }
        // checking the condition
        if (root.data == subRoot.data){
            if (isIdentical(root , subRoot)){
                return  true ;
            }
        }
        // recursion and return the value
        return isSubTree(root.left , subRoot) || isSubTree(root.right , subRoot) ;
    }
    // information class
    static  class Info{
        Node node ;
        int hd ;  // horizontal Distance
        Info(Node node , int hd){
            this.node = node ;
            this.hd = hd ;
        }
    }
   // Top view of tree
    public static  void topView(Node root ){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer ,Node >  map = new HashMap<>();
        int min =0, max=0 ;
        q.add(new Info(root , 0));
        q.add(null );
        while (!q.isEmpty()){
            Info currInfo = q.remove();
            if (currInfo ==null){
                if (!q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }else{
                // If map not contain the key element
                if (!map.containsKey(currInfo.hd)){
                    map.put(currInfo.hd, currInfo.node);
                }
                // checking for the left element
                if (currInfo.node.left!=null){
                    q.add(new Info(currInfo.node.left, currInfo.hd-1 ));
                    min = Math.min(currInfo.hd-1 ,  min);
                }
                // checking for the right element
                if (currInfo.node.right!=null){
                    q.add(new Info(currInfo.node.right, currInfo.hd+1 ));
                    max= Math.max(currInfo.hd+1 ,  max);
                }
            }

        }
        for (int i=min ; i<=max ; i++){
            Node p = map.get(i);
            System.out.print(p+ " ");
        }
    }

    


    public static void main(String[] args) {
        // Sub Root
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        topView(root);
        // Sub Root
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

//        System.out.println(isSubTree(root , subRoot));

    }
}
