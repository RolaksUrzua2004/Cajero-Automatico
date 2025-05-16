package cajeroautomatico.modelo;
/**
 *
 * @author Sveen Urzua
 */
public class CuentaDebito extends Cuenta {
    private static final long serialVersionUID = 1L;

    public CuentaDebito(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public String toString() {
        return "Cuenta Débito - Saldo: $" + saldo;
    }
}
