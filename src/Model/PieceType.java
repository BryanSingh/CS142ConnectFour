package Model;

import java.awt.*;

public enum PieceType
{
	RED ("RED"),
	BLACK ("BLACK"),
	GREEN ("GREEN"),
	YELLOW ("YELLOW");

    private String type;

    private PieceType(String type) 
    {
    	this.type = type;
    }
    
    public String getType()

    {
    	return this.type;
    }

    public Color getColor() {
        if (type.equals("RED")) {
            return Color.RED;
        } else if (type.equals("GREEN")) {
            return Color.GREEN;
        } else if (type.equals("YELLOW")) {
            return Color.YELLOW;
        } else {
            return Color.BLACK;
        }
    }
}