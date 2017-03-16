
/**
 * Created by juanyan.li on 3/9/17.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int end = matrix.length - 1;
        int start = 0;
        while (start < end) {
            rotateOneLayer(matrix, start, end);
            end -= 1;
            start += 1;
        }
    }

    public void rotateOneLayer(int[][] matrix, int start, int end) {
        for (int i=start; i<end; i+=1) {
            int x = start;
            int y = i;
            boolean incX = true;
            boolean incY = true;
            int tmp = matrix[x][y];
            int v = x;
            int w = y;
            for (int j=0; j<4; j+=1) {
                if (incX && incY) {
                    v = w;
                    w = end;
                    incY = false;
                } else if (incX && !incY) {
                    w = v == start ? w : end - v + start;
                    v = end;
                    incX = false;
                } else if (!incX && !incY) {
                    v = w;
                    w = start;
                    incY = true;
                } else {
                    w = v == end ? w : end - v + start;
                    v = start;
                    incX = true;
                }
                matrix[x][y] = matrix[v][w];
                matrix[v][w] = tmp;
                tmp = matrix[x][y];
            }
        }
    }

    public void printRes(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "|");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] inputs = new int[][]{{ 1, 2, 3, 4, 5, 1},
                                     { 6, 7, 8, 9,10, 6},
                                     {11,12,13,14,15,11},
                                     {16,17,18,19,20,16},
                                     {21,22,23,24,25,21},
                                     {26,27,28,29,30,26}};
        ri.rotate(inputs);
        ri.printRes(inputs);
    }
}

