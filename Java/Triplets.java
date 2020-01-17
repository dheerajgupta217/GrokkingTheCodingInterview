package business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Triplets {
    public static void main(String[] args) {
        int arr[] = {-3, 0, 1, 2, -1, 1, -2};
        System.out.println(searchTriplets(arr));
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j = i + 1; j < arr.length; j++) {
                int x = -(arr[i] + arr[j]);
                if (set.contains(x)) {
                    List<Integer> trips = new ArrayList<>();
                    trips.add(x);
                    trips.add(arr[i]);
                    trips.add(arr[j]);
                    triplets.add(trips);
                } else {
                    set.add(arr[j]);
                }
            }
        }
      return triplets;
    }
}


