package array.easy;

/**
 * Created by Administrator on 2017/11/5.
 */
//思路：  遍历整个数组  当数组元素为1时 则这个区域的个数应该是其上下左右个数+1 并把该位置值复制为-1（避免重复计算）
    //    保留最大值即可
public class MaxAreaOfIsland695 {
    public static void main(String[] args) {
        int[][] nums = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int result = maxAreaOfIsland(nums);
        System.out.println(result);
    }

    private static int maxAreaOfIsland(int[][] nums) {
        int max=0,count=0;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j <nums[i].length ; j++) {
                if(nums[i][j] == 1) {
                    count = isLand(nums, i, j);
                   if(count > max)
                       max = count;
                }
            }

        }
        return max;
    }

    private static int isLand(int[][] nums,int i,int j) {
        int count = 1;
        nums[i][j] = -1;
        if(i-1>=0 && nums[i-1][j] == 1){
            count += isLand(nums,i-1,j);
        }
        if(j-1>=0 && nums[i][j-1] == 1){
            count += isLand(nums,i,j-1);
        }
        if(i+1 <nums.length && nums[i+1][j] ==1){
            count += isLand(nums,i+1,j);
        }
        if(j+1<nums[i].length && nums[i][j+1] ==1){
            count += isLand(nums,i,j+1);
        }
        return count;

    }
}
