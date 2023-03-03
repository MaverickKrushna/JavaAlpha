package com.krushnaDSA;

public class Ap20 {
    public static boolean  isSortedArray(int arr[] , int i){
        if(i== arr.length-1){
            return true;
        }
        if (arr[i]>arr[i+1]){
            return false;
        }

        return  isSortedArray(arr, i+1);
    }
    public  static  int findIndexKey(int arr[] , int key,int i ){
        if (i== arr.length){
            return -1;
        }
        if (arr[i]==key) {
            return i;
        }
       return findIndexKey(arr, key , i+1);

    }
    public  static  int LastfindIndexKey(int arr[] , int key,int i ){
        if (i== arr.length){
            return -1;
        }
        if (arr[i]==key) {
            return i;
        }
        return findIndexKey(arr, key , i+1);

    }

    public static int powerOfN(int n , int p){
        if (p==0){
            return 1;
        }
        return  n*powerOfN(n,p-1);
    }
    public  static  int optimisePower(int n, int p){
        if (p==0){
            return 1;
        }
        int halfPowerSqr = optimisePower(n,p/2);
        if(p%2==0){
            return halfPowerSqr * halfPowerSqr  ;
        }
        return  n* halfPowerSqr * halfPowerSqr;
    }
    public static int flooringTile(int n ){
        if(n==0|| n==1){
            return 1;
        }
        // vertical tiling
    int fnm1 = flooringTile(n-1); //f(n-1) =
    int fnm2 = flooringTile(n-2); // f(n-2)
    int totalway = fnm1 + fnm2 ;
    return  totalway ;
    }
    public static void removeDuplicate(String str , int idx, StringBuilder newStr , boolean []map){
        if (idx == str.length()){
            System.out.println(newStr);
            return;
        }
        char currentChar = str.charAt(idx) ;
        if(map[currentChar - 'a']){
            removeDuplicate(str , idx +1 , newStr , map);
        }
        else{
            map[currentChar -'a']=  true ;
            removeDuplicate(str , idx +1 , newStr.append(currentChar), map);
        }
    }


    public  static  int paringFriends(int noOfFriends){
        if (noOfFriends ==1 || noOfFriends==2){
            return noOfFriends;
        }
        int single= paringFriends(noOfFriends-1);
        int paring = (noOfFriends-1)*paringFriends(noOfFriends-2);
        return (single + paring) ;

    }
    //problem 14
    public static  void printBinaryString(int n , int lastPlaceValue , String str ){
        if (n==0){
            System.out.println(str);
            return;
        }
        printBinaryString(n-1 , 0 , str+"0");
        if (lastPlaceValue==0){
            printBinaryString(n-1 ,1 , str+"1");
        }
    }
    public static  void printBinaryDigit(int n , String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinaryDigit(n-1,str+"0");
        printBinaryDigit(n-1,str+"1");
    }
    public static void main(String[] args) {
//        String str = "apnacollege";
//        removeDuplicate(str ,0, new StringBuilder(),new  boolean [26]);
//        System.out.println(paringFriends(3));

//        int arr[]={5,1,2,3,4,5,6};

//        System.out.println(isSortedArray(arr,0));
//        System.out.println(findIndexKey(arr,6,0));
//        System.out.println(powerOfN(8,2));
//        System.out.println(optimisePower(8,3));
//        System.out.println(flooringTile(4));

//        printBinaryString(4 , 0, "");
          printBinaryDigit(4,"");
    }
}
