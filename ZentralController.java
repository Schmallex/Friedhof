package a12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Alex on 12.06.2017.
 */
public class ZentralController implements ActionListener {
    public SmileyModel model;
    public boolean smile;

    public ZentralController(SmileyModel model) {
        this.model = model;
    }

    public void actionPerformed(ActionEvent e) {
        String comp = e.getActionCommand();
        switch (comp) {
            case "PLEASED":
                model.setSmile(true);
                break;
            case "SAD":
                if (!smile) {
                    model.setSmile(false);
                }
                break;
            case "SMILE":
                AbstractButton box = (AbstractButton) e.getSource();
                if (box.isSelected()) {
                    model.setSmile(true);
                    this.smile = true;
                } else {
                    model.setSmile(false);
                    this.smile = false;
                }
                break;
            case "EYE_DEGREE":
                JTextField dirField = (JTextField) e.getSource();
                model.setDegree(Double.parseDouble(dirField.getText()));
                break;
            case "RADIUS":
                JTextField radField = (JTextField) e.getSource();
                model.setDurchmesser(Integer.parseInt(radField.getText()));
                break;
            case "EYE_RADIUS":
                JTextField eRadField = (JTextField) e.getSource();
                model.setDurchmesser(Integer.parseInt(eRadField.getText()));
                break;
            case "RESET":
                model.setDurchmesser(250);
                model.setDegree(50);
                model.setSmile(true);
                model.setPosition(150, 150);
                break;
            case "BIGGER":
                model.setDurchmesser(model.getDurchmesser() + 10);
                break;
            case "SMALLER":
                model.setDurchmesser(model.getDurchmesser() - 10);
                break;
            case "UP":
                model.moveRelativ(0, -25);
                break;
            case "DOWN":
                model.moveRelativ(0, 25);
                break;
            case "LEFT":
                model.moveRelativ(-25, 0);
                break;
            case "RIGHT":
                model.moveRelativ(25, 0);
                break;
            case "Dog":

                break;
            case "EXIT":
                System.exit(-1);
        }


    }
}
