package cajeroautomatico;

import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {
    private List<Cliente> clientes;

    public RepositorioClientes() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarPorUsuario(String usuario) {
        for (Cliente c : clientes) {
            if (c.usuario.equals(usuario)) {
                return c;
            }
        }
        return null;
    }
}
