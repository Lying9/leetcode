package pickone.medium;

import java.util.ArrayList;

/**
 * Created by ying on 2019/3/27.
 */
public class IntervalIntersection986 {

    public Interval[] intervalIntersection1(Interval[] A, Interval[] B) {
        int indexA = 0, indexB = 0;
        ArrayList<Interval> result = new ArrayList<>();
        while (indexA < A.length && indexB < B.length) {
            int s = Math.max(A[indexA].start, B[indexB].start);
            int e = Math.min(A[indexA].end, B[indexB].end);
            if (s <= e) {
                result.add(new Interval(s, e));
            }
            if (A[indexA].end > B[indexB].end) {
                indexB++;
            } else if (A[indexA].end < B[indexB].end) {
                indexA++;
            } else {
                indexA++;
                indexB++;
            }
        }


        Interval[] r = new Interval[result.size()];
        result.toArray(r);
        return r;
    }


    /*
    *  思路：两个区间一共有如下几种情况
    *          [   ]
    *  (1) []
    *  (2)   [ ]         头和尾相等
    *  (3)         [ ]   头和尾相等
    *  (4)            []
    *  (5)  [    ]        相交
    *  (6)       [           ] 相交
    *  (7)       []         相交
    * */
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int indexA = 0, indexB = 0;
        ArrayList<Interval> result = new ArrayList<>();
        while (indexA < A.length && indexB < B.length) {
            if (B[indexB].start > A[indexA].end) {
                indexA++;
            } else if (B[indexB].start == A[indexA].end) {
                result.add(new Interval(B[indexB].start, B[indexB].start));
                indexA++;
            } else {
                if (B[indexB].end < A[indexA].start) {
                    indexB++;
                } else if (B[indexB].end == A[indexA].start) {
                    result.add(new Interval(A[indexA].start, B[indexB].end));
                    indexB++;
                } else {
                    result.add(new Interval(Math.max(A[indexA].start, B[indexB].start), Math.min(A[indexA].end, B[indexB].end)));
                    if (A[indexA].end > B[indexB].end) {
                        indexB++;
                    } else if (A[indexA].end < B[indexB].end) {
                        indexA++;
                    } else {
                        indexA++;
                        indexB++;
                    }
                }

            }
        }
        Interval[] r = new Interval[result.size()];
        result.toArray(r);
        return r;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
