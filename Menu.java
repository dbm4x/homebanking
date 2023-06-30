import java.util.Scanner;

public class Menu {

    Scanner teclado = new Scanner(System.in);
    Usuario usuario = new Usuario();
    Login login = new Login();


    public void VerMenu() {
        boolean salir = false;
        do {
            System.out.println("*** El saldo de su cuenta es de $" + usuario.SaldoActual() + ". ***\n");
            System.out.println("Elija el tipo de operación que desea realizar ...\n");
            System.out.println("1) Deposito.\n" +
                    "2) Retiro.\n" +
                    "3) Prestamo.\n" +
                    "4) Lista de movimientos.\n\n" +
                    "Otras opciones:\n\n" +
                    "5) Cambio de password.\n" +
                    "6) Modificar nombre y apellido.\n" +
                    "7) Salir.\n");

            switch (teclado.next()) {
                case "1":
                    deposito();
                    break;
                case "2":
                    retiro();
                    break;

                case "3":
                    prestamo();
                    break;
                case "4":
                    movimientos();
                    break;
                case "5":
                    cambiopass();
                    break;
                case "6":
                    cambionombre();
                    break;
                case "7":
                    salir = true;
                    break;
            }
        }
        while (!salir);
    }

    private void deposito() {
        System.out.print("\nIngrese el monto que desea depositar: ");
        String monto = teclado.next();
        try {
            if (usuario.Deposito(Integer.parseInt(monto))) {
                System.out.println("\n *** Deposito realizado con éxito ***\n");
            } else {
                System.out.println("\n *** Uno o más errores ocurrieron durante el retiro, intente nuevamente. ***\n");
            }
        } catch (Exception e) {
            System.out.println("\n *** Uno o más errores ocurrieron durante el deposito, intente nuevamente. ***\n");
        }
    }

    private void retiro() {
        System.out.print("\nIngrese el monto que desea retirar: ");
        String monto = teclado.next();
        try {
            if (usuario.RetirarSaldo(Integer.parseInt(monto))) {
                System.out.println("\n *** Retiro realizado con éxito ***\n");
            } else {
                System.out.println("\n *** Uno o más errores ocurrieron durante el retiro, intente nuevamente. ***\n");
            }
        } catch (Exception e) {
            System.out.println("\n *** Uno o más errores ocurrieron durante el retiro, intente nuevamente. ***\n");
        }
    }

    private void prestamo() {
        System.out.print("\nIngrese el monto del prestamo: ");
        String monto = teclado.next();
        try {
            usuario.Prestamo(Integer.parseInt(monto));
            System.out.println("\n *** Prestamo aprobado. ***\n");
        } catch (Exception e) {
            System.out.println("\n *** Uno o más errores ocurrieron durante el tramite de su prestamo, intente nuevamente. ***\n");
        }
    }

    private void movimientos() {
        System.out.println("\nLista de movimientos:");
        for (int i = 0; i < usuario.ListaMovimientos().size(); i++) {
            System.out.println("------------------------------------");
            System.out.println("Tipo de movimiento: " +
                    usuario.ListaMovimientos().get(i).tipoMovimientos.toString() +
                    "\n Fecha: " + usuario.ListaMovimientos().get(i).fecha + "" +
                    "\nSaldo anterior al movimiento: $" + usuario.ListaMovimientos().get(i).saldoAnterior +
                    "\nSaldo despues del movimiento: $" + usuario.ListaMovimientos().get(i).saldoActual);
        }
        System.out.println("------------------------------------\n");
    }

    private void cambiopass() {
        System.out.println("Cambio de contraseña ...");
        System.out.print("Ingrese su contraseña anterior: ");
        String vieja = teclado.next();
        System.out.print("Ingrese nueva contraseña: ");
        String nueva = teclado.next();

        if (login.cambioPass(vieja, nueva)) {
            System.out.println("\n*** Contraseña cambiada con éxito. ***\n");
        } else {
            System.out.println("\n*** Error al cambiar la contraseña. Chequee sus datos e intente nuevamente ... ***\n");
        }
    }

    private void cambionombre() {
        System.out.println("\nCambio de nombre ...");
        System.out.print("Ingrese su nuevo nombre: ");
        String nombre = teclado.next();
        login.cambioNombre(nombre);
        System.out.println("\nCambio realizado con éxito. Hola de nuevo " + login.nombreCliente() + "!\n");
    }
}
