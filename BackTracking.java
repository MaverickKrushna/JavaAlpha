package com.krushnaDSA;

import java.util.*;


public class BackTracking {
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
    static  class BinaryTree{
        static  int ind =-1 ;
        public  static  Node buildTree(int nodes[]){
            ind ++;
            if (nodes[ind]==-1){
                return  null     ;
            }
            Node newNode = new Node(nodes[ind]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return  newNode ;

        }

    }


    public static void main(String[] args) {

        

    }
}
