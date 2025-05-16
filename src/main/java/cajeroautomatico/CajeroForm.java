package cajeroautomatico;
/**
 *
 * @author Sveen Urzua
 */
import cajeroautomatico.modelo.Cliente;
import cajeroautomatico.modelo.Cuenta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CajeroForm extends JFrame {
    private final Cliente cliente;
    private final Cuenta cuenta;
    private final JTextArea areaSalida;

    public CajeroForm(Cliente cliente) {
        this.cliente = cliente;
        this.cuenta = cliente.getCuenta();

        setTitle("Cajero Automático - Cliente: " + cliente.getNombre());
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 255, 255));
        setLayout(null);

        JLabel titulo = new JLabel("Operaciones Bancarias", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBounds(100, 10, 300, 30);
        add(titulo);

        JButton btnDeposito = new JButton("Depósito");
        btnDeposito.setBounds(50, 60, 150, 30);
        add(btnDeposito);

        JButton btnRetiro = new JButton("Retiro");
        btnRetiro.setBounds(250, 60, 150, 30);
        add(btnRetiro);

        JButton btnSaldo = new JButton("Ver Saldo");
        btnSaldo.setBounds(50, 110, 150, 30);
        add(btnSaldo);

        JButton btnImprimir = new JButton("Imprimir Operación");
        btnImprimir.setBounds(250, 110, 150, 30);
        add(btnImprimir);

        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaSalida);
        scrollPane.setBounds(50, 160, 350, 150);
        add(scrollPane);

        JButton btnSalir = new JButton("Cerrar Sesión");
        btnSalir.setBounds(150, 320, 150, 30);
        btnSalir.setBackground(Color.RED);
        btnSalir.setForeground(Color.WHITE);
        add(btnSalir);

        // Listeners
        btnDeposito.addActionListener(this::realizarDeposito);
        btnRetiro.addActionListener(this::realizarRetiro);
        btnSaldo.addActionListener(e -> mostrarSaldo());
        btnImprimir.addActionListener(e -> imprimirOperacion());
        btnSalir.addActionListener(e -> {
            this.dispose();
            new Main().main(null); // Regresa al menú principal
        });
    }

    private void realizarDeposito(ActionEvent e) {
        String input = JOptionPane.showInputDialog(this, "Ingrese el monto a depositar:");
        try {
            double monto = Double.parseDouble(input);
            cuenta.depositar(monto);
            areaSalida.append("Depósito exitoso de $" + monto + "\n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Monto inválido.");
        }
    }

    private void realizarRetiro(ActionEvent e) {
        String input = JOptionPane.showInputDialog(this, "Ingrese el monto a retirar:");
        try {
            double monto = Double.parseDouble(input);
            if (cuenta.retirar(monto)) {
                areaSalida.append("Retiro exitoso de $" + monto + "\n");
            } else {
                areaSalida.append("Fondos insuficientes para retiro de $" + monto + "\n");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Monto inválido.");
        }
    }

    private void mostrarSaldo() {
        double saldo = cuenta.getSaldo();
        areaSalida.append("Saldo actual: $" + saldo + "\n");
    }

    private void imprimirOperacion() {
        String resumen = "Resumen de cuenta:\n" +
                "Cliente: " + cliente.getNombre() + "\n" +
                "Cuenta: " + cuenta.getClass().getSimpleName() + "\n" +
                "Saldo: $" + cuenta.getSaldo() + "\n";
        areaSalida.append(resumen + "\n");
    }
}
