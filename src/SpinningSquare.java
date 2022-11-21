import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;

public class SpinningSquare extends JPanel implements ActionListener {
    private int sidePanelLength;
    private int squareSide;
    private Color color;
    private Timer timer;
    private int rotate = 0;
    private int force = 1;
    private JComponent parent;

    public SpinningSquare(JComponent parent, int squareSide, Color color){
        this.squareSide = squareSide;
        this.parent = parent;
        this.sidePanelLength = calculatePanelSize();
        this.setPreferredSize(new Dimension(sidePanelLength,sidePanelLength));
        this.color = color;
        timer = new Timer(15,this);
        timer.start();
        try{
            this.setBackground(parent.getBackground());
        }
        catch(NullPointerException e){
            this.setBackground(color.WHITE);
        }
        
    }

    private int calculatePanelSize(){
        return (int) Math.sqrt(2*(squareSide*squareSide));
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        try{
            this.setBackground(parent.getBackground());
        }
        catch(NullPointerException e){
            this.setBackground(Color.WHITE);
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(getGraphics());

        Graphics2D g2d = (Graphics2D) g;
        int centerSquare = (this.sidePanelLength/2) - (this.squareSide/2);
        int panelCenter = this.sidePanelLength/2;
        Rectangle2D.Double rectangle = new Rectangle2D.Double(centerSquare,centerSquare, squareSide,squareSide);
        g2d.rotate(Math.toRadians(rotate),panelCenter,panelCenter);
        g2d.setColor(this.color);
        g2d.fill(rectangle);
        g2d.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        this.repaint();
        rotate += force;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void colorRandomizer(){
        int random = (int)(Math.random()*6);

        switch(random){
            case 1:
                this.setColor(color.GREEN);
                break;
            case 2:
                this.setColor(color.RED);
                break;
            case 3:
                this.setColor(color.magenta);
                break;
            case 4:
                this.setColor(color.PINK);
                break;
            case 5:
                this.setColor(color.ORANGE);
                break;
        }

    }

    public void changeDirection(){
        this.force *= -1;
    }

    public void pauseSpin(){
        this.timer.stop();
    }

    public void resumeSpin(){
        this.timer.start();
    }
}