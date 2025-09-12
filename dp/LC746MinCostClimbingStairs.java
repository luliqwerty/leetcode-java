//给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。 
//
// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 
//
// 请你计算并返回达到楼梯顶部的最低花费。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10,15,20]
//输出：15
//解释：你将从下标为 1 的台阶开始。
//- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
//总花费为 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1,100,1,1,1,100,1,1,100,1]
//输出：6
//解释：你将从下标为 0 的台阶开始。
//- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
//总花费为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
//
// 👍 1699 👎 0

  
package dp;
public class LC746MinCostClimbingStairs {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] f = new int[len + 1];
        for (int i = 2; i <= len; ++i) {
            f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
        }
        return f[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static class LC2466CountWaysToBuildGoodStrings {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countGoodStrings(int low, int high, int zero, int one) {
            // low < n * zero + m * one < high
            // Ling shen orz
            final int MOD = 1_000_000_007;
            int res = 0;
            int[] f = new int[high + 1];
            f[0] = 1;
            // f[i] 来自长度为 i - zero 串添加 zero 个 0 +
            //         长度为 i - one  串添加 one 个 1
            for (int i = 1; i <= high; ++i) {
                if (i >= zero) f[i] = f[i - zero];
                if (i >= one) f[i] = (f[i] + f[i - one]) % MOD;
                // 符合条件的添加到答案中。
                if (i >= low) res = (res + f[i]) % MOD;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    }
}