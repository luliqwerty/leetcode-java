//Given two strings word1 and word2, return the minimum number of steps 
//required to make word1 and word2 the same. 
//
// In one step, you can delete exactly one character in either string. 
//
// 
// Example 1: 
//
// 
//Input: word1 = "sea", word2 = "eat"
//Output: 2
//Explanation: You need one step to make "sea" to "ea" and another step to make 
//"eat" to "ea".
// 
//
// Example 2: 
//
// 
//Input: word1 = "leetcode", word2 = "etco"
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 and word2 consist of only lowercase English letters. 
// 
//
// 👍 742 👎 0

  
package dp;
public class LC583DeleteOperationForTwoStrings {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        for (int i = 1; i <= n1; ++i) {
            for (int j = 1; j <= n2; j++) {
                int x1 = i - 1, x2 = j - 1;
                if (c1[x1] == c2[x2]) {
                    dp[i][j] = dp[x1][x2] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][x2], dp[x1][j]);
                }
            }
        }
        return n1 + n2 - dp[n1][n2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
