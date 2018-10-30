package pickone.medium;

/**
 * Created by ying on 2018/10/25.
 */
public class RemoveKdigits402 {

    public static void main(String[] args) {
        String num = "43000024";
        int k = 2;
        System.out.println(removeKdigits(num,k));
    }

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        int p = 1, c = k-1; int i = -1, zeros = 0;
        while(c>=0) {
            while(p<n&&num.charAt(p)=='0') {
                zeros++; i=++p;
            }
            if(c>0) p++; c--;
        }
        if(p>=n) return "0";
        String sub = i>-1?num.substring(i):num;
        k-= i>-1?i-zeros:0;
        StringBuilder sb = new StringBuilder();
        p = 0;
        while(k>0){
            if (k==sub.length()-p) return sb.toString();
            int cc = 1;
            int ccc = p;
            while(cc<=k) {
                if(sub.charAt(p+cc)<sub.charAt(p)) {
                    k-=cc; p += cc; break;
                }
                cc++;
            }
            if (ccc==p) {
                sb.append(sub.charAt(p++));
            }
        }
        return sb.toString()+sub.substring(p);
    }

    //删除一个时，删除的是从前往后的第一个比后面数字大的数
    public static String removeKdigits1(String num, int k) {
        String result = num;
        for (int i = 0; i < k ; i++) {
            int j;
            int loopcount = result.length();
            for (j= 0; j < loopcount-1 ; j++) {
                if(result.charAt(j) > result.charAt(j+1)){
                    result = result.substring(0,j)+result.substring(j+1);
                    break;
                }
            }
            if(j==loopcount-1){
                result = result.substring(0,loopcount-1);
            }
            while(result.length()>0 && result.charAt(0) == '0'){
                result = result.substring(1);
            }
           if(result.length() == 0)
               return "0";
        }
        return result;
    }
}
