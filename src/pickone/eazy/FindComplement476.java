package pickone.eazy;

/**
 * Created by ying on 2018/10/16.
 */
public class FindComplement476 {

    public static void main(String[] args) {
        int num =8;
        System.out.println(Integer.lowestOneBit(num));
//        System.out.println(findComplement(num));
    }

    /* num    num的补result
       num+result = 2的num的二进制数长度 次幂 -1
       因此找到num的二进制数长度 就可

       结果也是num异或上全一的数

       Integer.lowestOneBit(num)  返回num的二进制的1的最低（右）一位所表示的十进制的数
       Integer。highestOneBit（num） 返回num的二进制的1的最高（左）一位所表示的十进制的数
    * */
    public static int findComplement(int num) {
//        time limit exceed
      /*  int sum = 2;
        while(true){
            if(sum > num)
                break;
            sum *= 2;
        }
        return sum-1-num; */
//        System.out.println(Integer.toBinaryString(num));

//        accept
        /*int length = Integer.toBinaryString(num).length();
        return (int)(Math.pow(2,length)-1-num);*/

        return num ^((Integer.highestOneBit(num)<<1)-1);
    }

}
