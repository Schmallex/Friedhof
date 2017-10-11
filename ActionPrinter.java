package a12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ActionPrinter implements ActionListener, PropertyChangeListener {
    protected ResourceBundle rb;

    public ActionPrinter(){
        this.rb=ResourceBundle.getBundle("resource.Smiley_en", Locale.ENGLISH);
    }

    public void actionPerformed(ActionEvent e) {
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
        System.out.printf("%-30s %7tT : %-10s%n", rb.getString("ACTIONEVENT_AT"), time, e.getActionCommand());
    }

    public void propertyChange(PropertyChangeEvent evt) {
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
        System.out.printf("%-30s %7tT : %-10s %s %-10s%n", rb.getString("PROPERTYCHANGE_AT"), time, evt.getPropertyName(), rb.getString("PROPERTYCHANGE_OLD"), evt.getNewValue());
    }
}
