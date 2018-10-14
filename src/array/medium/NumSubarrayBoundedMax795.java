package array.medium;

/**
 * Created by ying on 2018/4/13.
 */
public class NumSubarrayBoundedMax795 {

    public static void main(String[] args) {
       /* int[] A = {2,1,4,3};
        System.out.println(numSubarrayBoundedMax(A,2,3));//3*/
        /*int[] A = {7,3,6,7,1};
        System.out.println(numSubarrayBoundedMax(A,1,4));//2*/
      int[] A =  {73,55,36,5,55,14,9,7,72,52};
        System.out.println(numSubarrayBoundedMax(A,32,69));//22
    }
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int lasti = -1;
        int fristi = 0;
        int result =0;
        for (int i = 0; i <A.length ; i++) {
            if(A[i] > R){
                lasti = -1;
                fristi = i+1;
            }else{
                if(A[i] >= L){
                    lasti = i;
                }
                if(lasti >= 0){
                    result+=lasti-fristi+1;
                }
            }
        }
        return result;
    }

}

   /* public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        //pre连续的<=R的个数    ppre   -1前面数是大于R的   mincount 连续的<L的个数
        int pre = 0,result = 0,ppre =-1,mincount =0;
        for (int i = 0; i < A.length ; i++) {
            pre++;
            if(A[i]>= L && A[i] <= R) {
                ppre = i;
                result = result + pre;
            }
           else  if(A[i]>R) {
                pre = 0;
                ppre=-1;
            }
            else{
                if(ppre!=-1){
                    if(i >0 &&A[i-1] < L){
                        mincount ++;
                    }else
                        mincount=0;
                    result += pre-1-mincount;
                }
            }
        }
        return result;
    }
}*/
