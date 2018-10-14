package pickone.hard;

import java.util.ArrayList;

/**
 * Created by ying on 2018/9/10.
 */
public class GetMaxRepetitions466 {
    /*思路：看从哪一段 开始 重复   重复中：几段重复，包含多少s2
    *重复：每一段结束时判断到的S2的下标是否在之前出现过
     *  */
    public static void main(String[] args) {
        String s1 = "baba";
        String s2 = "baab";
        int n1 = 11, n2 = 1;
        System.out.println(getMaxRepetitions(s1, n1, s2, n2));
    }

    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        //暴力破解
       /* int index = 0, count = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == s2.charAt(index)) {
                    index++;
                }
                if (index % s2.length() == 0) {
                    count++;
                    index = 0;
                }
            }
        }
        return count/n2;*/
        int index = 0, count = 0;
        ArrayList<Integer> indexlist = new ArrayList<>();
        ArrayList<Integer> countlist = new ArrayList<>();
        indexlist.add(0);
        countlist.add(0);
        for (int i = 1; i <= n1; i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == s2.charAt(index)) {
                    index++;
                }
                if (index == s2.length() ) {
                    count++;
                    index = 0;
                }
            }
            if (indexlist.contains(index)) {
                int number = indexlist.indexOf(index);//开始重复的块号
                int length = i - number; //这么长的块重复
                int seg = (n1 - number) / length;//一共这么多段 重复
                int remain = (n1 - number)%length;//还剩多少段
                count = countlist.get(number)+seg*(count - countlist.get(number))+(countlist.get(number+remain)-countlist.get(number));
                break;
            } else {
                indexlist.add(index);
                countlist.add(count);
            }

        }
        return count / n2;
    }

    /*public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(n1 == 0)
            return 0;
        else if(n1 ==1)
            return getCount(0,s1,s2)/n2;
        int start = 0, count = 0, index = 0, c = 1;
        StringBuilder sb = new StringBuilder(s1);
        int frist = sb.toString().indexOf(s2.charAt(0), start);
        while (index >= 0) {
            int i = 0;
            for (i = 0; i < s2.length(); i++) {
                index = sb.toString().indexOf(s2.charAt(i), start);
                if (index < 0) {
                    if (c < n1) {
                        sb.append(s1);
                        c++;
                        i--;
                    } else
                        return count / n2;
//                        break;
                } else
                    start = index + 1;
            }
            if (i >= s2.length())
                count++;
            if (count >= 2) {
                int nextbegin = sb.toString().indexOf(s2.charAt(0), start);
                int length = 0;
                if (nextbegin < 0) {
                    if (c < n1)
                        nextbegin = sb.append(s1).toString().indexOf(s2.charAt(0), start);
                    else return count / n2;
                }
                length = nextbegin - frist;
                int seg = (s1.length() * n1 - frist) / length;//共有多少个这样的段
                int counte = 0, starte = 0;
                String s = "";
                if ((s1.length() * n1 - frist) % length != 0) {
                    starte = frist + length * seg;//末尾的那一段的开始
                    c = starte / s1.length();
                    starte = starte % (s1.length());
                    if (starte!=0) {
                        s = s1.substring(starte);
                        c++;
                    }
                    while (n1 - c > 0) {
                        s = s.concat(s1);
                        c++;
                    }
                }
                counte = getCount(starte, s, s2);
                return (seg * 2 + counte) / n2;
            }
        }
        return 0;
    }*/

   /* public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // Memory Limit Exceeded  一个一个找
      *//*  StringBuilder sb = new StringBuilder(s1);
        for (int i = 1; i <n1 ; i++) {
            sb.append(s1);
        }
        return getCount(0,sb.toString(),s2)/n2;*//*

        if (n1 == 0)
            return 0;
        else if (n1 == 1) {
            int start = 0, count = 0;
            count = getCount(start, s1, s2);
          *//*  while (index >= 0) {
                int i = 0;
                for (i = 0; i < s2.length(); i++) {
                    index = s1.indexOf(s2.charAt(i), start);
                    if (index < 0)
                        break;
                    else
                        start = index + 1;
                }
                if (i >= s2.length())
                    count++;
            }*//*
            return count / n2;
        } else {
            int c = 2;
            String s = s1.concat(s1);
            int start = 0, index = 0, count = 0, frist = 0;
            frist = s.indexOf(s2.charAt(0), start);
            if (frist < 0)
                return 0;
            int i = 0,before = 0;
            while(index >= 0) {
                for (i = before; i < s2.length(); i++) {
                    index = s.indexOf(s2.charAt(i), start);
                    if (index < 0)
                        break;
                    else
                        start = index + 1;
                }
                if(i >= s2.length()) {
                    count++;
                    if(count >= 2)
                        break;
                }else{
                    if(c<n1) {
                        s.concat(s1);
                        c++;
                        before = i;
                        index = 0;
                    }
                }
            }
            if (index > 0) {
                int nextbegin = s.indexOf(s2.charAt(0),start);
                int length = nextbegin-frist;
                int seg = (s1.length() * n1 - frist) / length;//共有多少个这样的段
                int counte = 0;
                if ((s1.length() * n1 - frist) % length != 0) {
                    int starte = frist + (index - frist + 1) * seg;//末尾的那一段的开始
//                末尾需不需要考虑 留下的字段是不是 多于  一个S1
                    starte = starte % (s1.length());
//                    int indexe = 0;
                    counte = getCount(starte, s1, s2);
                *//*    while (indexe >= 0) {
                        int i = 0;
                        for (i = 0; i < s2.length(); i++) {
                            indexe = s1.indexOf(s2.charAt(i), starte);
                            if (indexe < 0)
                                break;
                            else
                                starte = indexe + 1;
                        }
                        if (i >= s2.length())
                            counte++;
                    }*//*
                }
                count = seg  + counte;
                return count / n2;
            } else return 0;
        }
    }
*/

    public static int getCount(int begin, String s1, String s2) {
        int start = begin, count = 0, index = 0, c = 1;
        while (index >= 0) {
            int i = 0;
            for (i = 0; i < s2.length(); i++) {
                index = s1.indexOf(s2.charAt(i), start);
                if (index < 0) {
                    break;
                } else
                    start = index + 1;
            }
            if (i >= s2.length())
                count++;
        }
        return count;
    }
}
