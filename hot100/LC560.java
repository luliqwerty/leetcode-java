package hot100;

public class LC560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum == k) {
                    ++count;
                }
                // 以下代码写错了，如果有负数的话就错了
//                if (sum > k) {
//                    break;
//                }
            }
        }
        return count;
    }
}
