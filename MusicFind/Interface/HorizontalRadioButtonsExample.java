package MusicFind.Interface;

import javax.swing.*;
import java.awt.*;

public class HorizontalRadioButtonsExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Horizontal Radio Buttons Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout with LEFT alignment

                JRadioButton radioButton1 = new JRadioButton("Option 1");
                JRadioButton radioButton2 = new JRadioButton("Option 2");
                JRadioButton radioButton3 = new JRadioButton("Option 3");

                // Add radio buttons to the panel
                panel.add(radioButton1);
                panel.add(radioButton2);
                panel.add(radioButton3);

                frame.getContentPane().add(panel);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
