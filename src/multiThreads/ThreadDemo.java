package multiThreads;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/13 11:00
 */
public class ThreadDemo implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            addCount();
        }
    }

    private void addCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
