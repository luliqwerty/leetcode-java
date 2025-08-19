package hot100;

public class LC283 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }

        /*
         *
         * 左指针左边均为非零数，直到指向第一个零之后不动
         * 右指针向右走遇到非零数就和左指针交换
         * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。

         */

        int left = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left++] = temp;
            }
        }
    }
}
