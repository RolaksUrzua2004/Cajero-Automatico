package cajeroautomatico;

public class CuentaCredito extends Cuenta {
    private static final double INTERES = 0.05;

    public CuentaCredito(Cliente cliente, double saldoInicial) {
        super(cliente, Math.max(saldoInicial, 3000));
    }

    @Override
    public void depositar(double monto) {
        saldo += monto + (monto * INTERES);
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
