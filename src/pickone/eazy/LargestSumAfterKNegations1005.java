package pickone.eazy;

import java.util.Arrays;

/**
 * Created by ying on 2019/4/18.
 */
public class LargestSumAfterKNegations1005 {
    public static void main(String[] args) {
        int[] a = {-8,3,-5,-3,-5,-2};
        System.out.println(largestSumAfterKNegations(a,6));

    }
    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int index = 0;
        for(int i = 0;i<K;i++){
            int temp = A[index];
            A[index] = -A[index];
            if(temp<0 && index+1<A.length){
                if(A[index+1]>0){
                    if(A[index] > A[index+1]){
                        index++;
                    }
                }else
                    index++;
            }else{
                if((K-i-1)%2!=0)
                    A[index] = -A[index];
                break;
            }

        }
        int sum = 0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        return sum;
    }
}
