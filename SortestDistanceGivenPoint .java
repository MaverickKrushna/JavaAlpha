package com.krushnaDSA;

import java.util.Scanner;

class SortestDistanceGivenPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("The Number : ");
        int n = scan.nextInt();
        int d [][]= new int[n][2];
        for (int i=0 ; i< d.length ; i++){
            for (int j= 0 ; j < d[0].length ; j++ ){
                d[i][j]= scan.nextInt();
            }
        }
        int x1=0, x2 = 0;
        int y1=0, y2 =0;
        int min =Integer.MAX_VALUE ;
        for (int i=0 ; i< d.length ; i++){
            for (int j= i+1 ; j < d[0].length ; j++ ){
                int x =(d[i][0] - d[j][0] )*(d[i][0] - d[j][0] ) ;
                int y = (d[i][1] - d[j][1] )*(d[i][1] - d[j][1] ) ;

                 int currdistance = (int) Math.sqrt(x+y);
                 if (min > currdistance){
                     x1 = d[i][0];
                     x2 = d[j][0];
                     y1 = d[i][1];
                     y2 = d[j][1];
                 }
                 min = Math.min(min , currdistance);
            }
        }
        System.out.println("("+ x1 +","+ y1 +")" +","+ "(" + x2 + "," + y2 +")");
        System.out.println(min);
    }
}
