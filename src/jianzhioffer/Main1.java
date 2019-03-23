package jianzhioffer;



/**
 * Created by ying on 2019/3/16.
 */


import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int limit = sc.nextInt();
        String[] s = str.split(" ");
        int[] people = new int[s.length];
        for (int i = 0; i <s.length ; i++) {
            people[i] = Integer.valueOf(s[i]);
        }
        Arrays.sort(people);
        int low = 0,high = people.length-1;
        int result = 0;
        while(low < high){
            if(people[low] + people[high] <= limit){
                result++;
                low ++;
                high--;
            }else{
                result++;
                high--;
            }
        }
        if(low == high)
            result++;
        System.out.println(result);



      /*  int index = str.indexOf("0");
        while(index !=-1){
            str = str.substring(0,index-1) + str.substring(index+1,str.length());
            index = str.indexOf("0");
        }

        System.out.println(f(str));*/
    }



    public static int f(String str){
        if(str.length() <=1)
            return 1;
        else{
            int num = Integer.valueOf(str.substring(0,2));
            if(num > 26){
                return f(str.substring(1,str.length()));
            }else{
                return f(str.substring(1,str.length()))+f(str.substring(2,str.length()));
            }
        }
    }



    public static int count(int num){
        if(num <=0)
            return 0;
        else if(num == 1)
            return 2;
        return 1+num +(num -1)*num/2;
    }

}
