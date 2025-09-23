//You are given a 0-indexed m x n matrix grid consisting of positive integers. 
//
// You can start at any cell in the first column of the matrix, and traverse 
//the grid in the following way: 
//
// 
// From a cell (row, col), you can move to any of the cells: (row - 1, col + 1),
// (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move 
//to, should be strictly bigger than the value of the current cell. 
// 
//
// Return the maximum number of moves that you can perform. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
//Output: 3
//Explanation: We can start at the cell (0, 0) and make the following moves:
//- (0, 0) -> (0, 1).
//- (0, 1) -> (1, 2).
//- (1, 2) -> (2, 3).
//It can be shown that it is the maximum number of moves that can be made. 
//
// Example 2: 
//
// 
//
//Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
//Output: 0
//Explanation: Starting from any cell in the first column we cannot perform any 
//moves.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 1000 
// 4 <= m * n <= 10⁵ 
// 1 <= grid[i][j] <= 10⁶ 
// 
//
// 👍 83 👎 0

  
package dp;
public class LC2684MaximumNumberOfMovesInAGrid {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int ans;

    public int maxMoves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(i, 0, grid); // 从第一列的任一单元格出发
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] grid) {
        ans = Math.max(ans, j);
        if (ans == grid[0].length - 1) { // ans 已达到最大值
            return;
        }
        // 向右上/右/右下走一步
        for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, grid.length); k++) {
            if (grid[k][j + 1] > grid[i][j]) {
                dfs(k, j + 1, grid);
            }
        }
        grid[i][j] = 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
