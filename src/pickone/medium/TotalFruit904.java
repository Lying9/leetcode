package pickone.medium;

/**
 * Created by ying on 2018/10/20.
 */
public class TotalFruit904 {
    public static void main(String[] args) {
//        int[] tree = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
//        int[] tree ={1,2,1};
        int[] tree = {1, 0, 1, 4, 1, 4, 1, 2, 3};
        System.out.println(totalFruit(tree));
    }

    public static int totalFruit(int[] tree) {
        if (tree.length == 0)
            return 0;
        int type1 = tree[0], type2 = type1, temp;//type1    type2表示tree【i-1】的值
        int count_type2 = 0, max = 0, count = 0;      //count_type2 记录i之前的连续的值为tree[i-1]的个数
        for (int i = 0; i < tree.length; i++) {
            temp = tree[i];
            if (temp == type2) {
                count++;
                count_type2++;
            } else if (temp == type1) {
                count++;
                count_type2 = 1;
                type1 = type2;
                type2 = temp;
            } else {
                max = Math.max(max, count);
                count = count_type2 + 1;
                count_type2 = 1;
                type1 = type2;
                type2 = temp;
            }
        }
        max = Math.max(max, count);
        return max;
    }


    /*
    * accept
    * 思想：用两个变量type1和type2来记录当前篮子里的水果种类
    *      当出现第三种水果时，开始遍历的果树应该是与第三种水果之间没有其他类型水果的开始
    * */
    public static int totalFruit2(int[] tree) {
        if (tree.length == 0)
            return 0;
        int begin = 0, end = 1, type1 = tree[0], max = 0, type2 = -1;
        while (end < tree.length) {
            if (tree[end] != type1 && type2 == -1) {
                type2 = tree[end];
                end++;
            } else if (tree[end] == type1 || tree[end] == type2) {
                end++;
            } else {
                max = Math.max(max, end - begin);
                int temp = end - 1;
                while (temp > 0 && tree[temp] == tree[end - 1]) {
                    temp--;
                }
                begin = temp + 1;
                type1 = tree[begin];
                type2 = tree[end];
            }
        }
        max = Math.max(max, end - begin);
        return max;
    }

    //time limit exceed
    /*
        分别计算从0 到tree.length开始的段能装的数量    取最大
    * */
    public static int totalFruit1(int[] tree) {
        int max = 0;
        for (int i = 0; i < tree.length; i++) {
            int j = i + 1, count = 1;
            while (j < tree.length && tree[j] == tree[i]) {
                count++;
                j++;
            }
            if (j < tree.length) {
                int num = tree[j];
                count++;
                for (j = j + 1; j < tree.length; j++) {
                    if (tree[j] == num || tree[j] == tree[i])
                        count++;
                    else
                        break;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
