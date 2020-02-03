package business;

import java.util.Arrays;

public class JumpProgram {

    private static int canJump(int[] arr) {
        int num = arr.length;
        int[] jumps = new int[num];
        if (num == 0){
            return 0;
        }
        jumps[0] = 0;
        for (int i = 1; i < num; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(jumps));
        return (jumps[num - 1] );
    }

    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        System.out.println(canJump(arr));
    }
}
