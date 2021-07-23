package interview.vivo.vivo2020chun;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/6/17 14:42
 */
public class Main1 {

    /**
     * 16个方向
     */
    int[][] dir = {
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1},
            {1, 0}, {1, -1}, {0, -1}, {-1, -1},
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
    };

    /**
     * 是否已按下
     */
    boolean[][] isVisit = new boolean[5][5];
    int[] times = new int[10];

    boolean canVisit(int i, int j) {
        return i >= 1 && i <= 3 && j >= 1 && j <= 3 && !isVisit[i][j];
    }


    /**
     * d:已经被选中的键的个数(深度)
     */
    void dfs(int x, int y, int d) {
        if (d == 9) {
            return;
        }
        isVisit[x][y] = true;
        times[d++]++;

        //选择下一个键
        for (int i = 0; i < 16; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            //该点未被选择
            if (canVisit(newX, newY)) {
                dfs(newX, newY, d);
            } else if (i < 8) {
                //这步最关键，前8个方向的键若被按下了，可以选择同样方向但更远一步的位置
                newX += dir[i][0];
                newY += dir[i][1];
                //该点未被选择
                if (canVisit(newX, newY)) {
                    dfs(newX, newY, d);
                }
            }
        }
        isVisit[x][y] = false;
    }
}
