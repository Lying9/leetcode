package pickone.medium;

/**
 * Created by ying on 2018/12/4.
 */
public class NestedInteger385 {

    /*
    * 思路  ： 很明显可以用递归
    *    如果s长度=0              则直接返回
    *        s的开头是一个数字(0-9 或者-（负号）)    则s是仅含一个数字的list，可直接返回
    *        s的开头是[   则说明s是一个列表  则需要对列表里的每一个元素调用一遍递归函数 里面的元素又分列表和数字
    * */

   /* public NestedInteger deserialize(String s) {
        NestedInteger nested = new NestedInteger();
        if(s.length() == 0)
            return nested;
        if(Character.isDigit(s.charAt(0)) ||s.charAt(0) == '-' ){
            nested.setInteger(Integer.parseInt(s));
            return nested;
        }else{
            for(int i=1; i< s.length();i++){
                if(s.charAt(i) == '['){
                    int num = 1;
                    int tempi =i+1;
                    while(tempi<s.length() && num!=0){
                        if(s.charAt(tempi)=='[')
                            num++;
                        else if(s.charAt(tempi)==']')
                            num--;
                        tempi++;
                    }
                    nested.add(deserialize(s.substring(i,tempi)));
                    i = tempi-1;
                }else if (Character.isDigit(s.charAt(i)) ||s.charAt(i) == '-'){
                    int tempi=i+1;
                    while(tempi<s.length() && Character.isDigit(s.charAt(tempi))){
                        tempi++;
                    }
                    nested.add(deserialize(s.substring(i,tempi)));
                    i = tempi-1;
                }

            }
        }
        return nested;
    }*/
}
