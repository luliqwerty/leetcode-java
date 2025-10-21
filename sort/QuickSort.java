package sort;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {7, 4, 1, 3, 5, 2};
//        quickSort(nums, 6);
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < 6; ++i) {
            System.out.println(nums[i]);
        }
    }

    // 递归原地交换写法
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = nums[left];
            int i = left, j = right;

            // partition 函数的逻辑
            while (i < j) {
                while (i < j && nums[j] >= pivot) { // 从右往左找第一个 < pivot 的数
                    --j;
                }
                while (i < j && nums[i] <= pivot) { // 从左往右找第一个 > pivot 的数
                    ++i;
                }
                swap(nums, i, j);
            }

            swap(nums, i, left);
            // ---------------------  partition  ----------------------------

            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 递归非原地交换写法
    public static void quickSort(int[] nums/*需要排序的子数组*/, int n/*n 是传入数组的长度*/) {
        if (n <= 1) return;
        int pivot = nums[0];

        int[] left_nums = new int[n];
        int[] right_nums = new int[n];

        int leftIdx = 0;
        int rightIdx = 0;
        // 这里可以写原地交换逻辑，但是我写的只传入一个长度不行
        // 需要传递两个数字，数组的开始和结束位置
        for (int i = 1; i < n; ++i) {
            if (nums[i] > pivot) {
                right_nums[rightIdx++] = nums[i];
            } else {
                left_nums[leftIdx++] = nums[i];
            }
        }

        quickSort(left_nums, leftIdx);
        quickSort(right_nums, rightIdx);

        if (leftIdx > 0) System.arraycopy(left_nums, 0, nums, 0, leftIdx);
        nums[leftIdx] = pivot;
        if (rightIdx > 0) System.arraycopy(right_nums, 0, nums, leftIdx + 1, rightIdx);
    }
}
