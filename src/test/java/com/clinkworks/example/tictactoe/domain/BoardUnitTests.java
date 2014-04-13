package com.clinkworks.example.tictactoe.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardUnitTests {
	private Board board;
	
	@Before
	public void initBoard(){
		board = new Board(2, 5); //two player 5 by 5 game.
	}
	
	@Test(expected = IllegalStateException.class)
	public void ensureThatAMoveCanOnlyBeMadeOnce(){
		board.play(0, 0);
		board.play(0, 0);
	}
	
	@Test
	public void ensureTurnRotationIsKept(){
		board.play(0, 0);
		assertEquals(2, board.getCurrentPlayer());
		board.play(0, 1);
		assertEquals(1, board.getCurrentPlayer());	
	}
	
	@Test
	public void ensurePlayerCanWinAcross(){
		board.play(new Move(0, 0, 1));
		board.play(new Move(0, 1, 1));
		board.play(new Move(0, 2, 1));
		
		assertEquals("Player 1", board.whoWon());
	}
	
	@Test
	public void ensurePlayerCanWinDiagnal(){
		board.play(new Move(0, 0, 1));
		board.play(new Move(1, 1, 1));
		board.play(new Move(2, 2, 1));
		
		assertEquals("Player 1", board.whoWon());
	}
	
	@Test
	public void ensurePlayerCanWinOtherDiagnal(){
		board.play(new Move(4, 4, 1));
		board.play(new Move(3, 3, 1));
		board.play(new Move(2, 2, 1));
		assertEquals("Player 1", board.whoWon());
	}

	
}
