package dp;

public class LC2466CountWaysToBuildGoodStrings {

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