class eager{
    private static final eager instance = new eager();
    private eager(){};
    public static eager getInstance(){
        return instance;
    }

    public static void main(String[] Args){
        eager e = getInstance();
    }
}