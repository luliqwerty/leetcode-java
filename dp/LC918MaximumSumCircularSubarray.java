//Given a circular integer array nums of length n, return the maximum possible 
//sum of a non-empty subarray of nums. 
//
// A circular array means the end of the array connects to the beginning of the 
//array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the 
//previous element of nums[i] is nums[(i - 1 + n) % n]. 
//
// A subarray may only include each element of the fixed buffer nums at most 
//once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not 
//exist i <= k1, k2 <= j with k1 % n == k2 % n. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,-2,3,-2]
//Output: 3
//Explanation: Subarray [3] has maximum sum 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [5,-3,5]
//Output: 10
//Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
// 
//
// Example 3: 
//
// 
//Input: nums = [-3,-2,-3]
//Output: -2
//Explanation: Subarray [-2] has maximum sum -2.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 
//
// 👍 824 👎 0

  
package dp;
public class LC918MaximumSumCircularSubarray {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1. 求 [0,len) 最大子数组和，2. 数组和 - [0,len) 最小子数组和，3. 如果
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currentMin = 0;

        for (int num : nums) {
            // 使用 Kadane 算法计算最大子数组和
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            // 使用 Kadane 算法计算最小子数组和
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);

            sum += num;
        }

        // 如果 maxSum < 0，说明数组中所有元素都是负数。
        // 此时，最大和就是数组中最大的那个数（maxSum）。
        // sum - minSum 会等于 0，这是不正确的。
        if (maxSum < 0) {
            return maxSum;
        }

        // 结果是 “不跨界的最大和” 与 “跨界的最大和” 中的较大者。
        // 跨界的最大和 = 数组总和 - 最小子数组和。
        return Math.max(maxSum, sum - minSum);
    }

    // 我自己的解法，没做出来。
    public int maxSubarraySumCircular1(int[] nums) {
        int start = Integer.MIN_VALUE, end = 0;
        int len = nums.length;
        int n = len * 2;
        int res = 0, preMax = 0;

        for (int i = 0; i < n; ++i) {
            int idx = i % len;
            if (start >= idx) break;

            int tmp = Math.max(preMax, 0) + nums[i];
            if (res < tmp) {
                start = idx;
            }
            preMax = tmp;
            res = Math.max(res, tmp);

            System.out.println(res + " " + tmp + " " + preMax);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}