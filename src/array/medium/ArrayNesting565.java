package array.medium;

/**
 * Created by Administrator on 2017/12/27.
 */
public class ArrayNesting565 {
    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
       // int[] nums = {1,0,3,4,2};
        System.out.println(arrayNesting(nums));
    }
    public static int arrayNesting(int[] nums) {
        int max = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            if(result[i] >= 1)
                break;
            result[i] = 1;
            int frist,pre,count = 0;
            frist = nums[i];
            count ++;
            pre = frist;
            while(nums[pre] != nums[i]){
                result[nums[pre]] = 1;
                count ++;
                pre = nums[pre];
            }
            if(max < count)
                max = count;

        }
        return max;
    }
    /*
    * 产生的一个序列里的数 无论以哪个开始 结果都是等长的（例如 5 开头的  5 6 2 0 则在以 6 2 0 这几个开头得到的序列长都为4）  所以  用result记录已经访问了的
    * */
   /* public static int arrayNesting(int[] nums) {
        int max = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            if(result[i] >= 1)
                break;
            result[i] = 1;
            int[] temp  = new int[nums.length];//不必用temp 因为要是重复则必定是与序列的第一个元素重复  所以直接下面的while直接比较nums[pre]和nums[i] 是否相等即可
            int frist,pre,count = 0;
            frist = nums[i];
            temp[frist] = 1;
            count ++;
            pre = frist;
            while(temp[nums[pre]] != 1){
                temp[nums[pre]] = 1;
                result[nums[pre]] = 1;
                count ++;
                pre = nums[pre];
            }
            if(max < count)
                max = count;

        }
        return max;
    }*/

    //Time Limit Exceeded
   /* public static int arrayNesting(int[] nums) {
        int max = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            int[] temp  = new int[nums.length];
            int frist,pre,count = 0;
            frist = nums[i];
            temp[frist] = 1;
            result[frist] = 1;
            count ++;
            pre = frist;
            while(temp[nums[pre]] != 1){
                temp[nums[pre]] = 1;
                result[nums[pre]] = 1;
                count ++;
                pre = nums[pre];
            }
            if(max < count)
                max = count;
            int j;
            for (j = 0; j <result.length ; j++) {
                if(result[j] == 0)
                    break;
            }
            if(j >= result.length )
                break;

        }
        return max;
    }*/
}
