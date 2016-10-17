package Model;

public class ComputerPlayer extends Player
{
	public ComputerPlayer(String name, PieceType type)
	{
		super(name, type);
	}

	public int nextMove()
	{
		return 0;
	}
}