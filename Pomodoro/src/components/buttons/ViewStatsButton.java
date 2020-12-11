package components.buttons;

import java.awt.Color;
import java.awt.event.ActionListener;

public class ViewStatsButton extends Button {

    public ViewStatsButton(ActionListener mListener) {
        super(mListener);
        setForeground(Color.BLACK);
        setText("View Stats");
	}

    // @Override
    // protected void setListener() {
    //     addActionListener(new CustomButtonListener(new ViewStatsAction()));
    // }
}
