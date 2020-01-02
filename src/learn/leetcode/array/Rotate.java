package learn.leetcode.array;

    /*
    旋转图像：给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
    必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     */

//   先转置矩阵，然后翻转每一行
public class Rotate {
    public static void rotate(int[][] matrix){
        int n=matrix.length;

        //转置矩阵
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }

        //翻转每行
        for(int i=0;i<n;i++)
            for(int j=0;j<n/2;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=tmp;
            }
    }

    public static void main(String []args){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        int n=matrix.length;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j]+"  ");
            System.out.println();
        }
    }
}
