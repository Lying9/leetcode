package pickone.medium;

/**
 * Created by ying on 2019/4/19.
 */
public class MaxIncreaseKeepingSkyline807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int[] left = new int[grid.length];
        int[] top = new int[grid[0].length];
        for(int i = 0;i<grid.length;i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0;j<grid[0].length;j++){
                max = Math.max(max,grid[i][j]);
            }
            left[i] = max;
        }
        for(int i = 0;i<grid[0].length;i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0;j<grid.length;j++){
                max = Math.max(max,grid[j][i]);
            }
            top[i] = max;
        }
        int sum = 0;
        for(int i = 0;i<grid.length;i++){
            int max = left[i];
            for(int j = 0;j<grid[0].length;j++){
                sum += Math.min(max,top[j])-grid[i][j];
            }

        }
        return sum;
    }
}
