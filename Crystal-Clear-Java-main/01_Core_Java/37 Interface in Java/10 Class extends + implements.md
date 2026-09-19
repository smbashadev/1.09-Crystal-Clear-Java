# 🧒 Class `extends` + `implements`

When a Java class needs to **extend another class** and **implement one or more interfaces**, there is a fixed syntax order.

## ⭐ Correct Order

> **`extends` must come first, and `implements` must come after it.**

### Syntax

```java
class Child extends Parent implements Interface1, Interface2 {
    
}
```

Remember:

```text
class
  ↓
extends class
  ↓
implements interface(s)
```

---

## 1️⃣ Correct Syntax ✅

```java
class Vehicle {

    void start() {
        System.out.println("Vehicle starts");
    }
}

interface GPS {

    void locate();
}

class Car extends Vehicle implements GPS {

    public void locate() {
        System.out.println("Car location");
    }
}
```

Here:

```java
class Car extends Vehicle implements GPS
```

means:

* `Car` **extends** `Vehicle`
* `Car` **implements** `GPS`

---

## 2️⃣ Multiple Interfaces

A class can implement multiple interfaces:

```java
class Car extends Vehicle implements GPS, MusicPlayer, Camera {

}
```

The order remains:

```text
Class
  ↓
extends
  ↓
Parent class
  ↓
implements
  ↓
Interface 1, Interface 2, Interface 3
```

---

## 3️⃣ Incorrect Order ❌

This is invalid:

```java
class Car implements GPS extends Vehicle {
    
}
```

❌ `implements` cannot come before `extends`.

The correct syntax is:

```java
class Car extends Vehicle implements GPS {
    
}
```

---

# 🧠 Easy Memory Trick

Just remember:

> **E comes before I**

```text
E → Extends
I → Implements
```

So:

```java
class Child extends Parent implements Interface
```

### 🔥 Interview Answer

> **When a class extends another class and implements an interface, `extends` must appear before `implements`. The correct syntax is `class Child extends Parent implements Interface1, Interface2`. A class can extend only one class but can implement multiple interfaces.**
