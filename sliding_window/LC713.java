package sliding_window;

public class LC713 {
    // I think this problem has some logic bugs
    // like nums:[1,1,1], the answer is 6: [1], [1,1], [1,1,1], [1], [1,1], [1]
    // but the three [1] is not one subarray?
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            int product = 1;
            for (int j = i; j < len; ++j) {
                product *= nums[j];
                if (product < k) {
                    ++res;
                } else break;
            }
        }
        return res;
    }

    // sliding window solution
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }
}
