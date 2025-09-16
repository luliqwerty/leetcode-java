//You are given an integer array nums. The absolute sum of a subarray [numsl, 
//numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr). 
//
// Return the maximum absolute sum of any (possibly empty) subarray of nums. 
//
// Note that abs(x) is defined as follows: 
//
// 
// If x is a negative integer, then abs(x) = -x. 
// If x is a non-negative integer, then abs(x) = x. 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,-3,2,3,-4]
//Output: 5
//Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,-5,1,-4,3,-2]
//Output: 8
//Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) =
// 8.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 👍 198 👎 0

  
package dp;
public class LC1749MaximumAbsoluteSumOfAnySubarray {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // 滑动窗口解法，计算最大子数组和、最小子数组和，然后求两个数绝对值 max
        int n = nums.length;

        int minsum = 0, minres = 0, maxsum = 0, maxres = 0;
        for (int x : nums) {
            maxsum = Math.max(maxsum, 0) + x;
            maxres = Math.max(maxres, maxsum);

            minsum = Math.min(minsum, 0) + x;
            minres = Math.min(minres, minsum);
        }
        return Math.max(maxres, -minres);
    }

    public int maxAbsoluteSum1(int[] nums) {
        // 前缀和，用最大前缀和减去最小前缀和。

        int min = 0, max = 0;
        int sum = 0;
        for (int x : nums) {
            sum += x;
            if (sum > max) max = sum;
            else if (sum < min) min = sum;
        }
        return max - min;
    }

    public int maxAbsoluteSum0(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        f[1] = nums[0];

        int res = 0;
        for (int i = 1; i < n; ++i) {
            boolean flag = nums[i] * f[i] >= 0;
            if (flag) {
                int tmp = f[i + 1] = f[i] + nums[i];
                System.out.println(tmp);
                res = Math.max(res, tmp > 0 ? tmp : -tmp);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}