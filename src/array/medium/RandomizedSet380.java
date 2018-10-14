package array.medium;

import java.util.*;

/**
 * Created by ying on 2018/4/18.
 */
public class RandomizedSet380 {
    Map<Integer,Integer> map = new HashMap();
    List<Integer> list = new ArrayList<>();
    public RandomizedSet380() {

    }
    public void print(){
        System.out.println(map.toString());
        System.out.println(list.toString());
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val,map.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int index = map.get(val);
        if(index < list.size()-1){
            list.set(index,list.get(list.size()-1));
            map.put(list.get(list.size()-1),index);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    Random r = new Random();
    public int getRandom() {
        int i = r.nextInt(list.size()-1);
        return list.get(i);
    }

    public static void main(String[] args) {
        RandomizedSet380 r = new RandomizedSet380();
        r.insert(5);
        r.print();
        r.insert(6);
        r.print();
        r.remove(5);
        r.print();
    }
}
