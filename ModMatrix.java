package Wars;

import java.util.Arrays;

public class ModMatrix {
    /**
     * @param r - Rows in the matrix
     * @param c - Columns in the matrix
     * @return false when we go out of bounds and true if still in bounds
     */
    public static boolean isValid(int r, int c) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @param mat    - The 2D matrix to search from
     * @param r      - Rows in the matrix
     * @param c      - Columns in the matrix
     * @param target - The number we are searching for in the matrix
     * @return - Position of target if Target exists in the matrix and {-1,-1}
     *         otherwise
     */
    public static int[] search(int[][] mat, int r, int c, int target) {
        if (isValid(r, c)) {
            if (target == mat[r][c]) {
                return new int[] { r, c };
            } else if (target > mat[r][c]) {
                return search(mat, r, c + 1, target);
            } else if (target < mat[r][c]) {
                return search(mat, r + 1, c, target);
            }
        }
        return new int[] { -1, -1 };
    }

    /**
     * The 2D Matrix to search through.
     */
    static int[][] mat = {
            { 7, 8, 9 },
            { 3, 4, 6 },
            { 1, 2, 3 }
    };

    public static void main(String[] args) {

        int[] ans = search(mat, 0, 0, 4);
        System.out.println(Arrays.toString(ans));
    }
}
