package pickone.medium;

/**
 * Created by ying on 2019/3/22.
 */
public class MagicalString481 {
    public static void main(String[] args) {
        System.out.println(magicalString(7));
    }
    public static int magicalString(int n) {
        if(n<=0)
            return 0;
        if(n <= 3)
            return 1;
        StringBuilder s = new StringBuilder("122");
        int index = 2;
        while(s.length() <n){
            if(s.charAt(s.length()-1)=='1'){
                for(int i =0;i<Integer.valueOf(s.charAt(index)-'0');i++){
                    s.append('2');
                }
            }else{
                for(int i =0;i<Integer.valueOf(s.charAt(index)-'0');i++){
                    s.append('1');
                }
            }
            index++;
        }
        System.out.println(s.toString());
        int result = 0;
        for(int i = 0;i< n;i++){
            if(s.charAt(i)=='1')
                result++;
        }

        return result;
    }
}
