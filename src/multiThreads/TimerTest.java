package multiThreads;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/14 14:51
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("abc");
            }
        }, 50000, 1000);
    }
}
