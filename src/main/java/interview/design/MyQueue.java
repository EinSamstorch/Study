package interview.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/16 10:55
 */
public class MyQueue {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.add(x);
        // push的时候往回倒一遍
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        Deque<Integer> temp;
        temp = stack1;
        stack1 = stack2;
        stack2 = temp;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public Integer peek() {
        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
