package interview.meituan.meituan7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/7 21:30
 */
public class Main2 {
    private static Map<String, int[]> map = new HashMap<>();

    static {
        map.put("W", new int[]{-1, 0});
        map.put("A", new int[]{0, -1});
        map.put("S", new int[]{1, 0});
        map.put("D", new int[]{0, 1});
    }

    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt();
        cols = sc.nextInt();

        int P = sc.nextInt();
        int Q = sc.nextInt();
        // 多加一句nextLine()方法专门用来取出缓冲区中留下的空白符
        sc.nextLine();
        String[][] grid = new String[rows][cols];
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < rows; i++) {
            String str = sc.nextLine();
            String[] strs = str.split("");
            for (int j = 0; j < cols; j++) {
                // 确定开始的位置
                if ("S".equals(strs[j])) {
                    startX = i;
                    startY = j;
                }
                grid[i][j] = strs[j];
            }
        }
        String[] path = sc.nextLine().split("");
        int[] direction;
        int x = startX;
        int y = startY;
        int score = 0;
        // 只有第一次访问时才计算分数
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        for (String s : path) {
            direction = map.get(s);
            x = x + direction[0];
            y = y + direction[1];
            // 越界，回退
            if (!isValid(x, y)) {
                x = x - direction[0];
                y = y - direction[1];
                continue;
            }
            String curPos = grid[x][y];
            if ("O".equals(curPos)) {
                if (!visited[x][y]) {
                    score += P;
                }
            } else if ("X".equals(curPos)) {
                if (!visited[x][y]) {
                    score -= Q;
                }
            } else if ("#".equals(curPos)) {
                // 遇到墙也需要回退
                x = x - direction[0];
                y = y - direction[1];
            }
            visited[x][y] = true;
        }
        System.out.println(score);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
