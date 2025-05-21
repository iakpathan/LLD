class Animal {}
class Dog extends Animal {}

class Parent {
    public void feed(Animal animal) {
        System.out.println("Parent feeds an animal");
    }
}

class Child extends Parent {
    // Accepting same or broader type is OK
    @Override
    public void feed(Animal animal) {
        System.out.println("Child feeds an animal");
    }

    // Not allowed:
    // public void feed(Dog dog) { ... } 
    // This would overload, not override — and violate LSP
}

public class MethodArgument {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.feed(new Dog());  // Works fine
    }
}