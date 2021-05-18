package interview.meituan7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 小美的美丽树
 *
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/8 0:25
 */
public class Main4 {
    private static boolean[] visited;
    /**
     * 储存节点权值
     */
    private static int[] weight;
    /**
     * 储存以节点i为根的树有多少节点
     */
    private static int[] childNum;
    /**
     * 储存以节点i为根的子树下的最大值和最小值
     */
    private static int[] max, min;
    /**
     * 邻接表
     */
    private static HashMap<Integer, ArrayList<Integer>> tree;
    /**
     * 节点间的最大差值
     */
    private static int maxDiff = -1;
    /**
     * 待求节点
     */
    private static int node = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        weight = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
        }

        int x, y;
        tree = new HashMap<>();

        for (int i = 1; i <= n - 1; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            tree.computeIfAbsent(x, a -> new ArrayList<>());
            tree.get(x).add(y);
            tree.computeIfAbsent(y, a -> new ArrayList<>());
            tree.get(y).add(x);
        }

        int root = sc.nextInt();
        visited = new boolean[n + 1];
        max = new int[n + 1];
        min = new int[n + 1];
        childNum = new int[n + 1];
        dfs(root, k);
        System.out.println(node);
    }

    private static void dfs(int root, int k) {
        visited[root] = true;
        // 初始化root下的最值为root节点的权重
        max[root] = weight[root];
        min[root] = weight[root];
        // 初始情况下，该子树只有一个节点
        childNum[root] = 1;
        for (int i = 0; i < tree.get(root).size(); i++) {
            int child = tree.get(root).get(i);
            if (!visited[child]) {
                // 没访问过这个孩子就进行深度有限搜索
                dfs(child, k);
                max[root] = Math.max(max[root], max[child]);
                min[root] = Math.min(min[root], min[child]);
                childNum[root] += childNum[child];
            }
        }
        if (childNum[root] <= k && max[root] - min[root] >= maxDiff) {
            if (max[root] - min[root] > maxDiff) {
                node = root;
                maxDiff = max[root] - min[root];
            } else {
                // 如果node还没有赋值，就直接赋值为当前节点，否则取满足要求的节点中编号最小的
                node = node == -1 ? root : Math.min(node, root);
            }
        }
    }
}
