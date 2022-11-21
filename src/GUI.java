/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * november 20, 2022
 * mac OS
 */
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
    private MyPanel panel;
    private JPanel buttonPanel = new JPanel();
    JButton startStop = new JButton("Stop");
    public GUI(){
        this.panel = new MyPanel(500,500);
        this.add(panel);
        startStop.addActionListener(e -> press());
        buttonPanel.add(startStop);
        this.add(buttonPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(getPreferredSize());
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Dimension d = panel.getPreferredSize();
        int width = (int)d.getWidth();
        int height = (int)d.getHeight();
        panel.setBounds(0,0,width,width);
        buttonPanel.setBounds(0,height,width,height/4);
        this.setSize(width, height+height/4);
    }

    private void press(){
        startStop.setText(panel.startStop());
        this.repaint();
    }
}