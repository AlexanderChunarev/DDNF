package com.company;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    JButton DDNFOrDKNF = new JButton("DDNF&DKNF");
    JButton kvain = new JButton("Kvain method");
    
    Menu() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.GRAY);
        initializeWindow();
    }

    private void initializeWindow() {
        add(kvain);
        add(DDNFOrDKNF);
        changeButtonStyle();
    }

    private void changeButtonStyle() {
        for (Component comp : getComponents()) {
            if (comp instanceof JButton) {
                comp.setFont(new Font("Courier New", Font.ITALIC, 24));
                add(comp);
                ((JButton) comp).setContentAreaFilled(false);
                ((JButton) comp).setAlignmentX(Component.CENTER_ALIGNMENT);
                ((JButton) comp).setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
            }
        }
    }
}
