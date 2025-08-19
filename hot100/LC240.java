package hot100;

public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;

        for (int row = 0; row < m; ++row) {
            if (binarySearch(matrix[row], target) != -1) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] array, int target) {
        int len = array.length;
        // [left, right) 左闭右开
        int left = 0, right = len;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                // 左闭右开，array[mid] 已经检查过了，所以下一个 [left, right) 是 [mid + 1, right)
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

//      方法二
//      根据矩阵的性质，将矩阵旋转 45° 看为一个二叉搜索树

        /**
         * 元素特征如下
         * → → → → 通过缩小矩阵范围加快算法效率
         *       ↓ current 和左下的元素是需要搜索的
         *       ↓
         *       ↓
         *
         */
        int row = 0, clm = n - 1;
        while (row < m && clm >= 0) {
            // 从右上角开始搜索
            int current = matrix[row][clm];
            // 当前元素大于 target 说明这一列元素都比 target 大
            if (current > target) {
                --clm;
            }
            // 当前元素小于 target 说明这一行元素都比 target 小
            else if (current < target) {
                ++row;
            } else if (current == target){
                return true;
            }
        }
        return false;
    }
}
