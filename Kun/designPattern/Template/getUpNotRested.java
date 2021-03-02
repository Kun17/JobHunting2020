public class getUpNotRested extends getUpTemplate {
   @Override
   protected void wakeUp() {
       System.out.println("What the hell...");
   }
   @Override
   protected void pee() {
       System.out.println("No...not on the floor again");
   }
   @Override
   protected void sayHiToTheWorld() {
       System.out.println("...sign");
   }
}