public interface Observer {
    // This is called by subject
    public void update();

    // This is to attach itself to subject
    public void setSubject(Subject sub);
}
