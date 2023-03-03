package com.krushnaDSA;

import java.util.ArrayList;

public class Ap_33_Tree {
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
    // Kth level of Tree
    static  void  klevel(Node root , int level , int k){
        // base case
        if (root==null){
            return;
        }
        // kaam
        if (level == k){
            System.out.print(root.data + " ");
            return;
        }
        klevel(root.left , level+1 , k);
        klevel(root.right , level+1 , k);
    }
    // Get path for the Ancestor
    public  static  boolean getPath(Node root , int n , ArrayList<Node> path){
        // Base case
        if (root == null){
            return  false ;
        }
        // kaam
        path.add(root);
        if (root.data == n){
            return true ;
        }
        // Recursion two side
        boolean leftPath = getPath(root.left , n , path);
        boolean rightPath = getPath(root.right , n, path);

        if (leftPath || rightPath){
            return  true ;
        }
        path.remove(path.size()-1);

        return false ;
    }
    // Lowest Common Ancestor
    public static  Node lowestCommonAncestor(Node root , int n1 , int n2 ){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root , n1 , path1);
        getPath(root , n2 , path2);
        int ele=0 ;
        for (int i=0 ; i< path1.size() && i < path2.size() ; i++){
            if (path1.get(i) != path2.get(i)){
                break;
            }
            ele=i ;
        }
        return  path1.get(ele);
    }

    // Lowest common Acestor
    public  static  Node lca(Node root , int n1 , int n2){
        // base case
        if (root==null || root.data == n1 || root.data == n2 ){
            return root ;
        }

        Node leftlca = lca(root.left , n1 , n2 );
        Node rightlca = lca(root.right, n1 , n2 );

        if (leftlca==null){
            return  rightlca ;
        }
        if (rightlca==null){
            return  leftlca;
        }
        return  root ;
    }

public static  Node lca2(Node root , int n1 , int n2){
        if (root == null){
            return null ;
        }
        if (root.data > n1 && root.data > n2) {
        return lca2(root.left, n1, n2);
       }
    if (root.data < n1 && root.data < n2) {
        return lca2(root.right, n1, n2);
    }
    return  root ;
}
     // lca 3
    // Minimum Distance
    public  static  int minDistance(Node root , int n1 , int n2){
         Node lca = lowestCommonAncestor(root, n1, n2);
         int dist1 = lcaDistance(lca , n1 );
        int dist2 = lcaDistance(lca , n2 );
        return  dist1 + dist2 ;
    }
 // lca distance
    public  static  int lcaDistance(Node root , int n ){
        // base case --
        if (root== null){
            return -1 ;
        }
        // condition
        if (root.data == n){
            return  0;
        }
        // inner kaam
        int leftDistance = lcaDistance(root.left , n);
        int rightDistance = lcaDistance(root.right , n);
        if (leftDistance == -1 && rightDistance == -1){
            return  -1 ;
        }
        else if (leftDistance == -1){
            return  rightDistance +1;
        }
        else{
            return leftDistance +1;
        }
    }
    // Kth Ancestor
     public  static  int kThAncestor(Node root , int n , int k ){
        // base case
         if (root == null){
             return  -1 ;
         }
         if (root.data == n){
             return  0;
         }

         // left and right distance
         int letDistance = kThAncestor(root.left , n , k);
         int rightDistance = kThAncestor(root.right, n, k);
         int max = Math.max(letDistance , rightDistance);
         if (max+1 == k){
             System.out.println(root.data);
             return max+1 ;
         }
         return max +1 ;
     }
 // Transformation of the sum tree
    public  static  int transformSumTree(Node root ){
        // base case
        if (root== null){
            return 0;
        }
        int leftChild = transformSumTree(root.left);
        int rightChild = transformSumTree(root.right);
        int newLeftData = root.left == null ? 0 : root.left.data ;
        int newRightData = root.right == null ? 0 : root.right.data ;
        int data = root.data;
        root.data = leftChild + newLeftData + rightChild + newRightData ;

        return  data ;
    }
// pree order traversal
    public  static void preOrder(Node root){
        if (root== null){
//                System.out.print(-1 + " ");
            return ;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transformSumTree(root);
        preOrder(root);

//        kThAncestor(root , 5 ,1);

//        System.out.println(lowestCommonAncestor(root , 4,5).data);
//         Node ls = lca2(root , 4,5);
//        System.out.println( lca(root , 2,3).data);
//        klevel(root , 1 ,3);

    }
}
