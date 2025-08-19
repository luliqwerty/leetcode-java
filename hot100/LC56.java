package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        // Sort the left endpoints from smallest to largest
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // result definition
        List<int[]> ans = new ArrayList<>();

        // algorithm thought
        for (int[] p : intervals) {
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1] /* Conditions that can be merged */) {
                // update right endpoint
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]);
            } else { // can't be merged, add original interval.
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
