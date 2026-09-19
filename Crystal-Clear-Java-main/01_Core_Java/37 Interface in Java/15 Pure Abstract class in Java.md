# 🧒 Pure Abstract Class

A **Pure Abstract Class** is an abstract class that contains **only abstract methods**.

### Definition

> **A pure abstract class is an abstract class whose methods are all abstract methods, meaning the class provides no concrete method implementation.**

Example:

```java
abstract class Animal {

    abstract void eat();

    abstract void sleep();

    abstract void move();
}
```

Here:

```text
Animal
  ↓
Abstract class
  ↓
Only abstract methods
  ↓
Pure Abstract Class
```

The methods have **no body**:

```java
abstract void eat();
```

The child class must provide the implementations:

```java
class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("Dog eats");
    }

    @Override
    void sleep() {
        System.out.println("Dog sleeps");
    }

    @Override
    void move() {
        System.out.println("Dog moves");
    }
}
```

### Important distinction

```text
Abstract Class
       ↓
Can contain:
• Abstract methods
• Concrete methods
• Variables
• Constructors
• etc.

Pure Abstract Class
       ↓
Only abstract methods
```

### 🧠 Easy memory trick

> **Abstract class + only abstract methods = Pure Abstract Class**

A pure abstract class is conceptually very similar to an **interface used as a pure contract**, although Java interfaces have their own rules and can also contain default, static, and other modern method forms.
