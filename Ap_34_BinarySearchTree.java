package com.krushnaDSA;

import java.util.ArrayList;

public class Ap_34_BinarySearchTree {
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
    public static Node insert(Node root , int val ){
        if (root == null){
            root = new Node(val);
            return  root ;
        }
        if (root.data > val){
            root.left = insert(root.left , val);

        }else{
            root.right = insert(root.right , val);
        }
        return  root ;
    }
    // in order traversal
    public  static void inOrder(Node root){
        if (root== null){
//                System.out.print(-1 + " ");
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }
    // Search the node in BInary Tree
    public  static boolean search(Node root , int key ){
        if (root== null){
            return  false;
        }
        // kaam
        if (root.data == key ){
            return  true ;
        }
        if (root.data > key){
            return  search(root.left, key);
        }else {
            return  search(root.right, key);
        }

    }

    // Delete Node of the tree
    public static  Node delete(Node root , int val ){
        if (root.data > val){
            root.left =delete(root.left, val);
        }else if (root.data < val){
            root.right=delete(root.right, val);
        }else{
            // case -1
            if (root.left== null && root.right==null){
                return null;
            }
            // case -2
            if (root.left==null){
                return  root.right ;
            }
            else if(root.right == null){
                return  root.left;
            }
            // case -3
            Node iS = findInOrderSuccessor(root.right);
            root.data= iS.data ;
            root.right= delete(root.right , iS.data);
        }
        return root ;
    }

    // Finding Inorder succesor
    public  static  Node findInOrderSuccessor(Node root){
        while (root!=null){
            root = root.left ;
        }
        return root ;
    }
    // printing Node data in a range _____
    public  static  void printInRange(Node root , int k1 , int k2){
        // base case
        if (root==null){
            return;
        }
        if (root.data >= k1 && root.data <= k2){
            printInRange(root.left , k1,k2);
            System.out.print(root.data + " ");
            printInRange(root.right , k1,k2);
        }else if (root.data< k1){
            printInRange(root.left , k1,k2);
        }else {
            printInRange(root.right , k1,k2);
        }

    }
    // Root2leafPath
    public static  void root2LeafPaths(Node root , ArrayList<Integer> path){
        // base case
        if (root == null){
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right== null){
            printingArrayList(path);
        }
        root2LeafPaths(root.left, path);
        root2LeafPaths(root.right, path);
        path.remove(path.size()-1);

    }
    // printing arrayList
    public  static  void printingArrayList(ArrayList<Integer> path){
        for (int i=0 ; i< path.size() ; i++){
            System.out.print(path.get(i)+"-");
        }
        System.out.print("null\n");
    }

    // is Validate BST tree
    public static  boolean isValidateBST(Node root , Node min , Node max){
        // base case --
        if (root==null){
            return true ;
        }
        if (min!=null &&  root.data <= min.data){
            return  false ;
        }
        if (max!=null &&  root.data >= max.data){
            return  false ;
        }
        boolean leftTree = isValidateBST(root.left , min , root);
        boolean rightTree = isValidateBST(root.right , root , max);
        return  leftTree && rightTree ;
    }

    // BST mirror image
    public  static  Node mirrorBST(Node root){
        // base case
        if (root== null){
            return  null;
        }
        Node leftSubTree = mirrorBST(root.left);
        Node rightSubTree = mirrorBST(root.right);
        root.left = rightSubTree ;
        root.right = leftSubTree ;
        return  root ;
    }
// pre order
    public  static void preOrder(Node root){
         if (root== null){
         return ;
             }
         System.out.print(root.data + " ");
         preOrder(root.left);
         preOrder(root.right);
    }
    public static void main(String[] args) {
        Node root= new Node(8);
        root.left = new Node(5) ;
        root.left.left = new Node(3) ;
        root.left.right = new Node(6) ;
        root.right = new Node(10) ;
        root.right.right = new Node(11) ;
        preOrder(root);
        System.out.println();
        root = mirrorBST(root);
        preOrder(root);




//        int valu []= {8,5,3,1,4,6,10,11,14};
////        int valu[]={1,1,1};
//        Node root = null;
//        for (int i= 0 ; i< valu.length ; i++){
//           root = insert(root , valu[i]);
//        }
//
//        System.out.println(isValidateBST(root, null , null));
//        root= delete(root , 7);
//        root2LeafPaths(root , new ArrayList<>());
//        printInRange(root , 4,11);
//        System.out.println();
//        inOrder(root);
//        System.out.println(search(root , 46));

    }
}
