package models;

public class Administrador extends Usuario {
    public Administrador(String nombre, String usuario, String password) {
        super(nombre, usuario, password);
    }

    @Override
    public String getRol() {
        return "Administrador";
    }
}