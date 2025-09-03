package double_pointer;

//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//
// 字母和数字都属于字母数字字符。
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
//
//
// 示例 2：
//
//
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
//
//
// 示例 3：
//
//
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 2 * 10⁵
// s 仅由可打印的 ASCII 字符组成
//
//
// 👍 835 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class lc125 {
    // lingshen's solution
    public boolean isPalindrome2(String S) {
        char[] s = S.toCharArray();
        int l = 0, r = s.length - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s[l])) ++l;
            else if (!Character.isLetterOrDigit(s[r])) --r;
            else if (Character.toLowerCase(s[l]) == Character.toLowerCase(s[r])) {
                ++l;
                --r;
            } else {
                return false;
            }
        }
        return true;
    }

    // my solution
    public boolean isPalindrome(String S) {
        char[] s = S.toCharArray();
        int l = 0, r = s.length - 1;
        while (l <= r) {
            while (l <= r && !isAlphaOrNumber(s[l])) ++l;
            while (l <= r && !isAlphaOrNumber(s[r])) --r;
            if (l > r) return true;
            if (!equal(s[l], s[r])) return false;
            ++l;
            --r;
        }
        return true;
    }

    public boolean isAlphaOrNumber(char c) {
        if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9')
            return true;
        return false;
    }

    public boolean equal(char a, char b) {
        return a == b || (a ^ b) == 32 || (a ^ b) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
