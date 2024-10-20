
package icc;

import java.util.Scanner;

import icc.colors.Colors;

public class Prueba {

    public static int getInt(String mensaje, String error, int min, int max) {
        int valor;
        Scanner scan = new Scanner(System.in);

        while (true) {
            Colors.println(mensaje, Colors.CYAN + Colors.HIGH_INTENSITY);
            if (scan.hasNextInt()) {
                valor = scan.nextInt();
                // (-infinito, min) || (max, infinito)
                if (valor < min || max < valor) {
                    Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
                } else {
                    return valor;
                }
            } else {
                scan.next();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        }
    }

    public static void main(String args[]) {
        int opcion, aux;
        String mensaje, error;
        StringBuilder sb;
        StringBuilder sb2;
        Scanner scan = new Scanner(System.in);

        Colors.println("Bienvenido, este programa realiza un simulador de torneo de Volleyball.", Colors.CYAN + Colors.HIGH_INTENSITY);

        sb = new StringBuilder();
        sb.append("¿De cuantos equipos deseas hacer el torneo?");

        aux = -1;

            opcion = getInt(sb.toString(), "Por favor ingresa una canitdad de equipos valida.", 0, 100);

            String[] equipos = new String[opcion];
            for(int i = 0; i < equipos.length; i++){
                Colors.println("Ingresa el nombre del equipo " + (i + 1) + ":", Colors.BGD_RED + Colors.HIGH_INTENSITY);
                equipos[i] = scan.nextLine();
            }

        do {
            sb2 = new StringBuilder();
            sb2.append("1. Consultar puntuaciones.\n");
            sb2.append("2. Continuar con el torneo.\n");
            sb2.append("0. Salir.");

            aux = getInt(sb2.toString(),"ingresa una opcion valida", 0, 2);

            switch (aux){
                case 1:
                    for (int i = 0; i < equipos.length; i++) {
                        Colors.println("Aquí va la puntiacion del equipo " + equipos[i], Colors.HIGH_INTENSITY);
                    }
                    break;
                    case 2:
                        System.out.println("Aqui va una ronda en particular.");
                        System.out.println("El torneo termino, los puntajes quedaron así");

                        for(int i = 0; i < equipos.length; i++){
                            System.out.println("aquí va el puntaje del equipo: " + equipos[i]);
                        }
                        break;

                    case 0:
                        Colors.println("Vuelve pronto.", Colors.GREEN + Colors.HIGH_INTENSITY);
                        break;


            }
        } while (aux != 0);


    }

}
