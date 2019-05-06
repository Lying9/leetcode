package pickone.medium;

/**
 * Created by ying on 2019/5/6.
 */
public class LongestPalindrome5 {
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(longestPalindrome(s));
    }

    /*
    * dp:  用二维数组来存储最大的长度  dp[i][j] 表示string从下标i到下标j 之间的字符串的最大回文长度
    *   则  当 char[i] == char[j] 时， 如果i-1 到 j之间是回文 则dp[i][j] = dp[i-1][j+1]+2;
    *                                  如果不是回文            则dp[i][j] =dp[i][j-1]
    *       当 char[i] != char[j] 时   dp[i][j] =dp[i][j-1]
    * */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        int max =1,start = 0,end = 0;
        for (int k = 1; k <s.length() ; k++) {
            for (int i = 0,j=k; i <s.length() &&j<s.length() ; i++,j++) {
                if(s.charAt(i) == s.charAt(j)){
                    int temp =0;
                    if(dp[i+1][j-1] == j-1-i)
                       temp = dp[i+1][j-1]+2;
                    else
                        temp = dp[i][j-1];
                    dp[i][j] = temp;
                    if(temp >max){
                        max = temp;
                        start = i;
                        end = j;
                    }
                }else
                    dp[i][j] = dp[i][j-1];
            }
        }
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j <dp[i].length ; j++) {
                System.out.print( dp[i][j] + "  ");
            }
            System.out.println();
        }
        return s.substring(start,end+1);
    }
}
