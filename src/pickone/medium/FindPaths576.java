package pickone.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ying on 2018/11/15.
 */
public class FindPaths576 {
    //上，下，左，右
    private static int[][] position = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int path;
    static int  M=1000000007;

    public static void main(String[] args) {
        System.out.println(findPaths(1, 3, 3, 0, 1));
    }

//    备忘录的思想  但是不知道为什么对M取余
    public static int findPaths(int m, int n, int N, int i, int j) {
        int[][][] memo=new int[m][n][N+1];
        for(int[][] l:memo)
            for(int[] sl:l)
                Arrays.fill(sl,-1);
        return findPaths(m,n,N,i,j,memo);
    }

    public static int findPaths(int m, int n, int N, int i, int j, int[][][] memo) {
        if(i==m || j==n || i<0 ||j<0)
            return 1;
        if(N==0)
            return 0;
        if(memo[i][j][N]>=0)
            return memo[i][j][N];
        memo[i][j][N]=((findPaths(m,n,N-1,i-1,j,memo)+findPaths(m,n,N-1,i+1,j,memo))%M+(findPaths(m,n,N-1,i,j-1,memo)+findPaths(m,n,N-1,i,j+1,memo))%M)%M;
        return memo[i][j][N];
    }


    //   time limit exceeded  递归
    public static int findPaths2(int m, int n, int N, int i, int j) {
        int path1 = 0;
        if (N <= 0)
            return 0;
        for (int k = 0; k < 4; k++) {
            if (i + position[k][0] < 0 || i + position[k][0] >= m || j + position[k][1] >= n || j + position[k][1] < 0) {
                path1++;
            } else
                path1 += findPaths(m, n, N - 1, i + position[k][0], j + position[k][1]);
        }
        return path1;
    }


    //time limit exceeded   dfs的思想
    public static int findPaths1(int m, int n, int N, int i, int j) {
        ArrayList<Integer> list = new ArrayList<>();
        find(m, n, N, i, j, list);
        return path;
    }

    public static void find(int m, int n, int N, int i, int j, ArrayList<Integer> list) {
        if (list.size() < N)
            list.add(0);
        else return;
        int k = list.get(list.size() - 1);
        while (k < 4) {
            if (i + position[k][0] < 0 || i + position[k][0] >= m || j + position[k][1] >= n || j + position[k][1] < 0) {
                path++;
            } else {
                find(m, n, N, i + position[k][0], j + position[k][1], list);
            }
            list.set(list.size() - 1, k + 1);
            k++;
        }
        list.remove(list.size() - 1);
    }


}
