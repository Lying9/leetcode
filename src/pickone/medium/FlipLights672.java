package pickone.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ying on 2019/1/16.
 */
public class FlipLights672 {
    public static void main(String[] args) {
//        System.out.println(flipLights(1, 1));
//        System.out.println(flipLights(2, 1));
        System.out.println(flipLights(2, 2));

    }

    //    暴力破解  accept 5945 ms
//    可把string 和Stringbuilder的结合  改为  String和char数组  的结合
    public static int flipLights(int n, int m) {
        Set<String> init = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(1);
        }
        init.add(sb.toString());
//        System.out.println(sb.toString());
        for (int i = 0; i < m; i++) {
            Set<String> result = new HashSet<>();
            for (String s : init) {
                StringBuilder temp = new StringBuilder(s);
                result.add(change(0, 1, temp).toString());
                temp = new StringBuilder(s);
                result.add(change(1, 2, temp).toString());
                temp = new StringBuilder(s);
                result.add(change(0, 2, temp).toString());
                temp = new StringBuilder(s);
                result.add(change(0, 3, temp).toString());
            }
            init = result;
           /* System.out.println("------------");
            for(String s :init){
                System.out.println(s);
            }*/

        }
        return init.size();
    }

    public static StringBuilder change(int init, int increment, StringBuilder sb) {
        for (int j = init; j < sb.length(); j = j + increment) {
            if (sb.charAt(j) == '1') {
                sb.replace(j, j + 1, "0");
            } else {
                sb.replace(j, j + 1, "1");
            }
        }
        return sb;
    }

//    规律：为什么是这样？？
    /**   n= 1   2    3     4  5
     * m= 1  2   3    4     4   4...
     *    2  2   4    7     7   7...
     *    3  2   4    8     8   8 ...
     *    4  2   4   ...
     *       ...
     */
    public int flipLights1(int n, int m) {
        if(m==0) return 1;
        if(n==1) return 2;
        if(n==2&&m==1) return 3;
        if(n==2) return 4;
        if(m==1) return 4;
        if(m==2) return 7;
        if(m>=3) return 8;
        return 8;
    }

}
