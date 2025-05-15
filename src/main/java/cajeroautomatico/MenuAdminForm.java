package cajeroautomatico;

import javax.swing.*;
import java.awt.event.*;

public class MenuAdminForm extends JFrame {
    private JTextField txtNombre, txtIne, txtDireccion, txtTelefono, txtUsuario, txtContrasena;
    private JButton btnRegistrar;
    private RepositorioClientes repositorio;

    public MenuAdminForm(RepositorioClientes repositorio) {
        this.repositorio = repositorio;

        setTitle("Registro de Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 25);
        add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(130, 20, 200, 25);
        add(txtNombre);

        JLabel lblIne = new JLabel("INE:");
        lblIne.setBounds(20, 60, 100, 25);
        add(lblIne);
        txtIne = new JTextField();
        txtIne.setBounds(130, 60, 200, 25);
        add(txtIne);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(20, 100, 100, 25);
        add(lblDireccion);
        txtDireccion = new JTextField();
        txtDireccion.setBounds(130, 100, 200, 25);
        add(txtDireccion);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(20, 140, 100, 25);
        add(lblTelefono);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(130, 140, 200, 25);
        add(txtTelefono);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(20, 180, 100, 25);
        add(lblUsuario);
        txtUsuario = new JTextField();
        txtUsuario.setBounds(130, 180, 200, 25);
        add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(20, 220, 100, 25);
        add(lblContrasena);
        txtContrasena = new JTextField();
        txtContrasena.setBounds(130, 220, 200, 25);
        add(txtContrasena);

        btnRegistrar = new JButton("Registrar Cliente");
        btnRegistrar.setBounds(100, 270, 180, 40);
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cliente nuevo = new Cliente(
                    txtNombre.getText(),
                    txtIne.getText(),
                    txtDireccion.getText(),
                    txtTelefono.getText(),
                    txtUsuario.getText(),
                    txtContrasena.getText()
                );
                repositorio.agregarCliente(nuevo);
                JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
                limpiarCampos();
            }
        });
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtIne.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");
    }
}
