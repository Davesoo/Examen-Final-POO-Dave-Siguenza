package views;

import javax.swing.*;

import controller.ClienteController;
import controller.HabitacionController;
import controller.ReservaController;

public class MenuPrincipalView extends JFrame {
    private JTabbedPane pestañas;
    public ClienteView panelClientes;
    public HabitacionView panelHabitaciones;
    public ReservaView panelReservas;

    public MenuPrincipalView() {
        setTitle("Sistema de Gestión de Hotel");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pestañas = new JTabbedPane();
        panelClientes = new ClienteView();
        panelHabitaciones = new HabitacionView();
        panelReservas = new ReservaView();

        pestañas.add("Clientes", panelClientes);
        pestañas.add("Habitaciones", panelHabitaciones);
        pestañas.add("Reservas", panelReservas);

        add(pestañas);


        HabitacionController habitacionCtrl = new HabitacionController(panelHabitaciones);
        new ClienteController(panelClientes);
        new ReservaController(panelReservas, habitacionCtrl.getListaHabitaciones());

        setLocationRelativeTo(null);
        setVisible(true);
    }
}