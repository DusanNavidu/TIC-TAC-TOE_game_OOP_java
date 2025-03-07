package com.assignment.tictactoe;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;

public class BoardController implements BoardUI {

    @FXML
    private Button btn00;

    @FXML
    private Button btn01;

    @FXML
    private Button btn02;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn12;

    @FXML
    private Button btn20;

    @FXML
    private Button btn21;

    @FXML
    private Button btn22;

    @FXML
    private GridPane gridPane;

    @FXML
    private Label lblUser;

    @FXML
    private Label lblWin;

    @FXML
    private JFXButton btnReplay;

    Board board;
    HumanPlayer humanPlayer;
    AIPlayer aiPlayer;

    @FXML
    public void initialize() {
        board = new BoardImpl(this);
        humanPlayer = new HumanPlayer(board);
        aiPlayer = new AIPlayer(board,this);
    }
    @FXML
    void btn00OnAction(ActionEvent event) {
        update(0,0,true);
        humanPlayer.move(0,0);
        aiPlayer.move(-1,-1);
    }

    @FXML
    void btn01OnAction(ActionEvent event) {
        update(0,1,true);
        humanPlayer.move(0,1);
        aiPlayer.move(-1,-1);
    }

    @FXML
    void btn02OnAction(ActionEvent event) {
        update(0,2,true);
        humanPlayer.move(0,2);
        aiPlayer.move(-1,-1);
    }

    @FXML
    void btn10OnAction(ActionEvent event) {
        update(1,0,true);
        humanPlayer.move(1,0);
        aiPlayer.move(-1,-1);
    }

    @FXML
    void btn11OnAction(ActionEvent event) {
        update(1,1,true);
        humanPlayer.move(1,1);
        aiPlayer.move(-1,-1);
    }

    @FXML
    void btn12OnAction(ActionEvent event) {
        update(1,2,true);
        humanPlayer.move(1,2);
        aiPlayer.move(-1,-1);
    }

    @FXML
    void btn20OnAction(ActionEvent event) {
        update(2,0,true);
        humanPlayer.move(2,0);
        aiPlayer.move(-1,-1);
    }

    @FXML
    void btn21OnAction(ActionEvent event) {
        update(2,1,true);
        humanPlayer.move(2,1);
        aiPlayer.move(-1,-1);
    }

    @FXML
    void btn22OnAction(ActionEvent event) {
        update(2,2,true);
        humanPlayer.move(2,2);
        aiPlayer.move(-1,-1);
    }
    @FXML
    void btnReplayOnAction(ActionEvent event) {
        Button[][] button = new Button[][]{{btn00,btn01,btn02},{btn10,btn11,btn12},{btn20,btn21,btn22}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setText("");
                BoardImpl.pieces[i][j] = Piece.Empty;
                setDisableBoard(false);
                lblWin.setText("");
            }
        }
    }

    @Override
    public void update(int row, int column, boolean isHuman) {
        Button button = getButton(row, column);


        if (button != null) {
            button.setFont(new Font("Arial", 72));
            if (isHuman) {
                button.setText("X");
                button.setTextFill(Color.BLUE);
            } else {
                button.setText("O");
                button.setTextFill(Color.RED);
            }
            button.setDisable(true);
        }
    }

    private Button getButton(int row, int column) {
        if (row == 0) {
            if (column == 0) return btn00;
            else if (column == 1) return btn01;
            else if (column == 2) return btn02;
        } else if (row == 1) {
            if (column == 0) return btn10;
            else if (column == 1) return btn11;
            else if (column == 2) return btn12;
        } else if (row == 2) {
            if (column == 0) return btn20;
            else if (column == 1) return btn21;
            else if (column == 2) return btn22;
        }
        return null;
    }

    @Override
    public void notifyWinner( ) {
        Winner winner = board.checkWinner();
        String win;
        if (winner != null) {
            win = String.valueOf(winner.winningPiece);
            if (win == "O") {
                System.out.println("Ai is win");
                lblWin.setText("WON THE AI PLAYER 😒😒");
                setDisableBoard(true);
            } else if (win == "X") {
                System.out.println("Human is win");
                setDisableBoard(true);
                lblWin.setText("YOU ARE WON 😏🥱 ");
            } else {
                System.out.println("Tie");
                setDisableBoard(true);
                lblWin.setText("GAME IS TIE 😑😑");
            }
        }
    }

    public void setDisableBoard(Boolean isDisable){
        Button[][] button = new Button[][]{{btn00,btn01,btn02},{btn10,btn11,btn12},{btn20,btn21,btn22}};
        if (isDisable) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    button[i][j].setDisable(true);
                }
            }
        }
        if (!isDisable) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    button[i][j].setDisable(false);
                }
            }
        }
    }
}
