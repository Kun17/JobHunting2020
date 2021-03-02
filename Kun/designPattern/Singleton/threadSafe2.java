public class threadSafe2 {
    private static threadSafe2 instance;
    private threadSafe2(){};
    public static threadSafe2 getInstance(){
        if(instance == null){
            synchronized(threadSafe2.class){
                if(instance == null){
                    instance = new threadSafe2();
                }
            }
        }
        return instance;
    }
}
