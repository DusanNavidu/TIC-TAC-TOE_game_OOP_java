package com.assignment.tictactoe;

public interface BoardUI {
    void update(int column, int row, boolean isHuman);
    void notifyWinner();
}
