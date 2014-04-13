package com.clinkworks.example.tictactoe.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class MoveUnitTests {

	@Test
	public void equalsOnTwoIdenticalMovesReturnsTruthy(){
		assertTrue(new Move(0, 0, 1).equals(new Move(0, 0, 1)));
	}
	
	@Test
	public void hashCodesOnTwoIdenticalMovesAreTheSame(){
		assertTrue(new Move(0, 0, 1).hashCode() == new Move(0,0,1).hashCode());
	}
	
	@Test
	public void meetsCollectionsAPIHashStandards(){
		Set<Move> moveSet = new HashSet<Move>();
		
		moveSet.add(new Move(0, 0, 1));
		moveSet.add(new Move(0, 0, 1));
		
		assertEquals(1, moveSet.size());
	}
}
