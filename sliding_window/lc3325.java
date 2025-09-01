package sliding_window;

//给你一个字符串 s 和一个整数 k，在 s 的所有子字符串中，请你统计并返回 至少有一个 字符 至少出现 k 次的子字符串总数。
//
// 子字符串 是字符串中的一个连续、 非空 的字符序列。
//
//
//
// 示例 1：
//
//
// 输入： s = "abacb", k = 2
//
//
// 输出： 4
//
// 解释：
//
// 符合条件的子字符串如下：
//
//
// "aba"（字符 'a' 出现 2 次）。
// "abac"（字符 'a' 出现 2 次）。
// "abacb"（字符 'a' 出现 2 次）。
// "bacb"（字符 'b' 出现 2 次）。
//
//
// 示例 2：
//
//
// 输入： s = "abcde", k = 1
//
//
// 输出： 15
//
// 解释：
//
// 所有子字符串都有效，因为每个字符至少出现一次。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3000
// 1 <= k <= s.length
// s 仅由小写英文字母组成。
//
//
// 👍 13 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class lc3325 {
    public int numberOfSubstrings(String S, int k) {
        char[] s = S.toCharArray();
        int[] cnt = new int[26];
        int res = 0;

        int l = 0;
        for (char c : s) {
            ++cnt[c - 'a'];
            while (gtk(cnt, k)) {
                --cnt[s[l++] - 'a'];
            }
            res += l;
        }

        return res;
    }

    public boolean gtk(int[] cnt, int k) {
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] >= k) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
