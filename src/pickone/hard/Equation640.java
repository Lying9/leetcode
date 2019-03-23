package pickone.hard;

/**
 * Created by ying on 2019/3/21.
 */
public class Equation640 {
    public static void main(String[] args) {
        String s = "x=x+2";
        System.out.println(solveEquation(s));
    }

    public static String solveEquation(String equation) {
        int equal = equation.indexOf("=");
        int start = 0,end = 0;
        int[] left = num(equation.substring(0,equal));
        int[] right = num(equation.substring(equal+1,equation.length()));
        int xcount = left[0]-right[0];
        int num = right[1]-left[1];
        if(xcount == 0){
            if(num == 0){
                return "Infinite solutions";
            }else
                return "No solution";
        }else{
            int temp = num/xcount;
            return "x="+temp;
        }


    }
    public  static int[] num(String str){
        int start = 0,end = 0;
        int leftxcount = 0,leftnum = 0;
        if(str.charAt(0)>='0' && str.charAt(0)<='9')
            str = "+"+str;
        while(end < str.length()){
            if('x'==str.charAt(end)){
                if(start == end){
                    leftxcount++;
                }else{
                    String s =str.substring(start,end);
                    if("+".equals(s))
                        leftxcount++;
                    else if("-".equals(s))
                        leftxcount--;
                    else
                        leftxcount +=Integer.valueOf(s);
                }
                start = end+1;
                end = start;
            }else if('+'==(str.charAt(end)) || '-'== str.charAt(end)){
                end++;
                while(end < str.length() &&str.charAt(end)>='0' && str.charAt(end)<='9')
                    end++;
                if(end < str.length() && 'x' ==(str.charAt(end)))
                    continue;
                else{
                    leftnum +=Integer.valueOf(str.substring(start,end));
                    start = end;
                }
            }

        }
        int[] result = new int[2];
        result[0] = leftxcount;
        result[1] = leftnum;
        return result;
    }
}
