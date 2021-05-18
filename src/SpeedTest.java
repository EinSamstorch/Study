import java.util.ArrayList;
import java.util.List;

/**
 * @Author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @Date: 2020/8/31 20:03
 */
public class SpeedTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        long period = endTime - startTime;
        System.out.println(sum);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.contains(1));
    }
}
