package pickone.medium;

/**
 * Created by ying on 2018/10/25.
 */
public class MaskPII831 {

    public static void main(String[] args) {
//        String s = "LeetCode@LeetCode.com";
        String s = "86-(10)12345678";
//        String s = "AB@qq.com";
//        System.out.println(maskPII(s));
        System.out.println(s.replaceAll("\\D+",""));
    }

    public static String maskPII(String S) {
        StringBuilder sb = new StringBuilder();
        if (S.indexOf('@') == -1) {//数字 电话
//            可以用S.replaceAll("\\D+", "")吧所有不是数组的去掉    //d 数字
            int numcount = 0;
            for (int i = 0; i < S.length(); i++) {
                if (Character.isDigit(S.charAt(i)))
                    numcount++;
            }
            if (numcount <= 10) {    //没有区号
                sb.append("***-***-");
            } else {   //有区号
                sb.append("+");
                for (int i = 0; i < numcount - 10; i++) {
                    sb.append('*');
                }
                sb.append("-***-***-");
            }
//           添加后四位数字
            StringBuilder temp = new StringBuilder();
            for (int i = S.length() - 1; i >= 0; i--) {
                if (Character.isDigit(S.charAt(i))) {
                    temp.append(S.charAt(i));
                }
                if (temp.length() >= 4)
                    break;
            }
            sb.append(temp.reverse());
            return new String(sb);
        } else { //邮箱
            S = S.toLowerCase();
//            String name1 = S.substring(0, S.indexOf('@'));
            sb.append(S.charAt(0));
            sb.append("*****");
//            sb.append(name1.charAt(name1.length() - 1));
//            sb.append(S.substring(S.indexOf('@')));
            sb.append(S.substring(S.indexOf('@')-1));
            return new String(sb);
        }
    }
}
