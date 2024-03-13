package MusicFind.Interface;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.*;

import MusicFind.Interface.PreMade.ColorPalette;
import MusicFind.src.*;


import java.awt.*;
import java.util.ArrayList;

public class Musician extends JFrame {
    static JPanel leftBar;
    static JButton homeButton;
    static JButton searchButton;
    static JButton createEventButton;
    static JButton createBandButton;
    static JPanel mainPanel;
    static JPanel header;
    static JPanel profilePanel;
    static JLabel profileLabel;
    static JTextArea profileInfo;
    static JPanel genrePanel;
    static JLabel genreLabel;
    static JPanel ratingPanel;
    static JLabel ratingLabel;
    static JPanel infoPanel;
    static JTextArea musicianInfo;
    static JPanel repPanel;
    static JTextArea repertoireArea;

    private database database;
    private User usuario;
    private int idMusician;


    public Musician(database db, User user, int id) {
        super("MusicFind");
        database = db;
        usuario = user;
        idMusician = id;
        initComponents();
        setInfo();
    }

    
    private void initComponents() {
        
        // LEFT BAR COMPONENTS
        leftBar = new JPanel();
        leftBar.setBackground(ColorPalette.JET.getColor());
        leftBar.setSize(new Dimension(150, 800));
        leftBar.setLayout(new BoxLayout(leftBar, BoxLayout.Y_AXIS));
        
        homeButton = new JButton("H");
        homeButton.setBackground(ColorPalette.ONYX.getColor());
        homeButton.setForeground(ColorPalette.N_WHITE.getColor());
        homeButton.setPreferredSize(new Dimension(100, 50));
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.addActionListener(e -> {
            home();
        });
        
        searchButton = new JButton("S");
        searchButton.setBackground(ColorPalette.ONYX.getColor());
        searchButton.setForeground(ColorPalette.N_WHITE.getColor());
        searchButton.setPreferredSize(new Dimension(100, 50));
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton.addActionListener(e -> {
            openSearch();
        });
        
        createEventButton = new JButton("CE");
        createEventButton.setBackground(ColorPalette.ONYX.getColor());
        createEventButton.setForeground(ColorPalette.N_WHITE.getColor());
        createEventButton.setPreferredSize(new Dimension(100, 50));
        createEventButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createEventButton.addActionListener(e -> {
            createEvent();
        });
        
        createBandButton = new JButton("CB");
        createBandButton.setBackground(ColorPalette.ONYX.getColor());
        createBandButton.setForeground(ColorPalette.N_WHITE.getColor());
        createBandButton.setPreferredSize(new Dimension(100, 50));
        createBandButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createBandButton.addActionListener(e -> {
            createBand();
        });
        
        leftBar.add(Box.createRigidArea(new Dimension(0, 50)));
        leftBar.add(homeButton);
        leftBar.add(Box.createRigidArea(new Dimension(0, 20)));
        leftBar.add(searchButton);
        leftBar.add(Box.createRigidArea(new Dimension(0, 20)));
        leftBar.add(createEventButton);
        leftBar.add(Box.createRigidArea(new Dimension(0, 20)));
        leftBar.add(createBandButton);
        // END LEFT BAR COMPONENTS
        
        // MAIN PANEL COMPONENTS
        mainPanel = new JPanel();
        mainPanel.setBackground(ColorPalette.EERIE_B.getColor());

        header = new JPanel();
        header.setBackground(ColorPalette.EERIE_B.getColor());
        header.setSize(new Dimension(850, 200));
        header.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 10));
        
        profilePanel = new JPanel();
        profilePanel.setBackground(ColorPalette.EERIE_B.getColor());
        profilePanel.setPreferredSize(new Dimension(200, 200));
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));

        profileLabel = new JLabel("Perfil");
        profileLabel.setForeground(ColorPalette.N_WHITE.getColor());
        profileLabel.setFont(new Font("Arial", Font.BOLD, 26));
        profileLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        profileInfo = new JTextArea();
        profileInfo.setBackground(ColorPalette.EERIE_B.getColor());
        profileInfo.setForeground(ColorPalette.N_WHITE.getColor());
        profileInfo.setFont(new Font("Arial", Font.PLAIN, 13));
        profileInfo.setText("nome: \nemail: \nlocalização: \n");
        profileInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        profileInfo.setLineWrap(true);
        profileInfo.setWrapStyleWord(true);
        profileInfo.setEditable(false);
        profileInfo.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        profilePanel.add(profileLabel);
        profilePanel.add(profileInfo);

        genrePanel = new JPanel();
        genrePanel.setBackground(ColorPalette.EERIE_B.getColor());
        genrePanel.setPreferredSize(new Dimension(200, 200));

        genreLabel = new JLabel("Gênero");
        genreLabel.setForeground(ColorPalette.N_WHITE.getColor());
        genreLabel.setFont(new Font("Arial", Font.BOLD, 40));
        genreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        genrePanel.add(Box.createRigidArea(new Dimension(0, 100)));
        genrePanel.add(genreLabel);
        
        ratingPanel = new JPanel();
        ratingPanel.setBackground(ColorPalette.EERIE_B.getColor());
        ratingPanel.setPreferredSize(new Dimension(200, 200));

        ratingLabel = new JLabel("5.0");
        ratingLabel.setForeground(ColorPalette.N_WHITE.getColor());
        ratingLabel.setFont(new Font("Arial", Font.BOLD, 40));
        ratingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ratingPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        ratingPanel.add(ratingLabel);

        header.add(profilePanel, BorderLayout.WEST);
        header.add(genrePanel, BorderLayout.CENTER);
        header.add(ratingPanel, BorderLayout.EAST);

        infoPanel = new JPanel();
        infoPanel.setBackground(ColorPalette.EERIE_B.getColor());
        infoPanel.setPreferredSize(new Dimension(850, 250));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));

        musicianInfo = new JTextArea();
        musicianInfo.setBackground(ColorPalette.EERIE_B.getColor());
        musicianInfo.setForeground(ColorPalette.N_WHITE.getColor());
        musicianInfo.setPreferredSize(new Dimension(700, 200));
        musicianInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        musicianInfo.setText("dados do musico");
        musicianInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        musicianInfo.setLineWrap(true);
        musicianInfo.setWrapStyleWord(true);
        musicianInfo.setEditable(false);
        musicianInfo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        infoPanel.add(musicianInfo);
        
        repPanel = new JPanel();
        repPanel.setBackground(ColorPalette.EERIE_B.getColor());
        repPanel.setPreferredSize(new Dimension(850, 250));
        repPanel.setLayout(new BoxLayout(repPanel, BoxLayout.X_AXIS));

        repertoireArea = new JTextArea();
        repertoireArea.setBackground(ColorPalette.EERIE_B.getColor());
        repertoireArea.setForeground(ColorPalette.N_WHITE.getColor());
        repertoireArea.setPreferredSize(new Dimension(300, 200));
        repertoireArea.setFont(new Font("Arial", Font.PLAIN, 16));
        repertoireArea.setText("repertorio");
        repertoireArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        repertoireArea.setLineWrap(true);
        repertoireArea.setWrapStyleWord(true);
        repertoireArea.setEditable(false);

        repPanel.add(repertoireArea);

        mainPanel.add(header);
        mainPanel.add(infoPanel);
        mainPanel.add(repPanel);
        
        getContentPane().add(leftBar, BorderLayout.WEST);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(ColorPalette.ONYX.getColor());
        setSize(1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void home() {
        dispose();
        Home home = new Home(database, usuario);
    }
    
    private void createBand() {
        dispose();
        CreateBand createBand = new CreateBand(database, usuario);
    }

    private void createEvent() {
        dispose();
        CreateEvent createEvent = new CreateEvent(database, usuario);
    }

    private void openSearch() {
        dispose();
        SearchPage search = new SearchPage(database, usuario);
    }

    private void setInfo() {
        // TODO: pegar os valores do usuário logado
        ArrayList<String> info = database.getMusicoData(idMusician);
        info.addAll(database.getUserDataFromID(idMusician));
        System.out.println(info);
        profileLabel.setText(info.get(8));
        profileInfo.setText("Contato: " + info.get(6));
        ratingLabel.setText(info.get(7));
        genreLabel.setText(info.get(0));
        musicianInfo.setText("Instrumento: " + info.get(1) + "\nAnos de Experiência: " + info.get(2) + "\nCache: " + info.get(3));
        updateRepertoire();
    }
    //  0       1       2   3   4   5   6            7    8    9       10
    // [Rock, Guitarra, 8, 200, 1, 1, 11111111111, 4.5, joao, senha123, Musico]
    public void updateRepertoire() {
        repertoireArea.setText(String.join("\n", database.getRepertoireMusico(idMusician)));
    }
}

