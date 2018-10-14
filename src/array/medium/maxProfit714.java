package array.medium;

/**
 * Created by Administrator on 2018/1/15.
 */
public class maxProfit714 {

    public static void main(String[] args) {
        /*int[] prices = {1,3,2,8,4,9};
        int fee = 2;*/
       /* int[] prices = {1,3,7,5,10,3};
        int fee = 3;*/  //6
      /*  int[] prices = {1,5,9};
        int fee = 2;*/  //6
        int[] prices = {4,5,2,4,3,3,1,2,5,4};
        int fee = 1;  //4
       /* int[] prices = {4,5,5,2,4,3,5,5,2,3};
        int fee = 3;*/
        System.out.println(maxProfit(prices,fee));
    }
    public static int maxProfit(int[] prices,int fee){
        int cash = 0,hold = -prices[0];
        for (int i = 0; i < prices.length ; i++) {
            cash = Math.max(cash,hold+prices[i]-fee);
            hold = Math.max(hold,cash - prices[i]);
        }
        return cash;
    }

  /*  public static int maxProfit(int[] prices, int fee) {
        int buy,sell,add,profit = 0,presell = -1,prebuy = -1;
        for (int i = 0; i < prices.length ; i++) {
            while(i+1<prices.length && prices[i+1]<=prices[i])
                i++;
            if(i+1 >= prices.length)
                break;
            buy = i++;
            while(i+1<prices.length && prices[i+1]>=prices[i])
                i++;
            if(i+1 >= prices.length) {
                if(prices[i] - prices[buy] > fee)
                    profit += prices[i] - prices[buy] - fee;
                break;
            }
            sell= i;
            add = prices[sell] - prices[buy] - fee;
            if(prebuy!=-1&&presell!=-1&&add + prices[presell] - prices[prebuy] - fee > prices[sell] - prices[prebuy] - fee) {
                profit += add;
                presell = sell;
                prebuy = buy;
            }
            else{
                if(presell != -1 && prebuy!=-1) {
                    profit += prices[sell] - prices[presell];
                    presell = sell;
                }
                else{
                    if(add >= 0 ) {
                        profit += add;
                        presell = sell;//
                        prebuy = buy;
                    }
                }
            }


        }
        return  profit;
    }
*/
   /* public static int maxProfit(int[] prices, int fee) {
        int buy = prices[0];
        int profit = 0,add,sell = -1;
        for (int i = 1; i < prices.length ; i++) {
            if(prices[i] - buy > fee ) {
                add =prices[i] - buy - fee;
                if(add < fee && sell!=-1) {
                    profit += prices[i] - sell;
                }else
                    profit += add;
                sell = prices[i];
                if(i+1 < prices.length)
                    buy = prices[++i];

            }
            if(prices[i] < buy)
                buy = prices[i];
        }
        return  profit;
    }*/
}
