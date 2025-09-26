//Given an integer array nums, return true if you can partition the array into 
//two subsets such that the sum of the elements in both subsets is equal or false 
//otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 👍 2423 👎 0

  
package dp;

public class LC416PartitionEqualSubsetSum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            if (num > max) max = num;
        }

        // Odd number can't split into two parts whose sum equals to each other.
        // Or the max num greater than half of total sum
        int target = sum / 2;
        if ((sum & 1) == 1 || max > target) return false;

        boolean[][] dp = new boolean[n][target + 1];
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            dp[i][0] = true;
            for (int j = 1; j <= target; ++j) {
                if (j >= nums[i]) {
//  dp[i][j] means to from [0, i) we choose some number whose sum equals to j.
//                        doesn't choose nums[i]        choose nums[i]
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
