package components;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import state.Work;

public class IndicatorPane extends JPanel{
	private ArrayList<JLabel> circleIndicator;
	private static IndicatorPane instance = null;
	private int currentCycleIdx;
	private JPanel statePane;
	
	public IndicatorPane() {
		circleIndicator = new ArrayList<>();
		currentCycleIdx = 0; 
        statePane = new JPanel();
		
        statePane.setLayout(new BoxLayout(statePane, BoxLayout.LINE_AXIS));
        statePane.setOpaque(false);
	     
        //create indicator
        for (int i = 0; i < 4; i++) {
            JLabel indicatorLabel = new JLabel();
            
            ImageIcon ic = (i != currentCycleIdx) ? new OutlineDotIndicator().getImageIcon() :
            	new TwoToneDotIndicator().getImageIcon();
            
            indicatorLabel.setIcon(ic);            
            
			statePane.add(indicatorLabel);
        }
	}
	
    public synchronized static IndicatorPane getInstance() {
        if (instance == null) {
            instance = new IndicatorPane();
        }
        return instance;
    }
    
    public JPanel getStatePane() {
    	return statePane;
    }
      
}
