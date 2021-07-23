package interview.ali2;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 统计订阅人数：
 * 同时有N个商品（用long类型的商品id表示），每个商品都可以被任何一个用户（long类型的用户id）订阅，每被订阅一次，该商品的订阅数加1，
 * 同一个用户对同一个商品只能订阅一次 编辑写一个类，用3个方法提供以下功能（这3个方法都是在单机多线程环境下调用）： 
 * 1）为指定的用户id订阅指定的商品id
 * 2) 返回所有商品的订阅总数 
 * 3）根据商品ID返回这个商品的订阅数
 *
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/12 21:15
 */
public class Main {

    /**
     * key为商品id，value为HashSet,存放订阅该商品的用户id
     */
    private static final Map<Long, Set<Long>> productSubscribersMap = new ConcurrentHashMap<>();

    /**
     * key为商品id，value为每个商品的订阅人数
     */
    private static final Map<Long, Integer> productSubscribersNumMap = new ConcurrentHashMap<>();

    /**
     * 用于统计商品订阅总数
     */
    private static AtomicInteger totalCount = new AtomicInteger(0);

    private static final Object lock = new Object();

    public static void main(String[] args) {

        // 1. 为指定的用户id订阅指定的商品id
        subscribingProduct(1, 1);
        // 验证同一个用户对同一个商品只能订阅一次
        subscribingProduct(1, 1);
        // 验证同一个用户订阅不同的商品
        subscribingProduct(2, 1);
        subscribingProduct(2, 2);
        subscribingProduct(3, 3);
        subscribingProduct(4, 4);
        subscribingProduct(5, 5);
        subscribingProduct(6, 6);

        // 2. 返回所有商品的订阅总数
        AtomicInteger totalNamOfSubscriptions = getTotalNumOfSubscriptions();

        long productId = 1;
        // 3. 根据商品id返回这个商品的订阅人数
        int numOfCustomers = getCustomerNum(productId);

        System.out.println(totalNamOfSubscriptions);
        System.out.println(numOfCustomers);

    }

    private static int getCustomerNum(long productId) {
        return productSubscribersNumMap.getOrDefault(productId, 0);
    }

    private static AtomicInteger getTotalNumOfSubscriptions() {
        return totalCount;
    }


    private static void subscribingProduct(long subscriberId, long productId) {

        Set<Long> subscribers = productSubscribersMap.get(productId);

        if (subscribers == null) {
            // 使用synchronized（非this对象）同步代码块格式进行同步操作的时候，锁必须是同一个，如果不是同一个锁，则运行结果就是异步调用，交叉运行
            // 这边为什么不能用synchronized(this)，因为这里是静态代码块里
            synchronized (lock) {
                if (subscribers == null) {
                    subscribers = ConcurrentHashMap.newKeySet();
                }
            }
        }

        // 如果该商品已经被该用户订阅过，返回
        if (subscribers.contains(subscriberId)) {
            return;
        }
        subscribers.add(subscriberId);
        // 储存该商品id对应的订阅者集合
        productSubscribersMap.put(productId, subscribers);
        // 储存该商品id的订阅人数
        productSubscribersNumMap.put(productId, subscribers.size());
        // 总订阅数+1
        totalCount.getAndIncrement();
    }
}
