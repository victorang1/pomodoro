package event;

public interface Observable {
    
    public void broadcast();

	public void addObserver(Observer obs);
}