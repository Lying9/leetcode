package pickone.hard;

import java.util.HashMap;

/**
 * Created by ying on 2019/3/25.
 */
public class IsSelfCrossing335 {



    /*
    * 不会相交只有三种情况
    * （1）一直外旋
    * （2）一直内旋
    * （3）先外旋在内旋
    * 注：一旦内旋将不能再外旋
    * flag表示是否是内旋  true  内旋
    * */

    public boolean isSelfCrossing(int[] x) {
        if(x.length < 4)
            return false;
        boolean flag = false;
        for(int i=3;i<x.length;i++){
            if(flag){
                if(x[i] >= x[i-2])
                    return true;
            }else{
                if(x[i-1] > x[i-3])
                    continue;
                int x4 = i>=4 ? x[i-4]:0;
                int x5 = i>=5 ? x[i-5]:0;
                if(x[i-1] >= x[i-3] - x5){
                    if(x[i-2] <= x4+x[i])
                        return true;
                }else{
                    if(x[i-2] <= x[i])
                        return true;
                }
                flag = true;
            }
        }
        return false;
    }
}
