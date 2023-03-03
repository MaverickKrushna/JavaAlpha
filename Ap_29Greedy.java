package com.krushnaDSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ap_29Greedy {
    public static  void activitySelection(int startTime [] , int endTime[]){
        // Basic of the activity
        int myAct =0;
        ArrayList<Integer> activity = new ArrayList<>();
        // for 1st activity
        myAct ++ ;
        activity.add(0);
        int prevEndTime= endTime[0];
        for (int i=1 ; i< endTime.length ; i++){
           if (startTime[i] >= prevEndTime){
               myAct++;
               activity.add(i);
               prevEndTime = endTime[i];
           }

        }
        System.out.println("Number of activity done : "+ myAct);
        System.out.print("The activity are : ");
        for (int i=0 ;i < activity.size(); i++){
            System.out.print( "A"+activity.get(i) + "  ");
        }

    }

    public static  void  optimalActivitySelection(int startTime[] , int endTime[]){
        int activities[][]= new int[endTime.length][3];
        for (int i=0 ; i < activities.length ; i++){
            activities[i][0]=i;
            activities[i][1]= startTime[i];
            activities[i][2]= endTime[i];
        }
        // lambda function for sorting based on the EndTIme
        Arrays.sort(activities , Comparator.comparingDouble(o->o[2]));
        // activity selection
        // Basic of the activity
        int act =0;
        ArrayList<Integer> ans = new ArrayList<>();
        // for 1st activity
        act++ ;
        ans.add(activities[0][0]);
        int prevEndTime= activities[0][2];

        for (int i=1 ; i< endTime.length ; i++){
            if (activities[i][1] >= prevEndTime){
                act++;
                ans.add(activities[i][0]);
                prevEndTime = activities[i][2];
            }

        }
        System.out.println("Number of activity done : "+ act);
        System.out.print("The activity are : ");
        for (int i = 0; i < ans.size(); i++){
            System.out.print( "A"+ ans.get(i) + "  ");
        }

    }
 // Fractional knapsack
    public static void fractionalKnapsack(int weight[] , int value[] , int weightCapacity ){
        int capacity = weightCapacity ;
        double knapsackValue =0 ;

        double factionalValue[][]= new double[value.length][2];
        for (int i=0 ; i< weight.length ;i++){
            factionalValue[i][0]= i;
            factionalValue[i][1]= value[i]/ (double)weight[i];
        }
        // lambada function
        Arrays.sort(factionalValue , Comparator.comparingDouble(o->o[1]));
        // knapsack
        for (int i= factionalValue.length -1 ; i>=0 ; i--){
            int indx =(int) factionalValue[i][0];
            if (capacity >= weight[indx]){

                capacity -= weight[indx] ;
                knapsackValue += value[indx];
            }
            else{
                knapsackValue += factionalValue[i][1]*capacity ;
                capacity =0;
                break;
            }
        }
        System.out.println("The knapsack optimal solution : "+ knapsackValue);
    }
    // Min Absolute Different pairs
    public static  int minAbsoluteDifferent(int A[] , int B[]){
        int minDiff = 0 ;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i=  0 ; i<A.length ; i++){
            minDiff += Math.abs(A[i]- B[i]);
        }
        return  minDiff ;
    }
// Max lenght chain pair


    //IndianCoin System
    public static  void indianCoinSystem(int amount ){
        ArrayList<Integer> coins = new ArrayList<>();
        int money[]={2000,500,200,100,50,20,10,5,2,1};
        int numberOfCoins = 0 ;
        for (int i=0 ; i< money.length ; i++){
            if (money[i] <= amount ){
                while (money[i] <= amount){
                    numberOfCoins ++ ;
                    amount-= money[i];
                    coins.add(money[i]);
                }
            }
        }
        System.out.println("The number of the coins : "+ numberOfCoins);
        System.out.print("The coins are :");
        for (int i=0 ; i < coins.size() ; i++){
            System.out.print(" "+ coins.get(i) + " ");
        }

    }
    // Job sequence problem
    public static class  Job{
        int deadLine ;
        int profit ;
        int id ; // 1=A , 2=B , 3=C .......
        Job(int idd , int deadLineL , int profitt){
            this.id = idd ;
            this.profit = profitt ;
            this.deadLine = deadLineL ;
        }
    }
    // function of the job sequence
    public  static  void jobSequenceProblem(int jobInfo[][]){
        ArrayList<Job> jobs = new  ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++){
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }
        // This is the lambda function for sorting descending order of the ArrayList
        Collections.sort(jobs , (obj1 , obj2)-> obj2.profit - obj1.profit);

        // Array List sequence
        ArrayList<Integer> ans = new ArrayList<>();
        int time = 0 ;
        int profit =0;
        for (int i =0 ; i< jobInfo.length ; i++){
            if (jobs.get(i).deadLine > time){
                ans.add(jobs.get(i).id);
                time ++ ;
                profit+= jobs.get(i).profit ;

            }
        }
        System.out.println("The maximum job :"+ time);
        System.out.println("The total profit :"+ profit);
        System.out.print("The Jobs are done :");

        for (int i=0 ; i< ans.size() ; i++){
            System.out.print(" "+ ans.get(i)+" ");

        }

    }
    // Chocola problem
    public  static  void chocolaProblem(Integer costVer[] , Integer costHor[]){
        Arrays.sort(costHor , Collections.reverseOrder());
        Arrays.sort(costVer , Collections.reverseOrder());
        int h=0 , v=0;
        int hp=1 ,vp=1;
        int cost = 0 ;

        while (h< costHor.length && v < costVer.length){
            if(costVer[v]<= costHor[h]){
                cost+= (costHor[h]*vp);
                hp++ ;
                h++ ;
            }else{
                cost+= (costVer[v]*hp);
                vp++ ;
                v++ ;
            }

        }

        while (h< costHor.length){
            cost+= (costHor[h]*vp);
            hp++ ;
            h++ ;
        }
        while (v < costVer.length){
            cost+= (costVer[v]*hp);
            vp++ ;
            v++ ;
        }
        System.out.println("The total cost : "+ cost);
    }

    public static void main(String[] args) {

        // Chocola Problem
        int n=4 ;
        int m=6;
        Integer costVer[]={2,1,3,1,4};// m-1
        Integer costHor[]={4,1,2};//n-1
        chocolaProblem(costVer , costHor);

        // Job sequence
//        int jobInfo [][]={{4,20},{1,10},{1,40},{1,30}};
//        jobSequenceProblem(jobInfo);


        // India coin amount
//        indianCoinSystem(590);

        // min absolute Difference pairs
       /* int A[]={1,2,3};
        int B[]={2,1,3};
        System.out.println(minAbsoluteDifferent(A,B));*/

        // knapsack
//        int weight []= {10,20,30};
//        int value []= {60,100,120};
//        int w=50;
//        fractionalKnapsack(weight , value , w);
//       int  values[] = {1,2,3};
//        int weights[] = {4,5,1};
//        int ws =4;
//        fractionalKnapsack(weights , values , ws);



        // Activity Selection ....
//        int sartTime[]={1,3,0,5,8,5};
//        int endTime []={2,4,6,7,9,9};
//        activitySelection(sartTime , endTime);
//        int start[]={3,1,0,5,5,8};
//        int end []={4,2,6,7,9,9};
//
//        optimalActivitySelection(start, end);
    }
}
