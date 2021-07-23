package multiThreads.example;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/13 19:01
 */
public class BoundedBlockingQueue {
    private Semaphore consumeSeamaphore;
    private Semaphore produceSemaphore;
    private int capacity;
    private LinkedList<Integer> queue = new LinkedList<>();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        consumeSeamaphore = new Semaphore(0);
        produceSemaphore = new Semaphore(capacity);
    }

    public void enqueue(int element) throws InterruptedException {
        produceSemaphore.acquire();
        queue.add(element);
        consumeSeamaphore.release();
    }

    public int dequeue() throws InterruptedException {
        consumeSeamaphore.acquire();
        int v = queue.remove();
        produceSemaphore.release();
        return v;
    }

    public int size() {
        return queue.size();
    }
}
