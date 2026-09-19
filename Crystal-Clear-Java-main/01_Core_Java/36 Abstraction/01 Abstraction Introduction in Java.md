# 🧒 Abstraction in Java

**Abstraction** is one of the four major **OOP pillars**.

> 🧠 **Abstraction means hiding unnecessary implementation details and showing only the essential functionality to the user.**

A simple real-life example is a **car** 🚗.

When you call:

```text
Start the car
```

you don't need to know all the internal engine operations.

You only need to know **what operation is available**, not all the internal details.

In Java, abstraction can be achieved using **abstract classes** and **abstract methods**.

---

# 1. Abstract Class

An **abstract class** is a class declared using the `abstract` keyword.

### Syntax

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
abstract
   ↓
Vehicle
```

means `Vehicle` is an abstract class.

### Important point

You **cannot directly create an object** of an abstract class.

```java
Vehicle v = new Vehicle();   // ❌
```

But you can create an object of its child class.

---

# 2. Abstract Method

An **abstract method** is a method declared using the `abstract` keyword **without a method body**.

### Syntax

```java
abstract void start();
```

Notice:

```java
abstract void start();
```

There is:

* method declaration ✅
* method body ❌

For example:

```java
abstract class Vehicle {

    abstract void start();
}
```

Here:

```text
start()
   ↓
What should happen? → specified
How should it happen? → not specified
```

The child class provides the implementation.

---

# 3. Simple Program

```java
abstract class Vehicle {

    abstract void start();
}

class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts with a key");
    }
}

class Demo {

    public static void main(String[] args) {

        Car c = new Car();

        c.start();
    }
}
```

### Output

```text
Car starts with a key
```

---

# 4. Understand the Program

The parent class says:

```java
abstract void start();
```

It is basically saying:

> "Every vehicle must have a `start()` operation, but I am not deciding how it starts."

Then `Car` decides:

```java
void start() {

    System.out.println("Car starts with a key");
}
```

So:

```text
Vehicle
   │
   │ abstract start()
   ↓
 Car
   │
   └── implements start()
```

---

# 5. Abstract Class Can Have Normal Methods Too

An abstract class doesn't necessarily contain only abstract methods.

It can contain:

```text
Abstract methods     → no body
Concrete methods     → body
Variables
Constructors
```

Example:

```java
abstract class Vehicle {

    abstract void start();

    void stop() {

        System.out.println("Vehicle stopped");
    }
}
```

Child:

```java
class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car started");
    }
}
```

Here:

```text
Vehicle
 ├── abstract start() → Child must implement
 └── stop()           → Already implemented
```

---

# ⭐ Remember Forever

### Abstraction

> **Hiding implementation details and exposing essential functionality.**

### Abstract Class

```java
abstract class Vehicle {
}
```

> A class declared with `abstract`; it cannot be directly instantiated.

### Abstract Method

```java
abstract void start();
```

> A method declared without a body; a concrete child class generally must provide its implementation.

### Easy memory trick:

```text
Abstract Class
      ↓
Cannot directly create object

Abstract Method
      ↓
No method body

Child Class
      ↓
Provides implementation
```

### 🔥 Interview Answer

> **Abstraction is an OOP concept used to hide implementation details and expose only essential functionality. In Java, abstraction can be achieved using abstract classes and abstract methods. An abstract class cannot be directly instantiated, while an abstract method has no implementation body and is implemented by a concrete subclass.**
