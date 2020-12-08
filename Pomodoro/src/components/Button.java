package components;

import java.awt.Cursor;
import java.awt.Insets;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class Button {
	JButton jButton;
	
	public Button() {
		jButton = new JButton();
		jButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jButton.setBorderPainted(false);
		jButton.setBorder(null);
		jButton.setOpaque(false);
		jButton.setMargin(new Insets(0, 0, 0, 0));
		jButton.setSize(0, 0);
		jButton.setFocusPainted(false);
		jButton.setContentAreaFilled(false);
		
		jButton.setIcon(new ImageIcon(createIcon()));
	}
	
	public JButton getButton() {
		return jButton;
	}
	
	protected abstract URL createIcon();
}
