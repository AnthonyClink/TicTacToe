package com.clinkworks.example.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clinkworks.example.tictactoe.domain.Board;
import com.clinkworks.example.tictactoe.domain.Move;

public class TicTacToe {
	
    private static final String TIE = "TIE";
    
    private static final Map<String, Integer> gamesToWinsMap = new HashMap<String, Integer>();

	
    /**
     * accepts input in the following format:
     * 
     * playerCount rowCount columnCount (sets the game with the n players, n columns, and n rows
     * PlayerCount squareSize (defaults to a game with rows and cols the same as squareSize and the player count given)
     * PlayerCount (defaults to a 3 by 3 game)
     * no input (defaults to a 3 by 3 game with 2 players)
     * 
     * @param args
     */
    public static void main(String[] args) {

    	int playerCount = 2;
    	int rows = 3;
    	int cols = 3;
    	
    	if(args.length == 3){
    		playerCount = Integer.valueOf(args[0]);
    		rows = Integer.valueOf(args[1]);
    		cols = Integer.valueOf(args[2]);
    	}
    	
    	if(args.length == 2){
    		playerCount = Integer.valueOf(args[0]);
    		rows = Integer.valueOf(args[1]);
    		cols = rows;
    	}
    	
    	for(int i = 1; i <= playerCount; i++){
    		gamesToWinsMap.put("Player" + i, 0);
    	}
    	
    	//lets play 100 games and see the wins and ties
        playGames(100, playerCount, rows, cols);

        System.out.println("Played 100 games:");
        
        for(int i = 1; i <= playerCount; i++){
        	System.out.println("Number wins by Player " + i + ": " + gamesToWinsMap.get("Player " + i));
        }
        
        System.out.println("Number of ties: " + gamesToWinsMap.get(TIE));
    }
    


    public static void playGames(int gamesToPlay, int playerCount, int rows, int cols) {
    	//play a new game each iteration, in our example, count = 100;
        for (int i = 0; i < gamesToPlay; i++) {
            playGame(playerCount, rows, cols);
        }
    }

    public static void playGame(int playerCount, int rows, int cols) {
    	//create a new game board. this initalizes our 2d array and lets the complexity of handling that
    	// array be deligated to the board object.
    	

        Board board = new Board(playerCount, rows, cols);

        //we are going to generate a random list of moves. Heres where we are goign to store it
        List<Move> moves = new ArrayList<Move>();

        //we are creating moves for each space on the board.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                moves.add(new Move(row, col));
            }
        }

        //randomize the move list
        Collections.shuffle(moves);

        //do each move
        for (Move move : moves) {
            board.play(move.getRow(), move.getColumn());
            
            if(gameOver(board)){
            	break;
            }
        }
    }
    
    public static boolean gameOver(Board board){
        if (board.whoWon() != null) {
            System.out.println("\n" + board.whoWon() + " won the game!");
            System.out.println("Wining move: " + board.getWinningMove());
            System.out.println(board);
            
            Integer winCount = gamesToWinsMap.get(board.whoWon());
            winCount = winCount == null ? 1 : winCount + 1;
            
            gamesToWinsMap.put(board.whoWon(), winCount);
        
            return true;
            
        } else if (board.movesLeft() == 0) {
            
            Integer tieCount = gamesToWinsMap.get(TIE);
            tieCount = tieCount == null ? 1 : tieCount + 1;
            gamesToWinsMap.put(TIE, tieCount);
            
            return true;
        }
        
        return false;
    }
  
}
