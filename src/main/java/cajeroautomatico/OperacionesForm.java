package cajeroautomatico;

import javax.swing.*;
import java.awt.event.*;

public class OperacionesForm extends JFrame {
    private Cuenta cuenta;
    private JLabel lblSaldo;
    private JTextField txtMonto;

    public OperacionesForm(Cuenta cuenta) {
        this.cuenta = cuenta;

        setTitle("Operaciones");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        lblSaldo = new JLabel("Saldo actual: $" + cuenta.getSaldo());
        lblSaldo.setBounds(20, 20, 300, 25);
        add(lblSaldo);

        JLabel lblMonto = new JLabel("Monto:");
        lblMonto.setBounds(20, 60, 80, 25);
        add(lblMonto);

        txtMonto = new JTextField();
        txtMonto.setBounds(100, 60, 150, 25);
        add(txtMonto);

        JButton btnDepositar = new JButton("Depositar");
        btnDepositar.setBounds(20, 100, 100, 30);
        add(btnDepositar);

        JButton btnRetirar = new JButton("Retirar");
        btnRetirar.setBounds(140, 100, 100, 30);
        add(btnRetirar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(260, 100, 100, 30);
        add(btnSalir);

        btnDepositar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double monto = Double.parseDouble(txtMonto.getText());
                    cuenta.depositar(monto);
                    lblSaldo.setText("Saldo actual: $" + cuenta.getSaldo());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Monto inválido.");
                }
            }
        });

        btnRetirar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double monto = Double.parseDouble(txtMonto.getText());
                    if (cuenta.retirar(monto)) {
                        lblSaldo.setText("Saldo actual: $" + cuenta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Fondos insuficientes.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Monto inválido.");
                }
            }
        });

        btnSalir.addActionListener(e -> System.exit(0));
    }
}
