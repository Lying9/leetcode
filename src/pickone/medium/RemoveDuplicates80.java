package pickone.medium;

/**
 * Created by ying on 2018/9/18.
 */
public class RemoveDuplicates80 {

    public static void main(String[] args) {
        int[] nums ={0,0,1,1,1,1,2,2,2,3};
        int length = removeDuplicates(nums);
        System.out.println(length);
        for (int i = 0; i <length ; i++) {
            System.out.print(nums[i]+"\t");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int i=0;
        for(int num : nums){
            if(i<2 || nums[i-2]<num)
                nums[i++] = num;
        }
        return i;

       /* int i = 0, index = 0;
        while (i < nums.length) {
            int start = i;
            while (i < nums.length && nums[i] == nums[start])
                i++;
            if (i - start < 2) {
                if (index != i) {
                    nums[index++] = nums[start];
                } else index += i - start;
            } else {
                if (index != i) {
                    nums[index++] = nums[start];
                    nums[index++] = nums[start];
                } else index += 2;
            }

        }
        return index;*/
    }
}
