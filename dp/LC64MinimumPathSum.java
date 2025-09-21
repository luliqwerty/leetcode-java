//Given a m x n grid filled with non-negative numbers, find a path from top 
//left to bottom right, which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 200 
// 
//
// 👍 1861 👎 0

  
package dp;

import java.util.Arrays;

public class LC64MinimumPathSum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 递归写法
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return dfs1(m - 1, n - 1, grid);
    }
    public int dfs1(int i, int j, int[][] grid) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return grid[0][0];
        return Math.min(dfs1(i - 1, j, grid), dfs1(i, j - 1, grid)) + grid[i][j];
    }

    // 递归加记忆化搜索

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] memo = new int[m + 1][n + 1];

        return dfs2(m - 1, n - 1, grid, memo);
    }
    public int dfs2(int i, int j, int[][] grid, int[][] memo) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return grid[0][0];
        return memo[i][j] = Math.min(dfs2(i - 1, j, grid, memo), dfs2(i, j - 1, grid, memo)) + grid[i][j];
    }

    // 动态规划递推解法
    public int minPathSum3(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row + 1][col + 1];

        Arrays.fill(dp[0], Integer.MAX_VALUE);

        // 动态规划别想太远，只考虑以前的状态会之后的状态影响，不考虑之后的状态。
//        dp[1][0] = Integer.MAX_VALUE;
        for (int i = 1; i <= row; ++i) {
            // 这里不应该是 i - 1，因为 这样的话 dp[i][j - 1] 没初始化。
//            dp[i - 1][0] = Integer.MAX_VALUE;
            dp[i][0] = Integer.MAX_VALUE;
            for (int j = 1; j <= col; ++j) {
                int r = i - 1;
                int c = j - 1;
                if (r == 0 && c == 0) {
                    dp[1][1] = grid[0][0];
                } else {
                    dp[i][j] = Math.min(dp[r][j], dp[i][c]) + grid[r][c];
                }
            }
        }
        return dp[row][col];
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}
