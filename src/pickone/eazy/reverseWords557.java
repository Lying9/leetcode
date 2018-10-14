package pickone.eazy;

/**
 * Created by ying on 2018/10/9.
 */
public class reverseWords557 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    //    第一种：分成一个个单词  ，在一个个字母转
 /*   public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        for(String st : words){
            for (int i = st.length()-1; i >=0 ; i--) {
                result.append(st.charAt(i));
            }
            result.append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }*/
// 第二种  把句子分割成一个个单词，然后用StringBuilder的reverse方法进行转
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        for (String st : words) {
            result.append(new StringBuilder(st).reverse());
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
