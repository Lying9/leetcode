package array.medium;

/**
 * Created by Administrator on 2017/10/28.
 */
public class NumberOfArithmeticSlices2 {
    public static void main(String[] args) {
       // int[] A={0,1,2,2,2}; //4
        //int[] A={2,4,6,8,10}; //7
        // int[] A ={0,2000000000,-294967296};//0
        // int[] A = {-2147483648,0,-2147483648};//0
        //int[] A = {1,1,1,1,1}; //16
       int A[] ={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int count=numberOfArithmeticSlices(A);
        //int count=computer(1,0,1,A);
        System.out.println(count);
    }

    public static int numberOfArithmeticSlices(int[] A){
        long third, sub;
        int count = 0,a,b;
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = 1; j < A.length - i - 1; j++) {
                sub = (long)A[i + j] -(long) A[i];
                third = sub + A[i + j];  //相邻两元素 差相等的第三个数
               count += computer(third,sub,i+j,A);

            }


        }
        return count;
    }

    public static int computer(long target,long sub,int begin,int[] A){
        int count = 0,a,b;
        a=contains(target,begin, A);
        if ( a!= -1) {
            count++;
            count += computer(target + sub, sub, a, A);
            b = a;
            while (true) {
                b = contains(target, b, A);
                if (b != -1) {
                    count++;
                    count += computer(target + sub, sub, b, A);
                } else
                    break;
            }
        }
            return  count;
    }


    public static int contains(long num,int begin,int[] nums){
        for(int i=begin+1;i<nums.length;i++){
            if(num==nums[i])
                return i; //you
        }
        return -1;
    }
}
