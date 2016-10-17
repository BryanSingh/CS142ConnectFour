package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import View.gameBoard;
import java.util.Vector;

/**
 * Created by hanspistor on 10/16/16.
 */
public class PanelGameView extends JPanel {

    public Vector<Piece> shapesToDraw;
    private gameBoard gameBoard;
    private PieceType[][] gameMatrix;
    private Dimension gameDim;
    private final int XOFFSET = 100;
    private final int YOFFSET = 100;
    private JButton[] buttons;


    public PanelGameView(Dimension dim, gameBoard gameBoard) {
        super(null);
        this.gameBoard = gameBoard;
        this.gameMatrix = gameBoard.getGameMatrix();
        shapesToDraw = new Vector<Piece>();
        buttons = new JButton[6*7];
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
                int row = -1;
                int x = XOFFSET + col * 100 + 50;
                for (int i = 0; i < gameMatrix[0].length; i++) {
                    if (gameMatrix[i][col] == null) {
                        row = i;
                        break;
                    }
                }
                if (row < 0) {

                    return;
                }
                int y = YOFFSET + row*100 + 50;
                System.out.println("row, col : ("+ row +", " + col + ")");
                System.out.println("x, y : (" + x +", " + y +")");
                shapesToDraw.add(new Piece(x, y, 2, col, ));
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
            g.fillOval(p.x, p.y, p.diameter, p.diameter);
        }
    }

    class Piece {

        public int row, col, diameter, x, y;
        public Player player;

        public Piece(int x, int y, int row, int col, Player player) {
            this.x=x;
            this.y=y;
            this.row = row;
            this.player = player;
            this.col = col;
            this.diameter = 100;
        }

    }


}
