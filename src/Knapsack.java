/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/22 19:18
 */
public class Knapsack {

    /**
     * @param W   可装载重量为W的背包
     * @param N   可以放下N个物品
     * @param wt  第i个物品的重量为wt[i]
     * @param val 第i个物品的价值为val[i]
     * @return 最多能装的价值
     */
    public static int knapsack(int W, int N, int[] wt, int[] val) {
        // dp[i][w]：对于前i个物品，当前背包的容量为w，这种情况下可以装的最大价值是dp[i][w]。
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            int weight = wt[i - 1];
            for (int w = 1; w <= W; w++) {
                if (w < weight) {
                    // 当前背包容量装不下，只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(dp[i - 1][w - weight] + val[i - 1], dp[i - 1][w]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        int ans = knapsack(W, N, wt, val);
        System.out.println(ans);
    }
}
