package multiThreads.notifyTest;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/23 10:34
 */
public class SignalTest {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 25, 200,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(5),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private List<Integer> sleepList = new LinkedList<>();
    private List<Integer> notifyList = new LinkedList<>();

    public void startThread(int i) {
        executor.execute(() -> {
            try {
                lock.lock();
                sleepList.add(i);
                condition.await();
                notifyList.add(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        SignalTest a = new SignalTest();
        for (int i = 1; i < 30; i++) {
            a.startThread(i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        for (int i = 1; i < 30; i++) {
            Thread.sleep(10);
            lock.lock();
            // signal() 需要获得lock
            condition.signal();
            lock.unlock();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("休眠顺序" + a.sleepList);
        System.out.println("唤醒顺序" + a.notifyList);
    }

}
