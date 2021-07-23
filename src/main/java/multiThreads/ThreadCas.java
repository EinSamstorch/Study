package multiThreads;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/13 10:41
 */
public class ThreadCas {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //每个线程让count自增100次
                for (int i1 = 0; i1 < 100; i1++) {
//                    synchronized (ThreadCas.class) {
                    count++;
//                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
