package zhongxingpengyue;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/25 11:31
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        List<Integer> q1 = new LinkedList<>();
        List<Integer> q2 = new LinkedList<>();
        List<Integer> leave = new LinkedList<>();

        for (int i = 1; i <= n1; i++) {
            q1.add(i);
        }
        for (int i = n1 + 1; i <= n1 + n2; i++) {
            q2.add(i);
        }
        for (int i = 0; i < n3; i++) {
            leave.add(sc.nextInt());
        }

        int index;
        for (int people : leave) {
            if (q1.contains(people)) {
                index = q1.indexOf(people);
                q1.remove(index);
                q2.add(people);
                continue;
            }
            if (q2.contains(people)) {
                index = q2.indexOf(people);
                q2.remove(index);
                q1.add(people);
            }
        }

        for (int people : q1) {
            System.out.print(people + " ");
        }
        System.out.println();
        for (int people : q2) {
            System.out.print(people + " ");
        }
    }
}
