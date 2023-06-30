

import java.util.Scanner;

public class Main {

    /*
    Proyecto: Simulación Homebanking.
    Autor: Lanfranco D. Caballero
    Comisión 22922 - Fernanco Lucena
    Fecha: 28/10/2022
    Codo a codo inicial.
    */

    public static void main(String[] args) {

        int intentos = 0;

        Scanner keyboard = new Scanner(System.in);
        Login login = new Login();
        Menu menu = new Menu();

        System.out.println("Bienvenido al sistema de Homebanking ...");
        System.out.println("Inicia sesión para continuar ...\n");

        while (true) {
            if (intentos >= 3) {
                System.out.println("Ha alcanzado el límite de intentos permitidos.\nGracias por utilizar" +
                        " el sistema Homebanking.");
                break;
            }
            System.out.print("Indique su usuario: ");
            String usuario = keyboard.next();
            System.out.print("Indique su contraseña: ");
            String password = keyboard.next();
            System.out.println("\n*** Chequeando información ... ***\n");
            if (login.inicioDeSesion(usuario, password)) {
                System.out.println("Bienvenido " + login.nombreCliente() + "!\n");
                menu.VerMenu();
                System.out.println("Bienvenido al sistema de Homebanking ...");
                System.out.println("Inicia sesión para continuar ...\n");
            } else {
                System.out.println("Lamentablemente no pudimos validar su información. " +
                        "Intente nuevamente ... O aprete 1 para salir.\n");

                if (keyboard.next().equals("1")) {
                    break;
                } else {
                    intentos++;
                }
            }

        }

    }

}
