package cajeroautomatico;

import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private JComboBox<String> cmbTipoUsuario;
    private int intentos = 0;
    private final int MAX_INTENTOS = 3;
    private RepositorioClientes repositorio;

    public LoginForm(RepositorioClientes repositorio) {
        this.repositorio = repositorio;

        setTitle("Login - Cajero Automático");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 30, 180, 25);
        add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(30, 70, 80, 25);
        add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(120, 70, 180, 25);
        add(txtContrasena);

        JLabel lblTipo = new JLabel("Tipo de usuario:");
        lblTipo.setBounds(30, 110, 100, 25);
        add(lblTipo);

        cmbTipoUsuario = new JComboBox<>(new String[] {"Cliente", "Administrador"});
        cmbTipoUsuario.setBounds(140, 110, 160, 25);
        add(cmbTipoUsuario);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(100, 160, 120, 40);
        add(btnIngresar);

        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contrasena = new String(txtContrasena.getPassword());
                String tipo = cmbTipoUsuario.getSelectedItem().toString();

                if (tipo.equals("Administrador")) {
                    // Datos fijos para admin
                    if (usuario.equals("admin") && contrasena.equals("1234")) {
                        JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
                        new MenuAdminForm(repositorio).setVisible(true);
                        dispose();
                    } else {
                        manejarIntento();
                    }
                } else {
                    // Buscar cliente
                    Cliente cliente = repositorio.buscarPorUsuario(usuario);
                    if (cliente != null && cliente.contrasena.equals(contrasena)) {
                        JOptionPane.showMessageDialog(null, "Bienvenido " + cliente.nombre);
                        new CajeroForm(cliente).setVisible(true);
                        dispose();
                    } else {
                        manejarIntento();
                    }
                }
            }

            private void manejarIntento() {
                intentos++;
                if (intentos >= MAX_INTENTOS) {
                    JOptionPane.showMessageDialog(null, "Máximo de intentos alcanzado. Acceso bloqueado.");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Intento " + intentos + " de " + MAX_INTENTOS);
                }
            }
        });
    }
}
