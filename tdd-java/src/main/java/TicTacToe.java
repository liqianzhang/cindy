/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class TicTacToe {
    private static int SIZE = 3;
    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private char lastPlayer = '\0';

    private TicTacToeCollection ticTacToeCollection;

    protected TicTacToe(TicTacToeCollection collection) {
        ticTacToeCollection = collection;
    }

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(new TicTacToeBean(1, x, y, lastPlayer));
        if (isWin()) {
            return lastPlayer + " is the Winner";
        } else if (isDraw()) {
            return "The result is draw";
        } else {
            return "No winner";
        }
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin() {
        int playerTotal = lastPlayer * 3;
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] + board[1][i] + board[2][i]
                 == lastPlayer * SIZE) {
                return true;
            } else if (board[i][0] + board[i][1] + board[i][2]
                    == playerTotal) {
                return true;
            }
        }
        if ((board[0][0] + board[1][1] + board[2][2]
                == playerTotal)) {
            return true;
        } else if ((board[0][2] + board[1][1] + board[2][0]
                == playerTotal)){
            return true;
        }
        return false;
    }

//    private void setBox(int x, int y) {
//        if (board[x - 1][y - 1] != '\0') {
//            throw new RuntimeException("Box is occupied");
//        } else {
//            board[x - 1][y - 1] = lastPlayer;
//        }
//    }

    private void setBox(TicTacToeBean bean) {
        if (board[bean.getX() - 1][bean.getY() - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[bean.getX() - 1][bean.getY() - 1] = lastPlayer;
            if (!getTicTacToeCollection().saveMove(bean)) {
                throw new RuntimeException("Saving to DB failed");
            }
//            getTicTacToeCollection().saveMove(bean);
        }
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("X is outside board");
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

    public TicTacToeCollection getTicTacToeCollection() {
        return ticTacToeCollection;
    }
}
