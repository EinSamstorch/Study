package interview.vivo.vivo2021qiu;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/6/17 9:38
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String ans = main.compileSeq("1,2,-1,1");
        System.out.println(ans);

    }

    public String compileSeq(String input) {

        String[] items = input.split(",");
        int len = items.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 入度数组
        int[] inDegree = new int[len];
        // 邻接表
        List<Integer>[] adj = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < len; i++) {
            int file = i;
            int depend = Integer.parseInt(items[i]);
            // 首先加入不依赖于别的文件的节点
            if (depend == -1) {
                queue.add(i);
            } else {
                inDegree[i]++;
                adj[depend].add(file);
            }
        }

        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int head = queue.poll();
            res.add(String.valueOf(head));
            for (int file : adj[head]) {
                inDegree[file]--;
                if (inDegree[file] == 0) {
                    queue.offer(file);
                }
            }
        }
        return String.join(",", res);
    }
}
