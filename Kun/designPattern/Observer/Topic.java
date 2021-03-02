import java.util.Set;
import java.util.HashSet;

public class Topic implements Subject {
    private Set<Observer> observers;
    boolean changed;
    String message;
    private final Object MUTEX = new Object();

    Topic(){
        this.observers = new HashSet<>();
    }

    @Override
    public void register(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void unregister(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        if(changed){
            Set<Observer> localObservers = new HashSet<>();
            synchronized(MUTEX){
                localObservers.addAll(observers);
            }
            for(Observer obs: localObservers){
                obs.update();
            }
        }
    }

    @Override
    public Object getUpdate(Observer obs) {
        return this.message;
    }

    public void postMessage(String msg){
        System.out.println("Message posted to topoc: " + msg);
        this.message = msg;
        changed = true;
        notifyObservers();
    }    
}
