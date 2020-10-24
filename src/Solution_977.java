import java.util.Arrays;

public class Solution_977 {
    public static void main(String[] args) {
        int[] A = {-4, -1, 0, 3, 10};
    }

    public static int[] sortedSquares(int[] A) {
        if (A == null)
            return null;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++)
            res[i] = A[i] * A[i];
        Arrays.sort(res);
        return res;
    }
}
