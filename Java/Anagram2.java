package business;
/**
 *Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 * */
class Anagram2 {
    public static void main(String[] args) {
        String str = "aabdecabc";
        String pat = "abc";
        System.out.println( ifPatternIsPresent(str,pat));
    }
    private static String ifPatternIsPresent(String str, String pat){
        int[] hashCodePat = new int[256];
        int[] hashCodeStr = new int[256];
        int count = 0;
        int firstIndex = 0;
        int start = -1;
        int reqLen = str.length();
        if(str.length() < pat.length()){
            return "";
        }
        for (int i =0;i<pat.length();i++){
            hashCodePat[pat.charAt(i)]++;
        }
            for (int j = 0;j < str.length();j++){
                hashCodeStr[str.charAt(j)]++;
                if(hashCodePat[str.charAt(j)]!=0 &&  hashCodeStr[str.charAt(j)]<=hashCodePat[str.charAt(j)] ){
                    count ++;
                }
                if(count == pat.length()){
                    while (hashCodeStr[str.charAt(firstIndex)] > hashCodePat[str.charAt(firstIndex)] || hashCodePat[str.charAt(firstIndex)] == 0){
                        if (hashCodeStr[str.charAt(firstIndex)] > hashCodePat[str.charAt(firstIndex)]){
                            hashCodeStr[str.charAt(firstIndex)]--;
                        }
                        firstIndex++;
                    }
                    int windowSize = j - firstIndex + 1;
                    if (reqLen > windowSize){
                        reqLen = windowSize;
                        start = firstIndex;
                    }
                }
            }
        if (start == -1){
            return "";
        }
        return str.substring(start,start+reqLen);
    }
}
