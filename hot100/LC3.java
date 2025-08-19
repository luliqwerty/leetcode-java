package hot100;

import java.util.HashMap;
import java.util.Map;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = -1, res = 0, len = s.length();
        for (int right = 0; right < len; ++right) {
            if (map.containsKey(s.charAt(right))) {
                // 如果这个字符已经存在
                // 那么就更新左指针到和 right 处的字母相同字母的位置
                left = Math.max(left, map.get(s.charAt(right)));
            }
            // 添加字母到 map 中
            map.put(s.charAt(right), right);
            // 答案为已有的最长和当前最长的最大值
            res = Math.max(res, right - left);
        }
        return res;
    }
}
