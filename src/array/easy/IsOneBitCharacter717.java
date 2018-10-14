package array.easy;

/**
 * Created by Administrator on 2017/11/7.
 */
public class IsOneBitCharacter717 {
    public static void main(String[] args) {
        int[] bits = {1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0};
        System.out.println(isOneBitCharacter(bits));
    }
    //找数组中除最后一位以外 最后一位为0的元素    判断这个元素和最后一位元素的差为奇数还是偶数  奇 TRUE  偶 FALSE
    public static boolean isOneBitCharacter(int[] bits) {
        int i;
        for (i = bits.length-2; i >= 0  ; i--) {
            if(bits[i]==0)
                break;
        }
        if((bits.length-1-i)%2==0)
            return false;
        else return true;

        /*int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
*/
    }


}
