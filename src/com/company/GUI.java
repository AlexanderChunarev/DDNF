package com.company;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JPanel panelCont = new JPanel();
    private CardLayout cardLayout = new CardLayout();

    GUI() {
        panelCont.setLayout(cardLayout);
        cardLayout.show(panelCont, "Menu");
        add(panelCont);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void menuWindow() {
        Menu menu = new Menu();
        panelCont.add(menu, "Menu");
        menu.DDNFOrDKNF.addActionListener(e -> cardLayout.show(panelCont, "DDNFOrDKNF"));
        menu.kvain.addActionListener(e -> cardLayout.show(panelCont, "kvain"));
    }

    private void getDDNFOrDKNF() {
        DdnfDknf frame = new DdnfDknf();
        panelCont.add(frame, "DDNFOrDKNF");
        frame.back.addActionListener(e -> cardLayout.show(panelCont, "Menu"));
    }

    private void getMethodOfKvain() {
        KvainMethod kvainMethod = new KvainMethod();
        panelCont.add(kvainMethod, "kvain");
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.menuWindow();
        gui.getDDNFOrDKNF();
        gui.getMethodOfKvain();
    }
}
