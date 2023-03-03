package com.krushnaDSA;

public class Ap12 {
// Trapping Rainwater --------
    public static  int waterTrapping(int MyArray[]){
        int n= MyArray.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        // the left Maximum ____
        leftMax[0]=MyArray[0];
        for(int i=1 ; i<n ; i++ ){
            leftMax[i]=Math.max(leftMax[i-1],MyArray[i] );

        }
        // the right maximum ____
        rightMax[n-1]= MyArray[n-1];
        for (int i=n-2 ; i >=0 ; i--){
            rightMax[i]= Math.max(rightMax[i+1],MyArray[i] );
        }
        //trapped RainWater
        int trappedWater = 0 ;
        for (int i=0 ; i< n ; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i] );
            trappedWater += (waterLevel - MyArray[i]);
        }

        return trappedWater;


    }


// Buy and Sell Stocks __________
    // profit = sellingPrice - BuyingPrice
    public static  int maximumProfit(int stock[]){
        int profit =0  ;
        int buyingPrice = Integer.MAX_VALUE;


        for (int i=0 ; i< stock.length ; i++){
            if (buyingPrice < stock[i]){
                int varProfit = stock[i] - buyingPrice;
                profit = Math.max(varProfit , profit);
            }
            else{
                buyingPrice = stock[i];
            }

        }

//        for (int i=1 ; i< stock.length ; i++){
//            int curp;
//            for (int j=i-1 ; j>=0 ; j--){
//                curp = stock[i]- stock[j];
//                profit = Math.max(curp , profit);
//            }
//        }
        return profit ;
    }


    
    public static void main(String[] args) {
        int  bar[]={4,2,0,6,3,2,5};
        System.out.println("Trapped Water : "+waterTrapping(bar));
        int stock[]={7,1,5,3,6,4};
        System.out.println("The maximum Profit : "+ maximumProfit(stock));


    }
}
