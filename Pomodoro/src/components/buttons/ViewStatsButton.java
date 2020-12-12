package components.buttons;

import java.awt.Color;

import listener.ButtonListener;
import listener.ViewStatsButtonListener;

public class ViewStatsButton extends Button {

    public ViewStatsButton() {
        super();
        setForeground(Color.BLACK);
        setText("View Stats");
	}

    @Override
	protected ButtonListener getButtonListener() {
		return new ViewStatsButtonListener();
	}
}
