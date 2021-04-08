package com.connect4.Game4.model;

import java.util.ArrayList;


public class GameBoard {

	private ArrayList<Cell> board;
	private ArrayList<ArrayList<Integer>> trace ;

	private int turn;
	private static GameBoard gameboard;
	
	 public static synchronized GameBoard getInstance(){
        if(gameboard == null){
        	gameboard = new GameBoard();
        	for(int i=0; i<7;i++)
        	{
        		gameboard.board = createBoard();
        		gameboard.turn = 1;
        		gameboard.trace = createTrace();
        	}
        }
        return gameboard;
	 }

	public void setTrace(ArrayList<ArrayList<Integer>> trace) {
		this.trace = trace;
	}

	
	
	public ArrayList<ArrayList<Integer>> getTrace() {
		return trace;
	}

	private static ArrayList<ArrayList<Integer>> createTrace() {
		// TODO Auto-generated method stub
		
		 ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
		 for(int i=0;i<=6;i++)
		 {
			 ArrayList<Integer> t = new ArrayList<Integer>(); 
			 temp.add(t);
			 for(int j=0;j<=7;j++)
			 {
				 temp.get(i).add(-1);
			 }
		 }
		
		return temp;
	}

	public ArrayList<Cell> getBoard() {
		return board;
	}

	public void setBoard(ArrayList<Cell> board) {
		this.board = board;
	}

	private static ArrayList<Cell> createBoard() {
		// TODO Auto-generated method stub
		ArrayList<Cell> temp = new ArrayList<>();
		for(int i=0;i<=7;i++)
		{
		   temp.add(new Cell(i,1));	
		}
		
		return temp;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	
	
	
}
