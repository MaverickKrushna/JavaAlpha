package com.krushnaDSA;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Ap_36_PriorityQueue {
    static  class  Student implements  Comparable<Student>{
        String name ;
        int rank ;
        Student(String name , int rank){
            this.name = name ;
            this.rank = rank;
        }
        // methode orverriding
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }


    // NearBy Car
     static class Point implements  Comparable<Point>{
        int x;
        int y;
        int distSq;
        int ind ;
        Point(int x , int y , int ind ){
            this.x = x ;
            this.y = y ;
            this.ind = ind ;
            this.distSq = (x*x + y*y);
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }

    }

    // Connect N ropes +++++*****

    // Weakest Soldier
     public  static  class Row implements  Comparable<Row>{
        int soldiers ;
        int indx;
        Row( int soldiers , int indx ){
            this.soldiers = soldiers ;
            this.indx = indx ;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers){
                return this.indx - r2.indx ;
            }
           return  this.soldiers - r2.soldiers;
        }
    }


    // Sliding windos
    // max sub array pair
    static  class Pair implements  Comparable<Pair>{
        int val ;
        int ind ;
        Pair(int val ,int ind){
            this.val = val;
            this.ind = ind ;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
    }

    public static void main(String[] args) {

        // sliding windos
        int [] window = {1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]= new int[window.length - k +1];
        PriorityQueue<Pair> windo = new PriorityQueue<>();
        // 1st windo
        for (int i=0 ; i<k ; i++){
            windo.add(new Pair(window[i],i ));
        }
        res[0]= windo.peek().val;
        for (int i= k ; i < window.length ; i++){
            while (windo.size() >0 && windo.peek().ind <= (i-k)){
                windo.remove();
            }
            windo.add(new Pair(window[i],i ));
            res[i-k+1]= windo.peek().val ;
        }
        for (int i: res
             ) {
            System.out.print(i + " ");

        }


        // Weakest Soldier
//        int army[][]={
//                {1,0,0,0},
//                {1,1,1,1},
//                {1,0,0,0},
//                {1,0,0,0}
//
//        };
//        int k=2;
//        PriorityQueue<Row> soldier = new PriorityQueue<>();
//        for (int i=0 ; i< army.length; i++){
//            int soldiers =0 ;
//            for (int j=0;j < army[0].length ; j++){
//                soldiers+= army[i][j] == 1 ? 1 : 0;
//            }
//            soldier.add(new Row(soldiers , i));
//
//        }
//
//        for (int i= 0 ; i< k ;i++){
//            System.out.print(soldier.remove().indx + " ");
//        }
//


//        int rope[]={2,3,3,4,6};
//        PriorityQueue<Integer> ropes = new PriorityQueue<>();
//        for (int i=0 ; i< rope.length ; i++){
//            ropes.add(rope[i]);
//        }
//        int cost =0;
//
//        while (ropes.size() > 1){
//            int min1= ropes.remove();
//            int min2 = ropes.remove();
//            cost+= min1 + min2 ;
//            ropes.add(min1+min2);
//        }
//        System.out.println("The cost of the :"+ cost);

        // Connect N Ropes
//        int pts[][]={{3,3},{5,-1},{-2,4}};
//        int k=2;
//        PriorityQueue<Point> nearCar = new PriorityQueue<>();
//        for (int i=0 ; i< pts.length ; i++){
//            nearCar.add(new Point(pts[i][0] , pts[i][1],i+1) );
//        }
//        for (int i=0 ; i< k ; i++){
//            System.out.print( nearCar.remove().ind+ " ");
//
//        }
//





////        PriorityQueue<Integer> pq = new PriorityQueue<>();
////        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//     PriorityQueue<Student> st = new PriorityQueue<>(Comparator.reverseOrder());
//        st.add(new Student("A" , 5));
//        st.add(new Student("B",4));
//        st.add(new Student("C",2));
//        st.add(new Student("D",1));
//        st.add(new Student("E",6));
//        st.add(new Student("F" ,3));
//        st.add(new Student("E",7));
//
//        while (!st.isEmpty()){
//            System.out.println(st.peek().rank + "->"+ st.peek().name );
//            st.remove();
//        }


    }
}
