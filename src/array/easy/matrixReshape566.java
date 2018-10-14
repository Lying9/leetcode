package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/3.
 */
public class matrixReshape566 {
    public static void main(String[] args) {
        int[][]  nums = {{1,2,5,6},{3,4,7,8}};
        int r=4,c=2;
        int[][] result = new int[r][c];
         result = matrixReshape(nums,r,c);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if( i!=0)
                System.out.print(" ");
            System.out.print(Arrays.toString(result[i]));
            if(i != result.length-1)
                System.out.println(",");
        }
        System.out.print("]");
    }

    private static int[][] matrixReshape(int[][] nums, int r, int c) {
        int count = nums.length * nums[0].length;
        int row = 0,cloumn = 0;
        int[][] result = new int[r][c];
        if(count == r*c) {
            for (int i = 0; i < nums.length ; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    result[row][cloumn++] = nums[i][j];
                    if(cloumn%c == 0) {
                        cloumn = 0;
                        row++;
                    }
                }

            }
        }
        else{
            return nums;
        }
        return  result;
    }

   /* private static void matrixReshape(int[][] nums,int r,int c) {
        int count = nums.length * nums[0].length;
        int number = 0;
        if(count == r*c){
            System.out.print("[[");
            for (int i = 0; i < nums.length ; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    number++;
                    System.out.print(nums[i][j]);
                    if(number%c !=0)
                        System.out.print(",");
                    else {
                        if(number!=count) {
                            System.out.println("]");
                            System.out.print(" [");
                        }
                        else
                            System.out.print("]");
                    }
                }
            }
            System.out.print("]");
        }
        else {
            System.out.print("[");
            for (int i = 0; i < nums.length; i++) {
                if( i!=0)
                    System.out.print(" ");
                System.out.print(Arrays.toString(nums[i]));
                if(i != nums.length-1)
                    System.out.println(",");
            }
            System.out.print("]");
        }

    }*/

}
