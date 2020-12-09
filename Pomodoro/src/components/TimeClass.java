package components;

import javax.swing.JLabel;
import javax.swing.Timer;

import event.Observable;
import event.Observer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimeClass extends JLabel implements Observable, ActionListener {

    private Timer timer;
    private int counter;
    
    private ArrayList<Observer> observers;    
    
    public TimeClass() {
		setFont(new Font("Verdana", Font.PLAIN, 45));
		setForeground(Color.BLACK);
		setBounds(0, 0, 130, 80);
		setAlignmentX(JLabel.CENTER_ALIGNMENT);
		createTimer();
        this.observers = new ArrayList<>();
        
        refreshTimerText(1);
    }
    
    public void actionPerformed(ActionEvent tc) {
        counter--;
        refreshTimerText(counter);
        if(counter < 0) {
            broadcast();
        }
    }

    public void createTimer() {
        timer = new Timer(1000, this);
        timer.start();
    }

    public void refreshTimerText(int newTimer) {
        counter = newTimer;
        setText(String.format("%02d:%02d", counter / 60, counter % 60));
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void broadcast() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}


