package MusicFind.Interface;

import javax.swing.*;

import MusicFind.Interface.PreMade.ColorPalette;
import MusicFind.src.*;


import java.awt.*;

public class Event extends JFrame {
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
    static JPanel participantsPanel;
    static JTextArea participantsInfo;
    static JPanel infoPanel;
    static JTextArea info;

    private database database;
    private User usuario;
    private int idEvento;
    
    public Event(database db, User user, int id) {
        super("MusicFind");
        idEvento = id;
        database = db;
        usuario = user;
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
        header.setLayout(new FlowLayout(FlowLayout.LEFT, 450, 10));
        
        profilePanel = new JPanel();
        profilePanel.setBackground(ColorPalette.EERIE_B.getColor());
        profilePanel.setPreferredSize(new Dimension(200, 200));
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        
        profileLabel = new JLabel("Evento");
        profileLabel.setForeground(ColorPalette.N_WHITE.getColor());
        profileLabel.setFont(new Font("Arial", Font.BOLD, 40));
        profileLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        //profilePanel.add(Box.createRigidArea(new Dimension(0, 100)));
        profilePanel.add(profileLabel, BorderLayout.WEST);

        genrePanel = new JPanel();
        genrePanel.setBackground(ColorPalette.EERIE_B.getColor());
        genrePanel.setPreferredSize(new Dimension(200, 200));
        
        genreLabel = new JLabel("Gênero");
        genreLabel.setForeground(ColorPalette.N_WHITE.getColor());
        genreLabel.setFont(new Font("Arial", Font.BOLD, 26));
        genreLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        genrePanel.add(genreLabel);
        
        header.add(profilePanel, BorderLayout.WEST);
        header.add(genrePanel, BorderLayout.EAST);
        
        infoPanel = new JPanel();
        infoPanel.setBackground(ColorPalette.EERIE_B.getColor());
        infoPanel.setPreferredSize(new Dimension(850, 250));
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        info = new JTextArea();
        info.setBackground(ColorPalette.EERIE_B.getColor());
        info.setForeground(ColorPalette.N_WHITE.getColor());
        info.setPreferredSize(new Dimension(800, 200));
        info.setFont(new Font("Arial", Font.PLAIN, 16));
        info.setText("info");
        info.setAlignmentX(Component.LEFT_ALIGNMENT);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setEditable(false);
        
        infoPanel.add(info);
        
        participantsPanel = new JPanel();
        participantsPanel.setBackground(ColorPalette.EERIE_B.getColor());
        participantsPanel.setPreferredSize(new Dimension(850, 250));
        
        participantsInfo = new JTextArea();
        participantsInfo.setBackground(ColorPalette.EERIE_B.getColor());
        participantsInfo.setForeground(ColorPalette.N_WHITE.getColor());
        participantsInfo.setPreferredSize(new Dimension(800, 200));
        participantsInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        participantsInfo.setText("participantes");
        participantsInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        participantsInfo.setLineWrap(true);
        participantsInfo.setWrapStyleWord(true);
        participantsInfo.setEditable(false);
        
        participantsPanel.add(participantsInfo);
        
        
        mainPanel.add(header);
        mainPanel.add(infoPanel);
        mainPanel.add(participantsPanel);
        
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
        // TODO: setar com as informações do data base -- faz isso com base no idEvento
    }
}
