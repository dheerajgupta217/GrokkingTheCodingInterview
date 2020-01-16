/**
 * Given a sorted array, create a new array containing squares of all the number of the input array in the sorted orde
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 */

public class ArraySquareSum {
    public static void main(String[] args) {
        int[] arr = {-2, -1, 0, 1, 2};
        sortSquares(arr);
    }
    public static void sortSquares(int arr[]) {
        int n = arr.length;
        int k;
        for (k = 0; k < n; k++) {
            if (arr[k] >= 0)
                break;
        }
        int i = k - 1;
        int j = k;
        int ind = 0;
        int[] temp = new int[n];
        while (i >= 0 && j < n) {
            if (arr[i] * arr[i] < arr[j] * arr[j]) {
                temp[ind] = arr[i] * arr[i];
                i--;
            } else {
                temp[ind] = arr[j] * arr[j];
                j++;
            }
            ind++;
        }
        while (i >= 0) {
            temp[ind++] = arr[i] * arr[i];
            i--;
        }
        while (j < n) {
            temp[ind++] = arr[j] * arr[j];
            j++;
        }
        for (int x = 0; x < n; x++)
            System.out.println(temp[x]);
    }
}

