public class proxy implements eatVeg {
    private boolean allowed;
    private eatVeg action;

    proxy(String title){
        if(title.equals("king")) allowed = true;
        action = new eatCarrot();
    }

    @Override
    public void eat() {
        if(allowed) action.eat();
        else {
            System.out.println("You filthy creature, how dare you eat this noble veg!");
        }
    }

    public static void main(String[] Args){
        proxy p = new proxy("peasant");
        p.eat();
        proxy p2 = new proxy("king");
        p2.eat();
    }
}
