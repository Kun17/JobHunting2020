public class dog extends animal {
    dog(){
        super();
        setSound();
    }
    public void setSound(){
        this.sound = "wangwang";
    }
    public void makeSomeVoice(){
        System.out.println(this.sound);
    }
}
