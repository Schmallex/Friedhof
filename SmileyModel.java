package a12;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Alex on 30.05.2017.
 */
public class SmileyModel {

    protected int durchmesser;
    protected boolean smile;
    protected double degree;
    protected int x;
    protected int y;
    protected int radius;
    private PropertyChangeSupport support;

    public SmileyModel(int durchmesser, boolean smile, double degree, int x, int y) {
        this.durchmesser = durchmesser;
        this.smile = smile;
        this.degree = degree;
        this.x = x;
        this.y = y;
        this.radius = durchmesser / 2;
        this.support = new PropertyChangeSupport((this));
    }


    public void addPropertyChangeListener(PropertyChangeListener listen) {
        support.addPropertyChangeListener(listen);
    }

    public void removePropertyChangeListener(PropertyChangeListener listen) {
        support.removePropertyChangeListener(listen);
    }

    private void zustandAendern(Object parameter) {
        support.firePropertyChange("MODEL_UPDATE", "EVENT", parameter);
    }

    public void moveRelativ(int dx, int dy) {
        this.x = x + dx;
        this.y = y + dy;
        zustandAendern(x);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        zustandAendern(x);
    }

    public void setDurchmesser(int durchmesser) {
        this.durchmesser = durchmesser;
        zustandAendern(durchmesser);
    }

    public void setSmile(boolean smile) {
        this.smile = smile;
        zustandAendern(smile);
    }

    public void setDegree(double degree) {
        this.degree = degree;
        zustandAendern(degree);
    }

    public void setPleased(boolean b){
        if(b){
            setSmile(true);
        }
    }

    public void setSad(boolean b){
        if(b){
            setSmile(false);
        }
    }


    public boolean getSmile() {
        return smile;
    }

    public double getDegree() {
        return degree;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDurchmesser() {
        return durchmesser;
    }


}
