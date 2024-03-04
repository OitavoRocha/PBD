package MusicFind.Interface;

import javax.swing.*;

import MusicFind.Interface.PreMade.ColorPalette;

import java.awt.*;

public class RepertoireAdd extends JFrame{
    static JLabel title;
    static JTextField musicName;
    static JButton addMusic;
    
    public RepertoireAdd() {
        super("MusicFind");
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(ColorPalette.JET.getColor());
        mainPanel.setSize(new Dimension(300, 300));
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 40));

        JPanel header = new JPanel();
        header.setBackground(ColorPalette.JET.getColor());
        header.setPreferredSize(new Dimension(300, 70));
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));


        title = new JLabel("Insira o nome da música:");
        title.setForeground(ColorPalette.N_WHITE.getColor());
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        //title.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        musicName = new JTextField();
        musicName.setPreferredSize(new Dimension(300, 30));
        musicName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        header.add(title);
        header.add(musicName);

        addMusic = new JButton("Adicionar");
        addMusic.setBackground(ColorPalette.BYAZNTINE_BLUE.getColor());
        addMusic.setForeground(ColorPalette.N_WHITE.getColor());
        addMusic.setPreferredSize(new Dimension(100, 30));
        addMusic.setAlignmentX(Component.CENTER_ALIGNMENT);
        addMusic.addActionListener(e -> {
            addMusic();
        });

        mainPanel.add(header);
        mainPanel.add(addMusic);

        add(mainPanel);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addMusic() {
        // TODO: adicionar musica ao banco de dados
        
        dispose();
    }
    
}
