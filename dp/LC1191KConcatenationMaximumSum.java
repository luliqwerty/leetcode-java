//Given an integer array arr and an integer k, modify the array by repeating it 
//k times. 
//
// For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2,
// 1, 2, 1, 2]. 
//
// Return the maximum sub-array sum in the modified array. Note that the length 
//of the sub-array can be 0 and its sum in that case is 0. 
//
// As the answer can be very large, return the answer modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2], k = 3
//Output: 9
// 
//
// Example 2: 
//
// 
//Input: arr = [1,-2,1], k = 5
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: arr = [-1,-2], k = 7
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁵ 
// 1 <= k <= 10⁵ 
// -10⁴ <= arr[i] <= 10⁴ 
// 
//
// 👍 164 👎 0

  
package dp;

import java.util.Arrays;

public class LC1191KConcatenationMaximumSum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    final int MOD = 1_000_000_007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        long res;
        if (k == 1) {
            res = maxSubArray(arr, k);
        } else {
            int two = maxSubArray(arr, 2);
            int sum = Arrays.stream(arr).sum() % MOD;
            if (sum > 0) {
                res = two + ((long) (k - 2) * sum) % MOD;
            } else {
                res = two;
            }
        }
        return (int) res;
    }

    private int maxSubArray(int[] arr, int k) {
        int len = arr.length;
        int n = len * k;
        int pre = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int idx = i % len;
            pre = Math.max(pre, 0) % MOD + arr[idx];
            res = Math.max(pre, res) % MOD;
        }
        System.out.println(res);
        return Math.max(res, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}