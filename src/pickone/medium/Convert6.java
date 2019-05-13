package pickone.medium;

/**
 * Created by ying on 2019/5/13.
 */
public class Convert6 {
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int num = 4;
        System.out.println(convert(s, num));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int count = numRows + numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int mod = i % count;
            for (int j = 0; j < numRows; j++) {
                if (mod == j || mod == count - j) {
                    sb[j].append(s.charAt(i));
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(sb[i]);
        }
        return result.toString();
    }
}
