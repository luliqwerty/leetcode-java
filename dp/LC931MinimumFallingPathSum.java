//Given an n x n array of integers matrix, return the minimum sum of any 
//falling path through matrix. 
//
// A falling path starts at any element in the first row and chooses the 
//element in the next row that is either directly below or diagonally left/right. 
//Specifically, the next element from position (row, col) will be (row + 1, col - 1), (
//row + 1, col), or (row + 1, col + 1). 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown.
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// 👍 416 👎 0

  
package dp;

import java.util.Arrays;

public class LC931MinimumFallingPathSum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
//        System.arraycopy(matrix[0], 0, dp[0], 0, n);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = dp[i - 1][j];
                // when j == n - 1, this if statement will be executed.
                // when j == 0, this if statement will be executed.
                // when 0 < j < n - 1, the flowing two statement all will be executed.
                if (j > 0) {
                    min = Math.min(dp[i - 1][j - 1], min);
                }
                if (j < n - 1) {
                    min = Math.min(dp[i - 1][j + 1], min);
                }
                dp[i][j] = min + matrix[i][j];
            }
        }

        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

    // 空间优化
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int[] f = new int[m + 2];
        System.arraycopy(matrix[0], 0, f, 1, m);
        f[0] = f[m + 1] = Integer.MAX_VALUE;

        for (int r = 1; r < m; ++r) {
            int pre = f[0];
            for (int c = 0; c < m; c++) {
                int tmp = f[c + 1];
                f[c + 1] = Math.min(pre, Math.min(f[c + 1], f[c + 2])) + matrix[r][c];
                pre = tmp;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= m; ++i) {
            if (f[i] < res) res = f[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
