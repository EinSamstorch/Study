package interview.vivo.vivo2020chun;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/6/17 15:01
 */
public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.solution(11);
        System.out.println(ans);
    }

    public int solution1(int n) {
        int index = 0;
        for (int i = 0; i < n; i++) {
            int sum = i * (i + 1) / 2;
            if (sum > n) {
                index = i - 1;
                break;
            }
        }
        int sum = index * (index + 1) / 2;
        return index * (index + 1) * (2 * index + 1) / 6 + (n - sum) * (index + 1);
    }

    public int solution(int n) {
        int ans = 0;
        for (int i = 1; n > 0; i++) {
            ans += i * Math.min(i, n);
            n -= i;
        }
        return ans;

    }
}
