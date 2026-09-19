# 🧒 Interface and Multiple Inheritance

Java **does not support multiple inheritance through classes**, but it supports multiple inheritance **through interfaces**.

The basic idea is:

```text
Interface 1 ──┐
              ├──→ Class
Interface 2 ──┘
```

One class can implement multiple interfaces.

---

## 1️⃣ Multiple Inheritance Through Interfaces

Suppose we have two interfaces:

```java
interface Camera {

    void click();
}
```

```java
interface MusicPlayer {

    void play();
}
```

Now one class can implement **both**:

```java
class Mobile implements Camera, MusicPlayer {

    public void click() {
        System.out.println("Taking photo");
    }

    public void play() {
        System.out.println("Playing music");
    }
}
```

Notice:

```java
class Mobile implements Camera, MusicPlayer
```

The class gets contracts from **two interfaces**.

```text
       Camera          MusicPlayer
          │                │
          │                │
          └───────┬────────┘
                  ↓
                Mobile
```

---

# 2️⃣ Multiple Interfaces

A class can implement more than two interfaces as well.

```java
interface Camera {

    void click();
}

interface MusicPlayer {

    void play();
}

interface GPS {

    void locate();
}
```

One class:

```java
class Mobile implements Camera, MusicPlayer, GPS {

    public void click() {
        System.out.println("Taking photo");
    }

    public void play() {
        System.out.println("Playing music");
    }

    public void locate() {
        System.out.println("Finding location");
    }
}
```

So:

```text
Camera ────────┐
               │
MusicPlayer ───┼──→ Mobile
               │
GPS ───────────┘
```

This is **multiple inheritance through interfaces**.

---

# 3️⃣ Why Not Multiple Classes?

Java does not allow:

```java
class Parent1 {

    void display() {
        System.out.println("Parent1");
    }
}

class Parent2 {

    void display() {
        System.out.println("Parent2");
    }
}
```

Then:

```java
class Child extends Parent1, Parent2 {  // ❌
}
```

The problem is:

```text
Parent1
   │
 display()
   │
   ├──────→ Child
   │
 display()
   │
Parent2
```

If we write:

```java
Child c = new Child();

c.display();
```

Which `display()` should execute?

```text
Parent1.display() ❓
        OR
Parent2.display() ❓
```

This creates **ambiguity**.

---

# 4️⃣ How Interfaces Help

With interfaces, Java can provide a controlled way to achieve multiple inheritance of **type/contracts**.

```java
interface Camera {

    void click();
}

interface MusicPlayer {

    void play();
}
```

Then:

```java
class Mobile implements Camera, MusicPlayer {

    public void click() {
        System.out.println("Photo");
    }

    public void play() {
        System.out.println("Music");
    }
}
```

There is no conflict because the class provides the implementations.

```text
Camera
  ↓
click()
  \
   \
    → Mobile → provides click()
   /
  /
MusicPlayer
  ↓
play()
```

---

# ⭐ Complete Example

```java
interface Calculator {

    void add();
}

interface Printer {

    void print();
}

class Machine implements Calculator, Printer {

    @Override
    public void add() {

        System.out.println("Addition performed");
    }

    @Override
    public void print() {

        System.out.println("Printing document");
    }
}

class Demo {

    public static void main(String[] args) {

        Machine m = new Machine();

        m.add();
        m.print();
    }
}
```

### Output

```text
Addition performed
Printing document
```

---

# 🧠 Easy Memory Trick

### Classes

```text
Class + Class
     ↓
Multiple inheritance ❌
```

### Interfaces

```text
Interface + Interface
       ↓
     Class
       ↓
Multiple interfaces can be implemented ✅
```

So remember:

```text
class Child extends Parent
        ↓
Single class inheritance

class Child implements I1, I2
        ↓
Multiple interface implementation
        ↓
Multiple inheritance of type
```

### 🔥 Interview Answer

> **Java does not support multiple inheritance through classes because it can create ambiguity when multiple parent classes contain the same members. Java supports multiple inheritance through interfaces, where a class can implement multiple interfaces and provide the required implementations. This provides multiple inheritance of type while avoiding the traditional class-based multiple inheritance problem.**
