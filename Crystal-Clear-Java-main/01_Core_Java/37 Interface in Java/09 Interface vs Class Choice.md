# 🧒 Interface vs Class Choice

When designing a Java program, you may need both a **class** and an **interface**.

A useful rule is:

> **Prefer programming to an interface when you want flexibility, while using a class when you need shared implementation/state.**

---

## 1️⃣ Prefer Implementing an Interface

Suppose we have:

```java
interface Payment {

    void pay();
}
```

Different classes can implement it:

```java
class CreditCard implements Payment {

    public void pay() {
        System.out.println("Payment using Credit Card");
    }
}
```

```java
class UPI implements Payment {

    public void pay() {
        System.out.println("Payment using UPI");
    }
}
```

Now we can use the common interface:

```java
Payment p;

p = new CreditCard();
p.pay();

p = new UPI();
p.pay();
```

This gives us **flexibility and polymorphism**.

```text id="qk7i1n"
              Payment
             interface
                 │
        ┌────────┴────────┐
        ↓                 ↓
   CreditCard           UPI
        │                 │
        ↓                 ↓
    pay()              pay()
```

---

# 2️⃣ A Class Can Still Extend Another Class ⭐

Using an interface does **not** prevent a class from extending a class.

A class can do both:

```java
class Child extends Parent implements Interface {
    
}
```

For example:

```java id="8yxk9m"
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
        System.out.println("Car location found");
    }
}
```

Here `Car` gets:

```text id="r4u3fo"
Vehicle
   │
   │ extends
   ↓
  Car
   ↑
   │ implements
   │
  GPS
```

So `Car` can:

```java id="nq7wz8"
Car c = new Car();

c.start();    // inherited from Vehicle
c.locate();   // implemented from GPS
```

---

# 3️⃣ Multiple Inheritance Through Classes Is Not Allowed ❌

Java does not allow:

```java id="d4gqhl"
class Child extends Parent1, Parent2 {
}
```

❌ This is invalid.

Java allows only one direct superclass:

```java id="yy1r0r"
class Child extends Parent {
}
```

But multiple interfaces are allowed:

```java id="9lcb1g"
class Child implements Interface1, Interface2 {
}
```

✅

---

# ⭐ Best Combination

Java allows this powerful combination:

```java id="j3cc6k"
class Child extends Parent
            implements Interface1, Interface2
```

Meaning:

```text id="9iqt76"
             Parent
                │
             extends
                ↓
              Child
             ↙     ↘
     implements    implements
        ↓             ↓
   Interface1    Interface2
```

So the class gets:

* **One class inheritance** → `extends`
* **Multiple interface contracts** → `implements`

---

# 🧠 Quick Comparison

| Requirement                       | Use           |
| --------------------------------- | ------------- |
| Inherit from a class              | `extends`     |
| Follow an interface contract      | `implements`  |
| Multiple class inheritance        | ❌ Not allowed |
| Multiple interface implementation | ✅ Allowed     |
| Class + multiple interfaces       | ✅ Allowed     |

### 🔥 Remember

```text
Class → extends → ONE class

Class → implements → MULTIPLE interfaces
```

And the most useful syntax:

```java
class Child extends Parent implements Interface1, Interface2 {
}
```

> **A Java class can extend only one class, but it can implement multiple interfaces. This gives Java the benefits of class inheritance together with multiple interface-based contracts without allowing multiple inheritance through classes.**
