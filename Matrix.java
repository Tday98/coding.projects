/**
 * Created by tristanday on 2/27/17.
 */
public class Matrix {
    int mat[][];

    Matrix (int[][] mat) {this.mat = mat;}

    public int sum() {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }

    public static void main (String[] args) {
        int[][] t1 = {{1,2}, {3,4}};
        Matrix matrix = new Matrix(t1);
        System.out.println(matrix.sum());

        int[][] t2 = {{5,6,7,8,9,10}, {4,3,2,1}};
        Matrix matrix2 = new Matrix(t2);
        System.out.println(matrix2.sum());
    }
}
