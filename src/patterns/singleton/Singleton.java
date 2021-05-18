package patterns.singleton;

import java.io.Serializable;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/9 19:04
 */
public class Singleton implements Serializable {
    /**
     * volatile可以防止jvm指令重排优化,还有可见性
     */
    private volatile static Singleton instance;

    private Singleton() {
    }

    /**
     * 使用双重校验锁。
     */
    public static Singleton getInstance() {
        // 第一次校验instance是否为空
        // 为了代码提高代码执行效率，由于单例模式只要一次创建实例即可，
        // 所以当创建了一个实例之后，再次调用getInstance方法就不必要进入同步代码块，不用竞争锁。
        // 直接返回前面创建的实例即可。
        if (instance == null) {
            synchronized (Singleton.class) {
                // 第二次校验instance是否为空
                // 这个校验是防止二次创建实例
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * 防止序列化和反序列化出现问题
     */
    private Object readResolve() {
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " : " + Singleton.getInstance().hashCode());
                }
            }).start();
        }

    }
}
