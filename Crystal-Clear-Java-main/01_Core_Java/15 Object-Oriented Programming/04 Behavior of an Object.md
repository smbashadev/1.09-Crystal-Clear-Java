# 🧒 Behavior of an Object

In OOP, **Behavior** means:

> **The actions an object can perform — what the object does.**

Simple formula:

```text id="c8y2pm"
Behavior = Actions = What an object does
```

---

# 🎓 Student Behavior

A **Student** object can perform different actions:

```text id="m7x4qa"
Student
   ↓
 ┌───────────┐
 │ Eating    │
 │ Learning  │
 │ Reading   │
 │ Writing   │
 │ Sleeping  │
 └───────────┘
```

These are the **behaviors** of a student.

In Java, we normally represent behaviors using **methods**:

```java id="p4k8zs"
class Student {

    void eat() {
        System.out.println("Student is eating");
    }

    void learn() {
        System.out.println("Student is learning");
    }

    void read() {
        System.out.println("Student is reading");
    }

    void write() {
        System.out.println("Student is writing");
    }

    void sleep() {
        System.out.println("Student is sleeping");
    }
}
```

So:

```text id="q3n7mv"
Student Behavior
      ↓
eat()
learn()
read()
write()
sleep()
```

---

# 🌀 Fan Behavior

A **Fan** object can perform actions such as:

```text id="w6k2pz"
Fan
 ↓
Rotating
Giving Air
Stopping
```

In Java:

```java id="v8m3qx"
class Fan {

    void rotate() {
        System.out.println("Fan is rotating");
    }

    void giveAir() {
        System.out.println("Fan is giving air");
    }

    void stop() {
        System.out.println("Fan stopped");
    }
}
```

So:

```text id="a9p5ks"
Fan Behavior
     ↓
rotate()
giveAir()
stop()
```

---

# 🔗 State vs Behavior

This is **very important in OOP**.

### State = What the object HAS

### Behavior = What the object DOES

For a Student:

```text id="k7x2mq"
       STUDENT
          │
    ┌─────┴─────┐
    ↓           ↓
  STATE      BEHAVIOR
    ↓           ↓
 Name         Eat()
 Age          Learn()
 Marks        Read()
 Roll No.     Write()
              Sleep()
```

For a Fan:

```text id="n4q8zp"
         FAN
          │
    ┌─────┴─────┐
    ↓           ↓
  STATE      BEHAVIOR
    ↓           ↓
 Color        Rotate()
 Price        GiveAir()
 Speed        Stop()
 Brand
 Type
```

---

## 🧠 Easy Memory Trick

> **State = What an object HAS**
> **Behavior = What an object DOES**

```text id="x5m9qa"
Student
  │
  ├── State     → Name, Age, Marks
  │
  └── Behavior  → Read, Write, Learn

Fan
  │
  ├── State     → Color, Speed, Brand
  │
  └── Behavior  → Rotate, Give Air, Stop
```

### ⭐ Interview Answer

> **Behavior of an object refers to the actions or operations that the object can perform. In Java, behavior is generally represented using methods.**

So the OOP connection is:

```text id="r8v3kn"
Object
  ↓
┌──────────────────┐
│ State            │ → What it HAS
│ Behavior         │ → What it DOES
└──────────────────┘
```
