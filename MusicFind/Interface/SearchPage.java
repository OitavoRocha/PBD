package MusicFind.Interface;

import javax.swing.*;

import MusicFind.Interface.PreMade.ColorPalette;
import MusicFind.src.*;

import java.awt.*;

public class SearchPage extends JFrame {
    static JPanel leftBar;
    static JButton homeButton;
    static JButton searchButton;
    static JButton createEventButton;
    static JButton createBandButton;
    static JPanel mainPanel;
    static JPanel header;
    static JRadioButton searchByBand;
    static JRadioButton searchByEvent;
    static JRadioButton searchByMusician;
    static JPanel searchPanel;
    static JTextField searchField;
    static JPanel resultsPanel;
    static JTable resultsTable;
    static JPanel footer;
    static JButton goToButton;

    private database database;
    private User usuario;

    public SearchPage(database db, User user) {
        super("MusicFind");
        database = db;
        usuario = user;
        initComponents();
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
        searchButton.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        searchButton.setForeground(ColorPalette.N_WHITE.getColor());
        searchButton.setPreferredSize(new Dimension(100, 50));
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
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
        header.setSize(new Dimension(850, 100));
        header.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 0));
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 150));

        searchByBand = new JRadioButton("Band");
        searchByBand.setSelected(false);
        searchByBand.setBackground(ColorPalette.EERIE_B.getColor());
        searchByBand.setForeground(ColorPalette.N_WHITE.getColor());
        searchByBand.addActionListener(e -> {
            searchByEvent.setSelected(false);
            searchByMusician.setSelected(false);
            //SELECT FROM BANDA
        });

        searchByEvent = new JRadioButton("Event");
        searchByEvent.setSelected(false);
        searchByEvent.setBackground(ColorPalette.EERIE_B.getColor());
        searchByEvent.setForeground(ColorPalette.N_WHITE.getColor());
        searchByEvent.addActionListener(e -> {
            searchByBand.setSelected(false);
            searchByMusician.setSelected(false);
            //SELECT FROM EVENTO
        });

        searchByMusician = new JRadioButton("Musician");
        searchByMusician.setSelected(false);
        searchByMusician.setBackground(ColorPalette.EERIE_B.getColor());
        searchByMusician.setForeground(ColorPalette.N_WHITE.getColor());
        searchByMusician.addActionListener(e -> {
            searchByBand.setSelected(false);
            searchByEvent.setSelected(false);
            //SELECT FROM MUSICO
        });

        header.add(searchByBand);
        header.add(searchByEvent);
        header.add(searchByMusician);

        searchPanel = new JPanel();
        searchPanel.setBackground(ColorPalette.EERIE_B.getColor());
        searchPanel.setSize(new Dimension(850, 200));
        searchPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(500, 30));
        searchField.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        searchPanel.add(searchField);

        resultsPanel = new JPanel();
        resultsPanel.setBackground(ColorPalette.EERIE_B.getColor());
        resultsPanel.setSize(new Dimension(850, 600));
        resultsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        resultsTable = new JTable();
        resultsTable.setBackground(ColorPalette.JET.getColor());
        resultsTable.setForeground(ColorPalette.N_WHITE.getColor());
        resultsTable.setPreferredSize(new Dimension(800, 550));
        resultsTable.setAlignmentX(Component.CENTER_ALIGNMENT);

        resultsPanel.add(resultsTable);

        footer = new JPanel();
        footer.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        footer.setSize(new Dimension(850, 100));
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);

        goToButton = new JButton("Entrar");
        goToButton.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        goToButton.setForeground(ColorPalette.N_WHITE.getColor());
        goToButton.setPreferredSize(new Dimension(100, 30));
        goToButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        goToButton.addActionListener(e -> {
            goTo();
        });

        footer.add(goToButton);

        mainPanel.add(header);
        mainPanel.add(searchPanel);
        mainPanel.add(resultsPanel);
        mainPanel.add(footer);

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

    private void goTo() {
        // TODO: pegar o valor da tabela para ir até a página do evento/banda/músico
        
    }

    private void createBand() {
        dispose();
        CreateBand createBand = new CreateBand(database, usuario);
    }

    private void createEvent() {
        dispose();
        CreateEvent createEvent = new CreateEvent(database, usuario);
    }

    private void home() {
        dispose();
        Home home = new Home(database, usuario);
    }
}
