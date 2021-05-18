package interview.meituan8;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/26 14:55
 */
public class Main3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        int g = sc.nextInt();
        // 将三种搭配放入一个大根堆中，按照三种搭配的获利对搭配进行降序排序
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        maxHeap.offer(new int[]{a, e});
        maxHeap.offer(new int[]{b, f});
        maxHeap.offer(new int[]{c, g});
        // 把衬衫分配给领带、裤子和帽子中赚钱多的
        long money = 0;
        while (!maxHeap.isEmpty() && d > 0) {
            int[] temp = maxHeap.poll();
            money += (long) Math.min(temp[0], d) * temp[1];
            d -= temp[0];
        }
        System.out.println(money);
    }
}
