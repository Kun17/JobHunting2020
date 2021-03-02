public abstract class getUpTemplate {
    public final void steps(){
        wakeUp();
        pee();
        brushTeeth();
        sayHiToTheWorld();
        System.out.println("Now a new world is waiting for you out there!");
    }

    abstract protected void wakeUp();
    abstract protected void pee();
    abstract protected void sayHiToTheWorld();
    
    private void brushTeeth(){
        System.out.println("You brush your teeth using your dazzling sonic tooth brush");
    }

    public static void main(String[] Args){
        getUpTemplate g1 = new getUpWellRested();
        g1.steps();
        getUpTemplate g2 = new getUpNotRested();
        g2.steps();
    }
}