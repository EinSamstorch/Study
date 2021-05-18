package interview.design;

import java.util.Arrays;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/18 9:21
 */
public class PhoneDirectory {
    private boolean[] phone;
    private int size;

    public PhoneDirectory(int maxNumbers) {
        this.size = maxNumbers;
        phone = new boolean[maxNumbers];
        // true表示可以用
        Arrays.fill(phone, true);
    }

    public int get() {
        for (int i = 0; i < size; i++) {
            if (phone[i]) {
                phone[i] = false;
                return i;
            }
        }
        return -1;
    }

    public boolean check(int number) {
        return phone[number];
    }

    public void release(int number) {
        phone[number] = true;
    }
}
