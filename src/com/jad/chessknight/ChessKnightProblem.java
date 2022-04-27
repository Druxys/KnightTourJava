package com.jad.chessknight;

/**
 * The type Chess knight problem.
 */
public abstract class ChessKnightProblem {


    /**
     * Solve.
     *
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public static void solve() throws CloneNotSupportedException {
        ChessBoard chessBoard = new ChessBoard();
        ChessKnight chessKnight = new ChessKnight(chessBoard, 0, 0);

        int[] knightXMove = {2, 1, -1, -2, -2, -1, 1, 2, 2};
        int[] knightYMove = {1, 2, 2, 1, -1, -2, -2, -1, 1};

        if (!solveRecurcive(0, 0, 1, chessBoard, knightXMove, knightYMove)) {
            System.out.println("Impossible");
        } else {
            System.out.println(chessBoard);
        }

    }

    static boolean solveRecurcive(int x, int y, int movei, ChessBoard chessBoard, int[] xMove, int[] yMove) {
        int i, nextX, nextY;
        if (movei == chessBoard.getHeight() * chessBoard.getWidth())
            return true;
        for (i = 0; i < chessBoard.getHeight(); i++) {
            nextX = x + xMove[i];
            nextY = y + yMove[i];
            if (nextX >= 0 && nextX < chessBoard.getWidth() && nextY >= 0 && nextY < chessBoard.getHeight() && chessBoard.getAt(nextX, nextY).getValue() == 0) {
                chessBoard.putAt(nextX, nextY, new Square(movei + 1));
                if (solveRecurcive(nextX, nextY, movei + 1,
                        chessBoard, xMove, yMove))
                    return true;
                else {
                    chessBoard.putAt(nextX, nextY, new Square(0));
                }

            }
        }

        return false;
    }
}
