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
    
    public TimeClass(int counter) {
        setText(String.valueOf(counter));
        
		setFont(new Font("Verdana", Font.PLAIN, 45));
		setForeground(Color.BLACK);
		setBounds(0, 0, 130, 80);
		setAlignmentX(JLabel.CENTER_ALIGNMENT);
		createTimer();
		
        this.counter = counter;
        this.observers = new ArrayList<>();
    }
    
    public void actionPerformed(ActionEvent tc) {
        counter--;
        if(counter >= 1) {
            setText(String.valueOf(counter));
        }
        else {
            timer.stop();
            broadcast();
        }
    }

    public void createTimer() {
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void addObserver(Observer obs) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void broadcast() {
        // TODO Auto-generated method stub
        
    }
}


