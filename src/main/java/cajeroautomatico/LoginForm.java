package cajeroautomatico;

import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private int intentos = 0;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(20, 20, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 20, 150, 25);
        add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(20, 60, 80, 25);
        add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(100, 60, 150, 25);
        add(txtContrasena);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(100, 100, 100, 30);
        add(btnIngresar);

        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String pass = new String(txtContrasena.getPassword());

                // Simulamos cliente pre-registrado
                Cliente c = new Cliente("Juan", "INE123", "Calle Falsa", "6441234567", "juan", "1234");
                Cuenta cuenta = new CuentaDebito(c, 1000);

                if (usuario.equals(c.usuario) && pass.equals(c.contrasena)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + c.nombre);
                    new OperacionesForm(cuenta).setVisible(true);
                    dispose();
                } else {
                    intentos++;
                    if (intentos >= 3) {
                        JOptionPane.showMessageDialog(null, "Demasiados intentos.");
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Intento " + intentos + "/3");
                    }
                }
            }
        });
    }
}
