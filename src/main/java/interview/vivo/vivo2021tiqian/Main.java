package interview.vivo.vivo2021tiqian;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/6/18 10:38
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] timeStrs = sc.nextLine().split(",");
        String[] relationships = sc.nextLine().split(";");
        int len = timeStrs.length;
        int[] marked = new int[len + 1];
        HashSet<Integer>[] adj = new HashSet[len + 1];
        int[] times = new int[len + 1];
        String[][] prerequisites = new String[len + 1][];
        // 处理输入数据
        for (int i = 1; i <= len; i++) {
            times[i] = Integer.parseInt(timeStrs[i - 1]);
            adj[i] = new HashSet<>();
            prerequisites[i] = relationships[i - 1].split(",");
        }

        // 初始化有向图
        for (int i = 1; i <= len; i++) {
            for (String s : prerequisites[i]) {
                int num = Integer.parseInt(s);
                if (num == 0) {
                    continue;
                }
                adj[i].add(num);
            }
        }
        // 使用stack或者list记录递归的顺序
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= len; i++) {
            if (dfs(i, adj, marked, stack)) {
                // 注意方法的语义，如果图中存在环，表示课程任务不能完成，
                System.out.println(-1);
            }
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = stack.pop();
        }
        System.out.println(Arrays.toString(res));


    }

    private static boolean dfs(int i, HashSet<Integer>[] adj, int[] marked, Stack<Integer> stack) {
        // 如果访问过了，就不用再访问了
        if (marked[i] == 1) {
            // 从正在访问中，到正在访问中，表示遇到了环
            return true;
        }
        if (marked[i] == 2) {
            // 表示在访问的过程中没有遇到环，这个节点访问过了
            return false;
        }
        // 走到这里，是因为初始化呢，此时marked[i] = 0;
        // 表示正在访问中
        marked[i] = 1;
        // 后继节点的集合
        HashSet<Integer> successorNodes = adj[i];
        for (Integer successor : successorNodes) {
            if (dfs(successor, adj, marked, stack)) {
                // 层层递归返回true，表示图中存在环
                return true;
            }
        }
        // i的所有后继节点都访问完了，都没有存在环，则这个节点就可以被标记为已经访问结束
        marked[i] = 2;
        stack.add(i);
        // false表示图中不存在换
        return false;
    }
}
