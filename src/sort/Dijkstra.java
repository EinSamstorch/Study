package sort;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/3/27 23:42
 */

import java.util.*;

public class Dijkstra {

    public int[] shortestPath(int[][] times, int N, int source) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        // 初始化邻接表
        for (int[] edge : times) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        // 初始化dis数组和vis数组
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N];

        // 起点的dis为0，但是别忘记0也要搞一下，因为它是不参与的，我计算结果的时候直接用了stream，所以这个0也就要初始化下了
        distance[source] = 0;
        distance[0] = 0;

        // new一个小堆出来，按照dis升序排，一定要让它从小到大排，省去了松弛工作
        // PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> dis[o1] - dis[o2]);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> distance[o]));
        // 把起点放进去
        queue.offer(source);

        while (!queue.isEmpty()) {
            // 当队列不空，拿出一个源出来
            Integer candidate = queue.poll();
            if (visited[candidate]) {
                continue;
            }
            // 把它标记为访问过
            visited[candidate] = true;
            // 遍历它的邻居们，当然可能没邻居，这里用getOrDefault处理就很方便
            List<int[]> list = map.getOrDefault(candidate, Collections.emptyList());
            for (int[] arr : list) {
                int next = arr[0];
                // 如果这个邻居访问过了，继续
                if (visited[next]) continue;
                // 更新到这个邻居的最短距离，看看是不是当前poll出来的节点到它更近一点
                distance[next] = Math.min(distance[next], distance[candidate] + arr[1]);
                queue.offer(next);
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] times = {{4, 5, 35}, {5, 4, 35}, {4, 7, 37}, {5, 7, 28}, {7, 5, 28}, {5, 1, 32}, {0, 4, 38}, {0, 2, 26}, {7, 3, 39}, {1, 3, 29}, {2, 7, 34}, {6, 2, 40}, {3, 6, 52}, {6, 0, 58}, {6, 4, 93}};

        int N = 8;
        int K = 0;
        Dijkstra dijkstra = new Dijkstra();
        int[] distance = dijkstra.shortestPath(times, N, K);
        System.out.println(Arrays.toString(distance));
    }
}

