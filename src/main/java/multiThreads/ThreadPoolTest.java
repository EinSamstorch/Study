package multiThreads;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/14 10:12
 */
@Slf4j
public class ThreadPoolTest {
    private static ThreadFactory guavaThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                guavaThreadFactory);


        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);

            System.out.printf("线程池中线程数目：%d，队列中等待执行的任务数目：%d，已执行完别的任务数目：%d%n",
                    executor.getPoolSize(), executor.getQueue().size(), executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    public void test() {

    }

}

@Slf4j
class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        log.info("正在执行task " + taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("task " + taskNum + "执行完毕");
    }
}
