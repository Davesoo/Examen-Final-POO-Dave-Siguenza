package models;

public class Cliente {
    private String nombre;
    private String apellido;
    private String documento;

    public Cliente(String nombre, String apellido, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDocumento() { return documento; }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}