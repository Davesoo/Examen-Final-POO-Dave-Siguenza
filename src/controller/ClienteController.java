package controller;

import models.Cliente;
import views.ClienteView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ClienteController implements ActionListener {
    private ClienteView vista;
    private DefaultTableModel modeloTabla;

    public ClienteController(ClienteView vista) {
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(this);

        String[] columnas = {"Nombre", "Apellido", "Documento"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        this.vista.tablaClientes.setModel(modeloTabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = vista.txtNombre.getText();
        String apellido = vista.txtApellido.getText();
        String documento = vista.txtDocumento.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || documento.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios");
            return;
        }

        Cliente cliente = new Cliente(nombre, apellido, documento);
        modeloTabla.addRow(new Object[]{cliente.getNombre(), cliente.getApellido(), cliente.getDocumento()});

        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtDocumento.setText("");
    }
}