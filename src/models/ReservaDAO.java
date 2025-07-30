package models;

import java.util.*;

public class ReservaDAO {
    private List<Reserva> reservas = new ArrayList<>();

    public void crearReserva(Reserva r) {
        reservas.add(r);
    }

    public List<Reserva> listar() {
        return reservas;
    }
}