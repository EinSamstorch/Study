package interview.vivo.vivo2020B;

import java.util.ArrayList;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/6/17 16:58
 */
public class Main1 {
    public static void main(String[] args) {
        int[] input = {6, 3};
        String ans = solution(input);
        System.out.println(ans);
    }

    private static String solution(int[] input) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < input[0]; i++) {
            list.add(i + 1);
        }
        int start = 1, pos = 0;
        while (list.size() > 0) {
            if (start % input[1] == 0) {
                // pos位置的员工报到了m的倍数，出列
                sb.append(list.remove(pos)).append(" ");
            } else {
                // 否则不出列，位置继续后移
                pos++;
            }
            // 到队尾后回到队首
            if (pos >= list.size()) {
                pos -= list.size();
            }
            // 报数
            start++;
        }
        return sb.toString().trim();
    }
}
