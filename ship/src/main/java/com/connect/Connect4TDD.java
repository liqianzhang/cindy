package com.connect;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.connect.Connect4.COLUMNS;
import static com.connect.Connect4.ROWS;

/**

 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
*/
public class Connect4TDD {

    private final PrintStream outputChannel;
    private String[][] board =
            new String[ROWS][COLUMNS];

    private static final String EMPTY = " ";

    public Connect4TDD(PrintStream out) {
        outputChannel = out;
        for (String[] row : board) {
            Arrays.fill(row, EMPTY);
        }
    }

    public int putDiscInColumn(int column) {
        checkColumn(column);
        int row = getNumberOfDiscsIncolumn(column);
        checkPositionToInsert(row, column);
        board[row][column] = "R";
        printBoard();
        switchPlayer();
        return row;
    }

    private void printBoard() {
        for (int row = ROWS - 1; row >= 0; row--) {
            StringJoiner stringJoiner = new StringJoiner(DELIMITER,
                    DELIMITER,
                    DELIMITER);
            Stream.of(board[row]).
                    forEachOrdered(stringJoiner::add);
            outputChannel
                    .println(stringJoiner.toString());

        }
    }

    private void switchPlayer() {
        if (RED.equals(currentPlayer)) {
            currentPlayer = GREEN;
        } else {
            currentPlayer = RED;
        }
    }

    private void checkPositionToInsert(int row, int column) {
        if (row == ROWS) {
            throw new RuntimeException(
                    "No more room in column " + column);

        }
    }

    public int getNumberOfDiscs() {
        return IntStream.range(0 ,COLUMNS)
                .map(this::getNumberOfDiscsIncolumn).sum();
    }

    private int getNumberOfDiscsIncolumn(int column) {

                return (int) IntStream.range(0, ROWS)
                .filter(row -> !EMPTY
                        .equals(board[row][column]))
                        .count();
    }

    private void checkColumn(int column) {
        if (column < 0 || column >= COLUMNS) {
            throw new RuntimeException("Invalid column " + column);
        }
    }

    private static final String RED = "R";

    private static final String GREEN = "G";

    private String currentPlayer = RED;

    private static final String DELIMITER = "|";

    public Object getCurrentPlayer() {
        outputChannel.printf("Player %s turn%n", currentPlayer);
        return currentPlayer;
    }

    public boolean isFinished() {
        return getNumberOfDiscs() == ROWS * COLUMNS;
    }

    public void getWinner() {

    }
}
