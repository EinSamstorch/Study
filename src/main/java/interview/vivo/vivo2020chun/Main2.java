package interview.vivo.vivo2020chun;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/6/17 15:37
 */
public class Main2 {

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        int n = 36;
        int ans = main2.soulution(n);
        System.out.println(ans);
    }

    public int soulution(int n) {
        if (n < 10) {
            return 10 + n;
        }
        int res = 0;
        int base = 1;
        for (int i = 9; i > 1; i--) {
            while (n % i == 0) {
                res += i * base;
                base *= 10;
                n /= i;
            }
        }
        return n > 1 ? -1 : res;
    }
}
