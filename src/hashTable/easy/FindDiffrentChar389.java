package hashTable.easy;

import java.util.HashMap;

/**
 * Created by ying on 2018/9/11.
 */
public class FindDiffrentChar389 {
/*只要是找两组数据  仅有一个不同的，，都应该想想异或可不可以用
* */
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }

    public static char findTheDifference(String s, String t) {
       /* HashMap<Character,Integer> smap = new HashMap<>();
        for(int i =0;i<s.length();i++){
            if(smap.keySet().contains(s.charAt(i))) {
                smap.put(s.charAt(i), smap.get(s.charAt(i)) + 1);
            }
            else
                smap.put(s.charAt(i),1);

        }
        int i=0;
        for(i =0;i<t.length();i++){
            if(smap.keySet().contains(t.charAt(i))){
                int count = smap.get(t.charAt(i))-1;
                if(count < 0)
                    break;
                smap.put(t.charAt(i),count);
            }
            else
                break;
        }
        return t.charAt(i);*/
        char mask = 0;
        for (int i = 0; i < s.length(); i++) {
            mask ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            mask ^= t.charAt(i);
        }
        return mask;
    }
}
