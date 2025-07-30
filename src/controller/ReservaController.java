package controller;

import models.Cliente;
import models.Habitacion;
import models.Reserva;
import models.ReservaDAO;
import views.ReservaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservaController implements ActionListener {
    private ReservaView vista;
    private DefaultTableModel modeloTabla;
    private ReservaDAO reservaDAO;
    private java.util.List<Habitacion> habitaciones;

    public ReservaController(ReservaView vista, java.util.List<Habitacion> habitaciones) {
        this.vista = vista;
        this.habitaciones = habitaciones;
        this.reservaDAO = new ReservaDAO();
        this.vista.btnReservar.addActionListener(this);
        
        String[] columnas = {"Cliente", "Habitación", "Fecha Inicio", "Fecha Fin", "Precio"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        this.vista.tablaReservas.setModel(modeloTabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String doc = vista.txtDocumentoCliente.getText();
            int numHab = Integer.parseInt(vista.txtNumeroHabitacion.getText());
            String fechaIniStr = vista.txtFechaInicio.getText();
            String fechaFinStr = vista.txtFechaFin.getText();

            // Buscar habitación
            Habitacion hab = null;
            for (Habitacion h : habitaciones) {
                if (h.getNumero() == numHab) {
                    hab = h;
                    break;
                }
            }

            if (hab == null) {
                JOptionPane.showMessageDialog(vista, "La habitación no existe");
                return;
            }

            if (!hab.isDisponible()) {
                JOptionPane.showMessageDialog(vista, "La habitación está ocupada");
                return;
            }

            // Crear reserva
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date ini = sdf.parse(fechaIniStr);
            Date fin = sdf.parse(fechaFinStr);

            Cliente cliente = new Cliente("N/A", "N/A", doc);
            Reserva reserva = new Reserva(cliente, hab, ini, fin, 100.0);

            reservaDAO.crearReserva(reserva);
            modeloTabla.addRow(new Object[]{doc, numHab, fechaIniStr, fechaFinStr, reserva.calcularTotal()});

            // Actualizar disponibilidad
            hab.setDisponible(false);

            vista.txtDocumentoCliente.setText("");
            vista.txtNumeroHabitacion.setText("");
            vista.txtFechaInicio.setText("");
            vista.txtFechaFin.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al crear la reserva: " + ex.getMessage());
        }
    }
}