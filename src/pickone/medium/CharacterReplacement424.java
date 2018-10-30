package pickone.medium;

import java.util.Collections;

/**
 * Created by ying on 2018/10/30.
 */
public class CharacterReplacement424 {
    public static void main(String[] args) {
        String s = "AAAAABBBAAAAAAAA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    //窗口滑动
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, max = -1;
        int result = 0;
        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            max = Math.max(max, count[s.charAt(end) - 'A']);   //不是很理解max，这里的max是历史最大，而不是start到end中字符的最大
            while (end - start + 1 - max > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
