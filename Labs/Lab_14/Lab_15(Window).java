package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Collections;

public class Container extends JPanel
{
    private Font f = new Font("SanSerif",Font.BOLD,20);
    private String[] elements = {"Add","Remove","Find","Sort","Show","Clear"};
    private ArrayList<Character> arr=new ArrayList<>();

    private JTextField T = new JTextField("",10);
    public void output() throws PrinterException {
        String str="";
        for(int i=0;i < arr.size();i++){
            str +=(arr.get(i)).toString();
        }
        T.setText(str);
    }
public Container(){
    setLayout(null);
    JButton j = new JButton("Press");
    JLabel l = new JLabel("Input:");
    JLabel L= new JLabel("Result:");
    JTextField t = new JTextField("",10);
    JComboBox<String> c = new JComboBox<>(elements);

    c.setBounds(10,85,200,50);
    c.setFont(f);
    c.setEditable(true);

    L.setBounds(10,165,70,50);
    L.setFont(f);

    T.setBounds(95,165,375,50);
    T.setFont(f);

    t.setBounds(75,10,395,50);
    t.setFont(f);

    l.setBounds(10,10,55,50);
    l.setFont(f);

    j.setBounds(225,85,250,50);
    j.setFont(f);
    j.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (c.getSelectedIndex()){
                case 0: String text1 = t.getText();
                t.setText("");
                    for(int i = 0; i < text1.length();i++){
                        arr.add(text1.charAt(i));
                    }
                    T.setText("Elements have added successfully!");
                    break;
                case 1: String text3 = t.getText();
                    t.setText("");
                          if(arr.size()>= Integer.parseInt(text3)) {
                           arr.remove(Integer.parseInt(text3));
                        try {
                            output();
                        } catch (PrinterException e1) {
                            e1.printStackTrace();
                        }
                    }else{
                        T.setText("Container doesn't contain " + text3);
                    }
                    break;
                case 2:String text2 = t.getText();
                    t.setText("");
                    if(arr.contains(text2.charAt(0))){
                        T.setText("Container contains " + text2);

                    }else{
                        T.setText("Container doesn't contain " + text2);
                    }
                    break;

                case 3:t.setText("");
                    Collections.sort(arr);
                    try {
                        output();
                    } catch (PrinterException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case 4:t.setText("");
                    try {
                    output();
                } catch (PrinterException e1) {
                    e1.printStackTrace();
                }
                    break;
                case 5:t.setText("");
                arr.clear();
                T.setText("Container successfully cleared!");
                    break;
                    default:
                        break;

            }
        }
    });

    add(j);
    add(l);
    add(t);
    add(c);
    add(T);
    add(L);
}
}

