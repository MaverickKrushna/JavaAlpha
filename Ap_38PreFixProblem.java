package com.krushnaDSA;

public class Ap_38PreFixProblem {
    static class Node{
      Node children[] = new Node[26];
      int freq ;
      boolean isEndOfWord=false;
        Node(){
           freq=1 ;
            for (int i=0 ; i<26 ; i++){
                children[i]= null ;
            }
        }
    }
    public static Node  root ;
    public static  void insert(String key ){
        int level ;
        int len = key.length();
        int index ;
        Node currentNode = root ;
        for (level =0 ; level < len ; level++){
            index = key.charAt(level)-'a';
            if (currentNode.children[index]==null){
                currentNode.children[index]= new Node();
            }else{
                currentNode.children[index].freq++;
            }
            currentNode = currentNode.children[index];


        }
        currentNode.isEndOfWord = true ;

    }


    public static void main(String[] args) {

        String arr[]= {"zebra" , "dog" , "duck", "dove"};


    }
}
