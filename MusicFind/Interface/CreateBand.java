package MusicFind.Interface;

import javax.swing.*;
import java.awt.*;

public class CreateBand extends JFrame{
    static JPanel leftBar;
    static JButton homeButton;
    static JButton searchButton;
    static JButton createEventButton;
    static JButton createBandButton;
    static JPanel mainPanel;
    static JPanel header;
    static JLabel title;
    static JPanel formPanel;
    static JPanel namePanel;
    static JTextField nameField;
    static JLabel nameLabel;
    static JPanel genrePanel;
    static JTextField genreField;
    static JLabel genreLabel;
    static JPanel cachePanel;
    static JTextField cacheField;
    static JLabel cacheLabel;
    static JPanel footer;
    static JButton createButton;

    public CreateBand() {
        super("MusicFind");
        initComponents();
    }

    public void initComponents() {
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
        createBandButton.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        createBandButton.setForeground(ColorPalette.N_WHITE.getColor());
        createBandButton.setPreferredSize(new Dimension(100, 50));
        createBandButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
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
        header.setPreferredSize(new Dimension(850, 70));
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 550));
        

        title = new JLabel("Comece sua Banda");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(ColorPalette.N_WHITE.getColor());
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        header.add(title);

        // FORM PANEL
        formPanel = new JPanel();
        formPanel.setBackground(ColorPalette.EERIE_B.getColor());
        formPanel.setPreferredSize(new Dimension(850, 600));
        formPanel.setLayout(new GridLayout(3, 2, 80, 0));

        // NAME PANEL
        namePanel = new JPanel();
        namePanel.setBackground(ColorPalette.EERIE_B.getColor());
        namePanel.setPreferredSize(new Dimension(300, 50));
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 90, 0));

        nameLabel = new JLabel("Nome do Evento:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setForeground(ColorPalette.N_WHITE.getColor());

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 30));
        nameField.setBackground(ColorPalette.ONYX.getColor());
        nameField.setForeground(ColorPalette.N_WHITE.getColor());

        namePanel.add(nameLabel);
        namePanel.add(nameField);
        // END NAME PANEL

        // DATE PANEL
        genrePanel = new JPanel();
        genrePanel.setBackground(ColorPalette.EERIE_B.getColor());
        genrePanel.setPreferredSize(new Dimension(300, 50));
        genrePanel.setLayout(new BoxLayout(genrePanel, BoxLayout.Y_AXIS));
        genrePanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 90, 0));

        genreLabel = new JLabel("Gênero Musical:");
        genreLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        genreLabel.setForeground(ColorPalette.N_WHITE.getColor());

        genreField = new JTextField();
        genreField.setPreferredSize(new Dimension(200, 30));
        genreField.setBackground(ColorPalette.ONYX.getColor());
        genreField.setForeground(ColorPalette.N_WHITE.getColor());

        genrePanel.add(genreLabel);
        genrePanel.add(genreField);
        // END DATE PANEL

        // CAPACITY PANEL
        cachePanel = new JPanel();
        cachePanel.setBackground(ColorPalette.EERIE_B.getColor());
        cachePanel.setPreferredSize(new Dimension(300, 100));
        cachePanel.setLayout(new BoxLayout(cachePanel, BoxLayout.Y_AXIS));
        cachePanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 90, 0));

        cacheLabel = new JLabel("Cache da Banda:");
        cacheLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        cacheLabel.setForeground(ColorPalette.N_WHITE.getColor());

        cacheField = new JTextField();
        cacheField.setPreferredSize(new Dimension(200, 30));
        cacheField.setBackground(ColorPalette.ONYX.getColor());
        cacheField.setForeground(ColorPalette.N_WHITE.getColor());

        cachePanel.add(cacheLabel);
        cachePanel.add(cacheField);
        // END CAPACITY PANEL
        

        formPanel.add(namePanel);
        formPanel.add(genrePanel);
        formPanel.add(cachePanel);
        // END FORM PANEL

        // FOOTER PANEL
        footer = new JPanel();
        footer.setBackground(ColorPalette.EERIE_B.getColor());
        footer.setPreferredSize(new Dimension(850, 100));
        footer.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        createButton = new JButton("Criar");
        createButton.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        createButton.setForeground(ColorPalette.N_WHITE.getColor());
        createButton.setPreferredSize(new Dimension(200, 50));
        createButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        createButton.addActionListener(e -> {
            createBand();
        });

        footer.add(createButton);


        mainPanel.add(header);
        mainPanel.add(formPanel);
        mainPanel.add(footer);

        getContentPane().add(leftBar, BorderLayout.WEST);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(ColorPalette.ONYX.getColor());
        setSize(1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void home() {
        dispose();
        Home home = new Home();
    }

    private void createEvent() {
        dispose();
        CreateEvent createEvent = new CreateEvent();
    }

    private void openSearch() {
        dispose();
        SearchPage search = new SearchPage();
    }

    private void createBand() {
        // TODO: adicionar evento no banco de dados
        dispose();
        Band band = new Band();
    }
}
