package View;

import com.fasterxml.jackson.core.io.MergedStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;
import java.io.File;

public class LoadPanel extends JPanel {

    /**
     * Etichetta per l'azione in caricamento
     */
    private JLabel lbl;

    /**
     * Costruttore del pannello di caricamento
     */
    public LoadPanel() {

        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        this.setBounds(100, 100, 600, 320);
        lbl = new JLabel("");
        lbl.setBounds(200, 140, 312, 20);
        this.add(lbl);

    }

    /**
     * Metodo per cambiare la frase dell'etichetta
     * @param txt Stringa da cambiare nell'etichetta
     */
    public void setLbl(String txt) {
        this.lbl.setText(txt);
    }

}