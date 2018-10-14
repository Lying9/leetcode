package hashTable.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ying on 2018/4/26.
 */
public class FindWords500 {
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] result = findWords(words);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
    /*思路：
    *       1.先把每一行的字符作为一个字符串存入数组中
    *       2.遍历words数组中的每个字符串  看其是否符合要求（即所有字符在一行）
    *           2.1 将字符串转换为字符数组
    *           2.2 判断字符数组的第一个字符所属的行
    *           2.3 判断字符数组中的剩余字符是否属于第一个字符所属的行
    * 知识点：
    *       1.字符串转化为字符串数组   String.toCharArray();
    *       2.contains 判断的是 是否连续存在于字符串中   如：“asdfgh”.contains("asd") 为true
     *                                                        “asdfgh”.contains("ad") 为false
     *      3.list转化为字符串数组    list.toArray(new String[list.size()])
     *                      直接用list.toarray()得到的是object[]
     * 改进： 在代码中 strings[0].indexOf(chars[j])==-1  大量的重复
     *         则可以抽取出来 写成一个方法  */
    public  static String[] findWords(String[] words) {
        String[] strings = {"QWERTYUIOPqwertyuiop","ASDFGHJKLlkjhgfdsa","ZXCVBNMmnbvcxz"};
        List<String> list = new ArrayList<>();
        for (int i = 0; i <words.length ; i++) {
            char[] chars = words[i].toCharArray();
            int num ;
            if(strings[0].indexOf(chars[0])!=-1)
                num =0;
            else if(strings[1].indexOf(chars[0])!=-1)
                num =1;
            else
                num =2;
            if(num == 0){
                int j;
                for ( j= 1; j < chars.length; j++) {
                    if(strings[0].indexOf(chars[j])==-1)
                        break;
                }
                if(j>=chars.length)
                 list.add(words[i]);
            } else if(num == 1){
                int j;
                for ( j= 1; j < chars.length; j++) {
                    if(strings[1].indexOf(chars[j])==-1)
                        break;
                }
                if(j>=chars.length)
                list.add(words[i]);
            }else if(num == 2){
                int j;
                for ( j= 1; j < chars.length; j++) {
                    if(strings[2].indexOf(chars[j])==-1)
                        break;
                }
                if(j>=chars.length)
                list.add(words[i]);
            }

        }
       String[] s = new String[list.size()];
        return  list.toArray(s);
    }
}
