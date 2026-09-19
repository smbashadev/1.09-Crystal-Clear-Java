# 🧒 Examples of Objects in OOP

In OOP, an **object** is something we can think of as a **thing/entity** that has **data (properties)** and **behavior (actions)**.

Let's use your real-world examples.

---

## 🪑 1. Chair

A **chair** is an object.

### Properties — What does it have?

```text id="t2c5md"
Chair
 ├── Color = Brown
 ├── Material = Wood
 ├── Legs = 4
 └── Height = 3 feet
```

### Behavior — What can it do?

```text id="4y8m0k"
Chair
 ├── Support
 └── Hold a person
```

---

## 🖊️ 2. Pen

A **pen** is an object.

### Properties

```text id="q7x3na"
Pen
 ├── Color = Blue
 ├── Brand = XYZ
 └── InkLevel = 80%
```

### Behavior

```text id="r5m9kz"
Pen
 ├── Write
 └── Open/Close
```

---

## 🪑 3. Table

A **table** is an object.

### Properties

```text id="w6p2xc"
Table
 ├── Color = Brown
 ├── Material = Wood
 ├── Height = 3 feet
 └── Shape = Rectangle
```

### Behavior

```text id="n8q4mv"
Table
 ├── Support items
 └── Hold objects
```

---

## ⌨️ 4. Keyboard

A **keyboard** is an object.

### Properties

```text id="k3v7pz"
Keyboard
 ├── Brand = ABC
 ├── Type = Mechanical
 └── Keys = 104
```

### Behavior

```text id="a9m5xc"
Keyboard
 ├── Type keys
 └── Send input
```

---

## 🏍️ 5. Bike

A **bike** is an object.

### Properties

```text id="j8q2wb"
Bike
 ├── Brand = Honda
 ├── Color = Black
 ├── Speed = 80 km/h
 └── Fuel = Petrol
```

### Behavior

```text id="f4m7ny"
Bike
 ├── Start
 ├── Accelerate
 ├── Brake
 └── Stop
```

---

# 🧠 Connect It to OOP

The important idea is:

```text id="u5c8mq"
Real-world object
       ↓
Properties + Behaviors
       ↓
Programming object
```

For example:

```text id="v3n7ka"
        BIKE
         ↓
 ┌─────────────────┐
 │ Data            │
 │ brand           │
 │ color           │
 │ speed           │
 │                 │
 │ Behavior        │
 │ start()         │
 │ accelerate()    │
 │ brake()         │
 │ stop()          │
 └─────────────────┘
```

In Java, a **class** can define the structure and behavior, and an **object** is an actual instance created from that class.

```java id="c6r9xp"
class Bike {
    String color;
    int speed;

    void start() {
        System.out.println("Bike started");
    }
}
```

Creating an object:

```java id="p2m8vq"
Bike b = new Bike();
```

Here:

```text id="k7x4zs"
Bike       → Class
b          → Reference variable
new Bike() → Object
```

### 🔑 Memory Trick

> **Object = A real-world entity represented in a program with its data and behavior.**

```text id="s8q3wm"
Chair
Pen
Table
Keyboard
Bike
   ↓
Real-world objects
   ↓
Can be modeled as
Java objects
```
