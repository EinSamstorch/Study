package multiThreads;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/14 9:48
 */
public class BlockingQueueTest1 {
    static ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) {
        // 生产者
        for (int i = 0; i < 3; i++) {
            new Thread(BlockingQueueTest1::producer, "producerThread" + i).start();
        }
        // 消费者
        for (int i = 0; i < 3; i++) {
            new Thread(BlockingQueueTest1::consumer, "consumerThread" + i).start();
        }
    }

    private static void consumer() {
        while (true) {
            try {
                String msg = abq.take();
                System.out.println(Thread.currentThread().getName() + " ->receive msg:" + msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void producer() {
        for (int i = 0; i < 100; i++) {
            try {
                abq.put("[" + i + "]");
                System.out.println(Thread.currentThread().getName() + " ->send msg:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
