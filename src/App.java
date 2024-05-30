import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int seleccion;

        do {
            System.out.println("Seleccione tabla:");
            System.out.println();
            System.out.println("1.Cine    2.Película    3.Sala");
            seleccion = teclado.nextInt();
            teclado.nextLine();

            switch (seleccion) {
                case 1:
                    Cine miCine = new Cine();
                    System.out.println("Inserte valores:");
                    System.out.println();
                    System.out.println("Nombre:");
                    miCine.setNombre(teclado.nextLine());
                    System.out.println("Direccion:");
                    miCine.setDireccion(teclado.nextLine());

                    miCine.insertCine();

                    break;

                case 2:
                    Pelicula miPelicula = new Pelicula();
                    System.out.println("Inserte valores:");
                    System.out.println();
                    System.out.println("Título:");
                    miPelicula.setTitulo(teclado.nextLine());
                    System.out.println("Duración");
                    miPelicula.setDuracion(teclado.nextInt());
                    teclado.nextLine();
                    System.out.println("Género:");
                    miPelicula.setGenero(teclado.nextLine());
                    System.out.println("Director:");
                    miPelicula.setDirector(teclado.nextLine());
                    System.out.println("Clasificación edad:");
                    miPelicula.setClasiEdad(teclado.nextInt());
                    teclado.nextLine();
                    System.out.println("Precio:");
                    miPelicula.setPrecio(teclado.nextDouble());

                    miPelicula.insertPelicula();

                    break;

                case 3:
                    Sala miSala = new Sala();
                    System.out.println("Inserte valores:");
                    System.out.println();
                    System.out.println("Capacidad:");
                    miSala.setCapacidad(teclado.nextInt());
                    System.out.println("Superficie");
                    miSala.setSuperficie(teclado.nextDouble());

                    miSala.insertSala();

                    break;

                default:
                    System.out.println("Número incorrecto");
                    break;

            }

        } while ((seleccion < 1) && (seleccion > 3));
        teclado.close();

        System.out.println();

        System.out.println("Proceso ejecutado con éxito.");

    }

}
