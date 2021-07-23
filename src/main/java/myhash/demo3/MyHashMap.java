package myhash.demo3;

import java.util.Objects;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/20 15:01
 */
public class MyHashMap<K, V> {

    private static int DEFAULT_INITIANL_CAPACITY = 16;
    private static float DEFAULT_LOAD_FACTOR = 0.75f;
    private float loadFactor;
    private int initCapacity;
    private Entry<K, V>[] table;

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.initCapacity = DEFAULT_INITIANL_CAPACITY;
        table = new Entry[this.initCapacity];
    }

    public MyHashMap(float loadFactor, int initCapacity, Entry<K, V>[] table) {
        this.loadFactor = loadFactor;
        this.initCapacity = initCapacity;
        this.table = table;
    }

    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(Objects.hash(key));
    }

    public V put(K key, V value) {
        int index = hash(key) % initCapacity;
        if (table[index] != null) {
            Entry<K, V> e = table[index];
            Entry<K, V> e2 = null;
            while (e != null) {
                if (hash(e.key) == hash(key) && e.key.equals(key)) {
                    // 如果键相同，则更新值
                    e.value = value;
                }
                // 遍历链表判断是否已经存在相同的key
                e2 = e;
                e = e.next;
            }
            // 如果不存在相同的key，则直接插入到尾结点的后面
            e2.next = new Entry<>(key, value, null);
        } else {
            Entry<K, V> e = new Entry<>(key, value, null);
            table[index] = e;
        }
        return value;
    }


    public V get(K key) {
        int index = hash(key) % initCapacity;
        Entry<K, V> e = table[index];
        if (e == null) {
            return null;
        }

        // 遍历index处的链表找到key
        while (e != null) {
            if (e.key == null && key == null || hash(e.key) == hash(key) && e.key.equals(key)) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }
    }
}

