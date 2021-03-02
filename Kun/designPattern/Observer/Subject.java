public interface Subject {
    public void register(Observer obs);
    public void unregister(Observer obs);
    public void notifyObservers();
    // This is called by observer
    public Object getUpdate(Observer obs);
}