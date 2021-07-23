package multiThreads.condition;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/14 19:57
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();

        MyThreadA a = new MyThreadA(service);
        a.start();

        MyThreadB b = new MyThreadB(service);
        b.start();
    }
}
