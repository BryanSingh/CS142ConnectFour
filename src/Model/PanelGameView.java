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

    private BufferedImage bgImage;

    public PanelGameView(Dimension dim) {
        super(null);
        this.gameDim = dim;
        this.setPreferredSize(gameDim);
        this.setSize(gameDim);
        System.out.println("Max size:\t" + this.getSize());

    }

    @Override
    public void paintComponent(Graphics g) {
        for (int y = 0; y < gameDim.getHeight(); y+=150) {
            g.drawLine(0, y, (int)this.getSize().getWidth(), y);
            System.out.println(y + "\t max: " + (int)this.getSize().getHeight());
        }
    }


}
