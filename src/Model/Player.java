package Model;

import Model.PieceType;

import java.util.regex.Pattern;

import static sun.rmi.transport.TransportConstants.Version;

public class Player 
{
	public static final String DEFAULT_NAME = "JohnCena";
	private String myName;
	private int myNumWins;
	private PieceType myPieceType;

	public Player(String name, PieceType type)
	{
	    myName = name;
        myPieceType = type;
        myNumWins = 0;
	}

	private boolean validateName(String name) 
	{
		if(name.matches("^[^\\d\\s]+$")) {
			System.out.print("Yes");
			// The string is not valid.
			return true;
		} else {
			// The string is not valid.
			System.out.print("No");
			return false;
		}
	}

	public void incrementScore() 
	{
	 myNumWins++;
	}
	
	public PieceType getPieceType()

	{
		return myPieceType;
	}

	public String getName() 
	{
		return myName;
	}

	public int getNumWins()
	{
		return myNumWins;
	}
	
	public int getScore()
	{
		return myNumWins;
	}
}