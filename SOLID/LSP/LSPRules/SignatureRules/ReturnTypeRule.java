
public class ReturnTypeRule {
    
}
class Animal {
    public Animal getAnimal() {
        System.out.println("Parent: Returning an Animal");
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    public Dog getAnimal() {
        System.out.println("Child: Returning a Dog");
        return new Dog();  // More specific return type — allowed
    }
}

class Cat extends Animal {
    // This would cause a compile error if uncommented, because it's broader type:
    /*
    @Override
    public Object getAnimal() {
        System.out.println("Child: Returning Object");
        return new Object();
    }
    */
}

public class ReturnTypeRule {
    public static void main(String[] args) {
        Animal parent = new Animal();
        Animal child = new Dog();  // Dog is an Animal

        parent.getAnimal();  // Output: Parent: Returning an Animal
        child.getAnimal();   // Output: Child: Returning a Dog
    }
}
