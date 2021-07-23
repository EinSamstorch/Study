package interview.vivo.vivo2021qiu;

import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/6/17 10:16
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int left = 0, right = input.length() - 1;
        String res = "";
        if (isValid(input, left, right)) {
            res = input.substring(1);
            System.out.println(res);
            return;
        }
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                if (isValid(input, left + 1, right)) {
                    res += input.substring(0, left);
                    res += input.substring(left + 1);
                    System.out.println(res);
                    return;
                } else if (isValid(input, left, right - 1)) {
                    res += input.substring(0, right);
                    res += input.substring(right + 1);
                    System.out.println(res);
                    return;
                } else {
                    System.out.println("false");
                    return;
                }
            }
            left++;
            right--;
        }
    }

    private static boolean isValid(String s, int left, int right) {
        char[] chars = s.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
