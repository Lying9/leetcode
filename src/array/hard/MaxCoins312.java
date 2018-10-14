package array.hard;

/**
 * Created by ying on 2018/5/4.
 */
public class MaxCoins312 {
    public static void main(String[] args) {
       /* int[] nums = {3,1,5,8};  //167
       // int[] nums = {9,76,64,21,97,60}; //1086136
        System.out.println(maxCoins(nums));*/
    }
    /*思路：  用动态规划  max[i][j] 表示nums从i到j 踩破气球所能得到的最大硬币
    *          计算max[i][j]的方法：假设k在i和j之间，k是最后一个被踩破的气球
    *                               则max[i][j]=max[i][k-1]+max[k+1][j]+nums[i-1]*nums[k]*numa[j+1]
    *          */
    public  static int maxCoins(int[] nums) {
        int[][] max = new int[nums.length][nums.length];//长度是num的长度 而不是tnums
        //tnums 的第一个和最后一个元素为1  中间为num的元素
        int[] tnums = new int[nums.length+2];
        tnums[0] = 1;
        tnums[tnums.length-1] = 1;
        for (int i = 1; i < tnums.length-1; i++) {
            tnums[i] = nums[i-1];
        }

        return maxCoinscompute(tnums,0,nums.length-1,max) ;
        //return max[0][nums.length-1];
    }
    public static int maxCoinscompute(int[] nums,int low,int high,int[][] max){
        if(low > high)
            return 0;
       if(max[low][high] != 0 )
           return max[low][high];
       else {
           int maxcoins = -1;
           for (int i = low + 1; i <= high + 1; i++) {
               maxcoins = Math.max(maxcoins, maxCoinscompute(nums, low, i - 2, max)
                       + maxCoinscompute(nums, i, high, max) + nums[i] * nums[low] * nums[high + 2]);
           }
           max[low][high] = maxcoins;
       }
       return max[low][high];
    }
    /*
    * 当输入集合为空时 ，输出为0
    * */
   /* public  static int maxCoins(int[] nums) {
        if(nums.length==0 || nums==null)
            return 0;
        if(nums.length == 1)
            return nums[0];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int max = 0;
        //爆破nums.length-2次  遍历完成后list中剩余两个元素
        for (int i = 0; i < nums.length-2 ; i++) {
            //如果list的头是1 爆破 头
            if(list.get(0) == 1){
                if(list.size()>=2) {
                    max += list.get(0)*list.get(1);
                }
                else max += list.get(0);
                list.remove(0);
            }else if(list.get(list.size()-1) == 1){
                if(list.size()>=2) {
                    max += list.get(list.size()-1)*list.get(list.size()-2);
                }
                else max += list.get(list.size()-1);
                list.remove(list.size()-1);
            }else{
                //找 下标为1到n-2的 最小值
                int min = Integer.MAX_VALUE,minindex = -1;
                int j;
                for (j = 1; j < list.size()-1 ; j++) {
                    if(min > list.get(j)){
                        min = list.get(j);
                        minindex = j;
                    }
                }
                max += list.get(minindex-1)*list.get(minindex)*list.get(minindex+1);
                list.remove(minindex);
            }

        }
            max += list.get(0)*list.get(1)+Math.max(list.get(0),list.get(1));
       return max;
    }*/

}
