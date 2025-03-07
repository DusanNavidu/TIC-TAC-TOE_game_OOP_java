package com.assignment.tictactoe;

public class BoardImpl implements Board{

    public static Piece[][] pieces ;
    public BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces = new Piece[3][3];
        initializeBoard();
    }

    @Override
    public BoardUI getBoardUi() {
        return null;
    }

    @Override
    public void initializeBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pieces[i][j] = Piece.Empty;
            }
        }
    }

    @Override
    public boolean isLegalMove(int row, int col) {
        boolean isLegal = false;
        if(row < 0 || row >= 3 || col < 0 || col >= 3) {
            return isLegal;
        }
        isLegal = pieces[row][col] == Piece.Empty;
        return isLegal;
    }

    @Override
    public void updateMove(int row, int col, Piece piece){
        if (isLegalMove(row, col)) {
            pieces[row][col] = piece;
        }
        if (piece == Piece.X){
            System.out.println("Human move");
        } else if (piece == Piece.O) {
            System.out.println("Ai move");
        }
        System.out.println();
        printBoard();
        checkWinner();
        boardUI.notifyWinner();
    }
    @Override
    public Winner checkWinner() {
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i][0] != Piece.Empty && pieces[i][0] == pieces[i][1] && pieces[i][1] == pieces[i][2]) {
                return new Winner(pieces[i][0]);
            }
        }

        for (int i = 0; i < pieces.length; i++) {
            if (pieces[0][i] != Piece.Empty && pieces[0][i] == pieces[1][i] && pieces[1][i] == pieces[2][i]) {
                if (true) {
                }
                return new Winner(pieces[0][i]);
            }
        } if (pieces[0][0] != Piece.Empty && pieces[0][0] == pieces[1][1] && pieces[1][1] == pieces[2][2]) {
            if (true) {
            }
            return new Winner(pieces[0][0]);
        } if (pieces[0][2] != Piece.Empty && pieces[0][2] == pieces[1][1] && pieces[1][1] == pieces[2][0]) {
            if (true) {
            }
            return new Winner(pieces[0][2]);
        }
        boolean boardFull = true;
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.Empty) {
                    boardFull = false;
                    break;
                }
            }
        }
        if (boardFull) {
            if (true) {
            }

            return new Winner(Piece.Empty);
        }
        return null;
    }
    public  void printBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(pieces[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checkWin(Piece player) {
        for (int i = 0; i < 3; i++) {
            if ((pieces[i][0] == player && pieces[i][1] == player && pieces[i][2] == player) ||
                    (pieces[0][i] == player && pieces[1][i] == player && pieces[2][i] == player)) {
                return true;
            }
        }
        return (pieces[0][0] == player && pieces[1][1] == player && pieces[2][2] == player) ||
                (pieces[0][2] == player && pieces[1][1] == player && pieces[2][0] == player);
    }
}

