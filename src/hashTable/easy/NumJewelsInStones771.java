package hashTable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ying on 2018/4/24.
 */
public class NumJewelsInStones771 {

    public static void main(String[] args) {
        String J= "Aa";
        String S="Aaasssss";
        System.out.println(numJewelsInStones(J,S));
       // System.out.println(charToInt('a'));
    }
    public static  int numJewelsInStones(String J, String S) {
        char[] allchars = new char[52];
        for(char a : J.toCharArray()){
            allchars[charToInt(a)] = 1;
        }
        int result =0;
        for (char a : S.toCharArray()){
            if(allchars[charToInt(a)] == 1)
                result++;
        }
        return result;
    }
    public static int charToInt(char a){
        if(a>='a' && a<='z')
            return a-'a';
        return a-39;
    }
    //时间比较慢
  /*  public static  int numJewelsInStones(String J, String S) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            map.put(J.charAt(i),0);
        }
        for (int i = 0; i < S.length() ; i++) {
            if(map.containsKey(S.charAt(i))){
                map.put(S.charAt(i),map.get(S.charAt(i))+1);
            }
        }
        int sum =0;
        for(Integer i : map.values())
            sum += i;
        return sum;
    }*/
}
