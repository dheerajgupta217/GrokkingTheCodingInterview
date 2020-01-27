package business;

import java.util.Stack;

public class BackspaceProcesor {
    public static void main(String[] args) {
        String str1="xp#", str2="xyz##";
        System.out.println(checkEquality(str1,str2));
    }
    static boolean checkEquality(String str1 , String str2){
        return compressedString(str1).equals(compressedString(str2));
    }

    static String compressedString(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != '#')
                stack.push(str.charAt(i));
            else if (!stack.isEmpty())
                stack.pop();
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        for (int j = res.length() - 1; j >= 0; j--) {
            result.append(res.charAt(j));
        }
        return result.toString();
    }
}
