import java.io.*;
class MinimunPathTriangle {
 
  static int helper(int A[][], int i, int j)
  {
 
    if(i == A.length){
      return 0 ;
    }
 
    int mn ;
 
    mn = A[i][j] + Math.min(helper(A, i+1,j), helper(A,i+1, j+1)) ;
 
    return mn ;
  }
  static int minSumPath(int A[][]) {
    return helper(A, 0, 0) ;
  }
 
  public static void main(String[] args)
  {
    int triangle [][] = { { 2 },
                         { 3, 9 },
                         { 1, 6, 7 }  };
    System.out.print(minSumPath(triangle));
  }
}
