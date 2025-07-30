package models;

import java.util.Date;

public class Reserva implements Pago {
    private Cliente cliente;
    private Habitacion habitacion;
    private Date fechaInicio;
    private Date fechaFin;
    private double precio;

    public Reserva(Cliente c, Habitacion h, Date ini, Date fin, double precio) {
        this.cliente = c;
        this.habitacion = h;
        this.fechaInicio = ini;
        this.fechaFin = fin;
        this.precio = precio;
    }

    public Cliente getCliente() { return cliente; }
    public Habitacion getHabitacion() { return habitacion; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    public double getPrecio() { return precio; }

    @Override
    public double calcularTotal() {
        return precio;
    }
}