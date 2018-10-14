package array.hard;

import java.util.*;

/**
 * Created by ying on 2018/9/14.
 */
public class MaxNumber321 {
    public static void main(String[] args) {
        int[] nums1 = {6,7};
//        maxArray(nums1,2);
        int[] nums2 = {6,0,4};
        int k = 5;
        int[] result = maxNumber(nums1, nums2, k);
        for (int i : result) {
            System.out.print(i + "\t");
        }
//        System.out.println(max(0,0,2,nums1,nums2));
    }


    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m= nums1.length, n=nums2.length;
        int[] res= new int[k];
        for (int len1=Math.max(0, k-n); len1<=Math.min(m, k); len1++){
            int len2= k-len1; // 0<=len2=k-len1<=n -> k-n<=len1<=n
            int[] candidate= merge(maxArray(nums1, len1), maxArray(nums2, len2));
            if (greater(candidate, 0, res, 0)) res=candidate;
        }
        return res;
    }
//    返回数组num中的 相对位置不变的len个大的数
    public static int[] maxArray(int[] nums,int len){
        int[] res= new int[len];
        for (int i=0, idx=0; i<nums.length && idx<len; i++){
            while(idx!=-1 && nums[i]>res[idx] && nums.length-i>=len-idx)
                idx--;
            if (idx+1<len) res[++idx]=nums[i];
        }
        return res;
    }
//    按顺序（由大到小）合并A b 这两个数组
    public static int[] merge(int[] a,int[] b){
        int[] res= new int[a.length+b.length];
        for (int idx=0, i=0, j=0; idx<res.length; idx++){
            if (greater(a, i, b, j)) res[idx]=a[i++];
            else res[idx]=b[j++];
        }
        return res;
    }
    public static boolean greater(int[] a, int i, int[] b, int j){
        for (; i<a.length && j<b.length; i++, j++){
            if (a[i]==b[j]) continue;
            return a[i]>b[j];
        }
        return i!=a.length;
    }
//    比较大小
    public static boolean compare(int[] a,int[] b){
        int i,j;
        for (i = 0,j = 0; i <a.length && j<b.length ; i++,j++) {
            if(a[i] == b[j]) continue;
            return a[i] > b[j];
        }
        return i!=a.length;
    }

    public static int[] maxNumber1(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];

        if(k==nums1.length+nums2.length){
            int i = 0,j=0,m = 0;
            while(i<nums1.length && j< nums2.length){
                if(nums1[i] < nums2[j]){
                    result[m++] = nums2[j++];
                }
                else
                    result[m++] = nums1[i++];
            }
            if(i < nums1.length){
                for (int l = i; l < nums1.length; l++) {
                    result[m++] = nums1[l];
                }
            }else {
                for (int l = j; l < nums2.length; l++) {
                    result[m++] = nums2[l];
                }
            }
            return  result;
        }


        int start1 = 0, start2 = 0;
        for (int i = 0; i < k; i++) {
            int level = 1;
            int remain;
            List<Integer> maxarray = max(start1, start2, level, nums1, nums2);
            if (maxarray.get(0) == 1) {
                remain = nums1.length - maxarray.get(1) + nums2.length - start2;
            } else
                remain = nums1.length - start1 + nums2.length - maxarray.get(1);
            List<Integer> maxarray1 = new ArrayList<>();
            while (remain < k - i) {
                level++;
                maxarray1 = max(start1, start2, level, nums1, nums2);
                if (maxarray1.get(0) == 1) {
                    remain = nums1.length - maxarray1.get(1) + nums2.length - start2;
                } else
                    remain = nums1.length - start1 + nums2.length - maxarray1.get(1);

            }
            if (level == 1) {
                result[i] = maxarray.get(2);
                if (maxarray.get(0) == 1) {
                    start1 = maxarray.get(1) + 1;
                } else
                    start2 = maxarray.get(1) + 1;
            } else {
                result[i] = maxarray1.get(2);
                if (maxarray1.get(0)== 1) {
                    start1 = maxarray1.get(1)+ 1;
                } else
                    start2 = maxarray1.get(1) + 1;
            }

        }
        return result;
    }

//元素大小相同的情况下  应该返回哪个？？
    public static List  max(int start1, int start2, int level, int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = start1; i < nums1.length; i++) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(i);
            list1.add(nums1[i]);
            list.add(list1);
        }
        for (int i = start2; i < nums2.length; i++) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(2);
            list1.add(i);
            list1.add(nums2[i]);
            list.add(list1);
        }
        Collections.sort(list, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                if (list1.get(2) < list2.get(2))
                    return -1;
                else if (list1.get(2) > list2.get(2))
                    return 1;
                else{
                    return 0;
                 /*   if (list1.get(1) < list2.get(1))
                        return -1;
                    else if (list1.get(1) > list2.get(1))
                        return 1;
                    else return 0;*/
                }

            }
        });
//        System.out.println(start1 + "\t" + start2 + "\t" + level);
        return list.get(list.size() - level);
    }
}
