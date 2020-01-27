package business;


import java.util.HashMap;

public class WordFrequency {
    public static void main(String[] args) {
        String str = "aaa bbb ccc sss aaa bbb ccc ddd eee bbb sss bbb";
        findFrequency(str);
    }
   static void findFrequency(String str){

       HashMap<String,Integer> map =new HashMap<>();
       int count =0;
       int i =0;
       String word = "";
       while(i<str.length()){

          if(str.charAt(i) !=' '){
              word = word + str.charAt(i);
          }else{
              if(map.containsKey(word)){
                  count = map.get(word);
                  count++;
                  map.put(word,count);
              }else{
                  map.put(word,1);
              }
              word="";
           }
           i ++;
       }
       System.out.println(map);
   }
}
