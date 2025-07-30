package controller;

import views.LoginView;
import views.MenuPrincipalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private LoginView vista;

    public LoginController(LoginView v) {
        this.vista = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = vista.getUsuario();
        String pass = vista.getPassword();

        // Validación básica
        if ((usuario.equals("admin") && pass.equals("1234")) ||
            (usuario.equals("recep") && pass.equals("1234"))) {
            JOptionPane.showMessageDialog(vista, "Login Exitoso");
            vista.dispose();
            new MenuPrincipalView();
        } else {
            JOptionPane.showMessageDialog(vista, "Credenciales incorrectas");
        }
    }
}