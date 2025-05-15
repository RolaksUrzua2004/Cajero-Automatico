package cajeroautomatico;

public class Cliente {
    String nombre, ine, direccion, telefono, usuario, contrasena;

    public Cliente(String nombre, String ine, String direccion, String telefono, String usuario, String contrasena) {
        this.nombre = nombre;
        this.ine = ine;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public boolean login(String u, String c) {
        return this.usuario.equals(u) && this.contrasena.equals(c);
    }
}
