import java.util.*;

import static java.lang.Integer.parseInt;


public class Ejercicio2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cadena de texto:");
        String cadena = sc.nextLine();

        Thread c1 = new Thread(new HiloContar(cadena,2));
        Thread c2 = new Thread(new HiloContar(cadena,4));
        Thread c3 = new Thread(new HiloContar(cadena,6));
        Thread c4 = new Thread(new HiloContar(cadena,8));

        System.out.println("Frecuencia de cada dígito par:");
        c1.start();
        c2.start();
        c3.start();
        c4.start();

        int paresTotales = new HiloContar(cadena, 2).paresTotales;
        System.out.println("Pares totales: " + paresTotales);
    }
}

class HiloContar implements Runnable{
    public int paresTotales = 0;
    private int digito;
    private int contador = 0;
    private String cadena;

    HiloContar(String cadena,int digito){
        this.digito = digito;
        this.cadena = cadena;
    }

    @Override
    public void run() {
        for (int i = 0; i<cadena.length();i++){
            if (parseInt(String.valueOf(cadena.charAt(i)))==digito){
                this.contador++;
                paresTotales++;
            }
        }
        System.out.println("Dígito " + digito + ": " + contador);
    }
}