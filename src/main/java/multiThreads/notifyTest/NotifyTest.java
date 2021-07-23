package multiThreads.notifyTest;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/23 10:25
 */
public class NotifyTest {
    private final Object object = new Object();
    private List<Integer> sleepList = new LinkedList<>();
    private List<Integer> notifyList = new LinkedList<>();

    public void startThread(int i) {
        new Thread(() -> {
            synchronized (object) {
                try {
                    sleepList.add(i);
                    object.wait();
                    notifyList.add(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        NotifyTest test = new NotifyTest();
        for (int i = 1; i < 30; i++) {
            test.startThread(i);
        }
        Thread.sleep(1000);

        System.out.println();
        for (int i = 1; i < 30; i++) {
            Thread.sleep(10);
            synchronized (test.object) {
                test.object.notify();
            }
        }

        Thread.sleep(1000);
        System.out.println("休眠顺序" + test.sleepList);
        System.out.println("唤醒顺序" + test.notifyList);

    }
}
