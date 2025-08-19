package hot100;

public class LC238 {
    /// 哈哈哈哈哈，提交答案的时候发现打败 100%
    /// 结果一看题解，不能用除法
    /// 突然发现 **三个反斜杠** 在换行的时候可以自动填充

    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        int product = 1;
        int countZero = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                results[i] = 1;
                ++countZero;
            } else {
                product *= nums[i];
            }
        }
        // 如果 0 的个数大于 1，说明返回结果所有的数都是 0
        if (countZero > 1) {
            return new int[nums.length];
        } else if (countZero == 1) {
            for (int i = 0; i < results.length; ++i) {
                if (results[i] == 1) {
                    results[i] = product;
                } else {
                    results[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < results.length; ++i) {
                results[i] = product / nums[i];
            }
        }

        return results;
    }

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        prefix[0] = 1;
        int[] suffix = new int[len];
        suffix[len - 1] = 1;

        /// 这里有个细节
        /// prefix[0] 是无意义的
        for (int i = 1; i < len; ++i) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        /// suffix[len - 1] 是无意义的
        for (int i = len - 2; i >= 0; --i) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; ++i) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
    }
}
