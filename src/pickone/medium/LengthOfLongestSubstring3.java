package pickone.medium;

/**
 * Created by ying on 2019/3/23.
 */
public class LengthOfLongestSubstring3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    //index 数组里存储已经遍历的字符串中，最后出现该字符的下标+1
    public static  int lengthOfLongestSubstring(String s){
        int[] index = new int[128];
        int start = 0,result = 0;
        for (int i = 0; i <s.length() ; i++) {
            start = Math.max(index[s.charAt(i)],start);
            result = Math.max(result,i-start+1);
            index[s.charAt(i)] = i+1;
        }
        return result;
    }




//每次去前面的串里查找字符是否出现过
    public int lengthOfLongestSubstring1(String s) {
        int length = 0;
        int max = 0,start = 0;
        for(int i = 0;i<s.length();i++){
            int temp = isContains(s.charAt(i),s,start,i);
            if(temp!=-1){
                start = temp+1;
            }
            max= Math.max(max,i-start+1);
        }
        return max;
    }
    public int isContains(char target,String s,int start,int end){
        for(int i=start;i< end;i++)
        {
            if(s.charAt(i) == target)
                return i;
        }
        return -1;
    }
}
