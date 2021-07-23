import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/24 14:03
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        List<String> q1 = new LinkedList<>();
        List<String> q2 = new LinkedList<>();
        List<String> leave = new ArrayList<>();

        for (int i = 1; i < n1 + 1; i++) {
            q1.add(String.valueOf(i));
        }
        for (int i = n2 + 1; i < n1 + n2 + 1; i++) {
            q2.add(String.valueOf(i));
        }
        for (int i = 0; i < n3; i++) {
            leave.add(String.valueOf(sc.nextInt()));
        }

        for (String people : leave) {
            if (q1.contains(people)) {
                q2.add(people);
                q1.remove(people);
            } else if (q2.contains(people)) {
                q1.add(people);
                q2.remove(people);
            }
        }

        for (String people : q1) {
            System.out.print(people + " ");
        }
        System.out.println();
        for (String people : q2) {
            System.out.print(people + " ");
        }
    }

}
