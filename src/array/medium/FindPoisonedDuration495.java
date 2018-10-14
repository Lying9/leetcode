package array.medium;

/**
 * Created by Administrator on 2017/12/6.
 */
public class FindPoisonedDuration495 {
    public static void main(String[] args) {
        int[] timeSeries = {1,3};
        System.out.println(findPoisonedDuration(timeSeries,2));
    }
    public  static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0 || timeSeries == null)
            return 0;
        int time = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if(timeSeries[i] - timeSeries[i-1] < duration)
                time += timeSeries[i] - timeSeries[i-1];
            else
                time += duration;
        }
        return time + duration;
    }
}
