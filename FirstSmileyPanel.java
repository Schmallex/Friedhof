package a12;


import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Alex on 06.06.2017.
 */

public class FirstSmileyPanel extends JPanel implements PropertyChangeListener {
    protected SmileyModel model;
    protected int durchmesser;
    protected boolean smiley;
    protected double degree;
    protected int x;
    protected int y;
    protected int radius;

    public FirstSmileyPanel(SmileyModel model) {

        this.model = model;
        this.durchmesser = model.getDurchmesser();
        this.smiley = model.getSmile();
        this.x = model.getX();
        this.y = model.getY();
        this.degree = model.getDegree();
        this.radius = durchmesser / 2;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("MODEL_UPDATE")) {
            this.durchmesser = model.getDurchmesser();
            this.smiley = model.getSmile();
            this.degree = model.getDegree();
            this.x = model.getX();
            this.y = model.getY();
            this.radius = durchmesser/2;
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.PINK);
        g.fillOval(x, y, durchmesser, durchmesser);
        drawEyes(g);
        drawSmile(g);
        drawHat(g);
    }

    public void drawEyes(Graphics g) {
        Color c = g.getColor();
        int radius = durchmesser/2;
        int width = radius / 2;

        int xLEye = x + radius / 2 - radius / 8;
        int xREye = x + radius + radius / 8;
        int yEyes = y + radius / 2;


        double bogenMaß = degree * Math.PI / 180;
        int lPupilX = (int) ((xLEye + width / 2.5) - Math.cos(bogenMaß) * (radius / 8));
        int PupilY = (int) (yEyes + width / 2.5 - Math.sin(bogenMaß) * (radius / 8));
        int rPupilX = (int) (xREye + width / 2.5 - Math.cos(bogenMaß) * (radius / 8));

        g.setColor(Color.white);
        g.fillOval(xLEye, yEyes, width, width);
        g.fillOval(xREye, yEyes, width, width);

        g.setColor(Color.black);
        g.fillOval(lPupilX, PupilY, width / 4, width / 4);
        g.fillOval(rPupilX, PupilY, width / 4, width / 4);

        g.setColor(c);
    }

    public void drawSmile(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.BLACK);

        if (smiley) {
            g.fillArc(x + radius / 2, y + radius, radius, radius / 2, 180, 180);
        } else {
            g.fillArc(x + radius / 2, y + radius + radius / 4, radius, radius / 2, 360, 180);
        }
        g.setColor(c);
    }

    public void drawHat(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.black);
        int startx = x;
        int starty = y;
        g.fillOval(startx, starty, durchmesser, radius / 2);
        g.fillRect(startx + radius / 2, starty - radius / 2 - radius / 4, radius, radius);
        g.setColor(c);
    }
}
