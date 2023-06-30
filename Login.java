public class Login {

    private String usuario = "juan";
    private static String contra = "123";

    private static String nombre = "Juan diaz";

    public boolean inicioDeSesion(String usuario, String contra) {

        return chequeoLogin(usuario, contra); // Conectando con db remota ...
    }

    private boolean chequeoLogin(String usuario, String contra) {

        if (usuario.equals(this.usuario) && contra.equals(this.contra)) {
            return true;
        }
        return false;
    }

    public void cambioNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean cambioPass(String viejaPass, String pass) {
        if (viejaPass.equals(this.contra)) {
            this.contra = pass;
            return true;
        }

        return false;
    }

    public String nombreCliente() {
        return nombre;
    }

}
