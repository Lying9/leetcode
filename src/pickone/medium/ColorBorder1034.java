package pickone.medium;

/**
 * Created by ying on 2019/5/6.
 */
public class ColorBorder1034 {
    public static void main(String[] args) {
        int[][] grid = {{1,2,2},{2,3,2}};
        int[][] result = colorBorder(grid,0,1,3);
        for (int i = 0; i <result.length ; i++) {
            for (int j = 0; j <result[0].length ; j++) {
                System.out.print(result[i][j]+"   ");
            }
            System.out.println();
        }
    }
    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int[][] flag = new int[grid.length][grid[0].length];
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                result[i][j] = grid[i][j];
            }
        }
        helper(grid,r0,c0,grid[r0][c0],flag,result,color);
        return result;

    }
    public static void helper(int[][] grid,int row,int col,int color,int[][] flag,int[][] result,int newcolor){
        int countb = 0,count = 0;
        if(row-1>=0){
            countb++;
            if(grid[row-1][col]==color){
                count++;
                if(flag[row-1][col] == 0){
                    flag[row-1][col] = 1;
                    helper(grid,row-1,col,color,flag,result,newcolor);

                }
            }
        }
        if(row+1<grid.length){
            countb++;
            if(grid[row+1][col]==color){
                count++;
                if(flag[row+1][col] == 0){
                    flag[row+1][col] = 1;
                    helper(grid,row+1,col,color,flag,result,newcolor);

                }
            }
        }
        if(col-1>=0){
            countb++;
            if(grid[row][col-1]==color){
                count++;
                if(flag[row][col-1] == 0){
                    flag[row][col-1] = 1;
                    helper(grid,row,col-1,color,flag,result,newcolor);

                }
            }
        }
        if(col+1<grid[0].length){
            countb++;
            if(grid[row][col+1]==color){
                count++;
                if(flag[row][col+1] == 0){
                    flag[row][col+1] = 1;
                    helper(grid,row,col+1,color,flag,result,newcolor);

                }
            }
        }
        if(countb!= count || countb!=4){
            result[row][col] = newcolor;
        }
    }
}
