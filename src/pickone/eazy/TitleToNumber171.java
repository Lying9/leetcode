package pickone.eazy;

/**
 * Created by ying on 2018/9/10.
 */
public class TitleToNumber171 {

    public static void main(String[] args) {
        String s = "ZY";
        System.out.println(titleToNumber(s));
    }

    public static int titleToNumber(String s) {
        int sub = 1,result = 0;
        for (int i = s.length()-1; i>=0 ; i--) {
            char c = s.charAt(i);
             result += ((int)c - 64)*sub;
             sub *= 26;
        }
        return result;
    }
}
