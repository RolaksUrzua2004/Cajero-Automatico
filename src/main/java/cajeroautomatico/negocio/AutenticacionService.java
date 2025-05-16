package cajeroautomatico.negocio;
/**
 *
 * @author Sveen Urzua
 */
import cajeroautomatico.datos.RepositorioClientes;
import cajeroautomatico.modelo.Cliente;

public class AutenticacionService {
    private int intentosRestantes = 3;

    public Cliente autenticar(String nombreUsuario, String ine) {
        Cliente cliente = RepositorioClientes.getClientePorNombre(nombreUsuario);
        if (cliente != null && cliente.getIne().equals(ine)) {
            intentosRestantes = 3;
            return cliente;
        } else {
            intentosRestantes--;
            return null;
        }
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public boolean estaBloqueado() {
        return intentosRestantes <= 0;
    }
}
