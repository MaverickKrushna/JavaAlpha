package com.krushnaDSA;

import java.util.Stack;

public class Ap28_Sq {
    public static  boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for (int i=0 ; i< str.length() ; i++){
            char ch = str.charAt(i);
            if(ch=='(' || ch== '{' || ch=='['){
                s.push(ch);
            }

            else if(ch==')' || ch== '}' || ch==']'){
                if (s.isEmpty()){
                    return false ;
                }
                if ((ch==')' && s.peek()=='(') ||
                        (  ch== '}' && s.peek()=='{' ) ||
                        (  ch==']' && s.peek()=='[')){
                    s.pop();
                }
                else{
                    return false ;
                }
                
            }

        }
        if (s.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
    // IsDuplicates ____-----_____----
    public  static  boolean isDuplicate(String str ){
        Stack<Character> s = new Stack<>();
        for (int i=0; i< str.length() ; i++){
            char ch = str.charAt(i);
            // Closing tags
            if(ch==')'){
                int count=0;
                while (s.peek()!='('){
                    s.pop();
                    count ++;
                }
                if (count < 1){
                    return true ;
                }
                else{
                    s.pop();
                }
            }
            else{
                s.push(ch);
            }
        }
        return  false;
    }

    // Histogram Problem
    public  static  int histogram(int hist []){
        int rightSmaller[] = new int[hist.length];
        Stack<Integer> s = new Stack<>();
        // right smaller !!
        for (int i = hist.length -1; i>=0 ; i--){
            while (!s.isEmpty() && hist[ s.peek()] >= hist[i] ){
                s.pop();
            }
            if (s.isEmpty()){
                rightSmaller[i]= hist.length;
            }
            else{
                rightSmaller[i]= s.peek();
            }
            s.push(i);

        }
        // Empty the stack
        while (!s.isEmpty()){
            s.pop();
        }
        // left smaller
        int leftSmaller[] = new int[hist.length];
        for (int i=0 ; i< hist.length ; i++){
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]){
                s.pop();
            }
            if (s.isEmpty()){
                leftSmaller[i]=-1;
            }
            else{
                leftSmaller[i]= s.peek();
            }
            s.push(i);
        }
        int area = Integer.MIN_VALUE;
        for (int i=0 ; i< hist.length ; i++){
            int currentArea = hist[i]*(rightSmaller[i]- leftSmaller[i]-1);
            area=Math.max(area, currentArea);
        }
        return area;
    }
    // public jistogra,m
    public static  int maxAreaOfHistogram(int histogram[]){
        int area = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        int rightSmall []=new int[histogram.length];
        for (int i= histogram.length-1 ; i>=0 ; i--){
            while (!s.isEmpty() &&  histogram[s.peek()]>= histogram[i]){
                s.pop();
            }
            if (s.isEmpty()){
                rightSmall[i]=histogram.length;
            }
            else{
                rightSmall[i]= s.peek();
            }
            s.push(i);
        }
        // Empty the stack
        while (!s.isEmpty()){
            s.pop();
                    }
        // leftSmaller
        int leftSmaller []=new int[histogram.length];
        for (int i=0 ; i<histogram.length; i++){
            while (!s.isEmpty() &&  histogram[s.peek()]>= histogram[i]){
                s.pop();
            }
            if (s.isEmpty()){
                leftSmaller[i]=-1;
            }
            else{
                leftSmaller[i]= s.peek();
            }
            s.push(i);
        }

        for (int i=0 ; i< histogram.length ; i++){
            int currentArea = histogram[i]*(rightSmall[i]- leftSmaller[i]-1);
            area=Math.max(area, currentArea);
        }

        return area;
    }
    public static void main(String[] args) {

        int hist []={2,1,5,6,2,3};
        System.out.println(histogram(hist));
        System.out.println(maxAreaOfHistogram(hist));
//        String str = "({}{}[](()))";
//        System.out.println(isValid(str));
//        String str1 = "((((a+b)+(a-b)))))";
//        System.out.println(isDuplicate(str1));



    }
}
