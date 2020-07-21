import java.util.ArrayList;
import java.util.List;

public class Interview_29 {
    public static void main(String[] args) {
        int[][] test = new int[3][5];
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(matrix.length);
        System.out.println(matrix[1].length);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0)
            return result;
        int row = matrix.length;
        int column = matrix[0].length;
        //上下左右边界
        int u = 0;
        int d = matrix.length;
        int l = 0;
        int r = matrix[0].length;
        while (true) {

        }
    }
}
