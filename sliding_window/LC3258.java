package sliding_window;
//给你一个 二进制 字符串 s 和一个整数 k。
//
// 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
//
//
// 字符串中 0 的数量最多为 k。
// 字符串中 1 的数量最多为 k。
//
//
// 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。
//
//
//
// 示例 1：
//
//
// 输入：s = "10101", k = 1
//
//
// 输出：12
//
// 解释：
//
// s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。
//
// 示例 2：
//
//
// 输入：s = "1010101", k = 2
//
//
// 输出：25
//
// 解释：
//
// s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。
//
// 示例 3：
//
//
// 输入：s = "11111", k = 1
//
//
// 输出：15
//
// 解释：
//
// s 的所有子字符串都满足 k 约束。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 50
// 1 <= k <= s.length
// s[i] 是 '0' 或 '1'。
//
//
// 👍 56 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class LC3258 {
    public int countKConstraintSubstrings(String S, int k) {
        char[] s = S.toCharArray();
        int res = 0;
        int l = 0;
        int[] cnt = new int[2];
        for (int r = 0; r < s.length; ++r) {
            cnt[s[r] & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s[l++] & 1]--;
            }
            res += r - l + 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
