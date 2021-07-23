import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @Date: 2020/9/8 15:46
 */
public class MonotonousStack {
    /**
     * 总结：
     * 找下一个更大的元素，就单调递减栈
     * 找下一个更小的元素，就单调递增栈
     * 找左边，从头遍历；找右边，从尾遍历
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.print("原数组：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        getLeftFirstLT(nums);
        System.out.println();
        getLeftFirstGT(nums);
        System.out.println();
        getRightFirstLT(nums);
        System.out.println();
        getRightFirstGT(nums);
    }

    /**
     * 求解数组中右边第一个比他大的元素
     * 从后往前，构造单调递减栈
     *
     * @param nums 数组
     */
    private static void getRightFirstGT(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();

        // 从后往前，构造单调递减栈
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                // 矮个子起开
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            // 进栈，接受之后的判定
            stack.push(nums[i]);
        }
        System.out.print("数组中右边第一个比他大的元素:");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    /**
     * 求解数组中右边第一个比他小的元素
     * 从后往前，构造单调递增栈
     *
     * @param nums
     */
    private static void getRightFirstLT(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();

        // 从后往前，构造单调递增栈
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                // 高个子起开
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        System.out.print("数组中右边第一个比他小的元素:");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    /**
     * 求解数组左边第一个比他大的元素
     * 从前往后，构造单调递减栈
     *
     * @param nums
     */
    private static void getLeftFirstGT(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();

        // 从前往后，构造单调递减栈
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        System.out.print("数组中左边第一个比他大的元素:");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    /**
     * 求解数组左边第一个比他小的元素
     * 从前往后，构造单调递增栈
     *
     * @param nums 数组
     */
    private static void getLeftFirstLT(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                // 高个子起开
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        System.out.print("数组中左边第一个比他小的元素:");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
