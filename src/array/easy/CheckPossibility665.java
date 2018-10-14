package array.easy;

/**
 * Created by Administrator on 2017/12/4.
 */
public class CheckPossibility665 {

    public static void main(String[] args) {
        int[] nums = {4,2,3};
        System.out.println(checkPossibility(nums));
    }

    /*
    *
    * 思路：：  首先遍历数组 找到nusm[i] > nums[i+1]的情况  则有两种选择
    *           1.修改i     nums[i-1] <= nums[i+1]
    *           2 修改i+1   nums[i-1] > nums[i+1]
    *           在继续遍历数组   用一个计数器count来记录更改的次数
    *
    *           注意：在判断改i还是i+1时  需要用到i-1和i+2进行比较  注意数组的下表越界的问题
    * */
    public static  boolean checkPossibility(int[] nums) {
        int count=0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]){
                count++;
                if(i>=1 && nums[i-1] > nums[i+1]){    //改i+1
                    if(i<nums.length-2 && nums[i] > nums[i+2])
                        return false;
                    else
                        i = i+1;
                }
            }
        }
        if(count <= 1)
            return true;
        return false;
    }
}
