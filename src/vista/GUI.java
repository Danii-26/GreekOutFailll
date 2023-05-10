package vista;

import controlador.Controlador;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GUI extends JFrame {

    private Header header;
    private JPanel jpDadosActivos, jpDadosInactivos, jpPuntos, jpDadosUsados, jpMenu;
    private JLabel[] dado, dadoPoints;
    private ImageIcon dadoImagen;
    private GridBagConstraints restricciones; // Referencias del grid
    private JButton lanzar, menu = null, atras, salir, entrar, salirFinal; // Declaracion de los botones del juego
    private Escucha listener;
    private Menu menu1;// Ventana que contiene el menu para salir del juego
    private Controlador controlador;
    private int pressed;
    private GUI_INI guiIni;
    private FondoPanel fondoPanel;


    public GUI(){


        entrarVentana();
        inicioGUI();

        this.setTitle("Greek out masta");
        this.isOpaque();

        this.setUndecorated(true);//Quita los trs botones de la ventana
        this.setBackground(new Color(255,255,255,0)); //Quita el fondo de la ventana tiene que estar despues de  setUndecorated y antes de para que funcione
        this.pack();
        this.setSize(new Dimension(750,500));
        this.setResizable(true);
        this.setVisible(false);// Oculta la ventana del juego, espera un evento que lo active
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void entrarVentana(){

        listener = new GUI.Escucha();
        guiIni = new GUI_INI();
        guiIni.getContentPane().setLayout(new GridBagLayout());//Obtiene el contenedor por defecto de la ventana y pone un layout del tipo "GridBagLayout"
        restricciones = new GridBagConstraints();//Se crea un objeto "constrain" para configurar el "GridBagLayout" cuando se esten ubicando los componetes de la ventana

        //Añado Boton a la ventana
        restricciones.gridx=0;
        restricciones.gridy=0;
        restricciones.gridwidth=1;
        restricciones.gridheight=1;// combina 13 celdas para el titulo.
        restricciones.fill=GridBagConstraints.NONE;
        restricciones.anchor=GridBagConstraints.CENTER;
        restricciones.insets = new Insets(1,0,0,0);

        entrar = new JButton("ENTRAR");
        entrar.addActionListener(listener);
        guiIni.add(entrar, restricciones);

        //Añado Boton a la ventana
        restricciones.gridx=0;
        restricciones.gridy=1;
        restricciones.gridwidth=1;
        restricciones.gridheight=1;// combina 13 celdas para el titulo.
        restricciones.fill=GridBagConstraints.NONE;
        restricciones.anchor=GridBagConstraints.CENTER;
        restricciones.insets = new Insets(100,0,0,0);

        salirFinal = new JButton("SALIR");
        salirFinal.addActionListener(listener);
        guiIni.add(salirFinal, restricciones);

    }

    private void inicioGUI() {
        fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_Icon("/recursos/background.png");
        this.setContentPane(fondoPanel);

        pressed = 0;// '0' = botón lanzar sin usar
        dado = new JLabel[10];//Creacion de los dados
        dadoPoints = new JLabel[11];//Creacion de las carillas para los puntos

        //Ciclo que instancia los dados y las casillas y les pone una imagen
        for (int i=0;i<=9;i++){
            dadoImagen =new ImageIcon(getClass().getResource("/recursos/comodin.png"));
            dado[i] = new JLabel(dadoImagen);
            dadoImagen =new ImageIcon(getClass().getResource("/recursos/icono"+i+".png"));
            dadoPoints[i] = new JLabel(dadoImagen);
        }

        dadoImagen =new ImageIcon(getClass().getResource("/recursos/puntaje.png"));
        dadoPoints[10] = new JLabel(dadoImagen);

        //Set up JFrame Container's Layout
        controlador = new Controlador();

        //Create Listener Object and Control Object
        listener = new Escucha();

        //Instancio el menú del juego para utilizarlo luego el metodo escucha
        menu1 = null;

        //Obtiene el contenedor por defecto de la ventana y pone un layout del tipo "GridBagLayout"
        this.getContentPane().setLayout(new GridBagLayout());
        restricciones = new GridBagConstraints();//Se crea un objeto "constrain" para configurar el "GridBagLayout" cuando se esten ubicando los componetes de la ventana
        restricciones.insets = new Insets(3,30,3,30);// Inserta margenes en los componentes insertados en la ventana

        //Set up JComponents
        //Configuración de los botones


        atras = new JButton("ATRAS");
        atras.setPreferredSize(new Dimension(100,50));
        atras.setForeground(Color.white);
        atras.setBackground(Color.BLUE);
        atras.addActionListener(listener);

        salir = new JButton("SALIR");
        salir.setPreferredSize(new Dimension(100,50));
        salir.setForeground(Color.white);
        salir.setBackground(Color.BLUE);
        salir.addActionListener(listener);



        //Texto de cabecera y coordenadas constrain para añadirlo a la ventana
        restricciones.gridx=0;
        restricciones.gridy=0;
        restricciones.gridwidth=2; // combina 2 celdas para el titulo.
        restricciones.fill=GridBagConstraints.BOTH;
        restricciones.anchor=GridBagConstraints.CENTER;

        header = new Header("GreekOut Master", null);
        this.add(header, restricciones); //Change this line if you change JFrame Container's Layout


        //Añade el botón de Menú
        restricciones.gridx=0;
        restricciones.gridy=0;

        restricciones.gridwidth=2; // combina 13 celdas para el titulo.
        restricciones.fill=GridBagConstraints.NONE;
        restricciones.anchor=GridBagConstraints.LINE_END;

        menu = new JButton("MENU");
        menu.addActionListener(listener);
        this.add(menu, restricciones); //Change this line if you change JFrame Container's Layout


        //Zona_1: Dados usados
        restricciones.gridx=0;
        restricciones.gridy=1;
        restricciones.gridwidth=1;
        restricciones.gridheight=1;
        restricciones.fill=GridBagConstraints.BOTH;
        restricciones.anchor=GridBagConstraints.CENTER;

        jpDadosUsados = new JPanel();
        jpDadosUsados.setPreferredSize(new Dimension(200,180));
        jpDadosUsados.setBorder(BorderFactory.createTitledBorder(null, "Dados Usados", TitledBorder.CENTER,TitledBorder.CENTER,null,Color.YELLOW));
        jpDadosUsados.setBackground(new Color(14, 65, 119, 125));
        this.add(jpDadosUsados, restricciones); //Change this line if you change JFrame Container's Layout

        //Zona_2: Dados inctivos
        jpDadosInactivos = new JPanel();
        jpDadosInactivos.setBorder(BorderFactory.createTitledBorder(null,"Dados Inactivos", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION,null,Color.YELLOW));
        jpDadosInactivos.setBackground(new Color(14, 65, 119, 125));
        restricciones.gridx=1;
        restricciones.gridy=1;
        restricciones.gridwidth=1;
        restricciones.gridheight=1;
        restricciones.fill=GridBagConstraints.BOTH;
        restricciones.anchor=GridBagConstraints.CENTER;

        for (int i=0;i<=3-1;i++){
            jpDadosInactivos.add(dado[i]);
        }

        this.add(jpDadosInactivos, restricciones); //Change this line if you change JFrame Container's Layout

        //Zona_3: Dados puntos
        jpPuntos = new JPanel();
        jpPuntos.setPreferredSize(new Dimension(250,200));
        jpPuntos.setBorder(BorderFactory.createTitledBorder(null,"Puntaje",TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION,null,Color.WHITE));
        jpPuntos.setBackground(new Color(14, 65, 119, 125));
        restricciones.gridx=0;
        restricciones.gridy=2;
        restricciones.gridwidth=1;
        restricciones.gridheight=1;
        restricciones.fill=GridBagConstraints.BOTH;
        restricciones.anchor=GridBagConstraints.CENTER;

        jpPuntos.add(dadoPoints[10]);

        for (int i=0;i<=10-1;i++){
            jpPuntos.add(dadoPoints[i]);
        }

        this.add(jpPuntos, restricciones); //Change this line if you change JFrame Container's Layout


        //Zona_4 dedos Activos
        jpDadosActivos = new JPanel();
        jpDadosActivos.setPreferredSize(new Dimension(250,200));
        jpDadosActivos.setBorder(BorderFactory.createTitledBorder(null,"Dados Activos", TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION,null,Color.WHITE));
        jpDadosActivos.setBackground(new Color(14, 65, 119, 125));
        restricciones.gridx=1;
        restricciones.gridy=2;
        restricciones.gridwidth=1;
        restricciones.gridheight=1;
        restricciones.fill=GridBagConstraints.NONE;
        restricciones.anchor=GridBagConstraints.CENTER;

        for (int i=4-1;i<=10-1;i++){
            jpDadosActivos.add(dado[i],BorderLayout.SOUTH);
        }

        this.add(jpDadosActivos, restricciones); //Change this line if you change JFrame Container's Layout

        //Zona_5 grgar boton lanzar
        restricciones.gridx=0;
        restricciones.gridy=3;
        restricciones.gridwidth=2;
        restricciones.fill=GridBagConstraints.NONE;
        restricciones.anchor=GridBagConstraints.CENTER;

        lanzar = new JButton("Lanzar!");
        lanzar.addActionListener(listener);
        this.add(lanzar, restricciones); //Change this line if you change JFrame Container's Layout

    }



    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    public class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand() == "MENU"){
                menu1 = new Menu();
                menu.setEnabled(false);//Deshabilita el botón menú
                lanzar.setEnabled(false); //Deshabilita el botón lanzar
                jpMenu = new JPanel();//Contiene los botones del menu
                jpMenu.add(atras,BorderLayout.CENTER);
                jpMenu.add(salir,BorderLayout.SOUTH);
                menu1.add(jpMenu);
            }
            if (e.getActionCommand() == "ATRAS" && menu1 != null){
                menu1.dispose(); //Cierra la ventana de menu sin cerrar el programa
                menu.setEnabled(true);// Habilita el boton menu
                if (pressed == 0){
                    lanzar.setEnabled(true);
                }

            }
            if (e.getSource() == salir){
                int opcion = JOptionPane.showConfirmDialog(null, "Volver al menú principal?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION){
                    System.out.println("Salir");
                    dispose();
                    entrarVentana();
                }
                else if(opcion == JOptionPane.NO_OPTION){
                    System.out.println("Nada");
                    menu1.dispose();
                    menu.setEnabled(true);
                }
            }
            if (e.getSource() == lanzar){
                for (int i=0;i<=9;i++){
                    controlador.inicio(10);
                    Vector<Integer> face = controlador.getCara();
                    dadoImagen =new ImageIcon(getClass().getResource("/recursos/dado"+face.get(0)+".png"));
                    dado[i].setIcon(dadoImagen);
                    System.out.println("Test");
                }
                pressed = 1; // Indica que el botón lanzar ya fue usado

            }
            if (e.getSource() == entrar){
                guiIni.dispose();
                setVisible(true);
            }

            if (e.getSource() == salirFinal){
                System.exit(0);
            }

        }
    }
}