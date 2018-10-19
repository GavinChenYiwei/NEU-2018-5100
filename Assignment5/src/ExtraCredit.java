import java.util.LinkedList;
import java.util.List;

public class ExtraCredit {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix.length == 0)
            return list;
        int col_begin = 0, row_begin = 0, col_end = matrix[0].length - 1, row_end = matrix.length - 1;
        while (col_begin <= col_end && row_begin <= row_end) {
            for (int i = col_begin; i <= col_end; i++) {
                list.add(matrix[row_begin][i]);
            }
            row_begin++;
            for (int j = row_begin; j <= row_end; j++) {
                list.add(matrix[j][col_end]);
            }
            col_end--;
            if (row_begin <= row_end) {
                for (int i = col_end; i >= col_begin; i--) {
                    list.add(matrix[row_end][i]);
                }
                row_end--;
            }
            if (col_begin <= col_end) {
                for (int i = row_end; i >= row_begin; i--) {
                    list.add(matrix[i][col_begin]);
                }
                col_begin++;
            }
        }
        return list;
    }
}
