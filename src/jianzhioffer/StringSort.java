package jianzhioffer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ying on 2019/3/5.
 */
public class StringSort {
    public static void main(String[] args) {
        char[] a = {'q'};
        System.out.println(a.toString());
       /* String str = "aa";
        ArrayList<String> result = Permutation(str);
        for(String s: result)
            System.out.println(s);*/
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Character> list = new ArrayList<>();
        if (str == null || str.length() == 0)
            return result;
        int[] flag = new int[str.length()];

        helper(result, list, flag, str);
        return result;

    }

    public static void helper(ArrayList<String> result, ArrayList<Character> list, int[] flag, String str) {
        if (list.size() == str.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : list)
                sb.append(c);
            if (!result.contains(sb.toString()))
                result.add(sb.toString());
        }
        for (int i = 0; i < str.length(); i++) {
            if (flag[i] == 1)
                continue;
            list.add(str.charAt(i));
            flag[i] = 1;
            helper(result, list, flag, str);
            list.remove(list.size() - 1);
            flag[i] = 0;
        }
    }

    public  ArrayList<String> Permutation1(String str) {


        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0)
            return result;
        char[] chars = str.toCharArray();

        helper2(result, 0, chars);
        return result;

    }

    public void helper2(ArrayList<String> result, int index, char[] chars) {
        if (index == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (char c : chars)
                sb.append(c);
            if (!result.contains(sb.toString()))
                result.add(sb.toString());
        }
        for (int i = index; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = chars[index];
            chars[index] = temp;
            helper2(result, index + 1, chars);
            temp = chars[i];
            chars[i] = chars[index];
            chars[index] = temp;
        }

    }


}
