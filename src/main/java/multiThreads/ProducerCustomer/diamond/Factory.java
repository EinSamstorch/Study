package multiThreads.ProducerCustomer.diamond;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/23 10:05
 */
public class Factory {
    /**
     * 缓冲区容量
     */
    private final int CAPACITY = 5;
    /**
     * 缓存区数组
     */
    private Diamond[] container = new Diamond[CAPACITY];
    /**
     * 缓存区内产品数量
     */
    private int size;

    /**
     * 生产产品
     *
     * @param diamond 产品
     */
    public synchronized void put(Diamond diamond) {
        while (size >= CAPACITY) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        container[size++] = diamond;
        System.out.println(Thread.currentThread().getName() + " 生产了 " + diamond.getId() + " 号钻石");
        this.notifyAll();
    }

    /**
     * 消费产品
     *
     * @param diamond 产品
     */
    public synchronized void take(Diamond diamond) {
        while (size <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        container[--size] = null;
        System.out.println(Thread.currentThread().getName() + " 消费了 " + diamond.getId() + " 号钻石");
        this.notifyAll();
    }
}

