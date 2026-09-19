# 🧒 What Can an Abstract Class Contain?

An **abstract class is not an empty class**. It can contain almost all the normal members that a regular class can contain, along with **abstract methods**.

Example:

```java
abstract class Animal {

    // Static variable
    static int count = 10;

    // Non-static variable
    String name = "Dog";

    // Static block
    static {
        System.out.println("Static block");
    }

    // Non-static block
    {
        System.out.println("Non-static block");
    }

    // Constructor
    Animal() {
        System.out.println("Constructor");
    }

    // Static method
    static void staticMethod() {
        System.out.println("Static method");
    }

    // Non-static method
    void normalMethod() {
        System.out.println("Non-static method");
    }

    // Abstract method
    abstract void eat();

    // Main method
    public static void main(String[] args) {
        System.out.println("Main method");
    }
}
```

So an abstract class can contain:

| Member               | Can an abstract class contain it? |
| -------------------- | --------------------------------- |
| Constructor          | ✅ Yes                             |
| Static variables     | ✅ Yes                             |
| Static methods       | ✅ Yes                             |
| Static block         | ✅ Yes                             |
| Non-static variables | ✅ Yes                             |
| Non-static methods   | ✅ Yes                             |
| Non-static block     | ✅ Yes                             |
| Abstract methods     | ✅ Yes                             |
| `main()` method      | ✅ Yes                             |

---

## 1. Constructor ✅

An abstract class **can have a constructor**.

```java
abstract class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}
```

You cannot do:

```java
new Animal();   // ❌
```

But the constructor can execute when a child object is created:

```java
class Dog extends Animal {

    Dog() {
        System.out.println("Dog constructor");
    }
}
```

```java
Dog d = new Dog();
```

Output:

```text
Animal constructor
Dog constructor
```

So:

> **Abstract class cannot be instantiated, but its constructor can execute through child-object creation.**

---

# 2. Static Variable ✅

An abstract class can contain static variables.

```java
abstract class Animal {

    static int count = 10;
}
```

It can be accessed using the class name:

```java
System.out.println(Animal.count);
```

---

# 3. Static Method ✅

An abstract class can contain static methods.

```java
abstract class Animal {

    static void display() {
        System.out.println("Static method");
    }
}
```

Call it using:

```java
Animal.display();
```

You don't need an object.

---

# 4. Static Block ✅

An abstract class can contain a static block.

```java
abstract class Animal {

    static {
        System.out.println("Static block");
    }
}
```

The static block is associated with class initialization.

---

# 5. Non-Static Variable ✅

An abstract class can contain instance/non-static variables.

```java
abstract class Animal {

    String name = "Dog";
}
```

These belong to an object of a concrete subclass.

---

# 6. Non-Static Method ✅

An abstract class can contain normal methods with implementations.

```java
abstract class Animal {

    void sleep() {
        System.out.println("Animal sleeps");
    }
}
```

A child class can use the inherited method:

```java
class Dog extends Animal {
}
```

```java
Dog d = new Dog();
d.sleep();
```

---

# 7. Non-Static Block ✅

An abstract class can also contain an instance/non-static block.

```java
abstract class Animal {

    {
        System.out.println("Non-static block");
    }
}
```

It executes during creation of a concrete child object.

---

# 8. Abstract Method ✅

This is the special feature associated with an abstract class.

```java
abstract class Animal {

    abstract void eat();
}
```

There is no method body.

A concrete child must implement it:

```java
class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("Dog eats");
    }
}
```

---

# 9. `main()` Method ✅

An abstract class can contain the `main()` method.

```java
abstract class Animal {

    public static void main(String[] args) {

        System.out.println("Main method");
    }
}
```

The fact that the class is abstract does **not** prevent it from declaring a static `main()` method.

The important point is:

```text
abstract class
      ↓
cannot create object directly
      ↓
but can contain static main()
```

---

# ⭐ Complete Picture

Think of an abstract class as:

```text
              ABSTRACT CLASS
                    │
       ┌────────────┼─────────────┐
       ↓            ↓             ↓
   Variables     Methods       Blocks
       │            │             │
   ┌───┴───┐    ┌───┴────┐    ┌──┴────┐
   ↓       ↓    ↓        ↓    ↓       ↓
static  non-  static  non-  static  non-
        static         static        static
                         │
                         ↓
                  abstract method
```

And it can also contain:

```text
Constructor ✅
main()      ✅
```

---

# 🔥 Important Rule

Don't think:

> "Abstract class contains only abstract methods." ❌

Instead remember:

> **An abstract class can contain constructors, variables, blocks, static methods, non-static methods, abstract methods, and even `main()`.**

The key restriction is:

```text
Abstract class
     ↓
Direct object creation ❌
```

while:

```text
Abstract class
     ↓
Reference creation ✅
     ↓
Child object ✅
     ↓
Runtime polymorphism ✅
```
