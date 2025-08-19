package hot100;

public class LC11 {
    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int temp = (j - i) * Math.min(height[i], height[j]);
            if (height[i] > height[j]) {
                --j;
            } else {
                ++i;
            }

            if (temp > ans) {
                ans = temp;
            }
        }
        return ans;
    }
}
