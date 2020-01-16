/*
* Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target
 * */
public class ArraySum {
    public static void main(String[] args) {
    int [] arr= {1,2,3,4,5,6};
        System.out.println(sumExists(arr,5));
    }
    static boolean sumExists(int [] arr , int target){
        int left = 0;
        int right = (arr.length-1);
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target ){
                return true;
            }
            else if(sum < target){
                left++;
            }else{
                right --;
            }
        }
            return false;
    }
}

