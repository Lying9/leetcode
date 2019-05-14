package pickone.eazy;

/**
 * Created by ying on 2019/5/14.
 */
public class Reverse7 {
    public static void main(String[] args) {
        int x =-1534236469;
       // System.out.println(-9%10);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(x));
    }
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int reverse1(int x) {
        String s = String.valueOf(x);
        int flag = 1;
        if (x < 0) {
            flag = -1;
            s = s.substring(1, s.length());
        }
        s = new StringBuilder(s).reverse().toString();
        long result = Long.parseLong(s);
        result *= flag;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int) result;
    }
}
