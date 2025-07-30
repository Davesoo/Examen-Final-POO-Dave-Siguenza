package views;

import javax.swing.*;
import java.awt.*;

public class ReservaView extends JPanel {
    public JTextField txtDocumentoCliente;
    public JTextField txtNumeroHabitacion;
    public JTextField txtFechaInicio;
    public JTextField txtFechaFin;
    public JButton btnReservar;
    public JTable tablaReservas;

    public ReservaView() {
        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(5, 2));
        formulario.add(new JLabel("Documento Cliente:"));
        txtDocumentoCliente = new JTextField();
        formulario.add(txtDocumentoCliente);

        formulario.add(new JLabel("Número Habitación:"));
        txtNumeroHabitacion = new JTextField();
        formulario.add(txtNumeroHabitacion);

        formulario.add(new JLabel("Fecha Inicio (dd/mm/aaaa):"));
        txtFechaInicio = new JTextField();
        formulario.add(txtFechaInicio);

        formulario.add(new JLabel("Fecha Fin (dd/mm/aaaa):"));
        txtFechaFin = new JTextField();
        formulario.add(txtFechaFin);

        btnReservar = new JButton("Crear Reserva");
        formulario.add(btnReservar);

        add(formulario, BorderLayout.NORTH);

        String[] columnas = {"Cliente", "Habitación", "Fecha Inicio", "Fecha Fin", "Precio"};
        Object[][] datos = {};
        tablaReservas = new JTable(datos, columnas);
        add(new JScrollPane(tablaReservas), BorderLayout.CENTER);
    }
}