package double_pointer;

public class lc1750 {
    public int minimumLength(String S) {
        char[] s = S.toCharArray();
        int l = 0, r = s.length - 1;
        while (l < r && s[l] == s[r]) {
            char c = s[l];
            while (l <= r && c == s[l]) ++l;
            while (l <= r && c == s[r]) --r;
        }
        return r - l + 1;
    }
}
