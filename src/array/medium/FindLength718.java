package array.medium;

/**
 * Created by ying on 2018/4/4.
 */
public class FindLength718 {

    public static void main(String[] args) {
       /* int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};*/
        int[] A = {0,0,0,0,0,0,1,0,0,0};
        int[] B = {0,0,0,0,0,0,0,1,0,0};
        System.out.println(findLength(A,B));
    }

    public static  int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        int max = 0;
        for (int i = A.length-1; i >=0 ; i--) {
            for (int j = B.length-1; j >= 0 ; j--) {
                if(A[i] == B[j]){
                    dp[i][j] = dp[i+1][j+1] + 1;
                    max = Math.max(dp[i][j],max);
                }
            }

        }
        return max;
    }
    //Time LIMIt exceed  一个一个找
    /*public static  int findLength(int[] A, int[] B) {
        int max = 0,temp,begin,length,temp1;
        for (int i = 0; i < A.length ; i++) {
            begin =0;
            temp = search(B, A[i], begin);
            while(temp!=-1) {
                temp1 = temp;
                length=1;
                int j = i;
                while(j+1<A.length && temp+1<B.length && A[++j] == B[++temp] ){
                    length++;
                }
                if(length > max)
                    max = length;
                temp = search(B, A[i], temp1+1);
            }
        }
        return max;
    }
    public static int search(int[] B,int target,int begin){
        for (int i = begin; i < B.length ; i++) {
            if(B[i] == target)
                return i;
        }
        return -1;
    }*/
}
