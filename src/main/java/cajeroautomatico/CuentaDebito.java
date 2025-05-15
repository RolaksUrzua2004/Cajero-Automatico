package cajeroautomatico;

public class CuentaDebito extends Cuenta {
    public CuentaDebito(Cliente cliente, double saldoInicial) {
        super(cliente, saldoInicial);
    }

    @Override
    public void depositar(double monto) {
        saldo += monto;
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}
