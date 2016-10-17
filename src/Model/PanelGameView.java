package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import View.GameBoard;
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
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private JButton[] buttons;


    public PanelGameView(Dimension dim) {
        super(null);
        Dimension gameDim = new Dimension(150 * ROWS , 150 * COLUMNS);
        gameMatrix = new PieceType[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                gameMatrix[i][j] = null;
            }
        }
        shapesToDraw = new Vector<Piece>();
        buttons = new JButton[6*7];
        players = new Vector<Player>();
        this.gameDim = dim;
        this.setPreferredSize(gameDim);
        this.setSize(gameDim);
        this.setMinimumSize(gameDim);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Mouse clicked at: " + e.getX() +", " + e.getY());
                if (e.getX() < XOFFSET || e.getX() > 700+XOFFSET || e.getY() < YOFFSET || e.getY() > 600+YOFFSET) {
                    return;
                }
                int col = getCol(e.getX());
                System.out.println("Check 1");
                int row = -1;
                int x = XOFFSET + (col * 100);
                System.out.println(col);
                for (int i = 0; i < ROWS; i++) {
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
        for (int i = XOFFSET; i <= 700+XOFFSET; i+=100) {
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
        for (int y = YOFFSET; y <= 600+YOFFSET; y+=100) {
            g.drawLine(XOFFSET, y, 700+XOFFSET, y);
        }

        for (int x = XOFFSET; x <= 700+XOFFSET; x+=100) {
            g.drawLine(x, YOFFSET, x, 600+YOFFSET);
        }

        for (Piece p: shapesToDraw) {
            g.setColor(p.type.getColor());
            g.fillOval(p.x, p.y, p.diameter, p.diameter);
        }
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


}
