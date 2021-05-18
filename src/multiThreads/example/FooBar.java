package multiThreads.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/13 15:13
 */
class FooBar {
    private int n;
    private final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
    private final Map<String, Thread> map = new ConcurrentHashMap<>();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        map.put("foo", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            while (!atomicBoolean.get()) {
                LockSupport.park();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            atomicBoolean.compareAndSet(true, false);
            LockSupport.unpark(map.get("bar"));
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        map.put("bar", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            while (atomicBoolean.get()) {
                LockSupport.park();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            atomicBoolean.compareAndSet(false, true);
            LockSupport.unpark(map.get("foo"));
        }
    }
}

