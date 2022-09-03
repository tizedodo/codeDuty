import java.util.Scanner;

public class App {
    private static Scanner S = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        final int CANT_TIRO;
        int cantJugadores;
        int tiro;
        CANT_TIRO = 3;

        String[] mensaje = { "primer", "segundo", "tercer" };

        int punto, auxPunto = 0, tirosAlCentro = 0;
        int puntoMayor, posMayor = 0;

        do {
            System.out.print("Ingresa la cantidad de jugadores: ");
            cantJugadores = Integer.parseInt(S.nextLine());

        } while (cantJugadores < 2);

        System.out.println("Van hacer un total de: " + cantJugadores + " jugadores.");
        System.out.println(" ");

        int[] puntosTotal = new int[cantJugadores];
        String[] nombresDeJugadores = new String[cantJugadores];

        for (int i = 0; i < cantJugadores; i++) {
            int j = 1;
            j += i;
            System.out.print("Introduce el nombre del jugador " + j + ":");
            nombresDeJugadores[i] = S.nextLine();
            tiro = 0;

            auxPunto = 0;
            for (int g = 0; g < CANT_TIRO; g++) {
                System.out.print("Ingresa la distancia del " + mensaje[g] + " tirro: ");
                tiro = Integer.parseInt(S.nextLine());

                if (tiro == 0) {
                    punto = 500;
                    tirosAlCentro++;
                } else if (tiro <= 10) {
                    punto = 250;
                } else if (tiro > 10 && tiro <= 50) {
                    punto = 100;
                } else {
                    punto = 0;
                }

                auxPunto += punto;
            }

            puntosTotal[i] = auxPunto;
        }

        puntoMayor = puntosTotal[0];

        for (int i = 0; i < cantJugadores; i++) {

            if (puntosTotal[i] > puntoMayor) {
                posMayor = i;
            }
        }

        //
        // for(int i = 0; i < cantJugadores; i++){
        // System.out.println(nombresDeJugadores[i]+",");
        // System.out.println(puntosTotal[i]+",");
        //
        // }

        System.out.println("La cantidad total de tiros al centro fueron: " + tirosAlCentro);

        System.out.println("El ganador del torneo es: " + nombresDeJugadores[posMayor]);
        System.out.println("Con un total de: " + puntosTotal[posMayor] + " puntos");

    }
}
