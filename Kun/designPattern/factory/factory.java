public class factory {
    public static void getAnimalToSing(String type){
        animal a = null;
        if(type.equalsIgnoreCase("cat")) a = new cat();
        else if(type.equalsIgnoreCase("dog")) a = new dog();
        if(a != null) a.makeSomeVoice();
    }

    public static void main(String[] Args){
        factory.getAnimalToSing("cat");
        factory.getAnimalToSing("dog");
    }
}
