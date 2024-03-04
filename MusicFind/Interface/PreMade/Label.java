package MusicFind.Interface.PreMade;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel{

    public Label(String s){
        super(s);
        this.setForeground(ColorPalette.N_WHITE.getColor());
        this.setFont(new Font("Arial", Font.PLAIN, 18));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    
}
