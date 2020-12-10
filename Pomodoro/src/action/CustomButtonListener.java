package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomButtonListener implements ActionListener {
    
    private ActionCommand cmd;

    public CustomButtonListener(ActionCommand cmd) {
        this.cmd = cmd;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        cmd.execute();
    }
}
