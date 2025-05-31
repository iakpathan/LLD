// Define Behavior Interfaces
interface Flyable {
    void fly();
}

interface Dancable {
    void dance();
}

interface Swimmable { // New behavior without modifying Robot
    void swim();
}

// Implement Flyable behaviors
class FlywithWings implements Flyable {
    public void fly() { System.out.println("Robot is Flying with wings"); }
}

class FlywithHands implements Flyable {
    public void fly() { System.out.println("Robot is Flying with Hands"); }
}

// Implement Dancable behaviors
class TraditionalDance implements Dancable {
    public void dance() { System.out.println("This Robo knows Traditional Dance"); }
}

class WesternDance implements Dancable {
    public void dance() { System.out.println("This Robo knows Western Dance"); }
}

// Implement Swimmable behaviors (New Behavior)
class SwimWithFins implements Swimmable {
    public void swim() { System.out.println("Robot is Swimming with fins!"); }
}

class SwimWithArms implements Swimmable {
    public void swim() { System.out.println("Robot is Swimming using arms!"); }
}

// Base Robot class WITHOUT behavior dependency in constructor
abstract class Robot {
    private Flyable flyBehavior;
    private Dancable danceBehavior;
    private Swimmable swimBehavior; // New Behavior added without modifying existing robots

    public void setFlyBehavior(Flyable flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setDanceBehavior(Dancable danceBehavior) {
        this.danceBehavior = danceBehavior;
    }

    public void setSwimBehavior(Swimmable swimBehavior) {
        this.swimBehavior = swimBehavior;
    }

    public void fly() {
        if (flyBehavior != null) flyBehavior.fly();
        else System.out.println("This robot cannot fly.");
    }

    public void dance() {
        if (danceBehavior != null) danceBehavior.dance();
        else System.out.println("This robot cannot dance.");
    }

    public void swim() {
        if (swimBehavior != null) swimBehavior.swim();
        else System.out.println("This robot cannot swim.");
    }

    public void see() { System.out.println("Robot is seeing..."); }

    public abstract void projection();
}

// Companion Robot
class CompanionRobot extends Robot {
    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}

// Worker Robot
class WorkerRobot extends Robot {
    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}

// Main Execution
public class StrategyDesignPattern{
    public static void main(String[] args) {
        // Create a Companion Robot dynamically assigning behaviors
        Robot robot1 = new CompanionRobot();
        robot1.setFlyBehavior(new FlywithHands());
        robot1.setDanceBehavior(new TraditionalDance());
        robot1.setSwimBehavior(new SwimWithFins()); // NEW SWIMMING BEHAVIOR WITHOUT MODIFYING Robot class

        robot1.fly();
        robot1.dance();
        robot1.swim(); // NEW SWIMMING FEATURE
        robot1.see();
        robot1.projection();

        System.out.println("--------------------");

        // Create a Worker Robot dynamically assigning behaviors
        Robot robot2 = new WorkerRobot();
        robot2.setFlyBehavior(new FlywithWings());
        robot2.setDanceBehavior(new WesternDance());

        robot2.fly();
        robot2.dance();
        robot2.swim(); // Will print "This robot cannot swim" (no swim behavior assigned)
        robot2.see();
        robot2.projection();
    }
}