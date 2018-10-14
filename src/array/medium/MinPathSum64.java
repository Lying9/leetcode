package array.medium;

/**
 * Created by ying on 2018/4/10.
 */
public class MinPathSum64 {

    public static void main(String[] args) {
       // int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid = {{1, 2,5}, {3,2,1}};
        System.out.println(minPathSum(grid));
    }

/*
 * 思路： 1、 动态规划    用path[][]来存储 最短的路径
 *                  则  path[0][i] 为path[0][0]到path[0][i-1]的和
 *                      path[i][0] 为path[0][0]到path[i-1][0]的和
 *                      path[i][j] 为min（path[i-1][j],path[i][j-1]）+grid[i][j]
 *                   path[][]最后一个元素即为最小值
 *
 *         2.dfs     用path[][]来存储 最短的路径
 *                     从最后一个元素开始
 *
 */
    public static int minPathSum(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid[0].length ; i++) {
            sum += grid[0][i];
            path[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < grid.length ; i++) {
            sum += grid[i][0];
            path[i][0] = sum;
        }
        for (int i = 1; i <grid.length ; i++) {
            for (int j = 1; j < grid[0].length ; j++) {
                if(path[i-1][j] <= path[i][j-1])
                    path[i][j] = path[i-1][j] + grid[i][j];
                else
                    path[i][j] = path[i][j-1] + grid[i][j];
            }
        }
        return path[path.length-1][path[0].length-1];
       // return dfs(grid,grid.length-1,grid[0].length-1,path0);
    }

    public int dfs(int[][]grid,int x,int y,int[][]memo)
    {
        if(x<0 || y<0)
            return Integer.MAX_VALUE;
        if(memo[x][y] > 0)
            return memo[x][y];

        if(x==0 && y==0)
            return grid[0][0];


        int ans = grid[x][y] + Math.min(dfs(grid,x-1,y,memo),dfs(grid,x,y-1,memo));
        memo[x][y]=ans;

        return ans;
    }
}
