package pickone.medium;

/**
 * Created by ying on 2019/1/17.
 */
public class Search33 {
    public static void main(String[] args) {
//        int[] nums = {4,5,1,2,3};
//        System.out.println(binarySearch(0,nums.length-1,nums,3));
        int[] nums = {3, 1};
        System.out.println(search(nums, 3));
    }

    /*
        思路： 第一步：类比二分查找思想 找到nums的旋转的点
               第二步：在相应的区间中二分查找找target
        时间复杂度： O(logn)
    * */
    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            if (target == nums[0])
                return 0;
            else
                return -1;
        }
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;
//        nums原本就是有序的
        if (nums[0] < nums[nums.length - 1])
            mid = 0;
        else {
//            nums有旋转点
            while (nums[mid] < nums[mid + 1]) {
                if (nums[mid] < nums[high]) {
                    high = mid;
                    mid = (low + high) / 2;
                } else {
                    low = mid;
                    mid = (low + high) / 2;
                }
            }
            mid = mid + 1;
        }
//        System.out.println(mid);
        if (mid == 0)
            return binarySearch(0, nums.length - 1, nums, target);
        if (target > nums[0])
            return binarySearch(0, mid - 1, nums, target);
        else if (target == nums[0])
            return 0;
        else
            return binarySearch(mid, nums.length - 1, nums, target);
    }

    public static int binarySearch(int low, int high, int[] nums, int target) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
//                mid = (low + high) / 2;
            } else
                return mid;
        }
        return -1;
    }

//  在二分查找的过程中 判断 位置
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int num = nums[mid];
//            根据num与nums[0]的关系  以及 target与nums[0]的关系  判断target的所在区间
            if (!((num >= nums[0]) == (target >= nums[0]))){
                num = num >= nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (num < target){
                left = mid + 1;
            } else if (num > target){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums.length==1 && nums[0]==target) return 0;
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left<right){
            mid = (left+right)/2;
            if (nums[left]==target) return left;
            if (nums[right]==target) return right;
            if (nums[mid]==target) return mid;
            if (nums[mid] > nums[left]){ //第一种情况
                if (target>nums[mid]) {
                    left = mid+1;
                }else {
                    if (target>nums[left]) {
                        right = mid-1;
                    }else {
                        left = mid+1;
                    }
                }
            }else { //第二种情况
                if (target>nums[mid]){
                    if (target<nums[right]) {
                        left = mid + 1;
                    }else {
                        right = mid -1;
                    }
                }else {
                    right = mid -1;
                }
            }

        }
        return -1;
    }

}
