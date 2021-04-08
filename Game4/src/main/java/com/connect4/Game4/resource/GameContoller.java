package com.connect4.Game4.resource;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.connect4.Game.Exception.GameException;
import com.connect4.Game4.model.Cell;
import com.connect4.Game4.model.GameBoard;

@RestController
public class GameContoller {
	
	GameBoard gameboard;
	
	
	@GetMapping("/START")
	public String getBoard() throws GameException
	{
		
		if(gameboard==null)
		{
			gameboard = GameBoard.getInstance();
		}
		else
		{
			reset();
		}
		return "Ready";
	}
   
	@GetMapping("/{colId}")
	public String update(@PathVariable(value = "colId") Integer colid) throws GameException
	{
		if(colid<=7)
		{
			if(gameboard.getBoard().get(colid).getRowId()<=6)
			{
				int rowid = gameboard.getBoard().get(colid).getRowId();
				int turn = gameboard.getTurn();
				gameboard.getTrace().get(rowid).set(colid, turn);
				if(CheckWinner.check(gameboard, colid))
				{
					reset();
					return ("Winner :"+turn);
				}
				gameboard.getBoard().get(colid).setRowId(rowid+1);
				
				gameboard.getBoard().get(colid).setTurn(turn);
			   gameboard.setTurn(turn==1?2:1);
				
				return "valid";
			}
			else
			{
				return "Invalid";
			}
		}
		else
		{
			return "invalid";
		}
	}
	
	
	@GetMapping("/Board")
	public ArrayList<Cell> printBoard() throws GameException
	{
		
		return gameboard.getBoard();
	}
	
	@GetMapping("/board")
	public ArrayList<ArrayList<Integer>> board()
	{
		return gameboard.getTrace();
	}
	

	private void reset() throws GameException{
		// TODO Auto-generated method stub
		for(Cell a: gameboard.getBoard())
		{
			a.setRowId(1);
		}
	}
	

}
