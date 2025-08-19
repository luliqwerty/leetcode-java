package hot100;

public class LC76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        // record number of necessary character
        for (int i = 0; i < t.length(); ++i) {
            need[t.charAt(i)]++;
        }
        // l: left bound
        // r: right bound
        // size: window size
        // count: number of necessary character
        // start: minimal index of String t
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        // traverse character in string s
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {
                --count;
            }
            need[c]--;// add right character
            if (count == 0) {
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    ++l;
                }
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    start = l;
                }
                need[s.charAt(l)]++;
                l++;// remove left character
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start  +size);
    }

}
