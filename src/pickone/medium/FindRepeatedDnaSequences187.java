package pickone.medium;

import java.util.*;

/**
 * Created by ying on 2019/1/18.
 */
public class FindRepeatedDnaSequences187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//        String s = "AAAAAAAAAAA";
        List<String> result = findRepeatedDnaSequences2(s);
        for (String sub : result) {
            System.out.println(sub);
        }
       /*Integer i =  0x0FFFFF;
        System.out.println(Integer.toBinaryString(i));*/
    }

    //    Time Limit Exceeded
    // 对每一个长度为10的字符串  在其后面找是否有该字符串
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String subs = s.substring(i, i + 10);
            if (s.indexOf(subs, i + 1) != -1) {
                if (!result.contains(subs)) {
                    result.add(subs);
                }
            }
        }
        return result;
    }

    //    accept   用hashmap  记录每一个长度为10的字符串的数量
    public static List<String> findRepeatedDnaSequences1(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subs = s.substring(i, i + 10);
            if (!map.containsKey(subs)) {
                map.put(subs, 1);
            } else {
                map.put(subs, map.get(subs) + 1);
            }
        }
        for (String sub : map.keySet()) {
            if (map.get(sub) > 1) {
                result.add(sub);
            }
        }
        return result;
    }

    public List<String> findRepeatedDnaSequences3(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }

    //别人代码  如何自己计算hash
    public static List<String> findRepeatedDnaSequences2(String s) {
        List<String> ans = new ArrayList();
        int n = s.length();
        if (n < 10) return ans;
//       由四个字符表示 长度为10的字符串 共有 4的10次方 中可能
        boolean[] hash = new boolean[1024 * 1024];
        int[] cov = new int[26];
        cov['A' - 'A'] = 0;
        cov['C' - 'A'] = 1;
        cov['G' - 'A'] = 2;
        cov['T' - 'A'] = 3;
        Set<Integer> set = new HashSet<Integer>();
        int tmp = 0;
        for (int i = 0; i <= 8; i++)
            tmp = (tmp << 2) + cov[s.charAt(i) - 'A'];
//        System.out.println(tmp);
        for (int i = 0; i + 10 <= n; i++) {
            tmp = ((tmp << 2) + cov[s.charAt(i + 9) - 'A']) & 0x0FFFFF;
            //System.out.println(tmp);
            if (!hash[tmp])
                hash[tmp] = true;
            else {
                if (set.contains(tmp))
                    continue;
                set.add(tmp);
                ans.add(s.substring(i, i + 10));
            }
        }
        return ans;
    }
}
