package modelo;

import java.util.Vector;

public class lanzarDados {
    private final Vector<Dado> dado;
    private int tiro;
    private int cantidadDeDados;
    private int suma;
    //Vector donde se guarda las dos caras del dado
    private Vector<Integer> caras;

    public lanzarDados() {
        dado = new Vector<Dado>();
        tiro = 0;
        suma = 0;
        caras = new Vector<>(0);
        cantidadDeDados =0;
    }
    public lanzarDados(int cantidadDeDados) {
        dado = new Vector<Dado>();
        tiro = 0;
        suma = 0;
        caras = new Vector<>(0);
        this.cantidadDeDados = cantidadDeDados -1;
    }

    public int getCantidadDeDados() {
        return cantidadDeDados;
    }

    public void setCantidadDeDados(int cantidadDeDados) {
        this.cantidadDeDados = cantidadDeDados - 1;
    }

    public Vector<Dado> getDado() {
        return dado;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public void setDado(Dado dado) {
        dado = new Dado();
        this.dado.addElement(dado);
    }

    public int getTiro() {
        return tiro;
    }

    public void setTiro(int tiro) {
        this.tiro = tiro;
    }

    public Vector<Integer> getCaras() {
        return caras;
    }

    public void setCaras(Vector<Integer> caras) {
        this.caras = caras;
    }

    public void iniciar(int cantidad_de_dados) {
        for (int i = 0; i <= cantidad_de_dados -1 ; i++){
            //Toma un dado y lo mete a un vector de dados
            setDado(new Dado());
            //Obtiene el dado lanzado y lo mete en un vector de caras
            caras.add(dado.get(i).getCara());
            suma = caras.get(i) + suma;
            System.out.println("Cara #"+(i+1)+" = "+ caras.get(i));
        }
        //devuelve la cantidad de dados
        int tamano = dado.size();
        System.out.println("|| Dados usados "+tamano+" ||");
        System.out.println("Sumatoria = "+ suma);
    }
}