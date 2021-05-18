/**
 * @Author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @Date: 2020/9/8 19:47
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int ans = searchUpperBound(nums, target);
        System.out.println(ans);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 找到目标数在最左边出现的位置
     *
     * @param nums   待寻找的数组
     * @param target 目标数
     * @return 目标数第一次出现的位置
     */
    private static int searchLowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 找到目标数在最右边出现的位置
     *
     * @param nums   待寻找的数组
     * @param target 目标数
     * @return 目标数最后第一次出现的位置
     */
    private static int searchUpperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
