package echecObservable;

import java.util.ArrayList;
import java.util.Observer;

public interface Observable {
	
	
	public void addObserver();
	
	
	public void removeObserver(Observer obs);
	
	
	public void notifyObserver(ArrayList<String> moves);
}