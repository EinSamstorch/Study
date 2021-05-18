package zhongxingpengyue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/25 10:37
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer>[] stack = new ArrayDeque[6];
        // 用5个先进后出的栈保存任务优先级和索引
        for (int i = 1; i <= 5; i++) {
            stack[i] = new ArrayDeque<>();
        }

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            stack[x].addLast(i);
            if (stack[1].size() > 0 && stack[2].size() > 0 && stack[3].size() > 0
                    && stack[4].size() > 0 && stack[5].size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= 5; j++) {
                    sb.append(stack[j].removeLast()).append(" ");
                }
                System.out.println(sb.toString());
            } else {
                System.out.println(-1);
            }
        }
    }
}
