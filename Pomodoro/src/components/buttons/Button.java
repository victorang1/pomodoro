package components.buttons;

import java.awt.Cursor;
import java.awt.Insets;

import javax.swing.JButton;

import listener.ButtonListener;

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
		addActionListener(getButtonListener().getListener());
	}

	protected abstract ButtonListener getButtonListener();
}
