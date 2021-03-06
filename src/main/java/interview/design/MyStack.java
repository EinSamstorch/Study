package interview.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/16 10:51
 */
public class MyStack {
    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public Integer pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public Integer top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
