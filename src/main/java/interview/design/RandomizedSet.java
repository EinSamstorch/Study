package interview.design;

import java.util.*;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/16 11:20
 */
public class RandomizedSet {
    /**
     * hashmap储存值到索引的映射
     */
    Map<Integer, Integer> dict;
    /**
     * 动态数组储存元素值
     */
    List<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }
        // move the last element to the palcae idx of the element to delete
        int lastElement = list.get(list.size() - 1);
        int index = dict.get(val);
        list.set(index, lastElement);
        dict.put(lastElement, index);
        // delete the last element
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}