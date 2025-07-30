package views;

import javax.swing.*;
import controller.LoginController;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPass;
    private JButton btnLogin;

    public LoginView() {
        setTitle("Login de Usuario");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setBounds(30, 30, 80, 25);
        add(lblUser);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 30, 130, 25);
        add(txtUsuario);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(30, 70, 80, 25);
        add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds(120, 70, 130, 25);
        add(txtPass);

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(90, 110, 100, 30);
        add(btnLogin);

        btnLogin.addActionListener(new LoginController(this));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getUsuario() { return txtUsuario.getText(); }
    public String getPassword() { return new String(txtPass.getPassword()); }
}