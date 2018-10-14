package array.medium;

import java.util.*;

/**
 * Created by Administrator on 2017/10/27.
 */
public class NumberOfArithmeticSlices {
    public static void main(String[] args) {
        //int[] A={0,1,2,2,2}; //4
        int[] A={2,4,6,8,10}; //7
        // int[] A ={0,2000000000,-294967296};//0
        // int[] A = {-2147483648,0,-2147483648};//0
       // int[] A = {1, 1, 1, 1, 1}; //16
       // int A[] ={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int count = numberOfArithmeticSlices(A);
        System.out.println(count);
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length];

        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int) diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }

        }

        return res;
    }
}
        /*int[] A={2, 2,3,4};
        int third,sub,count=0;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <A.length-2 ; i++) {
            for (int j = 1; j <A.length-i-1 ; j++) {
                sub=A[i+j]-A[i];
                third = 2*A[i+j]-A[i];  //相邻两元素 差相等的第三个数
                if(contains(third,A)==1){
                    count++;
                    result.add(new int[]{A[i],A[i+j],third});
                    int a=4;
                    while(contains(third+sub,A)==1){
                        count++;
                        int[] temp=new int[a];
                        temp[0]=A[i];
                        for (int k = 1; k <a ; k++) {
                            temp[k]=temp[k-1]+sub;
                        }
                        result.add(temp);
                        third +=sub;
                        a++;
                    }
                }
            }


        }
        System.out.println(count);
        Iterator it = result.iterator();
        while(it.hasNext()){
            int[] a = (int[]) it.next();
            for (int i = 0;i<a.length; i++) {
                System.out.print(a[i] + "    ");

            }
            System.out.println();
        }
*/
        /*public static int numberOfArithmeticSlices(int[] A){
           long third, sub;
            int count = 0,a,b;
            for (int i = 0; i < A.length - 2; i++) {
                for (int j = 1; j < A.length - i - 1; j++) {
                    sub = (long)A[i + j] -(long) A[i];
                    third = sub + A[i + j];  //相邻两元素 差相等的第三个数
                    a=contains(third,i+j, A);
                    if ( a!= -1) {
                        count++;
                        b=a;
                        while(true){
                            b=contains(third,b, A);
                            if(b!=-1){
                                count++;
                            }
                            else
                                break;
                        }
                        while (true) {
                           a = contains(third+sub,a, A);
                           if(a!=-1) {
                               count++;
                               b=a;
                               while(true){
                                   b=contains(third,b, A);
                                   if(b!=-1){
                                       count++;
                                   }
                                   else
                                       break;
                               }
                               third= third+sub;
                           }
                           else break;
                        }
                    }
                }


            }
            return count;
        }


    public static int contains(long num,int begin,int[] nums){
        for(int i=begin+1;i<nums.length;i++){
            if(num==nums[i])
                return i; //you
        }
        return -1;
    }
}
*/
/*class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int third,sub,count=0;
        for (int i = 0; i <A.length-2 ; i++) {
            for (int j = 1; j <A.length-i-1 ; j++) {
                sub=A[i+j]-A[i];
                third = 2*A[i+j]-A[i];  //相邻两元素 差相等的第三个数
                if(contains(third,A)==1){
                    count++;
                    while(contains(third+sub,A)==1){
                        count++;
                        third +=sub;
                    }
                }
            }


        }
        return count;

    }
    public int contains(int num,int[] nums){
        for(int i=0;i<nums.length;i++){
            if(num==nums[i])
                return 1; //you
        }
        return 0;
    }
}*/
