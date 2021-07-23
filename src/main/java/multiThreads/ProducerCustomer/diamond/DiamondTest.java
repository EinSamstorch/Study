package multiThreads.ProducerCustomer.diamond;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/23 10:07
 */
public class DiamondTest {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Producer producer = new Producer(factory);
        Customer customer = new Customer(factory);

        Thread producerA = new Thread(producer, "生产者A");
        Thread producerB = new Thread(producer, "生产者B");
        Thread customerA = new Thread(customer, "消费者A");
        Thread customerB = new Thread(customer, "消费者B");
        producerA.start();
        producerB.start();
        customerA.start();
        customerB.start();
    }
}

