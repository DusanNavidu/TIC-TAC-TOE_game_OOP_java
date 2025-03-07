package com.assignment.tictactoe;

import java.util.Random;

public class AIPlayer extends Player {
    Random random;
    BoardController boardController;

    public AIPlayer(Board board, BoardController boardController) {
        super(board);
        this.boardController = boardController;
    }

    @Override
    public void move(int row, int col) {
        int[] bestMove = findBestMove();
        System.out.println("AI Move: " + bestMove[0] + " " + bestMove[1]);
        try {
            if (bestMove[0] != -1 && bestMove[1] != -1 ) {
                board.updateMove(bestMove[0], bestMove[1], Piece.O);
                boardController.update(bestMove[0], bestMove[1], false);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public int minimax(Piece[][] currentBoard, int depth, boolean isMaximizing) {
        Winner winner = board.checkWinner();

        if (winner != null) {
            if (winner.winningPiece == Piece.O) return 10 - depth;
            if (winner.winningPiece == Piece.X) return depth - 10;
            if (winner.winningPiece == Piece.Empty) return 0;
        }

        if (isMaximizing) {  // AI's turn
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (currentBoard[i][j] == Piece.Empty) {
                        currentBoard[i][j] = Piece.O;
                        int score = minimax(currentBoard, depth + 1, false);
                        currentBoard[i][j] = Piece.Empty;
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {  // Opponent's turn
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (currentBoard[i][j] == Piece.Empty) {
                        currentBoard[i][j] = Piece.X;
                        int score = minimax(currentBoard, depth + 1, true);
                        currentBoard[i][j] = Piece.Empty;
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    public int[] findBestMove() {
        int bestValue = Integer.MIN_VALUE;
        int[] bestMove = new int[]{-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (BoardImpl.pieces[i][j] == Piece.Empty) {
                    BoardImpl.pieces[i][j] = Piece.O;
                    int moveValue = minimax(BoardImpl.pieces, 0, false);
                    BoardImpl.pieces[i][j] = Piece.Empty;
                    if (moveValue > bestValue) {
                        bestMove = new int[]{i,j};
                        bestValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }
}
