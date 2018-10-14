package array.easy;

/**
 * Created by Administrator on 2017/10/27.
 */
public class ArraySum {
    public static void main(String[] args) {
        /*public int[] twoSum(int[] nums, int target) {

        }*/
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = new int[nums.length];
        int contain,count=0;
        for(int i =0 ;i<nums.length;i++){
            if(i!=0&&contains(i,result)==1)
                continue;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    contain = contains(j,result);
                    if(contain==0){
                        result[count++]=i;
                        result[count++]=j;

                    }

                }
            }
        }
        int[] resule1 = new int[count];
        for (int i = 0; i < count; i++) {
            resule1[i] = result[i];
        }
        for (int i = 0; i < resule1.length; i++) {
            System.out.println(resule1[i]);
        }
    }
    public static int contains(int num,int[] nums){
        for(int i=0;i<nums.length;i++){
            if(num==nums[i])
                return 1;
        }
        return 0;
    }
}
