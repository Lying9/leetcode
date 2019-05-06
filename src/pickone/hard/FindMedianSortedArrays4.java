package pickone.hard;

/**
 * Created by ying on 2019/4/30.
 */
public class FindMedianSortedArrays4 {
    public static void main(String[] args) {
        int[] nums1 = {4};
        int[] nums2 = {1, 2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = null;
        if (nums1 == null || nums1.length == 0) {
            temp = nums2;
        } else if (nums2 == null || nums2.length == 0)
            temp = nums1;
        if (temp != null) {
            int index = temp.length / 2;
            if (temp.length % 2 == 0) {
                return (double) (temp[index] + temp[index - 1]) / 2;
            } else {
                return (double) temp[index];
            }
        }
        int[] da = null;
        int[] xiao = null;
        if (nums1.length > nums2.length) {
            da = nums1;
            xiao = nums2;
        } else {
            da = nums2;
            xiao = nums1;
        }
        int start = 0, end = xiao.length - 1;
        int mid = 0, j = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            j = (xiao.length + da.length + 1) / 2 - mid;
            if (mid >start &&xiao[mid - 1] > da[j]) {
                end = mid - 1;
            } else if(mid < end && da[j-1]>xiao[mid]) {
                start = mid + 1;
            }else
                break;
        }
        int maxLeft = 0;
        if(mid ==0)
            maxLeft = da[j-1];
        else if(j == 0)
            maxLeft = xiao[mid-1];
        else{
            maxLeft = Math.max(xiao[mid - 1], da[j - 1]);
        }
        if((xiao.length + da.length) % 2 == 1)
            return (double)maxLeft;

        int minRight = 0;
        if(mid == xiao.length)
            minRight = da[j];
        else if(j == da.length)
            minRight = xiao[mid];
        else
            minRight = Math.min(xiao[mid], da[j]);
        return (double)(maxLeft+minRight)/2;

    }

   /* public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] temp = null;
        if (nums1 == null || nums1.length == 0) {
            temp = nums2;
        } else if (nums2 == null || nums2.length == 0)
            temp = nums1;
        if (temp != null) {
            int index = temp.length / 2;
            if (temp.length % 2 == 0) {
                return (double) (temp[index] + temp[index - 1]) / 2;
            } else {
                return (double) temp[index];
            }
        }
        int s1 = 0, e1 = nums1.length - 1, s2 = 0, e2 = nums2.length - 1;
        boolean flag = false;
        int m1 = 0, m2 = 0;
        while (!flag) {
            m1 = (s1 + e1) / 2;
            m2 = (s2 + e2) / 2;
            boolean f = true;
            if (m2 - 1 >= 0) {
                if (nums2[m2 - 1] > nums1[m1]) {
                    f = false;
                }
            }
            if (m2 + 1 < nums2.length) {
                if (nums2[m2 + 1] < nums1[m1])
                    f = false;
            }
            if (m1 - 1 >= 0) {
                if (nums1[m1 - 1] > nums2[m2])
                    f = false;
            }
            if (m1 + 1 < nums1.length) {
                if (nums1[m1 + 1] < nums2[m2])
                    f = false;
            }
            if (f)
                flag = true;
            else {
                if (nums1[m1] < nums2[m2]) {
                    s1 = m1 + 1;
                    e2 = m2 - 1;
                } else {
                    e1 = m1 - 1;
                    s2 = m2 + 1;
                }
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            int t = (nums1.length + nums2.length) / 2;
            while (m1 + m2 < t - 1) {
                if (m1 + 1 >= nums1.length) {
                    while (nums1.length + m2 < t - 1)
                        m2++;
                    return (double) (nums2[m2] + nums2[m2 + 1]) / 2;
                } else if (m2 + 1 >= nums2.length) {
                    while (nums2.length + m1 < t - 1)
                        m1++;
                    return (double) (nums1[m1] + nums1[m1 + 1]) / 2;
                } else if (nums1[m1] < nums2[m2])
                    m1++;
                else
                    m2++;
            }
            if (m1 + 1 < nums1.length && nums1[m1 + 1] < nums2[m2]) {
                return (double) (nums1[m1] + nums1[m1 + 1]) / 2;
            }
            if (m2 + 1 < nums2.length && nums2[m2 + 1] < nums2[m2])
                return (double) (nums2[m2] + nums2[m2 + 1]) / 2;
            return (double) (nums1[m1] + nums2[m2]) / 2;
        } else {
            int t = (nums1.length + nums2.length) / 2;
            if (m1 + m2 == t) {
                return (double) Math.min(nums1[m1], nums2[m2]);
            } else {
                return (double) Math.max(nums1[m1], nums2[m2]);
            }
        }

    }*/
}
