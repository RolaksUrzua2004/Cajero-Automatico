package cajeroautomatico;
/**
 *
 * @author Sveen Urzua
 */
import cajeroautomatico.negocio.AutenticacionService;
import cajeroautomatico.modelo.Cliente;

import javax.swing.*;

public class LoginForm extends JFrame {
    private JTextField txtUsuario;
    private JTextField txtINE;
    private JButton btnLogin;
    private AutenticacionService authService = new AutenticacionService();

    public LoginForm() {
        setTitle("Login Cliente");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(230, 240, 255));
        setLayout(null);

        JLabel lblUsuario = new JLabel("Nombre:");
        lblUsuario.setBounds(20, 20, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 20, 150, 25);
        add(txtUsuario);

        JLabel lblINE = new JLabel("INE:");
        lblINE.setBounds(20, 60, 80, 25);
        add(lblINE);

        txtINE = new JTextField();
        txtINE.setBounds(100, 60, 150, 25);
        add(txtINE);

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(100, 100, 100, 30);
        btnLogin.setBackground(java.awt.Color.BLUE);
        btnLogin.setForeground(java.awt.Color.WHITE);
        add(btnLogin);

        btnLogin.addActionListener(e -> autenticarCliente());
    }

    private void autenticarCliente() {
        String usuario = txtUsuario.getText();
        String ine = txtINE.getText();

        Cliente cliente = authService.autenticar(usuario, ine);
        if (cliente != null) {
            new CajeroForm(cliente).setVisible(true);
            this.dispose();
        } else {
            int intentos = authService.getIntentosRestantes();
            if (authService.estaBloqueado()) {
                JOptionPane.showMessageDialog(this, "Demasiados intentos fallidos. Acceso bloqueado.");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Datos incorrectos. Intentos restantes: " + intentos);
            }
        }
    }
}
