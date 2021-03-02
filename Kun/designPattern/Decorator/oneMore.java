public class oneMore implements restWell {
    protected restWell r;
    public oneMore(restWell r){
        this.r = r;
    }
    @Override
    public void action() {
        this.r.action();
    }
}
