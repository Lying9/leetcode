package pickone.medium;

import java.util.HashMap;

/**
 * Created by ying on 2019/5/14.
 */
public class IntToRoman12 {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};
        String[] strings = {"I", "V", "X", "L", "C", "D", "M"};
        HashMap<Integer, String> map = new HashMap<>();
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        StringBuilder sb = new StringBuilder();
        int index = nums.length - 1;
        while (num != 0) {
            //最高位是 4 或者 9
            String s = String.valueOf(num);
            int temp = s.charAt(0) - '0';
            if (temp == 4 || temp == 9) {
                for (int i = 0; i < s.length() - 1; i++) {
                    temp *= 10;
                }
                sb.append(map.get(temp));
                num -= temp;
                continue;
            }

            for (int i = index; i >= 0; i--) {
                if (num / nums[i] != 0) {
                    index = i;
                    sb.append(strings[i]);
                    num -= nums[i];
                    break;
                }
            }
        }

        return sb.toString();
    }
}
