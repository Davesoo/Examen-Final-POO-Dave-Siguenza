package models;

public class Recepcionista extends Usuario {
    public Recepcionista(String nombre, String usuario, String password) {
        super(nombre, usuario, password);
    }

    @Override
    public String getRol() {
        return "Recepcionista";
    }
}