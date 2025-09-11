package double_pointer;
import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=611 lang=java
 *
 * [611] 有效三角形的个数
 *
 * https://leetcode.cn/problems/valid-triangle-number/description/
 *
 * algorithms
 * Medium (54.67%)
 * Likes:    657
 * Dislikes: 0
 * Total Accepted:    134.7K
 * Total Submissions: 245.7K
 * Testcase Example:  '[2,2,3,4]'
 *
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是: 
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * 
 * 
 */

// @lc code=start
class LC611triangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int k = 2; k < nums.length; ++k) {
            int i = 0;
            int j = k - 1;
            int c = nums[k];
            while (i < j) {
                if (nums[i] + nums[j] > c) {
                    res += j - i;
                    --j;
                } else {
                    ++i;
                }
            }
        }
        return res;
    }
}
// @lc code=end

