package pickone.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ying on 2018/9/16.   341
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack();
    private LinkedList<Integer> listInt =  new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size()-1;i>=0;i--)
            stack.push(nestedList.get(i));
        while(!stack.isEmpty()){
            if(stack.peek().isInteger())
                listInt.add(stack.pop().getInteger());
            else{
                List<NestedInteger> list = stack.pop().getList();
                for(int i = list.size()-1;i>=0;i--)
                    stack.push(list.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        return listInt.poll();
    }

    @Override
    public boolean hasNext() {
        if(listInt.size()>0)
            return true;
        return false;
    }

}

 interface NestedInteger {
              public boolean isInteger();
             public Integer getInteger();
            public List<NestedInteger> getList();

  }
