package pickone.medium;

/**
 * Created by ying on 2018/11/1.
 */
public class KthSmallest378 {

    public static void main(String[] args) {
//        int[][] m = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] m = {{1, 5, 9, 13},
                {10, 11, 13, 14},
                {12, 13, 15, 16},
                {13, 14, 16, 18}};
        System.out.println(kthSmallest(m, 11));
    }
//二分查找的思想
    public static int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix.length - 1];
        int mid,num;
        while (left<=right) {
            mid = (right - left) / 2 + left;
            num = count(matrix,mid);
            if(num >=k){
                right = mid-1;
            }else
                left = mid+1;
        }
        return left;
    }
//    返回matrix中小于等于num的数的个数
    public static int count(int[][] matrix,int num){
        int n = matrix.length-1,col = 0;
        int sum = 0;
        while(n>=0 && col < matrix.length){
            if(matrix[n][col] <= num) {
                sum += n + 1;
                col++;
            } else
                n--;
        }
        return sum;
    }

    //accept 思想：两个有序数列找第k大的思想，两个时可以有两个指针，分别指向每个数列中的当前元素，比较其大小，然后移动指针
//             将这种思想扩充到N个数列中  index数组中记录每一个指针的位置。外层循环 循环一次，找到一个最小的元素。
//                内层循环在N个数列中找最小的元素
//    时间复杂度O（n*k）     空间复杂度O（n）   n:数组行/列数   k:参数
    public static int kthSmallest1(int[][] matrix, int k) {
        int[] index = new int[matrix.length];
        int min, minindex = 0;
        for (int m = 0; m < k; m++) {
            min = Integer.MAX_VALUE;
            minindex = -1;
            for (int i = 0; i < index.length; i++) {
                if (index[i] >= index.length)
                    continue;
                if (min > matrix[i][index[i]]) {
                    min = matrix[i][index[i]];
                    minindex = i;
                }
                if (index[i] == 0)
                    break;
            }
            index[minindex]++;
        }
        return matrix[minindex][index[minindex] - 1];
    }
}
