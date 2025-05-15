package cajeroautomatico;

import java.util.*;

public class RepositorioClientes {
    private List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    public Cliente buscarCliente(String usuario) {
        for (Cliente c : clientes) {
            if (c.usuario.equals(usuario)) return c;
        }
        return null;
    }
}
