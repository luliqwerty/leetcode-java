//You are given a 2D integer array grid with size m x n. You are also given an 
//integer k. 
//
// Your task is to calculate the number of paths you can take from the top-left 
//cell (0, 0) to the bottom-right cell (m - 1, n - 1) satisfying the following 
//constraints: 
//
// 
// You can either move to the right or down. Formally, from the cell (i, j) you 
//may move to the cell (i, j + 1) or to the cell (i + 1, j) if the target cell 
//exists. 
// The XOR of all the numbers on the path must be equal to k. 
// 
//
// Return the total number of such paths. 
//
// Since the answer can be very large, return the result modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
// Input: grid = [[2, 1, 5], [7, 10, 0], [12, 6, 4]], k = 11 
// 
//
// Output: 3 
//
// Explanation: 
//
// The 3 paths are: 
//
// 
// (0, 0) → (1, 0) → (2, 0) → (2, 1) → (2, 2) 
// (0, 0) → (1, 0) → (1, 1) → (1, 2) → (2, 2) 
// (0, 0) → (0, 1) → (1, 1) → (2, 1) → (2, 2) 
// 
//
// Example 2: 
//
// 
// Input: grid = [[1, 3, 3, 3], [0, 3, 3, 2], [3, 0, 1, 1]], k = 2 
// 
//
// Output: 5 
//
// Explanation: 
//
// The 5 paths are: 
//
// 
// (0, 0) → (1, 0) → (2, 0) → (2, 1) → (2, 2) → (2, 3) 
// (0, 0) → (1, 0) → (1, 1) → (2, 1) → (2, 2) → (2, 3) 
// (0, 0) → (1, 0) → (1, 1) → (1, 2) → (1, 3) → (2, 3) 
// (0, 0) → (0, 1) → (1, 1) → (1, 2) → (2, 2) → (2, 3) 
// (0, 0) → (0, 1) → (0, 2) → (1, 2) → (2, 2) → (2, 3) 
// 
//
// Example 3: 
//
// 
// Input: grid = [[1, 1, 1, 2], [3, 0, 3, 2], [3, 0, 2, 2]], k = 10 
// 
//
// Output: 0 
//
// 
// Constraints: 
//
// 
// 1 <= m == grid.length <= 300 
// 1 <= n == grid[r].length <= 300 
// 0 <= grid[r][c] < 16 
// 0 <= k < 16 
// 
//
// 👍 19 👎 0

  
package dp;
public class LC3393CountPathsWithTheGivenXorValue {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPathsWithXorValue(int[][] grid, int k) {
        final int MOD = 1_000_000_007;
        int mx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                mx = Math.max(mx, val);
            }
        }

        // 这行代码计算了存储异或和所需数组的最小大小。
        // 它找到 grid 中的最大值 mx，然后确定一个大于 mx 的最小的 2 的幂 u。
        // 因为所有 grid 中的值都小于 u，所以路径上任意数字的异或和也必然小于 u。
        int u = 1 << (32 - Integer.numberOfLeadingZeros(mx));
        if (k >= u) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][][] f = new int[m + 1][n + 1][u];
        f[0][1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                for (int x = 0; x < u; x++) {
                    f[i + 1][j + 1][x] = (f[i + 1][j][x ^ val] + f[i][j + 1][x ^ val]) % MOD;
                }
            }
        }
        return f[m][n][k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
