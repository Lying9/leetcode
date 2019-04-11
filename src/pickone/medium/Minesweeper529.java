package pickone.medium;

/**
 * Created by ying on 2019/3/26.
 */
public class Minesweeper529 {
    public static void main(String[] args) {
       /* char a =(char)(1+'0');
        System.out.println(a);*/
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        char[][] result = updateBoard(board, click);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        int rows = board.length, cols = board[0].length;
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else if (board[row][col] == 'E') {
            int count = 0;
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (isVaild(i, j, rows, cols)) {
                        if (board[i][j] == 'M')
                            count++;
                    }
                }
            }
            if (count == 0) {
                board[row][col] = 'B';
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (i == row && j == col)
                            continue;
                        if (isVaild(i, j, rows, cols)) {
                            if (board[i][j] == 'M' || board[i][j] == 'E') {
                                int[] temp = new int[2];
                                temp[0] = i;
                                temp[1] = j;
                                board = updateBoard(board, temp);
                            }
                        }
                    }
                }
            } else {
                board[row][col] = (char) (count + '0');
            }
        }
        return board;
    }

    //检查下标是否有效
    public static boolean isVaild(int i, int j, int rows, int cols) {
        if (i >= 0 && i < rows && j >= 0 && j < cols)
            return true;
        return false;
    }
}
