package components;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import state.Break;
import state.PomodoroState;
import state.Work;

public class IndicatorPane extends JPanel{
	private Vector<JLabel> dotIndicators; 
	private int currentCycleIdx;
	
	public IndicatorPane() {
		currentCycleIdx = 0; 
		dotIndicators = new Vector<>();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setOpaque(false);
	     
        //create empty indicator
        initDots();
	}
	     
	public void setCurrentDotToBreak() {
		setCurrentDotIconIndicator(new FilledDotIndicator().getImageIcon());
		currentCycleIdx++;
	}
	
	public void setCurrentDotToWork() {
		setCurrentDotIconIndicator(new TwoToneDotIndicator().getImageIcon());
	}
	
    public void resetCycle() {
        currentCycleIdx = 0;
        dotIndicators.clear();
        
        initDots();
    }

    public int getCurrentIndex() {
        return currentCycleIdx;
    }

    private void initDots() {       
        for (int i =0;i<4;i++) {     	    	
		  JLabel indicatorLabel = new JLabel();
		  indicatorLabel.setIcon(new OutlineDotIndicator().getImageIcon());       
		  dotIndicators.add(indicatorLabel);
        }
        
        refreshPane();
    }
    
    private void refreshPane() {
    	removeAll();
    	
    	for(JLabel n : dotIndicators) {
    		add(n);
    	}
    	
    }
    
    private void setCurrentDotIconIndicator(ImageIcon ic) {
    	 dotIndicators.get(currentCycleIdx).setIcon(ic);
    	 refreshPane();
    }
}
