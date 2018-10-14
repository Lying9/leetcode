package pickone.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ying on 2018/10/14.
 */
public class FindDiagonalOrder498 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = new int[0][0];
        int[] result = findDiagonalOrder(matrix);
        for (int number : result)
            System.out.print(number + "\t");

    }

    /*
    思路： 对于所有数 都按从左下到右上的顺序遍历，将其加入一个list中，在根据奇偶去判断其顺序
    需要注意：遍历要进行m+n次，准确的说是（m+n-1）次
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0 || matrix==null)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int index = 0;
        for (int k = 0; k < m + n-1; k++) {
            List<Integer> list = new ArrayList<>();
            int i, j;
            if (k >= m) {
                i = m - 1;
                j = k - m + 1;
            } else {
                i = k;
                j = 0;
            }
            while (i >= 0 && i < m && j >= 0 && j < n) {
                list.add(matrix[i][j]);
                i--;
                j++;
            }
            if (k % 2 == 0) {
                for (int num : list)
                    result[index++] = num;
            } else {
                for (int l = list.size() - 1; l >= 0; l--) {
                    result[index++] = list.get(l);
                }
            }
        }
        return result;
    }
    /*效率更高
    * 第二种 思路：观察可得，遍历的每一条直线上横纵坐标和要么都为偶数，要么都为奇数
    * 且偶数 遍历方向为左下到右上    奇数遍历方向为右上到左下
    * 且偶数遍历转奇数遍历时  下一个元素要么在其右面 要么在其下面
    *  奇数遍历转偶数遍历时   同样，下一个元素要么在其右面 要么在其下面
    * */
    public static int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = matrix[r][c];
            if((r+c) % 2 == 0){
                if(c == n-1){r++;}
                else if(r == 0){c++;}
                else{
                    c++;
                    r--;
                }
            }else{
                if(r == m-1){c++;}
                else if(c == 0){r++;}
                else{
                    c--;
                    r++;
                }
            }
        }
        return arr;
    }
}
