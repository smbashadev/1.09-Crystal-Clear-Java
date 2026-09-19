# 🧒 Class in Java

A **class** is like a **blueprint or template** that describes what an object should contain and what it can do.

### Simple Definition

> **A class is a blueprint/template that defines the information and behavior required to create objects.**

Think about a **house blueprint** 🏠.

```text
Blueprint
   ↓
Tells us:
   • How many rooms
   • Where doors go
   • Where windows go
   ↓
Actual House
```

Similarly:

```text
Java Class
    ↓
Defines:
    • State (data)
    • Behavior (methods)
    ↓
Object
```

---

# 1️⃣ Class as a Template

A template tells us **what something should look like**.

For example:

```java id="x8n4qm"
class Student {

    String name;
    int age;
    int marks;

    void study() {
        System.out.println("Student is studying");
    }
}
```

This `Student` class describes:

```text id="m3q7vp"
Student
 ├── name
 ├── age
 ├── marks
 └── study()
```

But the class itself is **not a particular student**.

It is a template for creating Student objects.

---

# 2️⃣ Class as a Blueprint

Imagine a blueprint:

```text id="a7k2pz"
       STUDENT BLUEPRINT
              ↓
     ┌─────────────────┐
     │ name            │
     │ age             │
     │ marks           │
     │ study()         │
     └─────────────────┘
```

From this blueprint, we can create multiple objects:

```java id="p5v8nx"
Student s1 = new Student();
Student s2 = new Student();
Student s3 = new Student();
```

Now:

```text id="w4m9qa"
          Student Class
               ↓
       ┌───────┼───────┐
       ↓       ↓       ↓
      s1      s2      s3
    Object   Object   Object
```

Each object can have its **own state**.

For example:

```text id="c9x3mq"
s1 → Basha, 26, 85
s2 → Ravi, 25, 90
s3 → Ali, 24, 78
```

Same class, different object data.

---

# 3️⃣ Information Required to Create an Object

The class defines the **structure** and behavior of the objects.

For example:

```java id="q7m2vz"
class Fan {

    String color;
    int speed;

    void rotate() {
        System.out.println("Fan is rotating");
    }
}
```

The class tells us that a `Fan` object has:

```text id="n5k8rx"
State:
  color
  speed

Behavior:
  rotate()
```

Then we create an object:

```java id="j3p6wm"
Fan f = new Fan();
```

---

# 4️⃣ Does the JVM Create Objects From the Class?

This needs a small technical correction.

Your note says:

> **"JVM creates objects from class."**

For beginner understanding, you can think of it that way, but more precisely:

> **When `new` is executed, the JVM runtime creates an object based on the class definition.**

Example:

```java id="r8x4kp"
Student s = new Student();
```

Think:

```text id="v2m7qa"
Student class
     ↓
new Student()
     ↓
JVM runtime creates object
     ↓
Student object
```

The class provides the **definition**, while `new` requests creation of an **instance/object**.

---

# 🧠 Class vs Object

| Class                         | Object                        |
| ----------------------------- | ----------------------------- |
| Blueprint/template            | Actual instance               |
| Describes structure           | Has actual state              |
| Defines fields and methods    | Uses those fields and methods |
| Example: `Student`            | Example: `s1`                 |
| Can be used to create objects | Created from a class          |

Think:

```text id="k6q3nz"
CLASS
  ↓
Blueprint 🏗️
  ↓
OBJECT
  ↓
Actual thing
```

### 🔑 Easy Memory Trick

> **Class = What an object should have and do.**
> **Object = Actual instance created from that class.**

```text id="m9x4pv"
class Student
      ↓
   Blueprint
      ↓
new Student()
      ↓
Student Object
      ↓
State + Behavior
```

### ⭐ Interview Answer

> **A class is a blueprint or template that defines the state and behavior of objects. When an object is instantiated using `new`, the JVM runtime creates an instance based on that class definition.**
