package pickone.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ying on 2018/12/18.
 */
public class LargestDivisibleSubset368 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
//        List<Integer> list = Arrays.stream( a).boxed().collect(Collectors.toList());
        List<Integer> result = largestDivisibleSubset(a);
        System.out.println(result);


    }

//    思路：dp找出来最长子序列中最大的值，

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if(nums.length==0){
            return list;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int j=1;j<nums.length;j++){
            for(int i=0;i<j;i++){
                if((nums[j]%nums[i]==0)||(nums[i]%nums[j]==0)){
                    dp[j] = dp[i]+1;
                    if(dp[j]>max){
                        max = dp[j];
                        maxIndex = j;
                        list.add(dp[i]-1,nums[i]);
                    }
                }
            }
        }


        list.add(nums[maxIndex]);
        return list;
    }
}
