package jianzhioffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by ying on 2019/3/4.
 */
public class StackTest {
    public static void main(String[] args) {

        //System.out.println("hello https://tool.lu/");
       /* Solution s = new Solution();
        s.push(3);
        System.out.println(s.min());*/
      /* int[] pushA = {1,2,3,4,5};
       int[] popA = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA,popA));*/
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list2.add(1);
        list2.add(2);
        list3.add(1);
        list3.add(2);
        list3.add(3);
        result.add(list2);
        result.add(list1);
        result.add(list3);
        result.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size() > o2.size())
                    return -1;
                else if(o1.size() < o2.size())
                    return 1;
                else
                    return 0;
            }
        });
        for(ArrayList<Integer> a : result){
            for(Integer i : a){
                System.out.print(i + "   ");
            }
            System.out.println();
        }


    }
    public static  boolean IsPopOrder(int [] pushA,int [] popA) {
        //List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i = 0;i<popA.length;i++){
            if(stack.empty() || stack.peek()!= popA[i]){
                while(index < pushA.length){
                    stack.push(pushA[index++]);
                    if(pushA[index-1] == popA[i])
                        break;
                }
            }
            if (stack.peek() == popA[i]) {
                stack.pop();
            }
            else
                return false;




        }
        return true;
    }
}

class Solution {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stacktemp = new Stack<>();
    public void push(int node) {

        if(stack.empty()){
            stacktemp.push(node);
        }else if(node < stack.peek())
            stacktemp.push(node);
        else
            stacktemp.push(stacktemp.peek());
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        stacktemp.pop();
    }

   /* public int top() {

    }*/

    public int min() {
        return stacktemp.peek();
    }
}