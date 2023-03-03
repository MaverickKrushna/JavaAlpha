package com.krushnaDSA;

public class Ap15 {
    // String In java
    public static  boolean pallendromString(String str){
        int len = str.length();
        for (int i=0 ; i<= len/2 ;i++){
            if(str.charAt(i)!=str.charAt(len-i-1)){
                return false;
            }
        }
        return  true ;
    }

    // Given a Root with 4
    /*
    *      N
    * W         E
    *     s
    * */
    public static  double compass(String str ){
        double sortestPath=0 ;
        int n = str.length() ;
        int x =0 , y=0;
        for (int i=0 ; i< n ; i++){
            if (str.charAt(i)=='E'){
                x++;
            }
            else if(str.charAt(i)=='W'){
                x--;
            }
            else if(str.charAt(i)=='N'){
                y++;
            }
            else if(str.charAt(i)=='S'){
                y--;
            }
            else {
                System.out.println("Something wrong input Error !!");
                return -1;
            }

        }
        double path= Math.pow(x,2) + Math.pow(y,2);
        sortestPath = Math.sqrt(path);
        return  sortestPath;
    }

    public  static  String  toUpperFirstCase(String str ){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i=1 ; i< str.length() ; i++){
            if(str.charAt(i)==' ' && i < str.length()-1 ){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));

            }
            else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
//        String str = "noon";
//        System.out.println(pallendromString(str));
//        String path = "WNEENESENNN";
//        double sortPath = compass(path);
//        System.out.println(sortPath);
//        String s1 ="Tony";
//        String s2 = "Tony";
//        String s3= new String("Tony");
//        String s4= new String("Tony");
//        if (s4.equals(s3)){
//            System.out.println("Equal ");
//
//        }
//        else{
//            System.out.println("Not equal ");
//        }
//        String str = "Iam Krushna Chandra Sahu ";
//        System.out.println(str.substring(0,15));
//        int a=10 ;
//        String n=Integer.toString(a) + "hekk";
//        System.out.println(n);

        String str = "Hi, krushna chandra sahu from berhmpur ganjam here done here to go ";
        System.out.println(toUpperFirstCase(str));

    }
}
