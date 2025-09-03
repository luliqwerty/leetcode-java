package sliding_window;

//给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
//
// 请返回这个数组中 「优美子数组」 的数目。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2,1,1], k = 3
//输出：2
//解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
//
//
// 示例 2：
//
//
//输入：nums = [2,4,6], k = 1
//输出：0
//解释：数列中不包含任何奇数，所以不存在优美子数组。
//
//
// 示例 3：
//
//
//输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//输出：16
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10^5
// 1 <= k <= nums.length
//
//
// 👍 326 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class lc1248 {
    // sliding window solution
    public int numberOfSubarrays(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k + 1);
    }

    public int slidingWindow(int[] nums, int k) {
        int cnt = 0, res = 0, l = 0;
        for (int r = 0; r < nums.length; ++r) {
            cnt += nums[r] & 1;
            while (l <= r && cnt >= k) {
                cnt -= nums[l] & 1;
                l++;
            }
            res += l;
        }
        return res;
    }

    // math
    public int numberOfSubarrays2(int[] nums, int k) {
        int n = nums.length, cnt = 0;
        int[] odd = new int[n + 2];
        for (int i = 0; i < n; ++i) {
            if ((nums[i] & 1) == 1) {
                odd[++cnt] = i;
            }
        }

        int res = 0;
        odd[0] = -1;
        odd[++cnt] = n;
        for (int i = 1; i + k <= cnt; ++i) {
            res += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
