package com.krushnaDSA;

public class Ap16 {
    // Bit Manupulation

    public static  void checkEvenOdd(int n ){
        if((n&1)==1){
            System.out.println("Odd Number ");
        }
        else {
            System.out.println("Even Number ");
        }
    }
// Get Bits Operation Bro ......
    public static int getBits(int n , int i){
        int bitMark= 1<<i;
        if ((n & bitMark)==0 ){
            return 0;
        }

        return 1;
//
//        int bitmark= n>>i ;
//        if ((bitmark & 1)==1){
//           return 1 ;
//        }
//        return 0 ;
    }
    public static int setBits(int n , int i){
        int bitMark = 1<<i ;
        return (n | bitMark);
    }
    public static int clearBits(int n , int i){
        int bitMark = ~(1<<i) ;
        return(n & bitMark) ;
    }

    public  static  int updateBit(int n , int i , int ele){
        if(ele==1){
           return setBits(n,i) ;
        }
        else if(ele==0){
            return getBits(n,i);
        }
        return -1 ;
    }
    public static  int updateBitsModified(int n , int i , int ele){
        int clear= clearBits(n,i);
        int bitsMark= ele<<i ;

        return  (clear | bitsMark);
    }
// set i'th bits
    // for set ele=1
    // for get ele =0

    public  static  int setAndGetBits(int n , int i  , int ele){
        int bitMark= 1<<i;
        if(ele==1){
            return  (n|bitMark);
        }
        else if (ele==0){
            return (n & (~(bitMark)));
        }
        return -1;
    }

    // clear bits upto 0 to i'th position  ...
    public  static int clearUptoIthBits(int n , int i ){
        int bitMark = (~0) <<i;
        return n & bitMark ;
    }
    // clearBitsUptoRange( Number , ending Index , starting Index )
    public static  int clearBitsUptoRange(int n , int j , int i ){
        // ending Index
        int a =(~0)<< (j+1) ;
        // starting Index
        int b = (1<<i) -1 ;

        int bitMark = a | b ;
        return  n & bitMark ;

    }

// Checking Number is 2 power or not
    public  static  boolean check2Powe(int n){
//        if((n & (n-1) )==0){
//            return true;
//        }
//        return false ;
        return ((n & (n-1) )==0) ? true : false ;
    }
    public static  int countSetBits(int n ){
        int count=0;
        while (n>0){
            if ((n&1) ==1){
                count++;
            }
            n= n>>1;

        }
        return count;
    }

    // fast Exponential b^n
    public static int fastExponetial(int b , int n ){
        int powerResult=1 ;
        while (n>0){
            if ( (n&1) ==1){
                    powerResult*=b;
            }
            b*=b ;
           n= n>>1;
        }
        return powerResult;
    }
    public static void main(String[] args) {
        System.out.println(15&1);
        checkEvenOdd(15);
        checkEvenOdd(14);
        System.out.println(getBits(10,1));
        System.out.println(setAndGetBits(10,2,1));
        System.out.println(check2Powe(15));
        System.out.println(countSetBits(7));

        System.out.println(fastExponetial(12,2));
        System.out.println(~12);
    }
}
