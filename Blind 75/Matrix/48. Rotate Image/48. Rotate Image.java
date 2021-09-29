// 0ms | Flip Horizontaly & Transpose | in-place
// The idea was firstly transpose the matrix and then flip it symmetrically. For instance,

// 1  2  3             
// 4  5  6
// 7  8  9
// after transpose, it will be swap(matrix[i][j], matrix[j][i])

// 1  4  7
// 2  5  8
// 3  6  9
// Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

// 7  4  1
// 8  5  2
// 9  6  3

public void rotate(int[][] matrix) {
    int N = matrix.length;
    //1 -Transpose
    for (int i = 0; i < N; i++) {
        for (int j = i; j < N; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    //2 -Reverse
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N / 2; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][N - 1 - j];
            matrix[i][N - 1 - j] = temp;
        }
    }
}

//Same solution With more redability
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}

//Alternative swap
public void rotate(int[][] matrix) {
    int s = 0, e = matrix.length - 1;
    while (s < e) {
        int[] temp = matrix[s];
        matrix[s] = matrix[e];
        matrix[e] = temp;
        s++;
        e--;
    }

    for (int i = 0; i < matrix.length; i++) {
        for (int j = i + 1; j < matrix[i].length; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}