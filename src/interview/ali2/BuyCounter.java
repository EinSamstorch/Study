package interview.ali2;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/18 15:13
 */
public class BuyCounter {
    /**
     * key：时间戳timestamp
     * value：message消息， message[0]为itemId，message[1]为userId
     * 使用TreeMap按照timestamp升序排序
     */
    private static TreeMap<Integer, String[]> map;

    private static Object lock = new Object();

    public BuyCounter() {
        map = new TreeMap<>();
    }

    public synchronized static void buy(int timestamp, String[] message) {
        map.put(timestamp, message);
    }

    public static void showMessage(int timestamp) {
        while (!map.isEmpty()) {
            synchronized (lock) {
                Map.Entry<Integer, String[]> first = map.firstEntry();
                int startTime = first.getKey();
                // 处理过期的时间戳
                if (timestamp - startTime >= 300) {
                    map.pollFirstEntry();
                } else {
                    break;
                }
            }
        }
        // 按照时间戳展示最近的十个数据
        System.out.println("当前时间：第" + timestamp + "秒");
        if (!map.isEmpty()) {
            show(timestamp);
        } else {
            System.out.println("最近300秒无人购买商品");
        }
    }

    private static void show(int timestamp) {
        AtomicInteger count = new AtomicInteger(1);
        for (Map.Entry<Integer, String[]> entry : map.entrySet()) {
            int time = timestamp - entry.getKey();
            String[] mess = entry.getValue();
            String itemId = mess[0];
            String userId = mess[1];

            if (count.get() > 10) {
                break;
            }
            count.getAndIncrement();
            System.out.println(userId + "用户最近" + time + "秒前购买了" + itemId + "商品");
        }
    }

    public static void main(String[] args) {
        BuyCounter buyCounter = new BuyCounter();
        String[] mess1 = {"111", "111"};
        String[] mess2 = {"222", "222"};
        String[] mess3 = {"333", "333"};
        String[] mess4 = {"444", "444"};

        buy(1, mess1);
        buy(2, mess2);
        buy(3, mess3);
        buy(503, mess4);

        showMessage(800);
        showMessage(1000);
    }
}

