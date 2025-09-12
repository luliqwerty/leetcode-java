//给你一个整数数组 nums ，你可以对它进行一些操作。 
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
// + 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 👍 1147 👎 0

  
package dp;

import java.util.Arrays;

public class LC740DeleteAndEarn {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);
        int[] f = new int[max + 1];
        for (int x : nums) {
            f[x] += x;
        }

        int f0 = 0, f1 = f[1];
        for (int i = 2; i <= max; ++i) {
            int tmp = f1;
            f1 = Math.max(f1, f0 + f[i]);
            f0 = tmp;
        }
        return f1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}