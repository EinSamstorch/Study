package sort;

import java.util.Arrays;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/1/12 21:20
 */
public class SortingTool {
    public static void exchange(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    /**
     * 冒泡排序
     * 每次将最大的数，冒泡到最上方
     *
     * @param nums 待排序数组
     */
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    exchange(nums, j, j + 1);
                }
            }
        }
        show(nums);
    }

    /**
     * 选择排序
     * <pre>
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * </pre>
     *
     * @param nums 待排序
     */
    public static void selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            exchange(nums, i, min);
        }
    }

    // 插入排序
    public static void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            // 将a[i]插入到a[i - 1], a[i - 2], ......
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    exchange(nums, j, j - 1);
                }
            }
        }
    }

    public static void shellSort(int[] nums) {
        int n = nums.length;
        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < n; i++) {
                // 将a[i]插入到a[i - h], a[i - 2 * h], a[i - 3 * h]。。。中
                for (int j = i; j > 0; j--) {
                    if (nums[j] < nums[j - h]) {
                        exchange(nums, j, j - h);
                    }
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 10, 3, 18, 17};
        show(nums);
//        bubbleSort(nums);
//        selectionSort(nums);
        insertionSort(nums);
        show(nums);
    }

}
