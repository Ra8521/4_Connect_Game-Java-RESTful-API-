package com.connect4.Game4.model;

public class Cell {
	
	private int colId;
	private int rowId;
	private int turn;
	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public Cell(int colId, int rowId) {
		super();
		this.colId = colId;
		this.rowId = rowId;
	}
	
	public int getColId() {
		return colId;
	}
	public void setColId(int colId) {
		this.colId = colId;
	}
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	

}
