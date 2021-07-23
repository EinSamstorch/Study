package multiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/13 11:00
 */
public class ThreadTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ThreadDemo threadDemo = new ThreadDemo();
        for (int i = 0; i < 10; i++) {
            threadPool.submit(threadDemo);
        }
        threadPool.shutdown();
        System.out.println(threadDemo.getCount());

    }
}
