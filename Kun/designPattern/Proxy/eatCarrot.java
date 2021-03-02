public class eatCarrot implements eatVeg {
    private String veg;
    eatCarrot(){
        this.veg = "carrot";
    }

    @Override
    public void eat() {
        System.out.printf("Behold, I now will be starting to eat %s\n", this.veg);
    }
}
