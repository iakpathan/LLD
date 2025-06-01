package Design_Patterns.SingletonDesignPattern;
/*Violation:
 * class Singleton {
    Singleton(){
        System.out.print("Obj is created\n");
    }
}
public class SingltonDesignPattern
{
	public static void main(String[] args) {
	Singleton s1=new Singleton();
	Singleton s2=new Singleton();
	System.out.print(s1==s2); //output: false (2 objs created and they are different)
}
 */

 /*Correction 1: Privatising Constructor and using instance 

class Singleton {
    private static Singleton instance; // Holds the single instance

    // Private constructor prevents direct instantiation
    private Singleton() {
        System.out.print("Obj is created\n");
    }

    // Static method to provide the single instance
    public static Singleton getInstance() {
        if (instance == null) { // Create instance only if it doesn't exist
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonDesignPattern {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance(); // Get Singleton instance
        Singleton s2 = Singleton.getInstance(); // Should return same instance

        System.out.print(s1 == s2); // Output: true (both references point to the same object)
    }
} * 
  */
  /*Correction 2: When it comes to Multithreading , different threads access instance freshly leading to new obj . 
   * class Singleton {
    private static Singleton instance; // Holds the single instance

    // Private constructor to prevent direct instantiation
    private Singleton() {
        System.out.print("Obj is created\n");
    }

    // Synchronized method ensures only one thread enters at a time
    public static synchronized Singleton getInstance() {
        if (instance == null) { // Single check to ensure lazy initialization
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonDesignPattern {
    public static void main(String[] args) {
        // Simulating multiple threads accessing Singleton
        Thread t1 = new Thread(() -> {
            Singleton s1 = Singleton.getInstance();
            System.out.println("Instance from Thread 1: " + s1);
        });

        Thread t2 = new Thread(() -> {
            Singleton s2 = Singleton.getInstance();
            System.out.println("Instance from Thread 2: " + s2);
        });

        t1.start();
        t2.start();
    }
}
  */
  /*Correction 3: After Lock opened , the thread access the instance and create obj. So,double check
   * class Singleton {
    private static volatile Singleton instance; // Volatile ensures visibility across threads

    // Private constructor prevents direct instantiation
    private Singleton() {
        System.out.println("Obj is created");
    }

    public static Singleton getInstance() {
        if (instance == null) { // First check (no synchronization)
            synchronized (Singleton.class) { // Synchronization block
                if (instance == null) { // Second check (thread-safe)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class SingletonDesignPattern {
    public static void main(String[] args) {
        // Simulating multiple threads accessing Singleton
        Thread t1 = new Thread(() -> {
            Singleton s1 = Singleton.getInstance();
            System.out.println("Instance from Thread 1: " + s1);
        });

        Thread t2 = new Thread(() -> {
            Singleton s2 = Singleton.getInstance();
            System.out.println("Instance from Thread 2: " + s2);
        });

        t1.start();
        t2.start();
    }
}
    */
    /*Locking is costly , therefore efficient Solution is Eager Intialiazation */
    class Singleton {
    // Instance is created at class loading
    private static final Singleton instance = new Singleton();

    // Private constructor prevents direct instantiation
    private Singleton() {
        System.out.println("Singleton Instance Created");
    }

    // Returns the already created instance
    public static Singleton getInstance() {
        return instance;
    }
}
public class SingletonDesignPattern {
    public static void main(String[] args) {
        // Both instances will refer to the same object
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2); // Output: true (same instance)
    }
}

    

