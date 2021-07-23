package multiThreads.ProducerCustomer.save_take_money;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/23 0:56
 */
public class AddMoney implements Runnable {
    BankCard bankCard;

    public AddMoney(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bankCard.save(1000);
        }
    }
}

