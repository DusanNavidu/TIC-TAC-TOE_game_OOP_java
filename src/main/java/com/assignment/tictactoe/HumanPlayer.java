package com.assignment.tictactoe;

public class HumanPlayer extends Player {

    public HumanPlayer(Board board) {
        super(board);
    }

    @Override
    public void move(int row, int col) {
        if(row != -3 && col != -3) {
            board.updateMove(row,col,Piece.X);
        }
    }
}
