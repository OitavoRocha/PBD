package MusicFind.Interface;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class Band extends JFrame{
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
    static JPanel eventsPanel;
    static JTextArea eventsInfo;
    static JPanel bandPanel;
    static JTextArea bandInfo;
    static JTextArea repertoireArea;
    static JButton repertoireButton;


    public Band() {
        super("MusicFind");
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

        profileLabel = new JLabel("Banda");
        profileLabel.setForeground(ColorPalette.N_WHITE.getColor());
        profileLabel.setFont(new Font("Arial", Font.BOLD, 26));
        profileLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        profileInfo = new JTextArea();
        profileInfo.setBackground(ColorPalette.EERIE_B.getColor());
        profileInfo.setForeground(ColorPalette.N_WHITE.getColor());
        profileInfo.setFont(new Font("Arial", Font.PLAIN, 13));
        profileInfo.setText("info");
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

        eventsPanel = new JPanel();
        eventsPanel.setBackground(ColorPalette.EERIE_B.getColor());
        eventsPanel.setPreferredSize(new Dimension(850, 250));

        eventsInfo = new JTextArea();
        eventsInfo.setBackground(ColorPalette.EERIE_B.getColor());
        eventsInfo.setForeground(ColorPalette.N_WHITE.getColor());
        eventsInfo.setPreferredSize(new Dimension(800, 200));
        eventsInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        eventsInfo.setText("Eventos: \n");
        eventsInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        eventsInfo.setLineWrap(true);
        eventsInfo.setWrapStyleWord(true);
        eventsInfo.setEditable(false);
        
        eventsPanel.add(eventsInfo);

        bandPanel = new JPanel();
        bandPanel.setBackground(ColorPalette.EERIE_B.getColor());
        bandPanel.setPreferredSize(new Dimension(850, 250));
        bandPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
        bandPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        repertoireArea = new JTextArea();
        repertoireArea.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        repertoireArea.setForeground(ColorPalette.N_WHITE.getColor());
        repertoireArea.setPreferredSize(new Dimension(700, 200));
        repertoireArea.setFont(new Font("Arial", Font.PLAIN, 16));
        repertoireArea.setText("repertorio");
        repertoireArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        repertoireArea.setLineWrap(true);
        repertoireArea.setWrapStyleWord(true);
        repertoireArea.setEditable(false);

        repertoireButton = new JButton("<html>Adicionar ao <br> repertório");
        repertoireButton.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        repertoireButton.setForeground(ColorPalette.N_WHITE.getColor());
        repertoireButton.setPreferredSize(new Dimension(100, 50));
        repertoireButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        repertoireButton.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        repertoireButton.addActionListener(e -> {
            addRepertoire();
        });

        bandPanel.add(repertoireArea);
        bandPanel.add(repertoireButton);

        mainPanel.add(header);
        mainPanel.add(bandPanel);
        mainPanel.add(eventsPanel);
        
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

    private void addRepertoire() {
        RepertoireAdd repertoire = new RepertoireAdd();
    }

    private void home() {
        dispose();
        Home home = new Home();
    }

    private void createBand() {
        dispose();
        CreateBand createBand = new CreateBand();
    }

    private void createEvent() {
        dispose();
        CreateEvent createEvent = new CreateEvent();
    }

    private void openSearch() {
        dispose();
        SearchPage search = new SearchPage();
    }
}
