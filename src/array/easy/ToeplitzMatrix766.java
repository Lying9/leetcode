package array.easy;

/**
 * Created by Administrator on 2018/3/9.
 */
public class ToeplitzMatrix766 {
    public static void main(String[] args) {
       /* int[][] matrix ={{1,2,3},{2,1,3},{3,2,1}};*/
        int[][] matrix ={{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));

    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
       /* if( matrix == null)
            return false;
        if(matrix.length == 1 || matrix[0].length == 1)
            return true;
        for (int i = 0; i < matrix[0].length ; i++) {
            int j = 0,k=i;
            while( ++j < matrix.length && ++k < matrix[0].length ){
                if(matrix[j][k]!=matrix[0][i])
                    return false;
            }
        }
        for (int i = 0; i < matrix.length ; i++) {
            int j =i,k = 0;
            while(++j < matrix.length && ++k < matrix[0].length ){
                if(matrix[j][k] != matrix[i][0])
                    return false;
            }
        }

        return true;*/

        /**
         * 比较其元素与其 左上的元素值相等
         */
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}
