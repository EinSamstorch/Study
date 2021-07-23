package interview.design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/18 10:14
 */
public class SnakeGame {
    /**
     * 储存已经走过的点
     */
    Set<Integer> grid;
    int width, height;
    LinkedList<Integer> snake;
    int head;
    int[][] food;
    int foodIdx;
    int score;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        grid = new HashSet<>();
        snake = new LinkedList<>();
        snake.add(0);
        head = 0;
        grid.add(0);
        foodIdx = 0;
        score = 0;
    }

    public int move(String direction) {
        char dir = direction.charAt(0);
        int nextX = head / width;
        int nextY = head % width;
        nextX += (dir == 'U') ? -1 : 0;
        nextX += (dir == 'D') ? 1 : 0;
        nextY += (dir == 'L') ? -1 : 0;
        nextX += (dir == 'R') ? 1 : 0;
        if (isGameOver(nextX, nextY)) {
            return -1;
        }
        int next = nextX * width + nextY;
        if (foodIdx < food.length && food[foodIdx][0] * width + food[foodIdx][1] == next) {
            score++;
            foodIdx++;
        }
        grid.add(next);
        snake.add(next);
        head = next;
        return score;
    }

    private boolean isGameOver(int nextX, int nextY) {
        if (nextX < 0 || nextX >= height || nextY < 0 || nextY >= width) {
            return true;
        }
        int tail = snake.peek();
        int next = nextX * width + nextY;
        return grid.contains(next) && next != tail;
    }
}
