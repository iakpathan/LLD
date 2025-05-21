// Exception Rule:
// A subclass can throw fewer or narrower checked exceptions, but NOT broader ones.

class Parent {
    public void readData() throws java.io.IOException {
        throw new java.io.IOException("Parent: IO error");
    }
}

class Child extends Parent {
    @Override
    public void readData() throws java.io.FileNotFoundException {
        throw new java.io.FileNotFoundException("Child: File not found");
        // throw new Exception("Child error"); // ❌ Not allowed: broader than IOException
    }
}

class Client {
    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void process() {
        try {
            p.readData();
        } catch (java.io.IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}

public class ExceptionRule {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        // Use either:
        // Client client = new Client(parent);
        Client client = new Client(child); // ✅ FileNotFoundException is narrower

        client.process();
    }
}
