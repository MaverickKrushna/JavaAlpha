package com.krushnaDSA;
public class Main {

        static void printPairs(int arr[])
        {
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (arr[i]!=arr[j] && arr[i]!=0){
                        System.out.println( arr[i]*10 + arr[j] );
                    }
                    if (arr[i]!=arr[j] && arr[j]!=0){
                        System.out.println( arr[j]*10 + arr[i] );
                    }

                }

            }
        }
  static void setConverter(int arr[] , int umique[] ){
      boolean unique[]= new boolean[10];
      for (int i=0 ; i< arr.length ; i++){
         unique[arr[i]]= true ;
      }



  }


    public static void main(String[] args) {
            int arr[]={1,2,3,0};
            int uniqueset[]= new int[10];
            printPairs(uniqueset);


    }
}





