package cajeroautomatico;
/**
 *
 * @author Sveen Urzua
 */
import cajeroautomatico.datos.RepositorioClientes;
import cajeroautomatico.modelo.Cliente;
import cajeroautomatico.modelo.Cuenta;
import cajeroautomatico.modelo.CuentaCredito;
import cajeroautomatico.modelo.CuentaDebito;

import javax.swing.*;

public class MenuAdminForm extends JFrame {
    public MenuAdminForm() {
        setTitle("Registro de Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new java.awt.Color(255, 245, 230));

        JTextField txtNombre = new JTextField(); txtNombre.setBounds(150, 20, 200, 25);
        JTextField txtINE = new JTextField(); txtINE.setBounds(150, 60, 200, 25);
        JTextField txtDireccion = new JTextField(); txtDireccion.setBounds(150, 100, 200, 25);
        JTextField txtTelefono = new JTextField(); txtTelefono.setBounds(150, 140, 200, 25);
        JTextField txtMonto = new JTextField(); txtMonto.setBounds(150, 180, 200, 25);
        JComboBox<String> comboTipoCuenta = new JComboBox<>(new String[]{"Crédito", "Débito"});
        comboTipoCuenta.setBounds(150, 220, 200, 25);
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(150, 270, 100, 30);
        btnRegistrar.setBackground(java.awt.Color.DARK_GRAY);
        btnRegistrar.setForeground(java.awt.Color.WHITE);

        add(new JLabel("Nombre:")).setBounds(20, 20, 120, 25); add(txtNombre);
        add(new JLabel("INE:")).setBounds(20, 60, 120, 25); add(txtINE);
        add(new JLabel("Dirección:")).setBounds(20, 100, 120, 25); add(txtDireccion);
        add(new JLabel("Teléfono:")).setBounds(20, 140, 120, 25); add(txtTelefono);
        add(new JLabel("Monto Inicial:")).setBounds(20, 180, 120, 25); add(txtMonto);
        add(new JLabel("Tipo de Cuenta:")).setBounds(20, 220, 120, 25); add(comboTipoCuenta);
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String ine = txtINE.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            double monto = Double.parseDouble(txtMonto.getText());
            String tipo = (String) comboTipoCuenta.getSelectedItem();

            Cuenta cuenta = null;
            if (tipo.equals("Crédito") && monto >= 3000) {
                cuenta = new CuentaCredito(monto);
            } else if (tipo.equals("Débito")) {
                cuenta = new CuentaDebito(monto);
            } else {
                JOptionPane.showMessageDialog(this, "Monto mínimo para crédito: $3000");
                return;
            }

            Cliente nuevo = new Cliente(nombre, ine, direccion, telefono, cuenta);
            RepositorioClientes.agregarCliente(nuevo);
            JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente.");
        });
    }
}
