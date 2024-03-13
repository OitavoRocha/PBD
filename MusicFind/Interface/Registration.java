package MusicFind.Interface;

import javax.swing.*;

import MusicFind.Interface.PreMade.ColorPalette;
import MusicFind.Interface.PreMade.ImagePanel;
import MusicFind.src.User;
import MusicFind.src.database;

import java.awt.*;
import java.util.ArrayList;
public class Registration extends JFrame{
    private JButton registerButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JPanel usernamePanel;
    private JPanel passwordPanel;
    private JPanel confirmPasswordPanel;
    private JLabel loginLabel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel mainPanel;
    private JPanel loginPanel;
    private JPanel header;
    private ImagePanel logo;

    private static database database;
    private static User usuario;
    
    public Registration(database db) {
        super("MusicFind");
        usuario = new User();
        database = db;
        initComponents();
    }

    private void initComponents() {
        header = new JPanel();
        header.setBackground(ColorPalette.JET.getColor());
        header.setPreferredSize(new Dimension(200, 32));

        loginLabel = new JLabel("Login");
        loginLabel.setForeground(ColorPalette.N_WHITE.getColor());
        loginLabel.setFont(new Font("Arial", Font.BOLD, 24));
        loginLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        header.add(loginLabel);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        leftPanel = new JPanel();
        leftPanel.setBackground(ColorPalette.EERIE_B.getColor());
        leftPanel.setPreferredSize(new Dimension(500, 800));
        
        // TODO: Trocar imagem provisoria
        logo = new ImagePanel("Images\\musicFinc.png");
        
        leftPanel.add(Box.createRigidArea(new Dimension(0, 600)));
        leftPanel.add(logo);
        
        rightPanel = new JPanel();
        rightPanel.setBackground(ColorPalette.EERIE_B.getColor());
        rightPanel.setPreferredSize(new Dimension(500, 800));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 50));
        loginPanel.setBackground(ColorPalette.JET.getColor());
        loginPanel.setPreferredSize(new Dimension(300, 300));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 50));

        usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(ColorPalette.N_WHITE.getColor());
        usernameLabel.setFont(new Font("Arial", Font.PLAIN , 18));
        usernameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        usernameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200, 30));
        usernameField.setMaximumSize(new Dimension(200, 30));
        usernameField.setForeground(ColorPalette.ONYX.getColor());
        usernameField.setAlignmentX(Component.LEFT_ALIGNMENT);

        usernamePanel = new JPanel();
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.Y_AXIS));
        usernamePanel.setBackground(ColorPalette.JET.getColor());
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        
        passwordLabel = new JLabel("Senha");
        passwordLabel.setForeground(ColorPalette.N_WHITE.getColor());
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setMaximumSize(new Dimension(200, 30));
        passwordField.setForeground(ColorPalette.ONYX.getColor());
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
        passwordPanel.setBackground(ColorPalette.JET.getColor());
        passwordPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        // aaa
        confirmPasswordLabel = new JLabel("Confirme a senha");
        confirmPasswordLabel.setForeground(ColorPalette.N_WHITE.getColor());
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmPasswordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        confirmPasswordLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(new Dimension(200, 30));
        confirmPasswordField.setMaximumSize(new Dimension(200, 30));
        confirmPasswordField.setForeground(ColorPalette.ONYX.getColor());
        confirmPasswordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        confirmPasswordPanel = new JPanel();
        confirmPasswordPanel.setLayout(new BoxLayout(confirmPasswordPanel, BoxLayout.Y_AXIS));
        confirmPasswordPanel.setBackground(ColorPalette.JET.getColor());
        confirmPasswordPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        confirmPasswordPanel.add(confirmPasswordLabel);
        confirmPasswordPanel.add(confirmPasswordField);
        
        
        loginPanel.add(header);
        loginPanel.add(usernamePanel);
        loginPanel.add(passwordPanel);
        loginPanel.add(confirmPasswordPanel);

        registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(400, 50));
        registerButton.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        registerButton.setForeground(ColorPalette.N_WHITE.getColor());
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.addActionListener(e -> {
            register();
        });

        rightPanel.add(loginPanel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        rightPanel.add(registerButton);
        
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        getContentPane().add(mainPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(ColorPalette.ONYX.getColor());
        setSize(1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void register() {
        String username = usernameField.getText();
        String userpassword = passwordField.getText();
        String userpasswordConfirm = confirmPasswordField.getText();

        ArrayList<String> usernames = database.getUsernames();

        if (username.equals("") || userpassword.equals("") || userpasswordConfirm.equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (usernames.contains(username)) {
            JOptionPane.showMessageDialog(this, "Nome de usuário já existente", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!(userpassword.equals(userpasswordConfirm))) {
            JOptionPane.showMessageDialog(this, "As senhas não coincidem", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Usuário registrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        usuario.username = username;
        usuario.userpassword = userpassword;
        
        dispose();
        NewUser newUser = new NewUser(database, usuario);
    }
}
