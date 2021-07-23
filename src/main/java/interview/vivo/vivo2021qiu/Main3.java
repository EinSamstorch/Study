package interview.vivo.vivo2021qiu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/6/17 13:42
 */
public class Main3 {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int len;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        int startY = sc.nextInt();
        int startX = sc.nextInt();
        int endY = sc.nextInt();
        int endX = sc.nextInt();
        sc.nextLine();
        int[][] grid = new int[len][len];
        for (int i = 0; i < len; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < len; j++) {
                if (row.charAt(j) == '#' || row.charAt(j) == '@') {
                    grid[i][j] = -1;
                }
            }
        }
        map = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        calcWayDistance(grid, startX, startY, 0);
        if (map[endX][endY] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(map[endX][endY]);
        }
    }

    private static void calcWayDistance(int[][] grid, int x, int y, int dis) {
        if (x < 0 || x >= len || y < 0 || y >= len || grid[x][y] == -1 || dis >= map[x][y]) {
            return;
        }
        map[x][y] = dis;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            calcWayDistance(grid, newX, newY, dis + 1);
        }
    }
}
