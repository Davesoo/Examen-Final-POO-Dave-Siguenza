package views;

import javax.swing.*;
import java.awt.*;

public class HabitacionView extends JPanel {
    public JTextField txtNumero;
    public JComboBox<String> cbTipo;
    public JButton btnAgregar;
    public JTable tablaHabitaciones;

    public HabitacionView() {
        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(3, 2));
        formulario.add(new JLabel("Número:"));
        txtNumero = new JTextField();
        formulario.add(txtNumero);

        formulario.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"INDIVIDUAL", "DOBLE", "SUITE"});
        formulario.add(cbTipo);

        btnAgregar = new JButton("Agregar Habitación");
        formulario.add(btnAgregar);

        add(formulario, BorderLayout.NORTH);

        String[] columnas = {"Número", "Tipo", "Disponible"};
        Object[][] datos = {};
        tablaHabitaciones = new JTable(datos, columnas);
        add(new JScrollPane(tablaHabitaciones), BorderLayout.CENTER);
    }
}