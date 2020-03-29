package pickone.medium;

/**
 * Created by ying on 2019/7/14.
 */
public class NumTrees96 {
    public static void main(String[] args) {
        System.out.println(numTrees(10));
    }

    public static int numTrees(int n) {
        if (n == 1)
            return 1;
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            int c = 0;
            for (int j = 1; j <=i ; j++) {
                c += count[j-1] * count[i-j];
            }
            count[i] = c;
        }
        /*for (int i = 0; i <n+1 ; i++) {
            System.out.print(count[i]+"\t");
        }
        System.out.println();*/
        return count[n];
    }
}
