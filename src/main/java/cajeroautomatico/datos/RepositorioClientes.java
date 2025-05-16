package cajeroautomatico.datos;
/**
 *
 * @author Sveen Urzua
 */
import cajeroautomatico.modelo.Cliente;

import java.io.*;
import java.util.ArrayList;

public class RepositorioClientes {
    private static final String ARCHIVO_CLIENTES = "clientes.dat";
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    static {
        cargarClientes();  // Se llama automáticamente al cargar la clase
    }

    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        guardarClientes(); // Guardar después de agregar
    }

    public static Cliente getClientePorNombre(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public static ArrayList<Cliente> getTodosClientes() {
        return clientes;
    }

    private static void guardarClientes() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            out.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void cargarClientes() {
        File archivo = new File(ARCHIVO_CLIENTES);
        if (!archivo.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            clientes = (ArrayList<Cliente>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
