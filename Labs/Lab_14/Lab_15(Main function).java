package com.company;
import com.sun.javaws.util.JfxHelper;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Check
{
private JFrame window;
public Check()
{
window = new JFrame("Лабораторна №15");
window.setSize(500,250);
window.add(new Container());
window.setLocationRelativeTo(null);
window.setResizable(false);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setVisible(true);
}
public static void main(String[] args)
{
SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        new Check();
    }
});
}

}
