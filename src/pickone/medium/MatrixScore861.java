package pickone.medium;

/**
 * Created by ying on 2018/11/2.
 */
public class MatrixScore861 {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(matrixScore(A));
    }

    //贪心算法  时间复杂度o(n * m) n:数组行数m:数组列数
    public static int matrixScore(int[][] A) {
        int max = 0;
        for (int i = 0; i < A[0].length; i++) {
            int colsum = 0;
            for (int j = 0; j < A.length; j++) {
                colsum += A[j][i] ^ A[j][0];    //因为2^n > 2^n-1 + 2^n-2 +...+2^0 所以每一行的开头为1时这一行最大   这个操作的每一行的
//                                                第一个元素都异或上自己为0  则max加上的为全为1的值。。
//                                                对于其他列：当原来这一行为1时   说明这一行没有变换，得到的是与自己本身相反的值
//                                                             当原来这一列为0时  说明这一列进行了变换 ，得到的是自身，即变换一次之后的反值
//                                                也就是说得到的是等个列所表述数的反值  则max加上的是变换与不变换中的最大值

            }
            max += Math.max(colsum, A.length - colsum) * 1 << (A[0].length - i - 1);
        }
        return max;
    }

    //accept  思路：先遍历每一行 当这一行 所表示的十进制数 比装换后的小 时  转换这一行
//              再遍历每一列  当这一列的1的个数小于0的个数时  转换这一列
//              最后求其表示的十进制数
//    时间复杂度 O（n * m） n:数组行数  m:数组列数
    public static int matrixScore1(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int rowsum = 0;
            for (int j = 0; j < A[0].length; j++) {
                rowsum += A[i][j] * Math.pow(2, A[0].length - j - 1);
            }
            if (Math.pow(2, A[0].length) - 1 - rowsum > rowsum) {
                for (int j = 0; j < A[0].length; j++) {
                    A[i][j] = A[i][j] ^ 1;
                }
            }
        }
        for (int i = 0; i < A[0].length; i++) {
            int countone = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 1)
                    countone++;
            }
            if (A.length - countone > countone) {
                for (int j = 0; j < A.length; j++) {
                    A[j][i] = A[j][i] ^ 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int rownum = 0;
            for (int j = 0; j < A[0].length; j++) {
                rownum += A[i][j] * Math.pow(2, A[0].length - j - 1);
            }
            sum += rownum;
        }
        return sum;
    }
}
