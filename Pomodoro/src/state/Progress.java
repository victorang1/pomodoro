//package state;
//
//import java.awt.Dimension;
//import java.util.ArrayList;
//
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import event.Observer;
//
//public class Progress implements Observer {
//
//    private static Progress instance;
//    private JPanel currentPane;
//
//    private PomodoroState state;
//    private ArrayList<JLabel> circleIndicator;
//
//    private Progress() {
//        circleIndicator = new ArrayList<>();
//        state = new Work(1);
//        refreshCircleIndicator();
//    }
//
//    public synchronized static Progress getInstance() {
//        if (instance == null) {
//            instance = new Progress();
//        }
//        return instance;
//    }
//
//    public void changeState() {
//        state = state.nextState();
//        refreshCircleIndicator();
//    }
//
//    public JPanel getCurrentPane() {
//        return currentPane;
//    }
//
//    public JPanel newIndicatorPane() {
//        JPanel statePane = new JPanel();
//		statePane.setLayout(new BoxLayout(statePane, BoxLayout.LINE_AXIS));
//        statePane.setOpaque(false);
//        for(int i = 0; i < circleIndicator.size(); i++) {
//            JLabel label = circleIndicator.get(i);
//			statePane.add(label);
//			if (i != circleIndicator.size() - 1)
//				statePane.add(Box.createRigidArea(new Dimension(3, 0)));
//        }
//        this.currentPane = statePane;
//        return statePane;
//    }
//
//    public void refreshCircleIndicator() {
//        circleIndicator.clear();
//        for (int i = 0; i < state.currentStateNumber; i++) {
//            JLabel indicatorLabel = new JLabel();
//            if (i == state.currentStateNumber - 1 && state instanceof Work) {
//                indicatorLabel.setIcon(new ImageIcon(Progress.class.getResource("../res/twotone_dot.png")));
//            }
//            else indicatorLabel.setIcon(new ImageIcon(Progress.class.getResource("../res/filled_dot.png")));
//            circleIndicator.add(indicatorLabel);
//        }
//
//        for (int i = 0; i < 4 - state.currentStateNumber; i++) {
//            JLabel indicatorLabel = new JLabel();
//            indicatorLabel.setIcon(new ImageIcon(Progress.class.getResource("../res/outline_dot.png")));
//            circleIndicator.add(indicatorLabel);
//        }
//    }
//
//    @Override
//    public void update() {
//        this.changeState();
//    }
//}
