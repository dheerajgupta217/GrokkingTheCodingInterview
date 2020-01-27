package business;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0};
        sort(arr);
    }
//    static int[] sortArray(int[] arr) {
//        int  count0 = 0, count1 = 0, count2 = 0;
//        for (int i = 0; i < arr.length; i++) {
//            switch (arr[i]) {
//                case 0:
//                    count0++;
//                    break;
//                case 1:
//                    count1++;
//                    break;
//                case 2:
//                    count2++;
//                    break;
//            }
//        }
//       int index = 0;
//        while (count0 > 0) {
//            arr[index++] = 0;
//            count0--;
//        }
//        while (count1 > 0) {
//            arr[index++] = 1;
//            count1--;
//        }
//        while (count2 > 0) {
//            arr[index++] = 2;
//            count2--;
//        }
//        return arr;
//    }

    public static void sort(int[] arr) {
        int n = arr.length, zero = 0 , one = 0, two = n-1;
        int temp = 0;
        while (one <= two){
            switch (arr[one]){
                case 0:{
                    temp  = arr[zero];
                    arr[zero] = arr[one];
                    arr[one] = temp;
                    zero++;
                    one++;
                    break;
                }
                case 1:{
                    one ++;
                    break;
                }
                case 2:{
                    temp = arr[one];
                    arr[one] = arr[two];
                    arr[two] = temp;
                    two --;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
