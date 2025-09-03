package sliding_window;

//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
//
// 子数组 是数组的一段连续部分。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
//
//
// 示例 2：
//
//
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁴
// nums[i] 不是 0 就是 1
// 0 <= goal <= nums.length
//
//
// 👍 360 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class lc930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindow(nums, goal) - slidingWindow(nums, goal + 1);
    }

    public int slidingWindow(int[] nums, int goal) {
        int sum = 0, res = 0, l = 0;
        for (int r = 0; r < nums.length; ++r) {
            sum += nums[r];
            while (l <= r && sum >= goal) {
                sum -= nums[l];
                ++l;
            }
            res += l;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
