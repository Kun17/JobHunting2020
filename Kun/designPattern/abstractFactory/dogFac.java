public class dogFac extends abstarctFactory{
    dogFac(){
        this.a = new dog();
    }
    public void getAnimalToSing(){
        a.makeSomeVoice();
    }
}
