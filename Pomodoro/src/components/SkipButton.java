package components;

import java.net.URL;

public class SkipButton extends Button{
	@Override
	protected URL createIcon() {
		return SkipButton.class.getResource("/res/skip.png");
	}
}
