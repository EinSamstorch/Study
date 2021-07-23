package multiThreads;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/14 11:22
 */
public class ConditionTest2 {

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);
    private Lock lock = new ReentrantLock();
    private Condition produce_condition = lock.newCondition();
    private Condition consume_condition = lock.newCondition();

    public static void main(String[] args) {
        ConditionTest2 test = new ConditionTest2();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();
        producer.setName("producer");
        consumer.setName("consumer");
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {

            lock.lock();
            try {
                while (queue.size() == 0) {
                    try {
                        System.out.println("队列空，等待数据");
                        consume_condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.poll();                //每次移走队首元素
                produce_condition.signal();
                System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
            } finally {
                lock.unlock();
            }

        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {

            lock.lock();
            try {
                while (queue.size() == queueSize) {
                    try {
                        System.out.println("队列满，等待有空余空间");
                        produce_condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.offer(1);        //每次插入一个元素
                consume_condition.signal();
                System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
            } finally {
                lock.unlock();
            }

        }
    }
}
