package multiThreads.ProducerCustomer.diamond;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/23 10:06
 */
public class Producer implements Runnable {
    Factory factory;

    public Producer() {
    }

    public Producer(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            factory.put(new Diamond(i, Thread.currentThread().getName()));
        }
    }
}

