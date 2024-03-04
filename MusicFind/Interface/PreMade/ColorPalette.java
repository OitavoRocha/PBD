package MusicFind.Interface.PreMade;

import java.awt.Color;

public enum ColorPalette {
    BYAZNTINE_BLUE(new Color(19, 88, 221)), 
    JORDY_BLUE(new Color(146, 188, 234)),
    ONYX(new Color(68, 68, 68)),
    JET(new Color(50, 50, 50)),
    EERIE_B(new Color(25, 25, 25)),
    N_BLACK(new Color(0, 0, 0)),
    N_WHITE(new Color(255, 255, 255));


    private final Color color;

    private ColorPalette(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
