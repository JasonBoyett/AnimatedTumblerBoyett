/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * november 20, 2022
 * mac OS
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener{
    private SpinningSquare spin;
    private Timer timer;
    private int x = 0;
    private int y = 0;
    private int xVelocity = (int)(Math.random()*4)+1;
    private int yVelocity = (int)(Math.random()*4)+1;
    private JButton startStop = new JButton("Stop");


    public MyPanel(int height, int width){
        startStop.setPreferredSize(new Dimension(100,75));
        startStop.addActionListener(e -> startStop());
        this.setPreferredSize(new Dimension(height,width));
        spin = new SpinningSquare(this,100,Color.cyan);
        this.add(spin);
        timer = new Timer(10,this);
        this.setBackground(Color.BLACK);
        timer.start();
    }

    public String startStop(){
        if(timer.isRunning()){
            timer.stop();
            spin.pauseSpin();
            this.yVelocity = (int) (Math.random() * 4) + 1;
            this.xVelocity = (int) (Math.random() * 4) + 1;
            return "Start";
        }
        else{
            timer.start();
            spin.resumeSpin();
            return "Stop";
        }

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        spin.setLocation(this.x,this.y);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        x += xVelocity;

        if (x >= this.getWidth() - spin.getWidth() || x < 0) {
            xVelocity = xVelocity * -1;
            spin.changeDirection();
            spin.colorRandomizer();
        }
        x += xVelocity;

        if (y >= this.getHeight() - spin.getHeight() || y < 0) {
            yVelocity = yVelocity * -1;
            spin.changeDirection();
            spin.colorRandomizer();
        }
        y += yVelocity;
        this.repaint();
    }

   


}