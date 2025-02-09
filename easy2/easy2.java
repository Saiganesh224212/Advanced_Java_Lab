//Before Refactoring (Violating LSP)
/*public class easy2 {    
    class Bird {
        void fly() 
        { 
            System.out.println("Flying"); 
        }
    }
    class Penguin extends Bird {
        // Penguins can't fly!
    }
    
}
*/

//After Refactoring (Following LSP)
// Abstract Bird class with common bird behaviors
public class easy2 {
    static abstract class Bird {
        abstract void move();
    }

    // Interface for flying birds
    interface CanFly {
        void fly();
    }

    // Class for birds that can fly
    static class Parrot extends Bird implements CanFly {
        @Override
        void move() {
            System.out.println("Parrot is moving");
        }

        @Override
        public void fly() {
            System.out.println("Parrot is flying");
        }
    }

    // Class for birds that cannot fly
    static class Penguin extends Bird {
        @Override
        void move() {
            System.out.println("Penguin is waddling");
        }
    }

    public static void main(String[] args) {
        Bird sparrow = new Parrot();
        sparrow.move();
        ((CanFly) sparrow).fly(); 

        Bird penguin = new Penguin();
        penguin.move(); 
    }
}
