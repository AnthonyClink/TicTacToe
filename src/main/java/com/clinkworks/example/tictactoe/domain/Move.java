package com.clinkworks.example.tictactoe.domain;

import org.apache.commons.lang3.ObjectUtils;

public class Move {
    private final int row;
    private final int column;
    private final Integer player;
    private final int hashCode;
    
    public Move(int row, int column){
    	this.row = row;
    	this.column = column;
    	this.player = -1;
    	hashCode = ObjectUtils.hashCodeMulti(row, column, player);
    }
    
    public Move(int row, int column, int player) {
        this.row = row;
        this.column = column;
        this.player = player;
        hashCode = ObjectUtils.hashCodeMulti(row, column, player);
    }
 
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Integer getPlayer(){
    	return player;
    }
    
    @Override
    public boolean equals(Object object){
    	if(!(object instanceof Move)){
    		return false;
    	}
    	
    	Move move = (Move)object;
    	boolean equals = getColumn() == move.getColumn();
    	equals = equals && getRow() == move.getRow();
    	equals = equals && getPlayer() == move.getPlayer();
    	
    	return equals;
    }
 
    @Override
    public int hashCode(){
    	return hashCode;
    }
    
    @Override
    public String toString(){
    	return "(" + getRow() + ", " + getColumn() + ") - Player " + getPlayer();
    }
}