package MusicFind.Interface;

import java.awt.*;
import javax.swing.*;

public class CreateEvent extends JFrame{
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
    static JPanel datePanel;
    static JTextField dateField;
    static JLabel dateLabel;
    static JPanel capacityPanel;
    static JTextField capacityField;
    static JLabel capacityLabel;
    static JPanel locationPanel;
    static JTextField locationField;
    static JLabel locationLabel;
    static JPanel focusPanel;
    static JTextField focusField;
    static JLabel focusLabel;
    static JPanel footer;
    static JButton createButton;


    public CreateEvent() {
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
        createEventButton.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        createEventButton.setForeground(ColorPalette.N_WHITE.getColor());
        createEventButton.setPreferredSize(new Dimension(100, 50));
        createEventButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
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
        header.setPreferredSize(new Dimension(850, 70));
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 600));
        

        title = new JLabel("Crie seu Evento");
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
        datePanel = new JPanel();
        datePanel.setBackground(ColorPalette.EERIE_B.getColor());
        datePanel.setPreferredSize(new Dimension(300, 50));
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.Y_AXIS));
        datePanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 90, 0));

        dateLabel = new JLabel("Data do Evento:");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dateLabel.setForeground(ColorPalette.N_WHITE.getColor());

        dateField = new JTextField();
        dateField.setPreferredSize(new Dimension(200, 30));
        dateField.setBackground(ColorPalette.ONYX.getColor());
        dateField.setForeground(ColorPalette.N_WHITE.getColor());

        datePanel.add(dateLabel);
        datePanel.add(dateField);
        // END DATE PANEL

        // CAPACITY PANEL
        capacityPanel = new JPanel();
        capacityPanel.setBackground(ColorPalette.EERIE_B.getColor());
        capacityPanel.setPreferredSize(new Dimension(300, 100));
        capacityPanel.setLayout(new BoxLayout(capacityPanel, BoxLayout.Y_AXIS));
        capacityPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 90, 0));

        capacityLabel = new JLabel("Capacidade do Evento:");
        capacityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        capacityLabel.setForeground(ColorPalette.N_WHITE.getColor());

        capacityField = new JTextField();
        capacityField.setPreferredSize(new Dimension(200, 30));
        capacityField.setBackground(ColorPalette.ONYX.getColor());
        capacityField.setForeground(ColorPalette.N_WHITE.getColor());

        capacityPanel.add(capacityLabel);
        capacityPanel.add(capacityField);
        // END CAPACITY PANEL

        // LOCATION PANEL
        locationPanel = new JPanel();
        locationPanel.setBackground(ColorPalette.EERIE_B.getColor());
        locationPanel.setPreferredSize(new Dimension(300, 100));
        locationPanel.setLayout(new BoxLayout(locationPanel, BoxLayout.Y_AXIS));
        locationPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 90, 0));

        locationLabel = new JLabel("Local do Evento:");
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        locationLabel.setForeground(ColorPalette.N_WHITE.getColor());

        locationField = new JTextField();
        locationField.setPreferredSize(new Dimension(200, 30));
        locationField.setBackground(ColorPalette.ONYX.getColor());
        locationField.setForeground(ColorPalette.N_WHITE.getColor());
        
        locationPanel.add(locationLabel);
        locationPanel.add(locationField);
        // END LOCATION PANEL

        // FOCUS PANEL
        focusPanel = new JPanel();
        focusPanel.setBackground(ColorPalette.EERIE_B.getColor());
        focusPanel.setPreferredSize(new Dimension(300, 100));
        focusPanel.setLayout(new BoxLayout(focusPanel, BoxLayout.Y_AXIS));
        focusPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 90, 0));

        focusLabel = new JLabel("Estilo do Evento:");
        focusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        focusLabel.setForeground(ColorPalette.N_WHITE.getColor());

        focusField = new JTextField();
        focusField.setPreferredSize(new Dimension(200, 30));
        focusField.setBackground(ColorPalette.ONYX.getColor());
        focusField.setForeground(ColorPalette.N_WHITE.getColor());

        focusPanel.add(focusLabel);
        focusPanel.add(focusField);
        // END FOCUS PANEL

        formPanel.add(namePanel);
        formPanel.add(datePanel);
        formPanel.add(capacityPanel);
        formPanel.add(locationPanel);
        formPanel.add(focusPanel);
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
            createEvent();
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

    private void createBand() {
        dispose();
        CreateBand createBand = new CreateBand();
    }

    private void openSearch() {
        dispose();
        SearchPage search = new SearchPage();
    }

    private void createEvent() {
        // TODO: adicionar evento no banco de dados
        //dispose();
        
    }
    
}
