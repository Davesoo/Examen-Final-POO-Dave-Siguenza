package controller;

import models.Habitacion;
import models.TipoHabitacion;
import views.HabitacionView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class HabitacionController implements ActionListener {
    private HabitacionView vista;
    private DefaultTableModel modeloTabla;

    public HabitacionController(HabitacionView vista) {
        this.vista = vista;
        this.vista.btnAgregar.addActionListener(this);

        String[] columnas = {"Número", "Tipo", "Disponible"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        this.vista.tablaHabitaciones.setModel(modeloTabla);
    }

    private java.util.List<Habitacion> listaHabitaciones = new java.util.ArrayList<>();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int numero = Integer.parseInt(vista.txtNumero.getText());
            String tipoStr = (String) vista.cbTipo.getSelectedItem();
            TipoHabitacion tipo = TipoHabitacion.valueOf(tipoStr);

            // Verificar si ya existe
            for (Habitacion h : listaHabitaciones) {
                if (h.getNumero() == numero) {
                    JOptionPane.showMessageDialog(vista, "La habitación ya existe");
                    return;
                }
            }

            Habitacion hab = new Habitacion(numero, tipo);
            listaHabitaciones.add(hab);

            modeloTabla.addRow(new Object[]{hab.getNumero(), hab.getTipo(), hab.isDisponible() ? "Sí" : "No"});
            vista.txtNumero.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Número inválido");
        }
    }

    public java.util.List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }
}