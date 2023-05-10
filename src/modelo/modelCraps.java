package modelo;

import java.util.Vector;

public class modelCraps {
    private int estado, tiroValido, punto, tiro;
    private Vector<String> estadoString;

    public modelCraps(int estado) {
        this.estado = estado;
    }

    public modelCraps() {
        estado = 0;
        tiroValido = 0;
        punto = 0;
        tiro = 0;
        estadoString = new Vector<String>();
    }

    public int getTiroValido() {
        return tiroValido;
    }

    public Vector<String> getEstadoString() {
        switch (getEstado()){
            case 0:
                setEstadoString("Tu tiro de salida fue ("+punto+")");
                setEstadoString("Sique lansando hasta sacar \""+punto+"\"\n"
                    +"Si sacas \"7\" antes que \""+punto+"\" perderás");
                    break;
            case 1:
                setEstadoString("Tiro de salida ("+tiro+")");
                setEstadoString("|Haz sacado un natural !GANASTE¡|");
                break;
            case 2:
                setEstadoString("Tu tiro de salida fue ("+tiro+")");
                setEstadoString("Sacaste Craps, has perdido!!");
                break;
            case 3:
                setEstadoString("Tu tiro fue ("+tiro+")"+"\nHiciste punto" );
                setEstadoString("Estableaste Punto en \""+punto+"\" Debes seguir lanzando!!\n" +
                    "Pero si sacas \"7\" antes que \""+punto+"\" perderás");
                break;
            case 4:
                setEstadoString("Tu tiro de salida fue ("+punto+")");
                setEstadoString("Volviste a sacar \""+punto+"\" haz ganado!!");
                break;
            case 5:
                setEstadoString("Tu tiro fue ("+tiro+")");
                setEstadoString("Sacaste \"7\" antes que "+punto+" haz perdido!!");
                break;
        }
        return estadoString;
    }

    public void setEstadoString(String texto) {
        estadoString.addElement(texto);
    }

    public void setTiroValido(int tiroValido) {
        this.tiroValido = tiroValido;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    public int getTiro() {
        return tiro;
    }

    public void setTiro(int tiro) {
        this.tiro = tiro;
    }

    public void ronda(){
        System.out.println("|Inicia la ronda tiro|");
        int ronda = getTiroValido();
        if ( ronda== 0) {
            if (getTiro() == 7 || getTiro() == 11) {
                setEstado(1);
                System.out.println("|!GANASTE¡|");
            } else if (getTiro() == 3 || getTiro() == 2 || getTiro() == 12) {
                setEstado(2);
                System.out.println("|!¡CRAPS|");
            }else {
                setEstado(3);
                setPunto(getTiro());
                setTiroValido(1);
                System.out.println("|!PUNTO¡|"+getPunto());
            }
        }
        else {
            System.out.println("va ausar ronda punto|");
            puntaje();
        }
    }
    public void puntaje(){
        System.out.println("|entro a ronda punto|");
        if (getTiro() == getPunto()){
            setEstado(4);
            setTiroValido(0);
            System.out.println("|!GANASTE EN RONDA PUNTO¡|");
        }
        else if (getTiro() == 7){
            setEstado(5);
            setTiroValido(0);
            System.out.println("|CRAPS EN RONDA PUNTO|");
        }
        System.out.println("tiro "+getTiro()+ " punto " +punto);
    }

}