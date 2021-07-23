package Offer;

import java.util.*;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/25 23:29
 */
public class Offer05 {
    public String replaceSpace(String s) {
        return s.replaceAll("", "%20");
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.poll());

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class CQueue {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        Deque<Integer> temp;
        temp = stack2;
        stack2 = stack1;
        stack1 = temp;
    }

    public int deleteHead() {
        return stack1.pop();
    }
}
