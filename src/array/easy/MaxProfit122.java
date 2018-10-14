package array.easy;

/**
 * Created by Administrator on 2017/11/13.
 */
/*
*   思路：找每个拐点
*
* */
public class MaxProfit122 {
    public static void main(String[] args) {
        int[] prices = {1,5,3,9,6};
        int a = maxProfit(prices);
        System.out.println(a);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0,i = 0,min =0;
        while(i < prices.length){
            while(i<prices.length-1 && prices[i+1] <= prices[i])
                i++;
            min = prices[i++];
            while(i<prices.length-1 && prices[i+1] >= prices[i])
                i++;
            profit += i < prices.length ? prices[i++]-min : 0;
        }
        return profit;
    }
}
