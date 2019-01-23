package jianzhioffer;

/**
 * Created by ying on 2019/1/23.
 *
 * 替换空格
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("happy new year");
        System.out.println(replaceSpace(sb));
    }

    /**
     * @param str
     * @return
     *
     * StringBuffer  的 replace（int start, int end, String str） 用str替换原字符串中start到end的字符串
     * String 中的   replace(char oldChar, char newChar)      字符替换
     *               replaceAll(String regex, String replacement)  字符串替换
     *
     */
    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }


}
