package com.krushnaDSA;

public class SubArray {

    public static void printSubArrayList(int MyArray[]) {
        int total_sub_array = 0;
        for (int i = 0; i < MyArray.length; i++) {

            for (int j = i; j < MyArray.length; j++) {
                System.out.print((total_sub_array + 1) + ") ");
                for (int k = i; k <= j; k++) {
                    System.out.print(MyArray[k] + " ");

                }
                total_sub_array++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

    // Maximum SubArray Problems
    public static void printMaxSubArray(int[] MyArray) {
        int currentSum;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < MyArray.length; i++) {
            for (int j = i; j < MyArray.length; j++) {
                currentSum = 0;
                for (int k = i; k <= j; k++) {
                    currentSum += MyArray[k];
                }
                System.out.println("Current sum : " + currentSum);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
            System.out.println();
        }
        System.out.println("The maximum sum of the sub Array :" + maxSum);
    }

    // Prefix Array For Finding Maximum Sum in Array
    public static void printPrefixSubArrayMax(int[] MyArray) {
        int[] prefixArray = new int[MyArray.length];
        prefixArray[0] = MyArray[0];
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + MyArray[i];
        }
        int currentSum;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < MyArray.length; i++) {
           currentSum =0;
            for (int j = i; j < MyArray.length; j++) {
                // currentSum = prefix[end] - prefix[start-1 ]
                // if start == 0 then currentSum = prefix[end]
                currentSum = (i == 0) ? prefixArray[j] : (prefixArray[j] - prefixArray[i - 1]);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
                System.out.println();
            }

        }
        System.out.println("The maximum sum Of subArray : "+ maxSum);
    }

    // maximum subArray in KADAN'S ALGORITHM
    public  static  void kadanes(int MyArray[]){
        int ms= Integer.MIN_VALUE ;
        int cs = 0;
        for (int i=0 ; i< MyArray.length  ; i++){
            cs+= MyArray[i];
            if(cs<0){
                cs=0 ;
            }
            ms= Math.max(cs , ms);
        }
        System.out.println("The maximum sum Of subArray : "+ ms);
    }
    // minimum mumber is array
     public static  void minimumArray(int MyArray[]){
        int min = Integer.MAX_VALUE ;

        for(int i=0 ; i< MyArray.length ; i++){
            if (min> MyArray[i]){
                min=MyArray[i];
            }

        }
         System.out.println("The maximum sum Of subArray : "+ min);
     }
// Checking all The Negative Number than Kadanes Algorithm not applieded

    public static  void AdvancedKadanes(int MyArray[]){
        int positiveNumber = 0 ;
        for (int i=0 ; i< MyArray.length ;i++){
            if (MyArray[i]>0){
                positiveNumber=1 ;
                break;

            }
        }
        if (positiveNumber ==1){
            kadanes(MyArray);
        }
        else{
            minimumArray(MyArray);
        }
    }
    public static void main(String[] args) {
        int MyArray[] = {-2,-3,4,-1,-2,1,5,3};
        System.out.println("Print the SubArray of the MyArray :");
        printSubArrayList(MyArray);
        System.out.println("The Maximum sum of the MyArray :");
        printMaxSubArray(MyArray);

    }
}
