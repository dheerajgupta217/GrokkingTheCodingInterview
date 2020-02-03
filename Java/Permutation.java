package business;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
int [] arr  = {1,2,3};
permutation(arr);
    }
    static void permutation(int [] arr){
        int n = arr.length;
        int left = 0 , right = n-1;
        operate(arr,left,right);
    }
    static void operate(int [] arr , int left, int right){
        if(left == right){
            System.out.println(Arrays.toString(arr));
        }else {
            for (int i = left ; i < arr.length ;i++ ){
//                if(swapRequired(arr,left,i)){
                    arr = swap(arr,left,i);
                    operate(arr,left+1 , right);
                    arr = swap(arr , left , i);
//                }
            }
        }
    }
    public static int[] swap(int[] arr, int i, int current){
        int temp = arr[i];
        arr[i] = arr[current];
        arr[current]= temp;
        return arr;
    }
    static boolean swapRequired(int []arr , int i ,  int j ){
        for(int iter = i; i < j ; i++ ){
            if(arr[iter] == arr[j]){
                return false;
            }
        }
        return true;
    }

}
