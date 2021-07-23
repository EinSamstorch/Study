package interview.meituan.meituan7;

import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/7 22:21
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String d = sc.nextLine();
        String S = sc.nextLine();
        String T = sc.nextLine();
        int start = 0;
        long result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(start)) {
                result += i + 1;
                start++;
            }
        }
        if (start < m) {
            System.out.print("No");
        } else {
            System.out.println("Yes");
            System.out.println(result);
        }
    }
}
