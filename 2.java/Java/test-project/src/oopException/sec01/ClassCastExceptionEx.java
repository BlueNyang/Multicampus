package oopException.sec01;

public class ClassCastExceptionEx {
    public static void main(String[] ignoredArgs) {
        // When trying to cast an object for a user-defined class to another.
        Dog dog = new Dog();
        changeDog(dog); // This will work fine

        Cat cat = new Cat();
        // changeDog(cat); // This will throw a ClassCastException at runtime because "cat" is not a Dog
    }

    public static void changeDog(Animal animal) {
        Dog dog = (Dog) animal; // This will work if "animal" is actually a Dog
    }
}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}
