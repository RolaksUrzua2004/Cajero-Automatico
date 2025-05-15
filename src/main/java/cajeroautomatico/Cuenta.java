package cajeroautomatico;

public abstract class Cuenta {
    protected double saldo;
    protected Cliente cliente;

    public Cuenta(Cliente cliente, double saldoInicial) {
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    public abstract void depositar(double monto);
    public abstract boolean retirar(double monto);
    public double getSaldo() {
        return saldo;
    }
}
