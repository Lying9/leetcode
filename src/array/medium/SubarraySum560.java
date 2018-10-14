package array.medium;

import java.util.HashMap;

/**
 * Created by ying on 2018/4/14.
 */
public class SubarraySum560 {
    public static void main(String[] args) {
        int[] nums ={1,1,1};
        System.out.println(subarraySum(nums,2)); //2
       /* int[] nums = {1};
        System.out.println(subarraySum(nums,0));*/    //0
      /*  int[] nums = {-1,-1,1};
        System.out.println(subarraySum(nums,0));//1*/
    }
 /*   public static int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1]; //sums[i]存储的为nums[0]到nums[i-1]的和
        }
        return sub(sums, new int[sums.length], 0, sums.length - 1, k);
    }*/

    private static int sub(int[] sums, int[] aux, int start, int end, int k) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int res = sub(sums, aux, start, mid, k) + sub(sums, aux, mid + 1, end, k);
        res += merge(sums, aux, start, mid, end, k);
        return res;
    }


    private static int merge(int[] sums, int[] aux, int start, int mid, int end, int k) {
        // System.out.println("start: " + start + " mid: " + mid + " end: " + end);
        // System.out.println("Before merge: " + Arrays.toString(sums));
        for (int i = start; i <= end; i++) {
            aux[i] = sums[i];
        }
        int count = 0;
        int i = start, j = mid + 1, t = start;
        int p = mid + 1;
        while (i <= mid) {
            while (p <= end && aux[p] - k < aux[i]) p++;
            for (int q = 0; q + p <= end; q++) {
                if (aux[p + q] - k > aux[i]) break;
                else count++;
            }

            while (j <= end && aux[i] > aux[j]) sums[t++] = aux[j++];
            sums[t++] = aux[i++];
        }

        while (j <= end) sums[t++] = aux[j++];
        // System.out.println("After merge: " + Arrays.toString(sums));
        return count;
    }
    public static int subarraySum(int[] nums, int k) {

        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>((int)(nums.length / 0.75 + 0.5));

        map.put(0, 1);

        for(int num : nums) {
            sum += num;
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, 1 + map.getOrDefault(sum, 0));
        }

        return count;
    }
//双层循环遍历
   /* public static  int subarraySum(int[] nums, int k) {
        int sum = 0,result = 0;
        for (int i = 0; i < nums.length ; i++) {
            sum = 0;
            for (int j = i; j <nums.length ; j++) {
                sum += nums[j];
                if(sum == k)
                    result ++;
            }
        }
        return result;
    }*/

}
