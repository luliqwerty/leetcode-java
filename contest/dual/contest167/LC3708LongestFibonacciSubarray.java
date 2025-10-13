//You are given an array of positive integers nums. 
//
// A Fibonacci array is a contiguous sequence whose third and subsequent terms 
//each equal the sum of the two preceding terms. 
//
// Return the length of the longest Fibonacci subarray in nums. 
//
// Note: Subarrays of length 1 or 2 are always Fibonacci. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,1,1,1,2,3,5,1] 
// 
//
// Output: 5 
//
// Explanation: 
//
// The longest Fibonacci subarray is nums[2..6] = [1, 1, 2, 3, 5]. 
//
// [1, 1, 2, 3, 5] is Fibonacci because 1 + 1 = 2, 1 + 2 = 3, and 2 + 3 = 5. 
//
// Example 2: 
//
// 
// Input: nums = [5,2,7,9,16] 
// 
//
// Output: 5 
//
// Explanation: 
//
// The longest Fibonacci subarray is nums[0..4] = [5, 2, 7, 9, 16]. 
//
// [5, 2, 7, 9, 16] is Fibonacci because 5 + 2 = 7, 2 + 7 = 9, and 7 + 9 = 16. 
//
// Example 3: 
//
// 
// Input: nums = [1000000000,1000000000,1000000000] 
// 
//
// Output: 2 
//
// Explanation: 
//
// The longest Fibonacci subarray is nums[1..2] = [1000000000, 1000000000]. 
//
// [1000000000, 1000000000] is Fibonacci because its length is 2. 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 0 👎 0

  
package contest.dual.contest167;

import java.util.Arrays;

public class LC3708LongestFibonacciSubarray {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        // dp[i] 定义为 以 i 结尾的的斐波那契子数组最长长度
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 2);

        for (int i = 2; i < n; ++i) {
            if (nums[i - 2] + nums[i - 1] == nums[i]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return Arrays.stream(dp).max().orElse(2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
