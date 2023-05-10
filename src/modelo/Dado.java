package modelo;

import java.util.Random;

public class Dado {
    //Atributo que retorna un lado de la cara del dado
    private int cara;
    //Si presiono "Alt + Insert" genera un método predefinido
    public int getCara() {
        //Creo un objeto randon que me permite crear un numeros aleatorios
        Random random = new Random();
        cara = random.nextInt(6)+1;
        return cara;
    }



}