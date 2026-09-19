# 🧒 Abstract Class

An **abstract class** is a class declared using the `abstract` keyword.

```java
abstract class Animal {

}
```

The main idea is:

> 🧠 **An abstract class is used as a general/template class rather than as a class whose direct objects we want to create.**

---

## 1. `abstract` Keyword

To declare an abstract class, use:

```java
abstract class ClassName {

}
```

Example:

```java
abstract class Vehicle {

}
```

Here:

```text
abstract → keyword
Vehicle  → class
```

---

# 2. Why Use an Abstract Class?

Suppose we have:

```text
Vehicle
   ↓
Car
Bike
Bus
```

`Vehicle` is a general concept.

Instead of creating a direct `Vehicle` object, we use it as a **parent class** for more specific classes.

```java
abstract class Vehicle {

}
```

Then:

```java
class Car extends Vehicle {

}
```

```java
class Bike extends Vehicle {

}
```

---

# 3. Cannot Instantiate an Abstract Class ❌

You cannot directly create an object of an abstract class.

```java
abstract class Vehicle {

}
```

This is invalid:

```java
Vehicle v = new Vehicle();  // ❌ Compile-time error
```

Why?

Because Java does not allow direct instantiation of an abstract class.

```text
abstract Vehicle
       ↓
new Vehicle()
       ↓
      ❌
```

---

# 4. But We Can Create a Reference Variable ✅

This is very important.

Although we cannot create an object of an abstract class:

```java
new Vehicle();    // ❌
```

we **can create a reference variable** of the abstract class:

```java
Vehicle v;
```

This is valid.

```text
Vehicle v;
   ↓
Reference variable ✅
```

But currently it doesn't refer to any object.

---

# 5. Parent Reference + Child Object ⭐

The most important use is:

```java
Vehicle v = new Car();
```

Here:

```text
Reference type → Vehicle
Object type    → Car
```

Diagram:

```text
        Vehicle
      (abstract)
          ↑
          │
          │ extends
          │
         Car
       (object)
```

So:

```java
Vehicle v = new Car();
```

means:

> The reference is of the abstract parent type, but the actual object is the child.

---

# 6. Polymorphism with Abstract Class

This is where **polymorphism** comes in.

Suppose:

```java
abstract class Vehicle {

    abstract void start();
}
```

Now:

```java
class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts");
    }
}
```

And:

```java
class Bike extends Vehicle {

    @Override
    void start() {

        System.out.println("Bike starts");
    }
}
```

Now we can use:

```java
Vehicle v;

v = new Car();
v.start();

v = new Bike();
v.start();
```

### Output

```text
Car starts
Bike starts
```

The same parent reference:

```java
Vehicle v;
```

can refer to different child objects:

```text
Vehicle v
    ↓
Car object
    ↓
Car.start()

Vehicle v
    ↓
Bike object
    ↓
Bike.start()
```

This is **runtime polymorphism**.

---

# 7. Complete Program

```java
abstract class Vehicle {

    abstract void start();
}

class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts");
    }
}

class Bike extends Vehicle {

    @Override
    void start() {

        System.out.println("Bike starts");
    }
}

class Demo {

    public static void main(String[] args) {

        // Vehicle v1 = new Vehicle();  // ❌ Not allowed

        Vehicle v1 = new Car();
        v1.start();

        Vehicle v2 = new Bike();
        v2.start();
    }
}
```

### Output

```text
Car starts
Bike starts
```

---

# 🧠 Understand the Difference

### ❌ Object of abstract class

```java
Vehicle v = new Vehicle();
```

Not allowed.

### ✅ Reference of abstract class

```java
Vehicle v;
```

Allowed.

### ✅ Abstract parent reference + child object

```java
Vehicle v = new Car();
```

Allowed and commonly used for **polymorphism**.

---

# ⭐ Important Concept

```text
Abstract Class
      ↓
Cannot instantiate
      ↓
But can create reference
      ↓
Vehicle v
      ↓
Can point to child object
      ↓
Vehicle v = new Car()
      ↓
Runtime Polymorphism
```

---

# 🔥 Interview Answer

> **An abstract class is a class declared using the `abstract` keyword. It cannot be instantiated directly, but a reference variable of the abstract class type can be created. An abstract class can act as a parent type for child objects, such as `Vehicle v = new Car()`, which supports runtime polymorphism.**
