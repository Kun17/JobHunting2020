import javax.management.RuntimeErrorException;

public class staticBlock {
    private static staticBlock instance;
    private staticBlock(){};
    static{
        try{
            instance = new staticBlock();
        } catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static staticBlock getinstance(){return instance;}
}
