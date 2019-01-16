package pickone.medium;

import java.util.Arrays;

/**
 * Created by ying on 2019/1/14.
 */
public class Change518 {
    public static void main(String[] args) {
      /*  int amount = 5;
        int[] coins = {1,2,5};*/
        /*int amount = 3;
        int[] coins = {2};*/
        /* int amount = 10;
        int[] coins = {10};*/
        /*int amount = 500;
        int[] coins = {1,2,5};*/
        int amount = 500;
        int[] coins = {3, 5, 7, 8, 9, 10, 11};
        System.out.println(change1(amount, coins));

        /*500[1,2,5]   12701
        500 [3,5,7,8,9,10,11]  35502874????
        * */
    }

    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return changecom(amount, coins, coins.length);
    }

    //Time Limit Exceeded
    public static int changecom(int amount, int[] coins, int end) {
        if (amount == 0)
            return 1;
        int result = 0;
        for (int i = 0; i < end; i++) {
            if (coins[i] == 1)
                result++;
            else {
                for (int j = 1; j <= amount / coins[i]; j++) {
                    result += changecom(amount - j * coins[i], coins, i);
                }
            }
        }
        return result;
    }

    //
    public static int change1(int amount, int[] coins) {
        int[] count = new int[amount + 1];
        count[0] = 1;
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i])
                    count[j] += count[j - coins[i]];
            }
        }
       /* for (int i = 1; i <= amount; i++) {
            int temp = 0;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i)
                    break;
                if (coins[j] == i) {
                    temp++;
                    break;
                } else {
                    if (coins[j] == 1) {
                        temp++;
                    } else {
                        temp += count[i - coins[j]];
                    }
                    if(i - coins[j] < coins[j] && i - coins[j]>1 ){
                        if(find(coins,i-coins[j]) > -1){
                            temp--;
                        }
                    }
                }
            }
            count[i] = temp;
        }
        for (int l = 0; l < count.length; l++) {
            System.out.println(l + " : " + count[l]);
        }*/
        return count[amount];
    }

}
