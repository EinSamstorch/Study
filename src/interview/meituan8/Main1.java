package interview.meituan8;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/26 13:17
 */

import java.util.*;

/**
 * 小美借书
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();
        // 行的编号是1~N
        // 对题目就无语，用N + 1就不行，还得用10001
        List<Integer>[] rows = new ArrayList[10001];
        for (int i = 1; i <= 10000; i++) {
            rows[i] = new ArrayList<>();
        }
        // 行是否加锁
        boolean[] locked = new boolean[10001];
        // 书是否在小美手上
        boolean[] owned = new boolean[10001];
        // 书是否已经在书架上
        boolean[] onShelf = new boolean[10001];
        Map<Integer, Integer> bookToRow = new HashMap<>();

        for (int i = 0; i < Q; i++) {
            int operator = sc.nextInt();
            if (operator == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                // 已经在书架上且原行上锁，则放置无效
                if (onShelf[x]) {
                    int row = bookToRow.get(x);
                    if (locked[row]) {
                        continue;
                    }
                }
                // 如果要放的行锁住了或者在小美手上,则放置无效
                if (locked[y] || owned[x]) {
                    continue;
                }
                rows[y].add(x);
                bookToRow.put(x, y);
                onShelf[x] = true;
            } else if (operator == 2) {
                int y = sc.nextInt();
                locked[y] = true;
            } else if (operator == 3) {
                int y = sc.nextInt();
                locked[y] = false;
            } else if (operator == 4) {
                int x = sc.nextInt();
                if (onShelf[x]) {
                    int row = bookToRow.get(x);
                    if (!locked[row]) {
                        System.out.println(row);
                        owned[x] = true;
                        onShelf[x] = false;
                        // 先找到那本书在list中的索引，再移除
                        int index = rows[row].indexOf(x);
                        rows[row].remove(index);
                    } else {
                        System.out.println(-1);
                    }
                } else {
                    System.out.println(-1);
                }

            } else if (operator == 5) {
                int x = sc.nextInt();
                if (owned[x]) {
                    owned[x] = false;
                    int row = bookToRow.get(x);
                    rows[row].add(x);
                }
            }
        }
    }
}
