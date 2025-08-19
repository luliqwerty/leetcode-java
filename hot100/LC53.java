package hot100;

public class LC53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int preSum = 0;
        int minPreSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            preSum += nums[i];// current preSum
            max = Math.max(max, preSum - minPreSum);// subtract minimal preSum
            minPreSum = Math.min(minPreSum, preSum);// maintain minimal preSum
        }
        return max;
    }
}
