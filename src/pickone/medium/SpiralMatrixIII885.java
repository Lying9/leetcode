package pickone.medium;

/**
 * Created by ying on 2018/10/6.
 */
public class SpiralMatrixIII885 {

    public static void main(String[] args) {
        int R = 5, C = 6, r0 = 1, c0 = 4;
        int[][] result = new int[R * C][2];
        result = spiralMatrixIII1(R, C, r0, c0);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        result[0] = new int[]{r0, c0};
        int index = 1;//result的下标，赋值用
        int length = 1;//走多少步
        int direction = 0;//表示应该向那个方向走  0 右，1 下，2左 ， 3上
        int r = r0, c = c0;
        while (index < R * C) {
            if (direction == 0) {
                for (int i = 0; i < length; i++) {
                    c = c + 1;
                    if (r >= 0 && r < R && c < C && c >= 0) {
                        result[index++] = new int[]{r, c};
                    }
                }
                direction++;
            } else if (direction == 1) {
                for (int i = 0; i < length; i++) {
                    r = r + 1;
                    if (r >= 0 && r < R && c < C && c >= 0) {
                        result[index++] = new int[]{r, c};
                    }
                }
                direction++;
                length++;
            } else if (direction == 2) {
                for (int i = 0; i < length; i++) {
                    c = c - 1;
                    if (r >= 0 && r < R && c < C && c >= 0) {
                        result[index++] = new int[]{r, c};
                    }
                }
                direction++;
            } else {
                for (int i = 0; i < length; i++) {
                    r = r - 1;
                    if (r >= 0 && r < R && c < C && c >= 0) {
                        result[index++] = new int[]{r, c};
                    }
                }
                direction = 0;
                length++;
            }
        }
        return result;
    }

    public static int[][] spiralMatrixIII1(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        result[0] = new int[]{r0, c0};
        int index = 1;//result的下标，赋值用
        int length = 1;//走多少步
        int r = r0, c = c0;
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        while (index < R * C) {
            for (int i = 0; i < 4; i++) {//代表四个不同的方向
                for (int j = 0; j < length; j++) {
                    r += dr[i];
                    c += dc[i];
                    if (r >= 0 && r < R && c < C && c >= 0) {
                        result[index++] = new int[]{r, c};
                    }
                }
                if (i % 2 != 0)
                    length++;
            }
        }
        return  result;
    }
}
