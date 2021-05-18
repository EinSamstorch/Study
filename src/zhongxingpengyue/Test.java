package zhongxingpengyue;

import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/24 19:20
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String test = sc.nextLine();
            System.out.println("test is :" + test);
            n--;
        }
    }
}
