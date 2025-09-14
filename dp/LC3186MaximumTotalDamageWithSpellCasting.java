//一个魔法师有许多不同的咒语。 
//
// 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。 
//
// 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] +
// 1 或者 power[i] + 2 的咒语。 
//
// 每个咒语最多只能被使用 一次 。 
//
// 请你返回这个魔法师可以达到的伤害值之和的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：power = [1,1,3,4] 
// 
//
// 输出：6 
//
// 解释： 
//
// 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。 
//
// 示例 2： 
//
// 
// 输入：power = [7,1,6,6] 
// 
//
// 输出：13 
//
// 解释： 
//
// 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。 
//
// 
//
// 提示： 
//
// 
// 1 <= power.length <= 10⁵ 
// 1 <= power[i] <= 10⁹ 
// 
//
// 👍 61 👎 0

  
package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC3186MaximumTotalDamageWithSpellCasting {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 抄的灵神的
    public long maximumTotalDamage1(int[] power) {
        // 统计伤害相同 咒语个数
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : power) {
            cnt.merge(x, 1, Integer::sum);
        }
        int n = cnt.size();
        int[] keys = new int[n];

        // 把 伤害值集合 拿出来
        int k = 0;
        for (int x : cnt.keySet()) {
            keys[k++] = x;
        }
        Arrays.sort(keys);

        int j = 0;
        // f[n] 表示：已经对前 n 个咒语做出了决策，此时获得的最大伤害是多少。
        long[] f = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            int x = keys[i];
            // 找伤害值 < power[i] - 2 ，power[i] - 1 的第一个咒语
            while (keys[j] < x - 2) {
                j++;
            }
            f[i + 1] = Math.max(f[i], f[j] + (long) x * cnt.get(x));
        }
        return f[n];
    }

    // 自己重新写的，感觉有点感觉了，对动态规划的递推公式有了一定的了解
    // 首先定义 最终解决的问题 表达的含义，例：f[n] 表示：已经对前 n 个咒语做出了决策，此时获得的最大伤害是多少。
    // 然后到了 第 i 个 的时候，此时有选和不选两种情况，分别求出然后用加法法则
    public long maximumTotalDamage2(int[] power) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : power) {
            cnt.merge(x, 1, Integer::sum);
        }

        int n = cnt.size();
        int[] keys = new int[n];
        int k = 0;
        for (int x : cnt.keySet()) {
            keys[k++] = x;
        }
        Arrays.sort(keys);

        long[] f = new long[n + 1];
        int j = 0;
        for (int i = 0; i < n; ++i) {
            int key = keys[i];
            while (keys[j] < key - 2) {
                j++;
            }
            f[i + 1] = Math.max(f[i], f[j] + (long) key * cnt.get(key));
        }
        return f[n];
    }

    // 常使用过二分解决，但是时间比上面的还长，不知为啥？
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : power) {
            cnt.merge(x, 1, Integer::sum);
        }

        int n = cnt.size();
        int[] keys = new int[n];
        int k = 0;
        for (int x : cnt.keySet()) {
            keys[k++] = x;
        }
        Arrays.sort(keys);

        long[] f = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            int key = keys[i];
            // 使用二分查找找到最后一个小于 key-2 的元素位置
            int j = binarySearch(keys, i, key - 2);
            f[i + 1] = Math.max(f[i], f[j + 1] + (long) key * cnt.get(key));
        }
        return f[n];
    }

    // 二分查找找到最后一个小于 target 的元素索引
    // 如果所有元素都大于等于 target，返回 -1
    private int binarySearch(int[] arr, int right, int target) {
        int ans = -1;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                ans = mid;  // 记录当前找到的位置
                left = mid + 1;  // 继续向右找更大的符合条件的值
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}