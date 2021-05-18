package interview.ali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/26 20:09
 */
public class Main {
    int targetX;
    int targetY;
    int rows;
    int cols;
    List<List<Integer>> res = new ArrayList<>();
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        new Main().solution();

    }

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        this.targetX = x2;
        this.targetY = y2;
        this.rows = n + 1;
        this.cols = m + 1;

        int[][] grid = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        List<Integer> path = new ArrayList<>();
        path.add(grid[x1][y1]);
        dfs(grid, visited, x1, y1, path);
        int min = Integer.MAX_VALUE;
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
            min = Math.min(list.size(), min);
        }
        System.out.println(min);

    }

    private void dfs(int[][] grid, boolean[][] visited, int x1, int y1, List<Integer> path) {
        if (x1 == targetX && y1 == targetY) {
            res.add(new ArrayList<>(path));
            return;
        }
        visited[x1][y1] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x1 + dx[i];
            int newY = y1 + dy[i];
            if (isVaild(grid, x1, y1, newX, newY) && !visited[newX][newY]) {
                path.add(grid[newX][newY]);
                dfs(grid, visited, newX, newY, path);
                path.remove(path.size() - 1);
            }
        }
        visited[x1][y1] = false;
    }

    private boolean isVaild(int[][] grid, int x1, int y1, int newX, int newY) {
        if (newX < 1 || newX >= rows || newY < 1 || newY >= cols) {
            return false;
        }
        int a = grid[x1][y1];
        int b = grid[newX][newY];
        return b - a >= 0;
    }
}
