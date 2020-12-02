package components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ContentPane {

    public ContentPane() {

    }

    public static JPanel getActionPane(JButton buttonPause) {
        JPanel actionPane = new JPanel();
		actionPane.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
		actionPane.setLayout(new BoxLayout(actionPane, BoxLayout.LINE_AXIS));
        actionPane.setBackground(new Color(229, 80, 57));
        actionPane.add(buttonPause);
        return actionPane;
    }
    
}
