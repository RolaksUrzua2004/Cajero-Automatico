package cajeroautomatico;

public class Main {
    public static void main(String[] args) {
        RepositorioClientes repositorio = new RepositorioClientes();
        MenuAdminForm adminForm = new MenuAdminForm(repositorio);
        adminForm.setVisible(true);
    }
}
