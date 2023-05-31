package View;

import com.fasterxml.jackson.core.io.MergedStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;
import java.io.File;

public class LoadPanel extends JPanel {

    JLabel lbl;

    /**
     * Create the panel.
     */
    public LoadPanel() {

        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        this.setBounds(100, 100, 600, 320);
        try {

            JLabel picLabel=new JLabel(new ImageIcon(new File("Resources/Loading_icon.gif").toURL()));

            picLabel.setBounds(0, 153, 100, 100);
            add(picLabel);
        }catch (Exception e){
            e.printStackTrace();
        }
        lbl = new JLabel("");
        lbl.setBounds(100, 153, 312, 14);
        this.add(lbl);

    }

    public void setLbl(String txt) {
        this.lbl.setText(txt);
    }

}