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

    public PanelGameView(Dimension dim) {
        super(null);
        this.gameDim = dim;
        this.setPreferredSize(gameDim);
        this.setSize(gameDim);
        this.setMinimumSize(gameDim);
        System.out.println("Max size:\t" + this.getSize().getHeight());

    }

    @Override
    public void paintComponent(Graphics g) {
        this.setSize(gameDim);
        for (int y = 0; y < this.getSize().getHeight(); y+=150) {
            g.drawLine(0, y, (int)this.getSize().getWidth(), y);
            System.out.println(y + "\t max: " + (int)this.getSize().getHeight());
        }
    }


}
