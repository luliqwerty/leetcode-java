package hot100;

import java.util.HashSet;
import java.util.Set;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;

        for (int x : set) {
            if (set.contains(x - 1)) {
                continue;
            }

            int y = x + 1;
            while (set.contains(y)) {
                ++y;
            }

            ans = Math.max(ans, y - x);
        }

        return ans;
    }
}
