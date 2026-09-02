class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowt = 0, rowb = matrix.length - 1;
        while(rowt <= rowb) {
            int rowm = rowt + ((rowb - rowt) / 2);
            if(matrix[rowm][0] > target) {
                rowb = rowm - 1;
            } else if(matrix[rowm][matrix[0].length - 1] < target) {
                rowt = rowm + 1;
            } else {
                int l = 0;
                int r = matrix[0].length - 1;
                while(l <= r) {
                    int m = l + ((r - l) / 2);
                    if(matrix[rowm][m] < target) {
                        l = m + 1;
                    } else if(matrix[rowm][m] > target) {
                        r = m - 1;
                    } else {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
