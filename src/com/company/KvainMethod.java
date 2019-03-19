package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class KvainMethod extends JPanel {
    private JButton getDDNF = new JButton("Get DDNF");
    String expression = "!x1 !x2 !x3 !x4 + !x1 !x2 !x3 x4 + !x1 !x2 x3 !x4 + !x1 x2 !x3 !x4 + !x1 x2 !x3 x4 + !x1 x2 x3 !x4 + !x1 x2 x3 x4 + x1 !x2 !x3 x4 + x1 x2 !x3 !x4 + x1 x2 x3 !x4";
    List<String> newList = splitExpression(expression.trim(), " \\+ ");
    List<String> set = new ArrayList<>();

    KvainMethod() {
        setLayout(null);
        getDDNF.setBounds(10, 10, 50, 50);
        add(getDDNF);

        DdnfDknf ddnfDknf = new DdnfDknf();
        for (String s: pasting(pasting(newList, 3), 2)) {
            System.out.println(s);
        }
        System.out.println(pasting(pasting(newList, 3), 2));
    }

    private List<String> pasting(List<String> list, int maxConcidence) {
        String result;
        int coincidence;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] parts = list.get(i).split(" ");
            for (int j = i+1; j < list.size(); j++) {
                String[] parts2 = list.get(j).split(" ");
                coincidence = 0;
                result = "";
                for (int k = 0; k < parts.length; k++) {
                    if (parts[k].equals(parts2[k])) {
                        coincidence++;
                        result += parts[k];
                    }
                }
                if (coincidence == maxConcidence) {
                    res.add(result.trim());
                }
            }
        }
        return res;
    }

    private List<String> splitExpression(String string, String regex) {
        List<String> list = new ArrayList<>();
        for (String retval : string.split(regex)) {
            list.add(retval);
        }
        return list;
    }
}
