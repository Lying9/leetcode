package pickone.eazy;

/**
 * Created by ying on 2019/3/23.
 */
/*
* 思路：  遇到I 就把当前所剩数字中的最小值赋值给 数组
*         遇到D 就把当前所剩数字中的最大值赋值给 数组
* */
public class DIString942 {
    public int[] diStringMatch(String S) {
        int start = 0,end = S.length();
        int[] result = new int[end+1];
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == 'I'){
                result[i] = start++;
            }else
                result[i] = end--;
        }
        result[S.length()] = start;
        return result;
    }
}
