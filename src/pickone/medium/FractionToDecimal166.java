package pickone.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ying on 2018/12/10.
 */
public class FractionToDecimal166 {

    public static void main(String[] args) {
        /*Integer a = -2147483648;
        System.out.println(-2147483648/-1);
        System.out.println(Integer.bitCount(a));*/
       /* Integer a = -2147483648;
        System.out.println(a.longValue()/-1);*/
        int a = -2147483648;
        int b = 1;
        System.out.println(fractionToDecimal(a, b));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";             //has to have this line       -1 0    -0
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) sb.append("-");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        sb.append(num / den);
        num %= den;
        if (num == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
//        map里的key为余数  value为在sb这个字符串中的位置
        map.put(num, sb.length());
//比自己的方法优化的地方：在循环中给sb赋值，不用再一次遍历整个sb
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }

//思路：保留商和余数    把余数作为键，商作为值 保存在linedHashMap中（有序）
//    当出现余数 和之前的某个余数相同时  表明后面的小数将与前面的小数重复
//    需要注意的问题  1.商是负数的情况 因此小数的部分需要用绝对值
//                    2. 0 除以某个负数应该是0  而不是-0
//                    3. int 越界的问题    和 -2147483648    Math.abs(-2147483648/1） = -2147483648  -2147483648/-1 = -2147483648
    public static String fractionToDecimal1(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Long, Long> remainder = new LinkedHashMap<>();
        if ((numerator ^ denominator) >>> 31 == 1 && numerator != 0)
            sb.append("-");
        long num = ((Integer)numerator).longValue();
        long deno = ((Integer)denominator).longValue();

        sb.append(Math.abs(num / deno));
        long remain = num % deno;
        if (remain == 0)
            return sb.toString();
        sb.append(".");
        while (!remainder.containsKey(remain) && remain != 0) {
            long quotient = Math.abs(remain * 10 / deno);
            remainder.put(remain, quotient);
            remain = remain * 10 % deno;
        }
        if (remain == 0) {
            for (long k : remainder.keySet())
                sb.append(remainder.get(k));
        } else {
            for (long k : remainder.keySet()) {
                if (remain == k)
                    sb.append("(");
                sb.append(remainder.get(k));
            }
            sb.append(")");
        }
        return sb.toString();
    }

}
