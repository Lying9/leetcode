package pickone.medium;

import java.util.HashMap;

/**
 * Created by ying on 2019/4/19.
 */
public class MyAtoi8 {
    public static void main(String[] args) {
        String s =  "-91283472332";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0 || str == null)
            return 0;
        int signal = 0;
        if(str.charAt(0) == '-')
            signal = -1;
        else if(str.charAt(0) == '+')
            signal = 1;
        int start = 0;
        if(signal !=0){
            start = 1;
        }
        Long result = 0L;
        for(int i = start;i<str.length();i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                result = result*10+str.charAt(i)-'0';
            }else
                break;
        }
        if(signal !=0 )
            result *= signal;
        if(result <Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return result.intValue();
    }
}
