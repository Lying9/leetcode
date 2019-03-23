package pickone.hard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ying on 2019/3/22.
 */
public class LRUcache146 {
        private   Map<Integer,Integer> map ;
        private   int capacity;
        private   LinkedList<Integer> list;

        public LRUcache146 (int capacity) {
            map = new HashMap();
            this.capacity = capacity;
            list = new LinkedList<>();
        }

        public   int get(int key) {
            if(map.containsKey(key)){
                if(list.contains(key)){
                    list.remove((Integer)key);
                }
                list.addFirst(key);
                return map.get(key);
            }else
                return -1;
        }

        public   void put(int key, int value) {
            if(map.containsKey(key)){
                map.put(key,value);
                list.remove((Integer)key);
                list.addFirst(key);
                return;
            }
            if(map.size()>=capacity){
                map.remove(list.peekLast());
                list.pollLast();
            }
            map.put(key,value);
            list.addFirst(key);

        }
        public void printf(){
            for(Integer i : map.keySet()){
                System.out.println(i);
            }
        }


    public static void main(String[] args) {
      /*  LRUcache146  l = new LRUcache146(2);
        l.put(1,1);
        l.put(2,2);
        System.out.println(l.get(1));
        l.put(3,3);
        l.printf();*/
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        System.out.println();
        cache.put(3,3);
        cache.printf();


    }

}

class LRUCache{
    private   Map<Integer,Integer> map ;
    private   int capacity;

    public LRUCache (int capacity) {
        map = new LinkedHashMap<Integer,Integer>(capacity,1,true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public   int get(int key) {
        Integer value = map.get(key);
        if(value == null)
            return -1;
        return value;
    }

    public   void put(int key, int value) {
       map.put(key,value);

    }
    public void printf(){
        for(Integer i : map.keySet()){
            System.out.println(i);
        }
    }

}
