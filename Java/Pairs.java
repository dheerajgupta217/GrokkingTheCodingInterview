package business;

public class Pairs {
    public static void main(String[] args) {
        int arr[] = {3,2,1};
        int arr_size = arr.length;
        System.out.println(getArray(arr, arr_size));
    }

    static int getArray(int arr[], int n) {
        int start = 0, end = n - 1, i, max, min;
        for (start = 0; start < n - 1; start++) {
            if (arr[start] > arr[start + 1])
                break;
        }
        if (start == n - 1) {
            return 0;
        }
        for (end = n - 1; end > 0; end--) {
            if (arr[end] < arr[end - 1])
                break;
        }
        max = arr[start];
        min = arr[start];
        for (i = start + 1; i <= end; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        for (i = 0; i < start; i++) {
            if (arr[i] > min) {
                start = i;
                break;
            }
        }
        for (i = n - 1; i >= end + 1; i--) {
            if (arr[i] < max) {
                end = i;
                break;
            }
        }
        return (end - start)+1;
    }

}