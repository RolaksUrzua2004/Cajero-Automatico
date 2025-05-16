package cajeroautomatico.modelo;
/**
 *
 * @author Sveen Urzua
 */
import java.io.Serializable;

public abstract class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;

    protected double saldo;
    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}
