package array.easy;

/**
 * Created by Administrator on 2017/11/22.
 */
public class SearchInsert35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }
/*
* 思路：  二分查找 注意：每次改变要给mid+1或-1
*                        应该插入的位置 都是right+1
* */
    public static int searchInsert(int[] nums, int target) {
        if(nums.length==0 || nums==null)
            return 0;
        int left = 0,right = nums.length-1,mid =0;
        while(left<= right){
            mid = (left+right)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return right+1;
    }
}
