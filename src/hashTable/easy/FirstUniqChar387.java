package hashTable.easy;

import java.util.HashMap;

/**
 * Created by ying on 2018/9/17.
 */
public class FirstUniqChar387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar(new String("leetcode")));
    }

    public static  int firstUniqChar(String s) {
        for(int i =0;i<s.length();i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        }
        return -1;

      /*  HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),-1);
            else
                map.put(s.charAt(i),i);
        }
        for(int i =0;i<s.length();i++){
            if(map.get(s.charAt(i))>=0)
                return i;
        }
        return -1;*/
    }

}
