package latkuis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginPage extends JFrame {
    private JTextField usernameLogin;
    private JPasswordField passwordLogin;

    public LoginPage() {
        setTitle("Halaman Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat panel dan mengatur layout
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JLabel lusername = new JLabel("Username:");
        usernameLogin = new JTextField(15);
        JLabel lpassword = new JLabel("Password:");
        passwordLogin = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        // Menambahkan komponen ke panel
        panel.add(lusername);
        panel.add(usernameLogin);
        panel.add(lpassword);
        panel.add(passwordLogin);
        panel.add(new JLabel());
        panel.add(loginButton);

        // Menambahkan panel ke frame
        add(panel);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameLogin.getText();
                String password = new String(passwordLogin.getPassword());

                if (username.equals("123230115") && password.equals("ifkelasg")) {
                    JOptionPane.showMessageDialog(panel, "Login Berhasil");
                    new BiodataPage().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau password salah!");
                }
            }
        });
    }
}
