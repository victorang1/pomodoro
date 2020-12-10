package components;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IndicatorPane extends JPanel{
	private ArrayList<JLabel> circleIndicator;
	private static IndicatorPane instance = null;
	private int currentCycleIdx;
	private JPanel statePane;
	
	public IndicatorPane() {
		circleIndicator = new ArrayList<>();
		currentCycleIdx = 1; 
        statePane = new JPanel();
		
        statePane.setLayout(new BoxLayout(statePane, BoxLayout.LINE_AXIS));
        statePane.setOpaque(false);
	     
        //create indicator
        refreshPane();
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
      
    public void incrementCycle() {
        currentCycleIdx++;
        refreshPane();
    }

    public int getCurrentIndex() {
        return currentCycleIdx;
    }

    private void refreshPane() {
        statePane.removeAll();
        int currCycle = currentCycleIdx/2;
        for (int i = 0; i < currCycle; i++) {
            JLabel indicatorLabel = new JLabel();
            ImageIcon ic = new FilledDotIndicator().getImageIcon();
            indicatorLabel.setIcon(ic);            
			statePane.add(indicatorLabel);
        }
        
        if (currCycle % 2 != 0) {
            JLabel indicatorLabel = new JLabel();
            ImageIcon ic = new TwoToneDotIndicator().getImageIcon();
            indicatorLabel.setIcon(ic);            
			statePane.add(indicatorLabel);
        }
        
        for (int i = 0; i < 4 - currCycle; i++) {
            JLabel indicatorLabel = new JLabel();
            ImageIcon ic = new OutlineDotIndicator().getImageIcon();
            indicatorLabel.setIcon(ic);            
			statePane.add(indicatorLabel);
        }
    }
}
