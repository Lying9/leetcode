package pickone.medium;

import java.util.ArrayList;

/**
 * Created by ying on 2018/11/15.
 */
public class FindPaths576 {
    //上，下，左，右
    private static int[][] position = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int path;

    public static void main(String[] args) {
        System.out.println(findPaths(1, 3, 3, 0, 1));
    }

    //time limit exceeded
    public static int findPaths(int m, int n, int N, int i, int j) {
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
