package a12;


import javax.swing.*;
import java.awt.*;


/**
 * Created by Alex on 17.06.2017.
 */
public class FirstGui {
    public static void main(String[] args) {



        JFrame frame = new JFrame("Smiley");
        Container cont = frame.getContentPane();
        GuiElements ele = new GuiElements();
        Toolbar toolbar = new Toolbar();
        Menu menu = new Menu();
        cont.setLayout(new BorderLayout());
        SmileyModel model = new SmileyModel(250, false, 50, 150, 150);
        FirstSmileyPanel panel = new FirstSmileyPanel(model);

        cont.add(panel, BorderLayout.CENTER);
        cont.add(ele,BorderLayout.WEST);
        cont.add(menu,BorderLayout.NORTH);
        cont.add(toolbar,BorderLayout.EAST);

        ZentralController zent = new ZentralController(model);
        ActionPrinter print = new ActionPrinter();

        model.addPropertyChangeListener(panel);
        model.addPropertyChangeListener(print);
        ele.addActionListener(zent);

        toolbar.addActionListener(zent);
        menu.addActionListener(print);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }


}
