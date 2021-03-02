import javax.swing.text.Style;

public class getUpWellRested extends getUpTemplate {
   @Override
   protected void wakeUp() {
       System.out.println("Energy restored to 100%!");
   }
   @Override
   protected void pee() {
       System.out.println("My urine can penetrate the toilet.");
   }
   @Override
   protected void sayHiToTheWorld() {
       System.out.println("I come, I wake up, I conquer.");
   }
}