package MusicFind.Interface;

import java.awt.*;

import javax.swing.*;

import MusicFind.Interface.PreMade.ColorPalette;
import MusicFind.Interface.PreMade.ImagePanel;
import MusicFind.src.*;

public class Login extends JFrame {
    private JButton loginButton;
    private JButton registerButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPanel usernamePanel;
    private JPanel passwordPanel;
    private JLabel loginLabel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel mainPanel;
    private JPanel loginPanel;
    private JPanel header;
    private ImagePanel logo;

    private database database;
    private User usuario;
    
    public Login(database db) {
        super("MusicFind");
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
        passwordPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(200, 50));
        loginButton.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        loginButton.setForeground(ColorPalette.N_WHITE.getColor());
        loginButton.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        loginButton.addActionListener(e -> {
            checkLogin();
        });
        
        loginPanel.add(header);
        loginPanel.add(usernamePanel);
        loginPanel.add(passwordPanel);
        loginPanel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(200, 30));
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

    private void checkLogin() {
        // TODO: fazer as coisas do login - comparar username e senha com o banco de dados //  testar se o usuario é tipo musico ou user // criar a instância de usuario adequada
        usuario = new User();

        dispose();

        Home home = new Home(database, usuario);
    }

    private void register() {
        dispose();
        Registration registration = new Registration(database);
    }
}
