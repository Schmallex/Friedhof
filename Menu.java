package a12;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Alex on 27.06.2017.
 */
public class Menu extends JMenuBar {
    private JButton save;
    private JButton load;
    private JButton exit;
    private JButton reset;
    private JButton bigger;
    private JButton smaller;
    private JButton german;
    private JButton eng;
    private JButton dog;
    private JMenu file;
    private JMenu smiley;
    private JMenu lang;
    private ResourceBundle rb;


    public Menu(){
        this.rb=ResourceBundle.getBundle("resource.Smiley_de", Locale.GERMAN);
        //this.rb=ResourceBundle.getBundle("resource.Smiley_dog", Locale.GERMAN);
        //this.rb=ResourceBundle.getBundle("resource.Smiley_en", Locale.GERMAN);
        Sm m = new Sm();
        this.file=new JMenu(rb.getString("FILE"));
        this.smiley=new JMenu(rb.getString("TITLE"));
        this.lang=new JMenu(rb.getString("LANGUAGE"));

        this.save = new JButton(rb.getString("SAVE"));
        this.load = new JButton(rb.getString("LOAD"));
        this.exit=new JButton(rb.getString("EXIT"));
        this.reset=new JButton(rb.getString("RESET"));
        this.bigger =new JButton(rb.getString("BIGGER"));
        this.smaller=new JButton(rb.getString("SMALLER"));
        this.german=new JButton(rb.getString("GERMAN"));
        this.eng=new JButton(rb.getString("ENGLISH"));

        reset.setActionCommand(m.RESET);
        bigger.setActionCommand(m.BIGGER);
        smaller.setActionCommand(m.SMALLER);
        exit.setActionCommand(m.EXIT);

        file.add(save);
        file.add(load);
        file.add(exit);
        smiley.add(reset);
        smiley.add(bigger);
        smiley.add(smaller);
        lang.add(german);
        lang.add(eng);
        add(file);
        add(smiley);
        add(lang);


        setVisible(true);

    }

    public void addActionListener(ActionListener listen){
        save.addActionListener(listen);
        load.addActionListener(listen);
        exit.addActionListener(listen);
        reset.addActionListener(listen);
        bigger.addActionListener(listen);
        smaller.addActionListener(listen);

    }
}
