package hot100;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralres(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int rows = matrix.length, clms = matrix[0].length;
        if (matrix == null || rows == 0 || clms == 0) {
            return res;
        }
        
        int left = 0, right = clms - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int clm = left; clm <= right; clm++) {
                res.add(matrix[top][clm]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int clm = right - 1; clm > left; clm--) {
                    res.add(matrix[bottom][clm]);
                }
                for (int row = bottom; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
