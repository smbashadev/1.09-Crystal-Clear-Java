# 🧒 Behavior Representation in Java

In OOP, we learned:

> **State = What an object has**
> **Behavior = What an object does**

In Java, an object's behavior is commonly represented using **non-static (instance) methods**.

---

## 1️⃣ Non-Static Methods

A **non-static method** is a method that belongs to an **object/instance**.

Example:

```java id="v8k2qa"
class Student {

    void study() {
        System.out.println("Student is studying");
    }

    void read() {
        System.out.println("Student is reading");
    }
}
```

Here:

```text id="q4m7xp"
study()
read()
   ↓
Non-static methods
   ↓
Student behavior
```

These methods describe **what a Student object can do**.

---

# 2️⃣ Calling a Non-Static Method

Because the method belongs to an object, we create an object first:

```java id="x6p9mz"
Student s = new Student();

s.study();
s.read();
```

Think:

```text id="n7c3qw"
Student class
      ↓
   new Student()
      ↓
Student object
      ↓
s.study()
      ↓
Student studies
```

The `.` operator is used to access the object's instance members.

---

# 3️⃣ Real-World Example: Fan 🌀

A fan has **state**:

```java id="k2m8vz"
class Fan {

    String color;
    int speed;
```

And **behavior**:

```java id="p5x7qa"
    void rotate() {
        System.out.println("Fan is rotating");
    }

    void stop() {
        System.out.println("Fan stopped");
    }
}
```

Complete:

```java id="d9w4ks"
class Fan {

    String color;
    int speed;

    void rotate() {
        System.out.println("Fan is rotating");
    }

    void stop() {
        System.out.println("Fan stopped");
    }
}
```

Create and use the object:

```java id="h3q8nm"
Fan f = new Fan();

f.rotate();
f.stop();
```

---

# 🔗 State + Behavior

```text id="v6m2xp"
             OBJECT
                │
        ┌───────┴────────┐
        ↓                ↓
      STATE           BEHAVIOR
        ↓                ↓
    Variables       Non-static methods
        ↓                ↓
   color, speed     rotate(), stop()
```

This is a key OOP idea.

---

## 🧠 Why "Non-Static"?

A non-static method is associated with an **instance/object**.

For example:

```java id="n8c4qa"
f.rotate();
```

means:

> **"This particular fan object, rotate."**

If we have two fan objects:

```java id="j7m3vx"
Fan f1 = new Fan();
Fan f2 = new Fan();

f1.rotate();
f2.rotate();
```

Both objects can use the same method definition, while each object can have its own instance state.

---

## ⚠️ Static vs Non-Static

| Static Method                                  | Non-Static Method                          |
| ---------------------------------------------- | ------------------------------------------ |
| Belongs to the class                           | Associated with an object/instance         |
| Called using class name (commonly)             | Called using an object/reference           |
| `Math.sqrt()`                                  | `f.rotate()`                               |
| Does not require an instance just to invoke it | Normally requires an instance to invoke it |

For OOP modeling, **instance methods are commonly used to represent object behavior**.

### 🔑 Memory Trick

```text id="q5x9mw"
STATE
 ↓
Instance Variables
 ↓
What object HAS

BEHAVIOR
 ↓
Non-static Methods
 ↓
What object DOES
```

### ⭐ Interview Answer

> **In Java, the behavior of an object is commonly represented using non-static (instance) methods. These methods are associated with an object and define the actions that the object can perform.**
