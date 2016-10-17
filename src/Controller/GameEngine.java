package Controller;

import java.util.Random;
import java.util.Vector;

import View.*;
import Model.*;

public class GameEngine 
{
	private Vector<Player> myPlayers;
	private Player myPlayerUp;
	private Player myStartingPlayer;
	private GameBoard myGameBoard;
  
	public GameEngine(Player player) {
		myPlayers = new Vector<Player>();
		myPlayers.add(player);
		myPlayers.add(new ComputerPlayer("Computer Player", PieceType.BLACK));

	}

	public boolean selectStartingPlayer()
	{
		Random random = new Random();
		int select = random.nextInt(2);
		myStartingPlayer = myPlayers.get(select);
		if (myStartingPlayer == myPlayers.get(select)) {
			return true;
		}
		return false;
	}

	public boolean startGame() {
		return false;
	}
	
	public Player switchPlayerUp() 
	{
		myPlayerUp = myPlayers.get((myPlayers.indexOf(myPlayerUp) + 1)%2);
		return myPlayerUp;
	}

	public boolean placePiece(int column)
	{
		return false;
	}

	public Player getPlayerUp() 
	{
		return null;
	}
	
	public Player getStartingPlayer()
	{
		return myStartingPlayer;
	}

	public Vector<Player> getPlayers()
	{
		return null;
	}
  
	public void setGameBoard(GameBoard gameboard)
	{

	}

	public GameBoard getGameBoard()
	{
		return null;
	}


}