public class lazy {
    private static lazy instance;
    private lazy(){};
    public static lazy getInstance(){
        if(instance == null){
            instance = new lazy();
        }
        return instance;
    }
}
