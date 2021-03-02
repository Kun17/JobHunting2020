public class cat extends animal {
    cat(){
        super();
        setSound();
    }
    public void setSound(){
        this.sound = "miaomiao";
    }
    public void makeSomeVoice(){
        System.out.println(this.sound);
    }
}
