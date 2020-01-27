package business;

public class Anagram {

    static boolean ifAnagram(String str1, String str2) {
        int[] count = new int[256];
        int i;
        for (i = 0; i < str1.length() && i < str2.length();i++){
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        if (str1.length() != str2.length()){
            return false;
        }else{
        for (i = 0; i < 256; i++)
            if (count[i] != 0) {
                return false;
            }
        return true;
        }
    }
    static void findAnagram(String arr[], int n)
    {
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
                if (ifAnagram(arr[i], arr[j]))
                    System.out.println(arr[i] + " is anagram of " + arr[j]);
    }
    public static void main(String args[])
    {
        String arr[] = {"hello", "madamimadam",
                "ada", "madamIama",
                "Teat"};
        int n = arr.length;
        findAnagram(arr, n);
    }
}
