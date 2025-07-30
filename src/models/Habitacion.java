package models;

public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private boolean disponible;

    public Habitacion(int numero, TipoHabitacion tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = true;
    }

    public int getNumero() { return numero; }
    public TipoHabitacion getTipo() { return tipo; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean d) { disponible = d; }
}