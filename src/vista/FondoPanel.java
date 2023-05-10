package vista;

import javax.swing.*;
import java.awt.*;

public class FondoPanel extends JPanel {
    private Image imagen;
    private String iconoImg;

    @Override
    public void paint(Graphics g) {
        imagen = new ImageIcon(getClass().getResource(get_ruta_icono())).getImage();
        g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        this.setBackground(null);
        super.paint(g);
    }

    public String get_ruta_icono() {
        return iconoImg;
    }

    public void set_ruta_Icon(String imageIcon) {
        this.iconoImg = imageIcon;
    }
}