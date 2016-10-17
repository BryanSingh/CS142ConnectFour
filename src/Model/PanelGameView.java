package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by hanspistor on 10/16/16.
 */
public class PanelGameView extends JPanel {

    private Dimension gameDim;
    private final int XOFFSET = 100;
    private final int YOFFSET = 100;
    private JButton[] buttons;

    Graphics2D g;

    public PanelGameView(Dimension dim) {
        super(null);
        buttons = new JButton[6*7];
        this.gameDim = dim;
        this.setPreferredSize(gameDim);
        this.setSize(gameDim);
        this.setMinimumSize(gameDim);



    }

    @Override
    public void paintComponent(Graphics g) {
        this.setSize(gameDim);
        this.g = (Graphics2D)g;
        for (int y = YOFFSET; y <= 600+YOFFSET; y+=100) {
            g.drawLine(XOFFSET, y, 700+XOFFSET, y);
        }

        for (int x = XOFFSET; x <= 700+XOFFSET; x+=100) {
            g.drawLine(x, YOFFSET, x, 600+YOFFSET);
        }
    }

    public void drawCircle() {
        if (g == null) {
            System.out.println("g is null");
        } else {
            g.fillOval(150, 150, 150, 150);
        }
    }


}
