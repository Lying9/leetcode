package array.medium;

/**
 * Created by ying on 2018/4/9.
 */
public class FindMin153 {
    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(findMin(nums));
    }
    /*
    * 思路：
    *   一：如果数组中第一个元素 <= 最后一个元素  则数组是升序的 最小值为第一个元素
    *       如果不是   则从头到尾遍历整个数组，找到某个元素比前面的元素小  即为最小值
    *   二：如果数组中第一个元素 <= 最后一个元素  则数组是升序的 最小值为第一个元素
    *       如果不是   用二分查找的思想
    *
    *
    *
    * */
    public static int findMin(int[] nums) {

        if(nums[0]<= nums[nums.length-1])
            return nums[0];
        int start = 0,end = nums.length-1,mid;
        while(start+1<end){
            mid = (start+end)/2;
            if(nums[mid] < nums[start])
                end = mid;
            else if(nums[mid] >nums[end])
                start=mid;
        }
        return nums[end];

       /* for (int i = 0; i <nums.length-1 ; i++) {
            if(nums[i] > nums[i+1])
                return nums[i+1];
        }
        return -1;*/

       /* else
            return researchmin(nums,0,nums.length-1);*/
    }



//效率没有提高的原因：二分查找中原数组是有序的，而在本题中   没有含有目标数的一半也要进行查找
    public static int researchmin(int[] nums,int start,int end){
        if(start >= end)
            return Integer.MAX_VALUE;
        int mid = (start+end)/2;
        if(mid-1>=start&&nums[mid-1]> nums[mid])
            return nums[mid];
        else if(mid+1<=end&&nums[mid] > nums[mid+1])
            return nums[mid+1];
        else return Math.min(researchmin(nums,start,mid-1),researchmin(nums,mid+1,end));
    }
}
