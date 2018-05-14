package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Container extends JPanel
{
    private Font f = new Font("SanSerif",Font.BOLD,20);
    private Font F = new Font("SanSerif",Font.BOLD,10);
    private String[] elements = {"Add","Remove","Find","Sort","Show","Clear","Read from file","Restore"};
    private ArrayList<String> arr=new ArrayList<>();
    private ArrayList<String> copy = new ArrayList<>();
    private JTextField T = new JTextField("",10);
    public void output() throws PrinterException {
        String str = "";
        if (arr.isEmpty()) {
            T.setText("Container is empty!");
        } else {
            for (int i = 0; i < arr.size(); i++) {
                str += (arr.get(i)).toString();
            }
            T.setText(str);
        }
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

    T.setBounds(95,165,585,50);
    T.setFont(F);

    t.setBounds(75,10,610,50);
    t.setFont(F);

    l.setBounds(10,10,55,50);
    l.setFont(f);

    j.setBounds(225,85,455,50);
    j.setFont(f);
    j.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (c.getSelectedIndex()){
                case 0: String text1 = t.getText();
                t.setText("");
                    for(int i = 0; i < text1.length();i++){
                        arr.add(String.valueOf(text1.charAt(i)));
                        copy.add(String.valueOf(text1.charAt(i)));
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
                    if(arr.contains(text2)){
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
                case 6:
                    try {
                        FileReader fileReader = new FileReader("Demo.txt");
                        Scanner scanner = new Scanner(fileReader);
                        while(scanner.hasNextLine())
                        {
                            String info = scanner.nextLine();
                            arr.add(info);
                            copy.add(info);

                        }
                        fileReader.close();
                    } catch (java.io.IOException e1) {
                        e1.printStackTrace();
                    }
                    T.setText("Reading from file has complited!");
                    break;
                case 7: for(int i = 0; i < copy.size();i++){
                    arr.add(copy.get(i));
                         }
                    T.setText("Container has restored!");
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

