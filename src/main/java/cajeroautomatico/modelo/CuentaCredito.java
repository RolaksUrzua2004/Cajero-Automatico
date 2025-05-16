package cajeroautomatico.modelo;
/**
 *
 * @author Sveen Urzua
 */
public class CuentaCredito extends Cuenta {
    private static final long serialVersionUID = 1L;

    private double limiteCredito;

    public CuentaCredito(double saldoInicial) {
        super(saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && (saldo + limiteCredito) >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public String toString() {
        return "Cuenta Crédito - Saldo: $" + saldo + ", Límite: $" + limiteCredito;
    }
}
