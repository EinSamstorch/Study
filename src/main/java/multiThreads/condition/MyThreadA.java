package multiThreads.condition;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/14 19:55
 */
public class MyThreadA extends Thread {
    private MyService myService;

    public MyThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            myService.set();
        }
    }
}
