package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/28.
 */
public class Merge88 {

    public static void main(String[] args) {
        int[] nums1 = {1,5,6,8,9,15,28,36,45,0,0,0,0,0,0,0,0,0,0,0};
        int[] nums2 = {2,5,6,9,14,16,29,35};
        merge(nums1,9,nums2,nums2.length);
    }
/*
*    思路 ：   从每个数组的最后一个有效元素开始遍历，则每次选出来的元素应放到nums1的i+j+1下标处
* */
    public static  void merge(int[] nums1, int m, int[] nums2, int n) {
       int i = m-1, j = n-1;
       while(i >=0 && j >= 0){
           if(nums1[i] < nums2[j] ){
               nums1[i+j+1] = nums2[j--];
           }else
               nums1[i+j+1] = nums1[i--];
       }
       if(i <= 0)
           while(j >= 0)
              nums1[i+j+1] = nums2[j--];
        System.out.println(Arrays.toString(nums1));
    }
    /*
    * 思路：  占用额外的存储空间，定义一个数组来存储排好序之后的元素，在把这个数组值赋值给nums1
    * */
    /*public static  void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[nums1.length];
        int i,j,k,h;
        for (i = 0,j = 0,k=0; i < m && j <n;k++ ) {
            if(nums1[i]<nums2[j])
                nums[k] = nums1[i++];
            else if(nums1[i] == nums2[j]){
                nums[k++] = nums1[i++];
                nums[k] = nums2[j++];
            }else
                nums[k] = nums2[j++];
        }
        if(j >= n){
            while(i <m)
                 nums[k++] = nums1[i++];
        }else if(i >= m){
            while( j < n)
                nums[k++] = nums2[j++];
        }
        for ( h = 0; h < m+n; h++) {
            nums1[h] = nums[h];
        }
        System.out.println(Arrays.toString(nums1));
    }*/
}
