package components.buttons;

import java.awt.Color;

import javax.swing.Icon;

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

	@Override
	protected Icon getButtonIcon() {
		// TODO Auto-generated method stub
		return null;
	}
}
