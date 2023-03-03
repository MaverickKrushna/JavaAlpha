package com.krushnaDSA;

public class Ap_38_TRied {
    static class Node{
         Node children[] = new Node[26];
        boolean isEndOfWord;
         Node(){
             boolean isEndOfWord = false ;
             for (int i=0 ; i<26 ; i++){
                 children[i]= null ;
             }
         }
    }
    public  static Node root ;
    public static  void insert(String key){
        int level ;
        int len = key.length();
        int index ;
        Node currentNode = root ;
        for (level =0 ; level < len ; level++){
            index = key.charAt(level)-'a';
            if (currentNode.children[index]==null){
                currentNode.children[index]= new Node();
            }
            currentNode = currentNode.children[index];


        }
        currentNode.isEndOfWord = true ;

    }

    public static  boolean search(String key ){
        int level ;
        int len = key.length();
        int index ;
        Node currentNode = root ;
        for (level =0 ; level < len ; level++){
            index = key.charAt(level)-'a';
            if (currentNode.children[index]==null){
               return  false ;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord ;

    }

    // word break problem

    public static  boolean wordBreak(String key){
        // base case
        if (key.length()==0){
            return true ;
        }
        for (int i=1 ; i<= key.length() ; i++){
            if (search(key.substring(0,i))&& wordBreak(key.substring(i))){
                return true ;
            }
        }

        return  false ;
    }



    public static void main(String[] args) {


        // word break problem
        root = new Node();
        String words[]= {"i" , "like" ,"sam", "samsung","mobile","ice"};
        String key = "ilikesam";
        for (String i : words){
            insert(i);
        }

        System.out.println(wordBreak(key));
//        String keys[] = {"the", "a", "there", "answer", "any",
//                "by", "bye", "their"};
//        String output[] = {"Not present in trie", "Present in trie"};
//        root = new Node();
//        for (int i = 0; i < keys.length ; i++)
//            insert(keys[i]);
//
//        System.out.println(search("thfe"));

    }
}
