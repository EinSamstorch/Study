package interview.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/15 22:44
 */
public class LFUCache {
    /**
     * 容量
     */
    private int capacity;
    /**
     * 时间戳
     */
    private int time;
    private Map<Integer, Node> cache;
    private TreeSet<Node> set;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.time = 0;
        cache = new HashMap<>();
        set = new TreeSet<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        // 如果hash表中没有key，返回-1
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        // 从平衡二叉树中删除旧的节点
        set.remove(node);
        // 将旧的节点更新
        node.count++;
        node.time = ++time;
        // 将新的节点重新放入哈希表和平衡二叉树中
        set.add(node);
        cache.put(key, node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!cache.containsKey(key)) {
            // 如果缓存达到上线
            if (cache.size() == capacity) {
                // 从哈希表和平衡二叉树中删除最近最少使用的缓存
                cache.remove(set.first().key);
                set.remove(set.first());
            }
            // 创建新的缓存
            Node node = new Node(1, ++time, key, value);
            // 将新节点放入到哈希表和平衡二叉树中
            cache.put(key, node);
            set.add(node);
        } else {
            // 这边和put相似
            Node node = cache.get(key);
            set.remove(node);
            node.count++;
            node.time = time++;
            node.value = value;
            set.add(node);
            cache.put(key, node);
        }
    }
}


class Node implements Comparable<Node> {
    int count, key, time, value;

    public Node(int count, int time, int key, int value) {
        this.count = count;
        this.time = time;
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Node) {
            Node node = (Node) obj;
            return this.count == node.count && this.time == node.time;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + count;
        result = result * 31 + time;
        return result;
    }
}
