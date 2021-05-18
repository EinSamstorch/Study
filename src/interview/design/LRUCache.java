package interview.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/15 22:13
 */
public class LRUCache {
    class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;

        public DlinkedNode() {
        }

        public DlinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DlinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    /**
     * 虚拟头结点和尾结点
     */
    private DlinkedNode dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        dummyHead = new DlinkedNode();
        dummyTail = new DlinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果key存在，先通过hash表定位，再移动到头部
        moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            // 如果key不存在，创建一个新的节点
            DlinkedNode newNode = new DlinkedNode(key, value);
            // 添加到hash表
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                // 如果超出容量，删除双向链表尾部节点
                DlinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 如果key存在，先通过哈希表定位，再修改value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DlinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DlinkedNode node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private DlinkedNode removeTail() {
        DlinkedNode res = dummyTail.prev;
        removeNode(res);
        return res;
    }
}
