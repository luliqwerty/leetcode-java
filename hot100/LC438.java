package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        // 这道题算是开始刷力扣开始第一道没看题解做出来的。
        // 好有成就感，虽然花了 1692ms，只击败了 10.03% 的人。
        int sLen = s.length();
        int pLen = p.length();

        char[] pChar = p.toCharArray();
        Arrays.sort(pChar);

        List<Integer> res = new ArrayList<>();
        for (int start = 0; start + pLen <= sLen; ++start) { // 这里的等号第一次写错了
            char[] subChar = s.substring(start, start + pLen).toCharArray();
            Arrays.sort(subChar);
            if (Arrays.equals(pChar, subChar)) {
                res.add(start);
            }
        }
        return res;
    }
}


