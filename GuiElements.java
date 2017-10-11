package a12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Alex on 20.06.2017.
 */
public class GuiElements extends JPanel {

    protected JPanel buttons;
    protected JPanel texts;

    protected JButton pleased;
    protected JButton sad;
    protected JTextField headRadius;
    protected JTextField eyeRadius;
    protected JTextField eyeDirection;
    protected JCheckBox smile;
    protected ResourceBundle rb;

    public GuiElements() {
        this.rb=ResourceBundle.getBundle("resource.Smiley_de",Locale.GERMAN);
        //this.rb=ResourceBundle.getBundle("resource.Smiley_dog", Locale.GERMAN);
        //this.rb=ResourceBundle.getBundle("resource.Smiley_en", Locale.GERMAN);
        this.buttons = new JPanel(new GridLayout(1, 0));
        this.pleased = new JButton(rb.getString("PLEASED"));
        this.sad = new JButton(rb.getString("SAD"));
        this.eyeDirection = new JTextField();
        this.eyeRadius = new JTextField();
        this.headRadius = new JTextField();
        this.smile = new JCheckBox(rb.getString("SMILE"));
        this.texts = new JPanel(new GridLayout(0, 1));
        Sm m = new Sm();

        setLayout(new GridLayout(0, 1));

        pleased.setActionCommand(m.PLEASED);
        sad.setActionCommand(m.SAD);
        eyeDirection.setActionCommand(m.DIRECTION);
        eyeRadius.setActionCommand(m.EYE_RADIUS);
        headRadius.setActionCommand(m.RADIUS);
        smile.setActionCommand(m.SMILE);

        texts.add(new JLabel(rb.getString("HEAD_RADIUS")));
        texts.add(headRadius);
        texts.add(new JLabel(rb.getString("EYE_RADIUS")));
        texts.add(eyeRadius);
        texts.add(new JLabel(rb.getString("EYE_DEGREE")));
        texts.add(eyeDirection);
        buttons.add(pleased);
        buttons.add(sad);
        add(texts);
        add(buttons);
        add(smile);


        setVisible(true);


    }

    public void addActionListener(ActionListener listen) {
        smile.addActionListener(listen);
        pleased.addActionListener(listen);
        sad.addActionListener(listen);
        eyeDirection.addActionListener(listen);
        eyeRadius.addActionListener(listen);
        headRadius.addActionListener(listen);

    }


}
