package components.viewstats;

import java.util.ArrayList;


import javax.swing.JLabel;
import javax.swing.JPanel;

import util.DateUtil;
import util.LogsUtil;

public class ViewStatsPanel extends JPanel {
    
    private String days[] = {"Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Mon"};
    private ArrayList<JPanel> childrenPanel;

    public ViewStatsPanel() {
        childrenPanel = new ArrayList<>();
        int position = 0;
        for (String d : days) {
            int currentCounter = LogsUtil.getInstance().getLogsValueFromKey(position++);
            DaysPanel jpanel = new DaysPanel(new JLabel(d), new CounterLabel(currentCounter));
			addPanel(jpanel);
		}
    }

    public void addPanel(JPanel jPanel) {
        add(jPanel);
        childrenPanel.add(jPanel);
    }

    public void updateCounter() {
        int orderWeek = DateUtil.getPomodoroDateOfWeekOrder();
        DaysPanel panel = (DaysPanel) childrenPanel.get(orderWeek);
        panel.updateCounter();
    }
}
