package components.buttons;

import java.awt.Cursor;
import java.awt.Insets;

import javax.swing.JButton;

import action.CustomButtonListener;

public abstract class Button extends JButton {
	
	public Button() {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorderPainted(false);
		setBorder(null);
		setOpaque(false);
		setMargin(new Insets(0, 0, 0, 0));
		setSize(0, 0);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setListener();
	}

	protected abstract void setListener();
}
