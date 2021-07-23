package interview.ali2;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 已知有商品的成交消息(notify消息，message中可知itemId、userId)，要求设计并实现存入和读取两个方法，
 * 使得前端在进入商品详情页后，展示5分钟内最近完成购买的10条记录。
 * (xxx用户最近xxx秒前购买了xxx商品)
 *
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/18 19:45
 */
public class Main2 {
    /**
     * key: itemId
     * value：TreeSet 用来存放自定义的订单类，按照订单时间排序
     */
    private static ConcurrentHashMap<String, TreeSet<Order>> ordersMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        write("item1", "user1");
        write("item2", "user2");
        write("item3", "user3");
        Thread.sleep(2000);
        List<Order> orders = read("item1");

        for (Order order : orders) {
            System.out.println(order.getUserId() + " " + order.getItemId());
        }
    }

    public static void write(String itemId, String userId) {
        TreeSet<Order> orders = ordersMap.computeIfAbsent(itemId, k -> new TreeSet<>());
        orders.add(new Order(new Date(), userId, itemId));
    }

    /**
     * 根据商品id查询其五分钟内的十条订单记录
     * 对一个查询操作也不要加锁，因为查询是特别频繁的一件事
     *
     * @param itemId 商品id
     * @return 查询出来的订单集合
     */
    public static List<Order> read(String itemId) {
        List<Order> res = new CopyOnWriteArrayList<>();
        TreeSet<Order> orders = ordersMap.get(itemId);
        // 如果为空，说明该商品现在没有订单记录
        if (orders == null) {
            return res;
        }
        Long curTime = new Date().getTime();
        AtomicInteger count = new AtomicInteger(1);

        for (Order order : orders) {
            Long orderTime = order.getDate().getTime();
            // 这一步不是原子性的，不知道如何简单的改了
            long sec = (curTime - orderTime) / 1000;
            // 在一个查询操作里，不要做删除操作，可以对数据进行筛选返回
            // 删除操作可以通过一个后台线程进行
            if (sec < 300 && count.get() < 10) {
                // 如果是多线程并发的情况下，ArrayList的add操作会抛出ConcurrentModificationException异常
                res.add(order);
                count.getAndIncrement();
            }
        }
        return res;
    }
}


class Order implements Comparable<Order> {
    private Date date;
    private String userId;
    private String itemId;

    public Order(Date date, String userId, String itemId) {
        this.date = date;
        this.userId = userId;
        this.itemId = itemId;
    }

    public Date getDate() {
        return date;
    }

    public String getUserId() {
        return userId;
    }

    public String getItemId() {
        return itemId;
    }

    @Override
    public int compareTo(Order o) {
        return (int) (date.getTime() - o.getDate().getTime());
    }
}
