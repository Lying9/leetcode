package array.easy;

import javax.swing.tree.RowMapper;

/**
 * Created by Administrator on 2017/11/20.
 */
/*
* 思路：  从头开始遍历整个数组  记录遍历的最小值  和 当前元素与最小元素的差并记录下最大值
* */
public class MaxProfit121 {

    public static void main(String[] args) {
       // int[] prices = {7,1,3,5,6,4};
        int[] prices = {7,6,5,4,3,2,1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length==0 || prices == null)
            return 0;
        int min = Integer.MAX_VALUE,maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min)
                min = prices[i];
            else{
                if(maxProfit < prices[i] - min)
                    maxProfit  = prices[i] - min;
            }
        }
        return maxProfit;
    }
}
