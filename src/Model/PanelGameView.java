package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Created by hanspistor on 10/16/16.
 */
public class PanelGameView extends JPanel {


    private PieceType[][] gameMatrix;
    private Vector<Player> players;
    private Player playerUp;
    public Vector<Piece> shapesToDraw;
    private Dimension gameDim;


    private final int XOFFSET = 100;
    private final int YOFFSET = 100;
    private int rows = 6;
    private int columns = 7;
    private final int SIZE = 100;
    private int maxDistanceX;
    private int maxDistanceY;

    public PanelGameView(Dimension dim) {
        this(dim, 6, 7);
    }

    public PanelGameView(Dimension dim, int rows, int columns) {
        super(null);
        this.rows = rows;
        this.columns = columns;
        this.maxDistanceX = XOFFSET + (SIZE * columns);
        this.maxDistanceY = YOFFSET + (SIZE * rows);
        Dimension gameDim = new Dimension(150 * rows, 150 * columns);
        gameMatrix = new PieceType[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                gameMatrix[i][j] = null;
            }
        }
        Player player = new Player("Player", PieceType.RED);
        shapesToDraw = new Vector<Piece>();
        players = new Vector<Player>();
        players.add(player);
        players.add(new ComputerPlayer("Computer Player", PieceType.BLACK));
        playerUp = player;

        this.gameDim = dim;
        this.setPreferredSize(gameDim);
        this.setSize(gameDim);
        this.setMinimumSize(gameDim);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Mouse clicked at: " + e.getX() +", " + e.getY());
                if (e.getX() < XOFFSET || e.getX() > maxDistanceX || e.getY() < YOFFSET || e.getY() > maxDistanceY) {
                    return;
                }
                int col = getCol(e.getX());
                System.out.println("Check 1");
                int row = -1;
                int x = XOFFSET + (col * 100);
                for (int i = 0; i < rows; i++) {
                    System.out.println("row " + i);
                    if (gameMatrix[i][col] == null) {
                        row = i;
                        gameMatrix[row][col] = getPlayerUp().getPieceType();
                        break;
                    }
                }
                System.out.println("Check 2");
                if (row < 0) {

                    return;
                }
                int y = (YOFFSET + 500) -  row*100;
                System.out.println("row, col : ("+ row +", " + col + ")");
                System.out.println("x, y : (" + x +", " + y +")");
                shapesToDraw.add(new Piece(x, y, 2, col, getPlayerUp().getPieceType()));
                repaint();
                switchPlayer();
            }
        });
    }

    private int getCol(int x) {
        int col = 0;
        for (int i = XOFFSET; i <= maxDistanceX; i+=100) {
            if (x > i) {
                col++;
            } else {
                col--;
                break;
            }
        }
        return col;
    }

    @Override
    public void paintComponent(Graphics g) {
        this.setSize(gameDim);
        for (int y = YOFFSET; y <= maxDistanceY; y+=100) {
            g.drawLine(XOFFSET, y, maxDistanceX, y);
        }

        for (int x = XOFFSET; x <= maxDistanceX; x+=100) {
            g.drawLine(x, YOFFSET, x, maxDistanceY);
        }

        for (Piece p: shapesToDraw) {
            g.setColor(p.type.getColor());
            g.fillOval(p.x, p.y, p.diameter, p.diameter);
        }
    }

    public Player getPlayerUp() {
        return playerUp;
    }

    public PieceType[][] getGameMatrix() {
        return this.gameMatrix;
    }

    public void switchPlayer() {
        System.out.println(playerUp.getName());
        playerUp = players.get((players.indexOf(playerUp) + 1 ) % 2);
        System.out.println(playerUp.getName());
    }


    class Piece {

        public int row, col, diameter, x, y;
        public PieceType type;

        public Piece(int x, int y, int row, int col, PieceType type) {
            this.x=x;
            this.y=y;
            this.row = row;
            this.type = type;
            this.col = col;
            this.diameter = 100;
            System.out.println(type.getColor());
            System.out.println(type.getType());
        }

    }





}
