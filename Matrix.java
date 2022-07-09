package Wars;

import java.util.Arrays;

/*
-Iterate through each row in the matrix 
-The apply Binary search on each row to see whether it contains the needed element.
-If yes, return the index
-If No to all return [-1,-1]
 */
class Wult {

    /**
     * 
     * @param subarr - The subarr to apply binary search to
     * @param target - The target element to search for
     * @return - Returns the index of the element
     */
    private static int binarysearch(int[] subarr, int target) {
        int hi = subarr.length - 1;
        int lo = 0;
        while (hi >= lo) {
            int midpoint = lo + (hi - lo) / 2;
            if (subarr[midpoint] == target) {
                return midpoint;
            } else if (subarr[midpoint] > target) {
                hi = midpoint - 1;
            } else {
                lo = midpoint + 1;
            }
        }
        return -1;
    }

    /**
     * 
     * @param target - Element to search for in the matrix
     * @param mat    - The 2D into search from
     * @return - Position of the element incase it exists and {-1,-1} otherwise
     */
    public static int[] search(int target, int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            int col = Wult.binarysearch(mat[i], target);
            if (col != -1) {
                return new int[] { i, col };
            }
        }
        return new int[] { -1, -1 };
    }
}

public class Matrix {
    public static void main(String[] args) {
        int[][] mat = {
                { 7, 8, 9 },
                { 3, 4, 6 },
                { 1, 2, 3 }
        };

        int[] arr = Wult.search(4, mat);
        System.out.println(Arrays.toString(arr));
    }
}