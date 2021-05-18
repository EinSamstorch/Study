package interview.wangyi0508;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/8 17:34
 */
public class Main3 {
    public static void main(String[] args) {

    }

    public String LCS(String str1, String str2) {
        // write code here
        char[] A = str1.toCharArray();
        char[] B = str2.toCharArray();
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;
        int end = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    end = j - 1;
                }
            }
        }

        String res;
        if (maxLen == 0) {
            return "";
        } else {
            return res = str2.substring(end - maxLen + 1, end + 1);
        }
    }
}
