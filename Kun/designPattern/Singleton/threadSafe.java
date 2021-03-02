public class threadSafe {
    private static threadSafe instance;
    private threadSafe(){};
    public static synchronized threadSafe getInstance(){
        if(instance == null){
            instance = new threadSafe();
        }
        return instance;
    }
}
