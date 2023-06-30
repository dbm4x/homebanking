import java.util.*;

public class Usuario {
    static int saldo = 5000;

    static List<movimientos> movimiento = new ArrayList<>();

    enum tiposdemovimiento {Retiro, Deposito, Prestamo}

    public int SaldoActual() {
        return this.saldo;
    }

    public boolean RetirarSaldo(int cuanto) {
        if (cuanto <= this.saldo) {
            int viejoSaldo = this.saldo;
            this.saldo -= cuanto;
            Date date = new Date();
            movimiento.add(new movimientos(tiposdemovimiento.Retiro, viejoSaldo, this.saldo, date));
            return true;
        }
        return false;
    }

    public boolean Deposito(int cuanto) {
        if (cuanto > 0 && cuanto <= 9999999) {
            int viejoSaldo = this.saldo;
            this.saldo += cuanto;
            Date date = new Date();
            movimiento.add(new movimientos(tiposdemovimiento.Deposito, viejoSaldo, this.saldo, date));
            return true;
        }
        return false;
    }

    public void Prestamo(int cuanto) {
        int viejoSaldo = this.saldo;
        this.saldo -= cuanto;
        Date date = new Date();
        movimiento.add(new movimientos(tiposdemovimiento.Prestamo, viejoSaldo, this.saldo, date));
    }

    public List<movimientos> ListaMovimientos() {
        return movimiento;
    }

    class movimientos {
        tiposdemovimiento tipoMovimientos;
        int saldoAnterior;
        int saldoActual;

        Date fecha;

        public movimientos(tiposdemovimiento tipo, int saldoAnterior, int saldoActual, Date fecha) {
            this.tipoMovimientos = tipo;
            this.saldoActual = saldoActual;
            this.saldoAnterior = saldoAnterior;
            this.fecha = fecha;
        }
    }
}
