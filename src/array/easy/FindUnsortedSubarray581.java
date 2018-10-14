package array.easy;

/**
 * Created by Administrator on 2017/11/29.
 */
public class FindUnsortedSubarray581 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }
    /**
     * 思路：   先从前往后找到不符合排序的元素下标
     *          在从后往前找到不符合排序的元素下标
     *          找到这两个下标之间的 元素中  的  最小元素和最大元素
     *
     *          找到最小元素和最大元素应该插入的位置  则可计算出 长度
     * */
    public static int findUnsortedSubarray(int[] nums) {
        int i = 0;
        while(i<nums.length - 1 && nums[i] <= nums[i+1])
            i++;
        if(i == nums.length - 1)
            return 0;
        int h = nums.length-1;
        while(h>= 1 &&  nums[h]>=nums[h-1])
            h--;
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for (int index = i; index <= h ; index++) {
            if(nums[index] > max)
                max = nums[index];
            if(nums[index] < min)
                min = nums[index];
        }
        int j = i-1;
        while(j >=0 && nums[j] > min)
            j--;
        int k = h+1;
        while(k < nums.length && nums[k]< max)
            k++;
        return k-j-1;
    }

}
