package multiThreads;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/14 16:00
 */

public class JoinThreadTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.println(Thread.currentThread().getName() + "i" + i);
            }

        });
        t1.start();

        //主线程在此调用t1.join()方法，就认为主线程应该把执行权交给t1 让t1执行完毕后再执行主线程
        try {
            System.out.println(t1.getName());
            t1.join();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
//        t1.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("main" + "i" + i);
        }

    }
}