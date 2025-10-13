//You are given a string s consisting of lowercase English letters. 
//
// A substring of s is called balanced if all distinct characters in the 
//substring appear the same number of times. 
//
// Return the length of the longest balanced substring of s. 
//
// 
// Example 1: 
//
// 
// Input: s = "abbac" 
// 
//
// Output: 4 
//
// Explanation: 
//
// The longest balanced substring is "abba" because both distinct characters 
//'a' and 'b' each appear exactly 2 times. 
//
// Example 2: 
//
// 
// Input: s = "zzabccy" 
// 
//
// Output: 4 
//
// Explanation: 
//
// The longest balanced substring is "zabc" because the distinct characters 'z',
// 'a', 'b', and 'c' each appear exactly 1 time. 
//
// Example 3: 
//
// 
// Input: s = "aba" 
// 
//
// Output: 2 
//
// Explanation: 
//
// One of the longest balanced substrings is "ab" because both distinct 
//characters 'a' and 'b' each appear exactly 1 time. Another longest balanced substring 
//is "ba". 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
//
// 👍 2 👎 0

  
package contest.single.contest471;
public class LC3713LongestBalancedSubstringI {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; ++i) {
            int[] cnt = new int[26];
            int kind = 0, max = 0;
            // kind 是字母种数，max 是某个字母最大出现次数
            // kind * max == j - i + 1 则说明：每一种字母的个数都是 max
            for (int j = i; j < n; ++j) {
                int x = s.charAt(j) - 'a';
                ++cnt[x];
                max = Math.max(max, cnt[x]);
                if (cnt[x] == 1) ++kind;
                if (kind * max == j - i + 1) res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
