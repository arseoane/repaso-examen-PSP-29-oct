import java.util.*;


public class Ejercicio1 {
    public static void main(String[] args) throws InterruptedException {
        Thread h3 = new Thread(new Hilo(), "Hilo 3");
        Thread h2 = new Thread(new Hilo(), "Hilo 2");
        Thread h1 = new Thread(new Hilo(), "Hilo 1");

        h3.start();
        h3.join();

        h2.start();
        h2.join();

        h1.start();
        h1.join();

        System.out.println("Programa principal terminado.");
    }
}

class Hilo implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 8; i++){
            System.out.println("Soy el " + Thread.currentThread().getName() + " - iteración: " + i);
            try {
                Thread.sleep(new Random().nextInt(100,200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

