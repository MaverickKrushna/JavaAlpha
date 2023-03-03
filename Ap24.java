package com.krushnaDSA;
import  java.util.ArrayList;

public class Ap24 {
    public static  void swap ( ArrayList<Integer> lst , int i , int j ){
        int temp = lst.get(i);
        lst.set(i , lst.get(j));
        lst.set(j , temp);
    }
    // container with most water
    public static int mostWater(ArrayList<Integer> height ) {
        int water = Integer.MIN_VALUE;
        for (int i= 0 ; i< height.size() ; i++){
            for(int j=i+1; j < height.size() ; j++){
                int hegthWater =Math.min(height.get(i) , height.get(j));
                int widthWater = (j-i);
                int newWater = hegthWater * widthWater ;
                water = Math.max(water , newWater);
            }
        }
       return water ;
    }
    // 2 pointer approach
    public static  int storeWate2Pointer(ArrayList<Integer> height){
        int water = Integer.MIN_VALUE;
        int leftPointer = 0 ;
        int rightPointer = height.size()-1;
        while (leftPointer < rightPointer){
            int hegthWater =Math.min(height.get(leftPointer) , height.get(rightPointer));
            int widthWater = (rightPointer - leftPointer);
            int newWater = hegthWater * widthWater ;
            water = Math.max(water , newWater);
            //
            if (height.get(leftPointer)< height.get(rightPointer)){
                leftPointer++;
            }
            else{
                rightPointer --;
            }

        }
        return water ;
    }
    // Target sum
    public static  void targetSum(ArrayList<Integer> lst , int target  ){
        for (int i=0 ; i< lst.size() ; i++){
            for (int j= i+1 ; j< lst.size() ; j++){
                if( (lst.get(i) + lst.get(j)) == target){
                    System.out.println("The indexs are "+ i + " "+ j);
                    return;
                }
            }
        }
        System.out.println("Any thing not match !!");
    }

    // 2 pointer approach
    public static  boolean targetSumIN(ArrayList<Integer> lst , int target){
        int lp = 0;
        int rp= lst.size()-1;
        while (lp< rp){
            if (lst.get(lp) + lst.get(rp) == target){
                return  true ;
            }
            if (lst.get(lp) + lst.get(rp) < target){
                lp++;
            }
            else {
                rp--;
            }
        }
        return  false;
    }
    // Rated Array List
    public  static  boolean targetSumRotatedArray(ArrayList<Integer> lst , int target ){
        int rp = breakingPoint(lst);
        int lp = rp+1 ;
        while (lp!=rp){
            if (lst.get(lp) + lst.get(rp) == target){
                return  true ;
            }
            if (lst.get(lp) + lst.get(rp) < target){
                if (lp == lst.size()-1){
                    lp=0;
                }
                lp++;
            }
            else {
                if (rp==0){
                    lp= lst.size()-1;
                }
                rp--;
            }
        }

       return  false ;
    }
    // optimize
    public  static  boolean targetSumRotatedArrayOPtimize(ArrayList<Integer> lst , int target ){
        int rp = breakingPoint(lst);
        int lp = rp+1 ;
        while (lp!=rp){
            if (lst.get(lp) + lst.get(rp) == target){
                return  true ;
            }
            if (lst.get(lp) + lst.get(rp) < target){
                lp = (lp+1)% (lst.size());
            }
            else {
                rp= (rp - 1 )% lst.size() ;

            }
        }

        return  false ;
    }

    public  static  int breakingPoint(ArrayList<Integer> lst){
        for (int i=0 ; i < lst.size()-1  ; i++){
            if (lst.get(i) <= lst.get(i+1)){

            }
            else {
                return  i ;
            }
        }
        return  0;
    }
    public static void main(String[] args) {
        ArrayList<Integer> RotedArray = new ArrayList<>();
        RotedArray.add(11);
        RotedArray.add(15);
        RotedArray.add(6);
        RotedArray.add(8);
        RotedArray.add(9);
        RotedArray.add(10);
        System.out.println( targetSumRotatedArray(RotedArray , 200));
        System.out.println(targetSumRotatedArrayOPtimize(RotedArray , 17));





//        ArrayList<Integer> lst = new ArrayList<>();
//        for (int i=1 ; i<=10 ; i++){
//            lst.add(i);
//        }
//        System.out.println(targetSumIN(lst , 50));
//        targetSum(lst , 50);



//        ArrayList<Integer> height = new ArrayList<>();
//        height.add(1);
//        height.add(8);
//        height.add(6);
//        height.add(2);
//        height.add(5);
//        height.add(4);
//        height.add(8);
//        height.add(5);
//        height.add(7);
//        System.out.println(height);
//        System.out.println(mostWater(height));
//        System.out.println(storeWate2Pointer(height));
//        targetSum(height , 13);

//        ArrayList<Integer> lst = new ArrayList<>();
//        lst.add(1);
//        lst.add(2);
//        lst.add(3);
//        lst.add(4);
//        lst.add(5);
 ////        lst.remove(2);
//        lst.add(2,6);
//        swap(lst , 2,5);
//        System.out.println(lst);
//        System.out.println(lst.get(2));
//        System.out.println(lst.contains(3));
//        System.out.println(lst.contains(5));
//        System.out.println(lst.size());
//        for (int i= lst.size()-1 ; i>=0 ; i--){
//            System.out.print(lst.get(i) +" ");
//        }
//        System.out.println();
//        int max = Integer.MIN_VALUE;
//        for (int i = 0 ; i< lst.size();i++){
////            if(lst.get(i)> max){
////                max= lst.get(i);
////            }
//            max = Math.max(lst.get(i),max );
//        }
//        System.out.println(max);
//        Collections.sort(lst); // Ascending order sorting
//        Collections.sort(lst , Collections.reverseOrder()); // Descending Order sorting
//        System.out.println(lst);
//     ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
//     ArrayList<Integer> arr1 = new ArrayList<>();
//     ArrayList<Integer> arr2 = new ArrayList<>();
//     arr1.add(1);
//     arr1.add(2);
//     arr2.add(3);
//     arr2.add(4);
//     arr2.add(5);
//     mainList.add(arr1);
//     mainList.add(arr2);
//     for (int i= 0 ; i< mainList.size() ; i++){
//         ArrayList<Integer> currList = mainList.get(i);
//         for (int j= 0 ; j< currList.size() ; j++){
//             System.out.print(currList.get(j) + " ");
//         }
//         System.out.println();
     }
    }

