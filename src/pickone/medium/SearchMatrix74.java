package pickone.medium;

/**
 * Created by ying on 2019/1/22.
 */
public class SearchMatrix74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//        int[][] matrix ={{1,3}};
        int target = 20;
        System.out.println(searchMatrix(matrix, target));
    }

    //    思路：对其行进行一次二分  找到对应的行，在在这个行中进行一次二分
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        if (rowLen == 0) {
            return false;
        }
        int colLen = matrix[0].length;
        if (colLen == 0) {
            return false;
        }
        int lo = 0;
        int hi = rowLen - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2 + 1;
            int curr = matrix[mid][0];
            if (curr == target) {
                return true;
            } else if (curr > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        int rowIdx = lo;
        lo = 0;
        hi = colLen - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int curr = matrix[rowIdx][mid];
            if (curr == target) {
                return true;
            } else if (curr > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }


    //    思路：把整个矩阵分为四块   则根据target和指定某个数的值大小，可以确定其可能在的子矩阵块，在其子矩阵块中继续查找
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
//        return search(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
        return FindPlus(matrix, 0, matrix.length, 0, matrix[0].length, target);
    }

//    public static boolean search(int[][] matrix, int target, int x1, int y1, int x2, int y2) {
        /*if (x1 < 0 || x2 < 0 || x1 >= matrix.length || x2 >= matrix.length || y1 < 0 || y2 < 0 || y2 >= matrix[0].length || y1 >= matrix[0].length)
            return false;
        if(x1== x2 && y1 == y2){
            if(target == matrix[x1][y1])
                return true;
            else
                return false;
        }
        if (x1 > x2 || y1 > y2) {
            return false;
        }
        int x0 = (x1 + x2) / 2;
        int y0 = (y1 + y2) / 2;
        if (target > matrix[x0][y0]) {
            return (search(matrix, target, x1, y0 + 1, x0, y2) || search(matrix, target, x0 + 1, y1, x2, y0) || search(matrix, target, x0 + 1, y0 + 1, x2, y2));
        } else if (target < matrix[x0][y0]) {
            return (search(matrix, target, x1, y1, x0, y0 - 1) || search(matrix, target, x1, y0, x0, y2) || search(matrix, target, x0 + 1, y1, x2, y0 - 1));
        } else
            return true;*/

//    }

    public static boolean FindPlus(int[][] array, int x0, int x1, int y0, int y1, int target) {
        if (x0 >= x1 || y0 >= y1) return false;
        int tx = (x0 + x1) / 2;
        int ty = (y0 + y1) / 2;

        if (array[tx][ty] == target) {
            return true;
        } else if (array[tx][ty] > target) {
            return FindPlus(array, x0, tx, ty, y1, target)  // B
                    || FindPlus(array, x0, tx, y0, ty, target)  // A
                    || FindPlus(array, tx, x1, y0, ty, target); // C
            // 后两个可以合并为 FindPlus(array, x0, x1, y0, ty, target);
        } else {
            return FindPlus(array, x0, tx + 1, ty + 1, y1, target) // F
                    || FindPlus(array, tx + 1, x1, y0, ty, target)   // E
                    || FindPlus(array, tx + 1, x1, ty, y1, target);  // G
            // 后两个可以合并为 FindPlus(array, tx+1, x1, y0, y1, target);
        }
    }
}
