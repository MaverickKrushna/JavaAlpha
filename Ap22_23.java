package com.krushnaDSA;

public class Ap22_23 {

    public  static  void changeArray(int arr[], int i , int val){
        // base case
        if(i== arr.length){
            return;
        }
        // kaam
        arr[i]=val ;
        // innerFunction
        changeArray(arr , i+1 , val+1); // function call
        arr[i]  = arr[i]-2 ;// backtracking steps 
    }

    public  static  void printArray (int ar[]){
        for (int i : ar){
            System.out.println(i + " ");
        }

    }
    // Sub Sets back tracking
    public static  void subSets(String str , String ans , int i){
        // base case
        if(i== str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }
            else {
                System.out.println(ans);
            }
            return;
        }
        // kaam  inner Recursion function
        subSets(str , ans+str.charAt(i), i+1);
        subSets(str, ans , i+1);


    }
    public static  void permutation(String str , String ans ){
        // base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        // inner function
        for(int i=0 ; i< str.length() ; i++){
            char currCharactor = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            permutation(newStr , ans+currCharactor);
        }
    }
 // N- Queen Problem
    static  int count = 0 ;
     public static void nQueen(char board[][], int row ){
        // base case
        if (row== board.length){
//            printBoard(board);
            count++;
            return;
        }
        // colomn wise Queen set
        for (int j=0 ; j< board.length ; j++){
            if (isSafe(board, row , j)){
                board[row][j]='Q';
                nQueen(board, row+1);
                board[row][j]='X';
            }
        }
     }
     // isSafe for the NQueen problem
     public static  boolean isSafe(char board[][], int row , int col ){
        // vertical up
         for (int i= row-1 ; i>=0 ; i--){
             if (board[i][col]=='Q'){
                 return false ;
             }
         }
         // diagonal left
         for (int i= row-1 , j=col-1 ;( i>=0 && j>=0 ); i--, j--){
             if (board[i][j]=='Q'){
                 return false;
             }
         }
         // diagonal right
         for (int i= row-1 , j=col+1 ;( i>=0 & j< board[0].length ); i--, j++){
             if (board[i][j]=='Q'){
                 return false;
             }
         }

        return  true ;
     }

    // printing the chess board ||
    static  void printBoard(char board[][]){
        System.out.println("____Chess Board_____");
        for(int i=0 ; i< board.length ; i++){
            for (int j=0 ; j< board[0].length ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
 // Grid ways
    public static  int gridWays(int i, int j, int n, int m){
         if(i==n-1 && j==m-1){
             return  1 ;
         }
         else if(i==n || j==m){
             return 0;
         }
         int  right = gridWays(i , j+1 , n, m );
         int down = gridWays(i+1 , j , n, m);
         return  (right + down);
    }

    // Sudoku Solver
    public static  boolean sudokuSolver(int sudoku [][], int row , int col ){
         // base case
        if (row==9){
            return  true ;
        }
        // recursion
       int  netxRow = row ;
        int nextCol = col+1 ;
        if(col+1==9){
            netxRow = row +1 ;
            nextCol = 0;
        }
        if(sudoku[row][col]!=0){
            return  sudokuSolver(sudoku, netxRow , nextCol);
        }
        //  placing of digit in sudoku
        for(int digit =1 ; digit<=9 ; digit ++){
            if(isSafeSudokuDigit(sudoku , row , col , digit)){
                sudoku[row][col]=  digit ;
                // calling for the next f(n-1)
                if (sudokuSolver(sudoku, netxRow,nextCol)){
                    return  true ;
                }
                sudoku[row][col]= 0 ;
            }
        }


        return  false ;
    }

    // isSafe Sudoku Digit function
    public  static boolean isSafeSudokuDigit(int sudoku[][], int row , int col , int digit ){
         // column wise
        for (int i = 0 ; i<9 ; i++){
            if (sudoku[i][col]== digit){
                return  false;
            }
        }
        // Row  wise
        for (int j = 0; j <9 ; j++){
            if (sudoku[row][j]== digit){
                return  false;
            }
        }
        // grid in 3*3 matrix
        int startingRow = (row/3)*3 ; // endingRow = startingRow +3
        int startingCol = (col/3)*3 ; // endingCol = startingCol +3
        // Grid Traversal
        for (int i= startingRow ; i < startingRow+3 ; i++){
            for (int j= startingCol ; j< startingCol +3 ; j++){
                if (sudoku[i][j]== digit){
                    return  false;
                }
            }
        }

         return true ;
    }

    // Printing the sudoku
    public static  void printingSudoku(int sudoku[][]){
        for (int i= 0; i < 9 ; i++){
            for (int j= 0; j< 9 ; j++){
                System.out.print(sudoku[i][j]+ " ");
            }
            System.out.println();
        }
    }
    // main Method
    public static void main(String[] args) {
         int sudoku[][]={
                 {0,0,8,0,0,0,0,0,0},
                 {4,9,0,1,5,7,0,0,2},
                 {0,0,3,0,0,4,1,9,0},

                 {1,8,5,0,6,0,0,2,0},
                 {0,0,0,0,2,0,0,6,0},
                 {9,6,0,4,0,5,3,0,0},

                 {0,3,0,0,7,2,0,0,4},
                 {0,4,9,0,3,0,0,5,7},
                 {8,2,7,0,0,9,0,1,3}
         };

         int sudokuEvil[][]={
                 {0,0,0, 5,0,9, 0,0,6},
                 {0,1,0, 0,0,0, 0,0,0},
                 {5,4,0, 8,0,0, 0,9,0},

                 {8,9,0, 4,0,0, 0,6,0},
                 {0,0,0, 0,2,0, 3,0,0},
                 {0,0,7, 0,0,0, 0,0,0},

                 {0,0,6, 7,0,0, 0,0,0},
                 {0,0,1, 0,0,0, 0,5,0},
                 {7,5,0, 0,4,0, 0,0,2},


         };
        int sudokuEvil2[][]={
                {0,7,0, 0,8,0, 0,0,0},
                {0,1,0, 0,0,0, 0,3,0},
                {0,0,6, 7,0,9, 4,0,0},

                {0,0,8, 0,4,0, 0,0,0},
                {0,0,0, 0,5,0, 2,0,0},
                {0,6,0, 8,0,2, 0,0,1},

                {0,0,7, 2,0,6, 9,0,0},
                {0,0,0, 0,0,5, 0,0,0},
                {9,0,0, 0,0,0, 0,0,4},


        };


        if (sudokuSolver(sudokuEvil2, 0,0)){
            System.out.println("Solution exist");
            printingSudoku(sudokuEvil2);
        }
        else{
            System.out.println("Solution not exist !!");
        }

//         if (sudokuSolver(sudoku, 0,0)){
//             System.out.println("Solution exist");
//             printingSudoku(sudoku);
//         }
//         else{
//             System.out.println("Solution not exist !!");
//         }

//        System.out.println(gridWays(0,0,3,3));

//        int n=16;
//        char board[][] = new char[n][n];
//        for(int i=0 ; i< board.length ; i++){
//            for (int j=0 ; j< board[0].length ; j++){
//               board[i][j] = 'X';
//            }
//        }
//        nQueen(board,0);
//        System.out.println(count);


//        int myArr[] = new int[5];
//        changeArray(myArr , 0,1);
//        printArray(myArr);
//        System.out.println("Printing the subset of the given string !");
//        subSets("abc", "",0);
//        System.out.println("printing the permutation of the given string !");
//        permutation("abc", "");

    }
}
