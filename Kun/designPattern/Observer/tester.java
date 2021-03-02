class tester {
    public static void main(String[] Args){
        Topic t = new Topic();
        Subscriber s1 = new Subscriber("nihao");
        Subscriber s2 = new Subscriber("haome");
        Subscriber s3 = new Subscriber("wohenhao");

        t.register(s1);
        t.register(s2);
        t.register(s3);

        s1.setSubject(t);
        s2.setSubject(t);
        s3.setSubject(t);

        t.notifyObservers();
        s1.update();

        t.postMessage("chileme");
    }
}
