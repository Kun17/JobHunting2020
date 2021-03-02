public class factory {
    public static void getAnimalToSing(abstarctFactory fac){
        fac.getAnimalToSing();
    }

    public static void main(String[] Args){
        factory.getAnimalToSing(new catFac());
        factory.getAnimalToSing(new dogFac());
    }
}
