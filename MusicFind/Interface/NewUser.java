package MusicFind.Interface;

import javax.swing.*;
import java.awt.*;

import MusicFind.Interface.PreMade.ColorPalette;
import MusicFind.Interface.PreMade.Label;
import MusicFind.src.*;

public class NewUser extends JFrame{
    static JPanel mainPanel;
    static JPanel innerPanel;
    static JPanel contactPanel;
    static Label contactLabel;
    static JTextField contactField;
    static JPanel typePanel;
    static Label typeLabel;
    static JComboBox<String> typeBox;
    static JPanel yearsPanel;
    static JTextField yearsField;
    static Label yearsLabel;
    static JPanel instrumentPanel;
    static JTextField instrumentField;
    static Label instrumentLabel;
    static JPanel genrePanel;
    static JTextField genreField;
    static Label genreLabel;
    static JPanel cachePanel;
    static JTextField cacheField;
    static Label cacheLabel;
    static JPanel footer;
    static JButton confirmButton;

    static database database;
    static User usuario;
    
    public NewUser(database db, User user){
        super("MusicFind");
        usuario = user;
        database = db;
        initComponents();
    }

    private void initComponents() {
        mainPanel = new JPanel();
        mainPanel.setBackground(ColorPalette.JET.getColor());
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));

        innerPanel = new JPanel();
        innerPanel.setBackground(ColorPalette.ONYX.getColor());
        innerPanel.setPreferredSize(new Dimension(400, 600));
        innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        contactPanel = new JPanel();
        contactPanel.setBackground(ColorPalette.ONYX.getColor());
        contactPanel.setPreferredSize(new Dimension(400, 70));
        contactPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));

        contactLabel = new Label("Insira seu telefone:");

        contactField = new JTextField();
        contactField.setPreferredSize(new Dimension(360, 30));

        contactPanel.add(contactLabel);
        contactPanel.add(contactField);

        typePanel = new JPanel();
        typePanel.setBackground(ColorPalette.ONYX.getColor());
        typePanel.setPreferredSize(new Dimension(400, 100));
        typePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        typeLabel = new Label("Você é músico(a)?");

        typeBox = new JComboBox<>();
        typeBox.addItem("Não");
        typeBox.addItem("Sim");
        typeBox.setPreferredSize(new Dimension(200, 30));
        typeBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeBox.setBackground(ColorPalette.ONYX.getColor());
        typeBox.setForeground(ColorPalette.N_WHITE.getColor());
        typeBox.addActionListener(e -> {
            if (typeBox.getSelectedItem().equals("Sim")) {
                yearsPanel.setVisible(true);
                instrumentPanel.setVisible(true);
                genrePanel.setVisible(true);
                cachePanel.setVisible(true);
            } else {
                yearsPanel.setVisible(false);
                instrumentPanel.setVisible(false);
                genrePanel.setVisible(false);
                cachePanel.setVisible(false);
            }
        });

        typePanel.add(typeLabel);
        typePanel.add(typeBox);

        yearsPanel = new JPanel();
        yearsPanel.setBackground(ColorPalette.ONYX.getColor());
        yearsPanel.setPreferredSize(new Dimension(400, 70));
        yearsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        yearsLabel = new Label("Anos de Experiência:");

        yearsField = new JTextField();
        yearsField.setPreferredSize(new Dimension(360, 30));

        yearsPanel.add(yearsLabel);
        yearsPanel.add(yearsField);

        instrumentPanel = new JPanel();
        instrumentPanel.setBackground(ColorPalette.ONYX.getColor());
        instrumentPanel.setPreferredSize(new Dimension(400, 70));
        instrumentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        instrumentLabel = new Label("Instrumento:");

        instrumentField = new JTextField();
        instrumentField.setPreferredSize(new Dimension(360, 30));

        instrumentPanel.add(instrumentLabel);
        instrumentPanel.add(instrumentField);

        genrePanel = new JPanel();
        genrePanel.setBackground(ColorPalette.ONYX.getColor());
        genrePanel.setPreferredSize(new Dimension(400, 70));
        genrePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        genreLabel = new Label("Estilo Musical:");

        genreField = new JTextField();
        genreField.setPreferredSize(new Dimension(360, 30));
        
        genrePanel.add(genreLabel);
        genrePanel.add(genreField);

        cachePanel = new JPanel();
        cachePanel.setBackground(ColorPalette.ONYX.getColor());
        cachePanel.setPreferredSize(new Dimension(400, 70));
        cachePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        cacheLabel = new Label("Cache Médio:");
        
        cacheField = new JTextField();
        cacheField.setPreferredSize(new Dimension(360, 30));
        
        cachePanel.add(cacheLabel);
        cachePanel.add(cacheField);

        footer = new JPanel();
        footer.setBackground(ColorPalette.ONYX.getColor());
        footer.setPreferredSize(new Dimension(800, 70));
        footer.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 0));

        confirmButton = new JButton("Confirmar");
        confirmButton.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        confirmButton.setPreferredSize(new Dimension(250, 60));
        confirmButton.setForeground(ColorPalette.N_WHITE.getColor());
        confirmButton.addActionListener( e -> {
            cadastrarUsuario();
        });

        footer.add(confirmButton);
        
        yearsPanel.setVisible(false);
        instrumentPanel.setVisible(false);
        genrePanel.setVisible(false);
        cachePanel.setVisible(false);

        innerPanel.add(contactPanel);
        innerPanel.add(typePanel);
        innerPanel.add(yearsPanel);
        innerPanel.add(instrumentPanel);
        innerPanel.add(genrePanel);
        innerPanel.add(cachePanel);
        innerPanel.add(footer);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        mainPanel.add(innerPanel);


        

        getContentPane().add(mainPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(ColorPalette.ONYX.getColor());
        setSize(1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarUsuario() {
        usuario.setContato(contactField.getText());
        usuario.setRating(5.0f);
        if (typeBox.getSelectedItem().equals("Sim")) {
            usuario.setTipo("Musico");
            usuario.setAnos_experiencia(Integer.parseInt(yearsField.getText()));
            usuario.setInstrumento(instrumentField.getText());
            usuario.setGenero(genreField.getText());
            usuario.setCache(Float.parseFloat(cacheField.getText()));
        } else {
            usuario.setTipo("Usuario");
            usuario.setAnos_experiencia(0);
            usuario.setInstrumento("");
            usuario.setGenero("");
            usuario.setCache(0);
        }
        usuario.printUser();
        
        database.insertUser(usuario);
        
        dispose();
        Home home = new Home(database, usuario);
    }

}
