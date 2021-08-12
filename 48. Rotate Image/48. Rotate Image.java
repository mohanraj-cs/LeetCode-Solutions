// 0ms | Flip Horizontaly & Transpose | in-place
public class Solution {
  public void rotate(int[][] matrix) {
      int N = matrix.length;
      //1 -Transpose
      for(int i = 0; i < N; i++){
          for(int j = i; j < N; j++){
              int temp = 0;
              temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
          }
      }

      //2 -Reverse
      for(int i = 0 ; i < N; i++){
          for(int j = 0; j < N / 2; j++){
              int temp = 0;
              temp = matrix[i][j];
              matrix[i][j] = matrix[i][N-1-j];
              matrix[i][N-1-j] = temp;
          }
      }
  }
}

//Alternative swap
class Solution {
  public void rotate(int[][] matrix) {
    int s = 0, e = matrix.length - 1;
    while(s < e){
        int[] temp = matrix[s];
        matrix[s] = matrix[e];
        matrix[e] = temp;
        s++; e--;
    }

    for(int i = 0; i < matrix.length; i++){
        for(int j = i+1; j < matrix[i].length; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
  }
}