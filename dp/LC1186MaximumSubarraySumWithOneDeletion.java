//Given an array of integers, return the maximum sum for a non-empty subarray (
//contiguous elements) with at most one element deletion. In other words, you want 
//to choose a subarray and optionally delete one element from it so that there is 
//still at least one element left and the sum of the remaining elements is 
//maximum possible. 
//
// Note that the subarray needs to be non-empty after deleting one element. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,-2,0,3]
//Output: 4
//Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the 
//subarray [1, 0, 3] becomes the maximum value. 
//
// Example 2: 
//
// 
//Input: arr = [1,-2,-2,3]
//Output: 3
//Explanation: We just choose [3] and it's the maximum sum.
// 
//
// Example 3: 
//
// 
//Input: arr = [-1,-1,-1,-1]
//Output: -1
//Explanation: The final subarray needs to be non-empty. You can't choose [-1] 
//and delete -1 from it, then get an empty subarray to make the sum equals to 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i] <= 10⁴ 
// 
//
// 👍 381 👎 0

  
package dp;
public class LC1186MaximumSubarraySumWithOneDeletion {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 我自己的思路：（是错的）
    // 1. 找出正常数组的最大子数组和 以及 数组中的最小值和它的下标
    // 2. 如果这个下标在最大子数组和中间那么就删除这个最小值。
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int pre = 0, res = 0;
        int min = Integer.MAX_VALUE, start = 0, end = 0, tmpStart = 0, minIdx = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }

//            pre = Math.max(pre, 0) + arr[i];
//            res = Math.max(res, pre);

            if (pre < 0) {
                pre = arr[i];
                tmpStart = i;
            } else {
                pre += arr[i];
            }

            if (pre > res) {
                res = pre;
                start = tmpStart;
                end = i;
            }
            System.out.println(start + " " + minIdx);
        }

        if (minIdx >= start && minIdx <= end) {
            res -= arr[minIdx];
        }
        return res;
    }

    // 动态规划解法，完全不会，刷了几天动态规划还是不会捏
    // 没事，看题解能看明白也挺厉害的了。以后会有自己的思路的，加油。
    public int maximumSum1(int[] arr) {
        int n = arr.length;
        int noDel = arr[0], oneDel = 0, res = arr[0];
        for (int i = 1; i < n; i++) {
            oneDel = Math.max(noDel, oneDel + arr[i]);
            noDel = Math.max(noDel + arr[i], arr[i]);
            res = Math.max(res, Math.max(noDel, oneDel));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
