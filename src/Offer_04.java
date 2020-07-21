public class Offer_04 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //N*M矩阵
        int N = matrix.length;
        int M = matrix[0].length;
        if (0 == M) return false;
        for (int i = 0; i < N; i++) {
            if (target > matrix[i][M - 1])
                continue;
            else if (target == matrix[i][M - 1])
                return true;
            else {
                for (int j = 0; j < M; j++) {
                    if (target == matrix[i][j])
                        return true;
                }
            }
        }
        return false;
    }
}
