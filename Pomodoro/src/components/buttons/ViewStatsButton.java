package components.buttons;

import java.awt.Color;

public class ViewStatsButton extends Button {
    
    public ViewStatsButton() {
        setForeground(Color.BLACK);
        setText("View Stats");
    }

    @Override
    protected void setListener() {
        // TODO OPEN View Stats Frame
    }
}
