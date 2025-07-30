package views;

import javax.swing.*;
import java.awt.*;

public class ClienteView extends JPanel {
    public JTextField txtNombre, txtApellido, txtDocumento;
    public JButton btnRegistrar;
    public JTable tablaClientes;
    public DefaultListModel<String> listaModel;

    public ClienteView() {
        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(4, 2));
        formulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        formulario.add(txtNombre);

        formulario.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        formulario.add(txtApellido);

        formulario.add(new JLabel("Documento:"));
        txtDocumento = new JTextField();
        formulario.add(txtDocumento);

        btnRegistrar = new JButton("Registrar Cliente");
        formulario.add(btnRegistrar);

        add(formulario, BorderLayout.NORTH);

        String[] columnas = {"Nombre", "Apellido", "Documento"};
        Object[][] datos = {};
        tablaClientes = new JTable(datos, columnas);
        add(new JScrollPane(tablaClientes), BorderLayout.CENTER);
    }
}