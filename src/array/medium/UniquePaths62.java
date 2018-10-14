package array.medium;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Administrator on 2018/3/13.
 */
public class UniquePaths62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(23,12));
    }

    /*//用栈来保存每一步的坐标  超时
    public static  int uniquePaths(int m, int n) {
        if(m==1 && n==1)
            return 1;
        Stack<List<Integer>>  stack = new Stack<>();
        int path = 0;
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        stack.push(list);
        while (!stack.empty()){
            List l = stack.pop();
            //往下
            if((Integer)l.get(0)+1 == m && (Integer)l.get(1) == n){
                path ++;
                continue;
            } if((Integer)l.get(1)+1 == n  && (Integer)l.get(0) == m) {  //往右
                path++;
                continue;
            }
            if((Integer)l.get(0)+1 <= m ){
                List list1 = new ArrayList();
                list1.add((Integer) l.get(0)+1);
                list1.add((Integer)l.get(1));
                stack.push(list1);
            }
            if((Integer)l.get(1)+1 <= n){
                List list1 = new ArrayList();
                list1.add((Integer) l.get(0));
                list1.add((Integer)l.get(1)+1);
                stack.push(list1);
            }
        }
        return path;
    }*/
    //递归  超时
   /* public static  int uniquePaths(int m, int n) {
        if(m==1 && n==1)
            return 1;
        return path(1,1,m,n);
    }
    public static int path(int row,int col,int m, int n){
        if(row+1 == m && col == n)
            return 1;
        if(row == m && col+1==n)
            return 1;
        if(row+1 <= m && col+1 <= n)
            return path(row+1,col,m,n)+path(row,col+1,m,n);
        if(row+1 <= m && col == n)
            return path(row+1,col,m,n);
        if(row == m && col <= n)
            return path(row,col+1,m,n);
        return 0;
    }*/

   //DP 算法解决
   public static  int uniquePaths(int m, int n) {
       int[][] map = new int[m][n];
       for (int i = 0; i < m ; i++) {
           map[i][0] = 1;
       }
       for (int i = 0; i < n ; i++) {
           map[0][i] = 1;
       }
       for (int i = 1; i < m ; i++) {
           for (int j = 1; j < n; j++) {
               map[i][j] = map[i-1][j] + map[i][j-1];
           }
       }
       return map[m-1][n-1];
   }
}
