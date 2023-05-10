package vista;

import javax.swing.*;
import java.awt.*;

public class GUI_INI extends JFrame{
    private ImageIcon imageIcon;
    private JLabel jLabel;
    private JPanel jPanel;
    private FondoPanel fondoPanel;

    public GUI_INI(){

        inicio();

        this.setTitle("Menú");
        this.setUndecorated(true);
        this.setBackground(new Color(255,255,255,0)); //Quita el fondo de la ventana tiene que estar despues de  setUndecorated y antes de para que funcione
        this.pack();
        this.setSize(new Dimension(760,500));
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//
    private void inicio() {
        fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_Icon("/recursos/bgMainMenu.png");
        this.setContentPane(fondoPanel);
    }


}