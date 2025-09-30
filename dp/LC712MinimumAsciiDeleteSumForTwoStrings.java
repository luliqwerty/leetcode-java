//Given two strings s1 and s2, return the lowest ASCII sum of deleted 
//characters to make two strings equal. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "sea", s2 = "eat"
//Output: 231
//Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the 
//sum.
//Deleting "t" from "eat" adds 116 to the sum.
//At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum 
//possible to achieve this.
// 
//
// Example 2: 
//
// 
//Input: s1 = "delete", s2 = "leet"
//Output: 403
//Explanation: Deleting "dee" from "delete" to turn the string into "let",
//adds 100[d] + 101[e] + 101[e] to the sum.
//Deleting "e" from "leet" adds 101[e] to the sum.
//At the end, both strings are equal to "let", and the answer is 100+101+101+101
// = 403.
//If instead we turned both strings into "lee" or "eet", we would get answers 
//of 433 or 417, which are higher.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 1000 
// s1 and s2 consist of lowercase English letters. 
// 
//
// 👍 441 👎 0

  
package dp;
public class LC712MinimumAsciiDeleteSumForTwoStrings {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (int i = 1; i <= n1; ++i) {
            for (int j = 1; j <= n2; j++) {
                int x = i - 1, y = j - 1;
                if (c1[x] == c2[y]) {
                    dp[i][j] = dp[x][y];
                } else {
                    dp[i][j] = Math.min(dp[i][y] + c2[y], dp[x][j] + c1[x]);
                }
            }
        }
        return dp[n1][n2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
