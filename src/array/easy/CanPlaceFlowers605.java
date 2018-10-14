package array.easy;

/**
 * Created by Administrator on 2017/11/28.
 */
public class CanPlaceFlowers605 {

    public static void main(String[] args) {
        int[] flowerbed = {0,0};
        System.out.println(canPlaceFlowers(flowerbed,1));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0 || flowerbed == null)
            return false;
        int i = 0, prev = -1, count = 0;
        while (i < flowerbed.length) {
            while (i < flowerbed.length && flowerbed[i] == 0 ) {
                i++;
            }
            if (prev == -1 && i >= flowerbed.length) {
                if((i - prev - 1)%2 == 1)
                    count += (i - prev - 1) / 2 +1;
                else
                    count += (i - prev - 1) / 2;
            }else if(prev == -1 || i >= flowerbed.length) {
                count += (i - prev - 1) / 2;
            } else {
                if ((i - prev - 1) % 2 == 0)
                    count += (i - prev - 1) / 2 - 1;
                else
                    count += (i - prev - 1) / 2;
            }
            prev = i++;
        }
        System.out.println(count);
        if(count >= n)
            return true;
        else
            return false;
    }
}
/*
*   if (flowerbed.length == 1) {
			if (flowerbed[0] == 0)     return 1 >= n;
			return 0 >= n;
		}
		int count = 0;
		for (int i = 0; i < flowerbed.length - 1; i++) {
			if (flowerbed[i] == 0) {
				if (flowerbed[i + 1] == 0) {
					flowerbed[i]++;
					count++;
					if (count >= n)
						return true;
					i++;
					continue;
				}
				else  i += 2;
			}
			else if (flowerbed[i] == 1)
				i++;
		}
		if (flowerbed[flowerbed.length - 2] == 0
				&& flowerbed[flowerbed.length - 1] == 0)
			count++;
		if (count >= n)
			return true;

		return false;

* */