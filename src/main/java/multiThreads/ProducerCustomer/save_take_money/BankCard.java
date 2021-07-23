package multiThreads.ProducerCustomer.save_take_money;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/23 0:54
 */
public class BankCard {
    private double money;

    /**
     * true:只能取钱
     */
    private boolean flag;

    public synchronized void save(double addMoney) {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        money += addMoney;
        System.out.println(Thread.currentThread().getName() + " 存了:" + addMoney + " 余额:" + money);
        flag = true;
        this.notifyAll();
    }

    public synchronized void take(double takeMoney) {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        money -= takeMoney;
        System.out.println(Thread.currentThread().getName() + " 取了:" + takeMoney + " 余额:" + money);
        flag = false;
        this.notifyAll();
    }
}

