package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Quadraplets {
    public static void main(String[] args) {
        int [] arr = {4, 1, 2, -1, 1, -3};
        System.out.println(searchQuadruplets(arr, 1));
    }


    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        int n = arr.length;
        HashMap<Integer, Couples> map = new HashMap<Integer, Couples>();
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                map.put(arr[i] + arr[j], new Couples(i, j));
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(target - sum)) {
                    Couples couple = map.get(target - sum);
                    if (couple.first != i && couple.first != j && couple.second != i && couple.second != j) {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(arr[i]);
                        quadruplet.add(arr[j]);
                        quadruplet.add(arr[couple.first]);
                        quadruplet.add(arr[couple.second]);
                        quadruplets.add(quadruplet);
//                        System.out.print("["+arr[i] + ", " + arr[j] +", " + arr[couple.first] +", " + arr[couple.second]+"]");
                    }
                    break;
                }
            }
        }

        for(List<Integer>  list: quadruplets){
            Collections.sort(list);
        }
        for(int i = 0; i <quadruplets.size()-1; i++) {
//            System.out.println("" + quadruplets);
         if(quadruplets.get(i).equals(quadruplets.get(i+1))){
             quadruplets.remove(i);
        }

         }

        return quadruplets;
    }
    static class Couples {
        int first, second;
        public Couples(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
