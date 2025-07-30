package models;

public abstract class Usuario {
    protected String nombre;
    protected String usuario;
    protected String password;

    public Usuario(String nombre, String usuario, String password) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public String getNombre() { return nombre; }
    public String getUsuario() { return usuario; }
    public String getPassword() { return password; }

    public abstract String getRol();
}