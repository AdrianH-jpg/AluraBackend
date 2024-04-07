import java.util.Random;
import java.util.Scanner;

public class juegoAdivinador {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int numeroGenerado = new Random().nextInt(100); // genera un número aleatorio entre 0 y 100
        int intentos = 0;

        while (intentos < 5) {
            System.out.print("Introduzca un número entre 0 e 100: ");
            int numeroDelUsuario = lector.nextInt();
            intentos++;

            if (numeroDelUsuario == numeroGenerado) {
                System.out.println("Felicidades, adivinaste el número en " + intentos + " intentos!");
                break; // interrumpe el loop while
            } else if (numeroDelUsuario < numeroGenerado) {
                System.out.println("El número que escribiste es menor al número generado.");
            } else {
                System.out.println("El número que escribiste es mayor al número generado.");
            }
        }

        if (intentos == 5) {
            System.out.println("Lo siento, no conseguiste adivinar el número en 5 intentos. El número era " + numeroGenerado);
        }
    }
}
