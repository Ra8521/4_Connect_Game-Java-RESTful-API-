package com.connect4.Game4.resource;

import com.connect4.Game4.model.GameBoard;

public class CheckWinner {
	
	
	/**
	 * check for for ward and backward diagonal
	 * vertical
	 * horizontal
	 * @return 
	 */
	
	/*forward diagonal   (i+1,j+1) and (i-1,j-1)*/
	
	
	public static boolean  check(GameBoard gameboard, int colid)
	{
		if(horizontal(gameboard,colid) || vertical(gameboard,colid)|| diagonal(gameboard,colid))
		{
			return true;
		}
		return false;
	}
	
	
	static boolean horizontal( GameBoard gameboard, int colid)
	{
	
		int turn = gameboard.getTurn();
		int rowid = gameboard.getBoard().get(colid).getRowId();
		int colid1 = colid;
		int colid2 = colid;
		int count=0;
		if(colid==4) {
			
		/* left */
		while(colid1>0 && gameboard.getTrace().get(rowid).get(colid)==turn)
		{
			count++;
			colid1--;
			if(count==4)
				return true;
		}
		count=0;
		/*right*/
		while(colid1<=7 && gameboard.getTrace().get(rowid).get(colid)==turn)
		{
			count++;
			colid2++;
			if(count==4)
				return true;
		}
		return false;
		}
		return false;
		
		
	}
	
	static boolean vertical( GameBoard gameboard, int colid)
	{
		int rowid = gameboard.getBoard().get(colid).getRowId();
		int turn = gameboard.getTurn();
		int count=0;
		if(rowid>=4)
		{
			while(rowid>0 && gameboard.getTrace().get(rowid).get(colid)==turn)
			{
				rowid--;
				count++;
				if(count==4)
				{
					return true;
				}
			}
			
			return false;
		}
		
		
		return false;
		
	}
	
	
	static boolean  diagonal( GameBoard gameboard, int colid)
	{
		int rowid = gameboard.getBoard().get(colid).getRowId();
		int turn = gameboard.getTurn();
		int count=0;
		int rowid1=rowid;
		int colid1=colid;
		int rowid2=rowid;
		int colid2=colid;
		if(colid==4)
		{
			/*left diagonal */
			while(colid1>0 && rowid1>0 && gameboard.getTrace().get(rowid).get(colid)==turn)
			{
				rowid1--;
				colid1--;
				count++;
				if(count==4)
				{
					return true;
				}
			}
			count=0;
			/* right diagonal */
			while(colid2<=7 && rowid2>0 && gameboard.getTrace().get(rowid).get(colid)==turn)
			{
				rowid2--;
				colid2++;
				count++;
				if(count==4)
				{
					return true;
				}
			}
			return false;
		}
		return false;
		
	}
	

}
