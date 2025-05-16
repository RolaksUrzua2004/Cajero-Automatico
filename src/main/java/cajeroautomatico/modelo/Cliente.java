package cajeroautomatico.modelo;
/**
 *
 * @author Sveen Urzua
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String ine;
    private String direccion;
    private String telefono;
    private Cuenta cuenta;
    private ArrayList<Cuenta> cuentas;

    public Cliente(String nombre, String ine, String direccion, String telefono, Cuenta cuenta) {
        this.nombre = nombre;
        this.ine = ine;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuenta = cuenta;
        this.cuentas = new ArrayList<>();
        
    }

    public String getNombre() { return nombre; }
    public String getIne() { return ine; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public ArrayList<Cuenta> getCuentas() {return cuentas;}
    public void agregarCuenta(Cuenta cuenta) {this.cuentas.add(cuenta);}

    public Cuenta getCuentaPorTipo(Class<? extends Cuenta> tipo) {
        for (Cuenta c : cuentas) {
            if (tipo.isInstance(c)) {
                return c;
            }
        }
        return null;
    }

    public Cuenta getCuenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

