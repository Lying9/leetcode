package pickone.hard;

/**
 * Created by ying on 2018/10/17.
 */
public class IsMatch44 {
    public static void main(String[] args) {
        /*String s ="aa";
        String p ="a";*/
        /*String s ="aa";
        String p ="*";*/
        /*String s ="adbceb";
        String p ="a*b";*/
       /* String s ="acdcb";
        String p ="a*c?b";*/
//        String s ="aaaa";
//        String p ="***a";    //true
       /* String s ="c";
      String p ="*?*"; */    //true;
        String s ="ho";
        String p ="ho**";
        System.out.println(isMatch(s,p));
    }

/*
* 动态规划： match[i][j]表示的是 s从下标i开始到结束的字符串   与  p从下标j开始到结束的字符串是否匹配
* */

    public static boolean isMatch(String s, String p) {
//        return isMatchCase(s, p, 0, 0);
//        动态规划
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()] = true;
        int i = p.length()-1;
        while(i>=0 && p.charAt(i) == '*'){
            match[s.length()][i] = true;
            i--;
        }
        for (i = s.length()-1; i >=0 ; i--) {
            for (int j = p.length()-1; j >=0 ; j--) {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    match[i][j] = match[i+1][j+1];
                else if(p.charAt(j) == '*')
                    match[i][j] = match[i+1][j] || match[i][j+1];
                else
                    match[i][j] = false;
            }
        }
        return match[0][0];
    }

    //Time Limit Exceeded
    public static  boolean isMatchCase(String s, String p, int i, int j) {
        if(i >= s.length()){
            while(j < p.length()){
                if( '*'!= p.charAt(j))
                    break;
                j++;
            }
            if(j>=p.length())
                return true;
            else
                return false;
        }
        if(j>=p.length())
            return false;
        if('?' == p.charAt(j)){
           return isMatchCase(s,p,i+1,j+1);
        }else if('*' == p.charAt(j)){
            while(j+1<p.length() &&('*' == p.charAt(j+1)))
                j = j+1;
            if(j+1<p.length()) {
                if('?' == p.charAt(j+1)){
                    boolean match = false;
                    while(i<s.length()){
                        match = match || (isMatchCase(s,p,i,j+1));
                        i++;
                        if(match == true)
                            return true;
                    }
                    return match;
                }
                else {
                    int index = s.indexOf(p.charAt(j + 1), i);
                    boolean match = false;
                    while (index != -1) {
                        if (match == true)
                            return true;
                        match = (match || isMatchCase(s, p, index + 1, j + 2));
                        index = s.indexOf(p.charAt(j + 1), index + 1);
                    }
                    return match;
                }
            }
            else
                return true;
        }else{
            if(s.charAt(i) == p.charAt(j))
                return isMatchCase(s,p,i+1,j+1);
            else
                return false;
        }
    }
}
