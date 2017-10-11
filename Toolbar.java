package a12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 28.06.2017.
 */
public class Toolbar extends JToolBar {
    private JButton smile;
    private JButton frown;
    private JButton up;
    private JButton down;
    private JButton left;
    private JButton right;


    public Toolbar(){
        setLayout(new GridLayout(0,1));
        Sm m = new Sm();
        ImageIcon smil =new ImageIcon(getClass().getResource("smiley.jpg"));
        ImageIcon frow =new ImageIcon(getClass().getResource("frowney.jpg"));
        ImageIcon u =new ImageIcon(getClass().getResource("up.jpg"));
        ImageIcon d =new ImageIcon(getClass().getResource("down.jpg"));
        ImageIcon rt =new ImageIcon(getClass().getResource("right.jpg"));
        ImageIcon lt =new ImageIcon(getClass().getResource("left.jpg"));
        this.smile=new JButton (smil);
        this.frown=new JButton(frow);
        this.up=new JButton(u);
        this.down=new JButton(d);
        this.right=new JButton (rt);
        this.left=new JButton (lt);
        smile.setActionCommand(m.PLEASED);
        frown.setActionCommand(m.SAD);
        up.setActionCommand(m.UP);
        down.setActionCommand(m.DOWN);
        left.setActionCommand(m.LEFT);
        right.setActionCommand(m.RIGHT);
        add(smile);
        add(frown);
        add(up);
        add(down);
        add(left);
        add(right);
    }

    public void addActionListener(ActionListener listen){
        smile.addActionListener(listen);
        frown.addActionListener(listen);
        up.addActionListener(listen);
        down.addActionListener(listen);
        left.addActionListener(listen);
        right.addActionListener(listen);
    }

}
