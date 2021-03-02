public class catFac extends abstarctFactory{
    catFac(){
        this.a = new cat();
    }
    public void getAnimalToSing(){
        a.makeSomeVoice();
    }
}
