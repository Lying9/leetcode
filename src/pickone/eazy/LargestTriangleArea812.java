package pickone.eazy;

/**
 * Created by ying on 2018/8/28.
 */
public class LargestTriangleArea812 {
    public static void main(String[] args) {
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(points));
    }
    public static double largestTriangleArea(int[][] points) {
//    1、逐个遍历   accept
//        不是三角形的面积为0
        double max = 0.0,area = 0.0;
        for (int i = 0; i < points.length ; i++) {
            for (int j = i; j < points.length ; j++) {
                for (int k = j; k < points.length ; k++) {
                   area = 0.5*Math.abs((points[j][0]-points[i][0])*(points[k][1]-points[i][1])-(points[k][0]-points[i][0])*(points[j][1]-points[i][1]));
                   max = Math.max(max,area);
                }
            }
        }
        return max;

    }
}
//也是遍历了所有的情况  只不过用了深度遍历的思想
class Solution {
    private double maxArea = 0d;
    public double largestTriangleArea(int[][] points) {
        if(points.length==3){
            return computeTriangleArea(points[0],points[1],points[2]);
        }else{
            int[][] data = new int[3][2];
            combinationUtil(points,data,0,points.length-1,0,3);
            return maxArea;
        }

    }
    /**
     * @param arr   ---> Input Array
     * @param data  ---> Temporary array to store current combination
     * @param start ---> Staring indexes in arr[]
     * @param end   ---> Ending indexes in arr[]
     * @param index ---> Current index in data[]
     * @param r     ---> Size of a combination
     */
    public void combinationUtil(int arr[][], int data[][], int start,
                                int end, int index, int r){
        // Current combination is ready to be printed, print it
        if (index == r){
            double area = computeTriangleArea(data[0],data[1],data[2]);
            if(area>maxArea){
                maxArea = area;
            }
            return ;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++){
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }
    private double computeTriangleArea(int[] pointA, int[] pointB, int[] pointC){
        double result = (double)(pointA[0]*(pointB[1]-pointC[1])+pointB[0]*(pointC[1]-pointA[1])+pointC[0]*(pointA[1]-pointB[1]))/2;
        return Math.abs(result);
    }
}

