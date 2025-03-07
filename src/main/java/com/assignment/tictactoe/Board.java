package com.assignment.tictactoe;

public interface Board {
    BoardUI getBoardUi();
    void initializeBoard();
    boolean isLegalMove(int row, int col);
    void updateMove(int row, int col, Piece piece);
    Winner checkWinner();
    void printBoard();

}
