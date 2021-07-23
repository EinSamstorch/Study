package multiThreads.condition;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/14 19:57
 */
public class MyThreadB extends Thread {
    private MyService myService;

    public MyThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            myService.get();
        }
    }
}

