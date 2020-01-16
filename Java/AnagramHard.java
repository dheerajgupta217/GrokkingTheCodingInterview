import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
    * Given a string and a list of words, find all the starting indices of substrings in the given string that are a concatenation of all the given words exactly once without any overlapping of words. It is given that all words are of the same length.
    *Input: String="catfoxcat", Words=["cat", "fox"]
    *Output: [0, 3]
    *Explanation: The two substring containing both the words are "catfox" & "foxcat".
* */
public class AnagramHard {
    public static void main(String[] args) {
        String str = "catfoxcat";
        String[] words = {"cat","fox"} ;
        System.out.println(findSubstring(str,words));
    }
    private static List<Integer> findSubstring(String str, String[] words) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word: words){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }else{
                map.put(word, 1);
            }
        }
        int len = words[0].length();
//asli kaam
        for(int j=0; j<len; j++){
            HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = j;
            int count = 0;

            for(int i=j; i<=str.length()-len; i=i+len){
                String sub = str.substring(i, i+len);
                if(map.containsKey(sub)){
                    if(currentMap.containsKey(sub)){
                        currentMap.put(sub, currentMap.get(sub)+1);
                    }else{
                        currentMap.put(sub, 1);
                    }

                    count++;

                    while(currentMap.get(sub)>map.get(sub)){
                        String left = str.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);

                        count--;
                        start = start + len;
                    }


                    if(count==words.length){
                        result.add(start);
                        String left = str.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);
                        count--;
                        start = start + len;
                    }
                }else{
                    currentMap.clear();
                    start = i+len;
                    count = 0;
                }
            }
        }
        return result;
    }
}
