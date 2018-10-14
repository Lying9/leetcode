package array.medium;

import java.util.Arrays;



/**
 * Created by Administrator on 2017/12/5.    看别人思路解决的
 */
public class ConstructArray667 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(5,4)));
    }
    /* k=1    nums: 1   2   3   .....   n
       k= n-1  nums: 1  n   2   n-1  3 n-2
       结合两种 {1，2，3 ... n-k-1}  {1，1+k,1+k+ k-1 ,...}
                                     {+n-k-1,+n-k+1 ...}
       例子：n = 6,k = 3
                {1,2}               {1,4,2,3}+2  {3,6,4,5}
                {1,2,3,6,4,5}

    */
  /*  public static int[] constructArray(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i <= n-k-1; i++) {
            nums[i] = i+1;
        }
        for (int i = n-k; i < n; i++) {
            if((i-n+k+1)%2 == 0)
                nums[i] = n - k + (i-n+k+1)/2;
            else
                nums[i] = n - (i-n+k+1)/2;
        }
        return nums;

    }*/



    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int l=1,r=n;
        for(int i=0;i<n;i++){
            res[i]=k>1?((k--%2!=0?l++:r--)):l++;
        }
        return res;
    }



}
