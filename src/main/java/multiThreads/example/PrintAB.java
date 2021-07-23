package multiThreads.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/23 0:31
 */
public class PrintAB {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory());
    public static int DEFUALT_TIMES = 10;

    public static void main(String[] args) {

        GuardObject lock = new GuardObject();
        new Thread(() -> {
            int i = DEFUALT_TIMES;
            while (i-- > 0) {
                lock.printA();
            }
        }, "t1").start();
        new Thread(() -> {
            int i = DEFUALT_TIMES;
            while (i-- > 0) {
                lock.printB();
            }
        }, "t2").start();
    }
}

class GuardObject {

    private boolean flag = true;


    public void printA() {
        synchronized (this) {
            while (!this.flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("A");
            flag = false;
            notifyAll();
        }

    }

    public void printB() {
        synchronized (this) {
            while (this.flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("B");
            flag = true;
            notifyAll();
        }

    }

}

