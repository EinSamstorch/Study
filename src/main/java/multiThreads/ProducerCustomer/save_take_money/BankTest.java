package multiThreads.ProducerCustomer.save_take_money;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/23 0:57
 */
public class BankTest {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory());

    public static void main(String[] args) {
        BankCard bankCard = new BankCard();
        AddMoney addMoney = new AddMoney(bankCard);
        TakeMoney takeMoney = new TakeMoney(bankCard);
        Thread producerA = new Thread(addMoney, "生产者A");
        Thread producerB = new Thread(takeMoney, "生产者B");
        Thread producerC = new Thread(takeMoney, "生产者C");
        Thread producerD = new Thread(takeMoney, "生产者D");
        Thread customerA = new Thread(takeMoney, "消费者A");
        Thread customerB = new Thread(takeMoney, "消费者B");
        Thread customerC = new Thread(takeMoney, "消费者C");
        Thread customerD = new Thread(takeMoney, "消费者D");
        producerA.start();
        producerB.start();
        producerC.start();
        producerD.start();
        customerA.start();
        customerB.start();
        customerC.start();
        customerD.start();
    }
}

