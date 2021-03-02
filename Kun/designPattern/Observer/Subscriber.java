public class Subscriber implements Observer {
    private Subject t;
    private String name;

    Subscriber(String nm){
        this.name = nm;
    }

    @Override
    public void update() {
        String msg = (String)t.getUpdate(this);
        if(msg == null){
            System.out.println(name + "::No new message");
        } else {
            System.out.println(name + "::consuming message::" + msg);
        }
    }

    @Override
    public void setSubject(Subject sub) {
        this.t = sub;
    }
    
}
