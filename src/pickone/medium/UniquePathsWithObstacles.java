package pickone.medium;

/**
 * Created by ying on 2019/8/12.
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
       // int[][] o = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] o = {{0,0},{1,0}};
        System.out.println(uniquePathsWithObstacles(o));

    }
/*dp[i][j] 表示从ij到终点的路径数
*  则对于dp的最后一行和最后一列  倒序如果无障碍物则为1，遇到第一个障碍物的前面都为0
*   对于其他位置 如果无障碍则 dp[i][j] = dp[i][j+1]+dp[i+1][j]; 有则dp[i][j] =0*/
//另一种思路  dp[i][j]表示从起点到i j的路径数
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0)
            return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int row = dp.length, col = dp[0].length;
        boolean flag = false;
        //最后一行
        for (int i = col-1; i >=0 ; i--) {
            if(obstacleGrid[row-1][i] == 1)
                flag = true;
            if(flag)
                dp[row-1][i] = 0;
            else
                dp[row-1][i] = 1;
        }
        //最后一lie
        flag = false;
        for (int i = row-1; i >=0 ; i--) {
            if(obstacleGrid[i][col-1] == 1)
                flag = true;
            if(flag)
                dp[i][col-1] = 0;
            else
                dp[i][col-1] = 1;
        }
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        for (int i = row-2; i >=0 ; i--) {
            for (int j = col-2; j >=0 ; j--) {
                if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i][j+1]+dp[i+1][j];
                }
            }
        }

        System.out.println();
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[0][0];
    }
}
