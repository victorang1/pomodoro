package components.viewstats;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewStatsPanel extends JPanel {
    
    private String days[] = {"Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Mon"};
    private ArrayList<JPanel> childrenPanel;

    public ViewStatsPanel() {
        childrenPanel = new ArrayList<>();
        for (String d : days) {
            DaysPanel jpanel = new DaysPanel(new JLabel(d), new CounterLabel());
			addPanel(jpanel);
		}
    }

    public void addPanel(JPanel jPanel) {
        add(jPanel);
        childrenPanel.add(jPanel);
    }

    public void updateCounter() {
        Calendar cal = Calendar.getInstance();
        int currentDay = cal.get(Calendar.DAY_OF_WEEK);
        DaysPanel panel = (DaysPanel) childrenPanel.get(((currentDay + 5) % 7) - 1);
        panel.updateCounter();
    }
}
