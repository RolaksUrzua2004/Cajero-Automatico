package cajeroautomatico;
/**
 *
 * @author Sveen Urzua
 */
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            String[] opciones = {"Administrador", "Cliente", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "¿Cómo deseas ingresar?",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            if (seleccion == 0) {
                MenuAdminForm adminForm = new MenuAdminForm();
                adminForm.setVisible(true);
                while (adminForm.isVisible()) {
                    try {
                        Thread.sleep(100); // Espera mientras la ventana está abierta
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (seleccion == 1) {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
                while (loginForm.isVisible()) {
                    try {
                        Thread.sleep(100); // Espera mientras la ventana está abierta
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                break; // Salir del programa
            }
        }
        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
        System.exit(0);
    }
}
