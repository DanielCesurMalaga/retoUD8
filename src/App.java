import java.util.Scanner;

import miCrud.Cine;
import miCrud.MiCRUD;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Alejandro");

        int numero = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Dónde quieres acceder?");
        System.out.println("1- Cines");
        System.out.println("2- Películas");
        System.out.println("3- Salas");

        do {
            numero = teclado.nextInt();
            teclado.nextLine();
            if (numero == 1) {
                System.out.println("Has accedido a 'Cines'");
                insertarCine(teclado);
            } else if (numero == 2) {
                System.out.println("Has accedido a 'Películas'");

            } else if (numero == 3) {
                System.out.println("Has accedido a 'Salas'");

            } else {
                System.out.println("Número incorrecto, prueba otra vez");
            }

        } while (numero < 1 || numero > 3);

        teclado.close();
    } // fin main

    public static void insertarCine(Scanner teclado) {
        String nombreCine = null;
        String direccionCine = null;

        System.out.println("Inserte el nombre del cine: ");
        nombreCine = teclado.nextLine();

        System.out.println("Inserte la dirección del cine:");
        direccionCine = teclado.nextLine();

        Cine cine1 = new Cine(direccionCine, nombreCine);
        cine1.setIdCine(1);

        System.out.println("Has creado el cine: ");
        System.out.println(cine1.getDireccion() + " " + cine1.getNombreCine());

        MiCRUD miCRUD = new MiCRUD("cinema");
        miCRUD.initConnection();
        miCRUD.createStatement();
        miCRUD.insertRow("cines", new String[] { "direccion", "idCines", "nombre" },
                new Object[] { cine1.getDireccion(), cine1.getIdCine(),
                        cine1.getNombreCine() });
        miCRUD.closeConnection();
    }

}
