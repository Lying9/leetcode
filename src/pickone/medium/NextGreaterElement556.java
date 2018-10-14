package pickone.medium;

import java.util.*;

/**
 * Created by ying on 2018/9/17.
 */
public class NextGreaterElement556 {
    /*
    * 整体的思路： 1、先找到i后面的元素 有比i位元素大的i   （注意：在这里只要比较相邻两位就可以 ）
    *              2、找出  i 后面  比i大且最小的元素 j
    *              3、把 i和 j位置的数交换
    *              4、把i之后的位置上的数 按从小到大的顺序排序
    *              所得即为结果
    * 注意：在char 和 int之间的转化
    * */

    public static void main(String[] args) {
       /* String s = "21";
        System.out.println(s.charAt(0));
        System.out.println((int)s.charAt(0));*/

        int n = 13;
        System.out.println(nextGreaterElement(n));
    }

    public int nextGreaterElement1(int n) {
        if (n <= 10)
            return -1;

        char str[] = Integer.toString(n).toCharArray();
        for (int i = str.length - 1 ; i > 0 ; i--) {
            if (str[i - 1] >= str[i])
                continue;
            else    {
                char num = str[i-1];
                int nextIndex = findNextNum(str, i - 1);
                char temp = str[i-1];
                str[i-1] = str[nextIndex];
                str[nextIndex]  = temp;
                Arrays.sort(str, i, str.length);
                try {
                    return Integer.parseInt(new String(str));
                } catch (Exception e)   {
                    return -1;
                }

            }
        }
        return -1;
    }
    private int findNextNum(char [] str, int index) {
        int nextNum = index + 1;
        for (int i = index + 2; i < str.length ; i++)   {
            if (str[i] > str[index] && str[nextNum] > str[i])
                nextNum = i;
        }
        return nextNum;
    }


    public static int nextGreaterElement(int n) {
        Integer m = new Integer(n);
        String s = m.toString();
        int i = s.length() - 1;
        StringBuffer news = new StringBuffer();
        Set<Integer> set = new HashSet();
        while (i >= 0) {
            int min = 10;
            for (int o : set) {
                if (o > (int)s.charAt(i)-48) {
                    min = Math.min(o, min);
                }
            }
            if (min < 10) { //找到了 后面有比他大的数
                if (i >= 1)
                    news = news.append(s.substring(0, i));
                news = news.append(min);
                if (i + 1 <= s.length() - 1) {
                    List list = new ArrayList<>();
                    list.add(s.charAt(i));
                    boolean flag = true;
                    for (int j = i + 1; j < s.length(); j++) {
                        if (s.charAt(j)-48 == min && flag) {
                            flag = false;
                            continue;
                        }
                        list.add(s.charAt(j));
                    }
                    Collections.sort(list);
                    for (Object o : list) {
                        news = news.append(o);
                    }
                }
                break;
            }else
                set.add((int)s.charAt(i)-48);
            i--;
        }
        if (news.length() == 0)
            return -1;
        if (news.length() >= 10 && news.toString().compareTo(new Integer(Integer.MAX_VALUE).toString()) > 0)
            return -1;
        return Integer.valueOf(news.toString());
    }


}
