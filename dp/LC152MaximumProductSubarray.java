//Given an integer array nums, find a subarray that has the largest product, 
//and return the product. 
//
// The test cases are generated so that the answer will fit in a 32-bit integer.
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
// 
// 
//
// 👍 2488 👎 0

  
package dp;
public class LC152MaximumProductSubarray {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int fMax, fMin;
        fMax = fMin = 1;
        for (int x : nums) {
            int tMax = fMax;
            fMax = Math.max(Math.max(fMax * x, fMin * x), x);
            fMin = Math.min(Math.min(tMax * x, fMin * x), x);

            res = Math.max(res, fMax);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
