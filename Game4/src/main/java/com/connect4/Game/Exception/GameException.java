package com.connect4.Game.Exception;

public class GameException extends Exception{

	private int id;
		
		public GameException(int login_id)
		{
			super(String.format("board does not exist of this is invalis api call"));
		}

}
