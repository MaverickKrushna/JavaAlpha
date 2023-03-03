package com.krushnaDSA;

import java.util.ArrayList;

public class Ap_36_Heap {

    static  class  Min_Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int child = arr.size()-1;// insert in the last index // child index
            int parent = (child - 1)/2 ; // parent index
            while (arr.get(child) < arr.get(parent)){
                int tParent= parent;
                int temp = arr.get(child);
                arr.set(child , arr.get(parent));
                arr.set(parent , temp);
                child = tParent ;
                parent = (child - 1)/2 ;
            }
        }
        public  int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = 2*i +1 ;
            int right = 2*i +2 ;
            int mindInd = i ;
            if ((left < arr.size()) && (arr.get(mindInd) > arr.get(left))){
                mindInd= left ;
            }
            if ((right < arr.size() )&& (arr.get(mindInd) > arr.get(right))){
                mindInd= right ;
            }
            if (mindInd!=i){
                int temp = arr.get(mindInd);
                arr.set(mindInd, arr.get(i));
                arr.set(i , temp);
                heapify(mindInd);
            }
        }

        public  int remove(){
            int data = arr.get(0);
            int start=0;
            int end= arr.size()-1;
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            heapify(start);
          return  data ;
        }

        public boolean isEmpty(){
            return  arr.size()==0 ;
        }

    }

    public static void main(String[] args) {
        Min_Heap hp = new Min_Heap();
        hp.add(1);
        hp.add(2);
        hp.add(3);
        hp.add(5);
        hp.add(4);
        hp.add(7);
        while (!hp.isEmpty()){
            System.out.println(hp.peek());
            hp.remove();
        }

    }
}
