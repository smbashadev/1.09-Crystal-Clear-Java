# 🧒 `extends` vs `implements`

Java uses **`extends`** and **`implements`** for inheritance and interface relationships.

There are **3 important rules** to remember:

```text
1. Class     extends    Class
2. Interface extends    Interface
3. Class     implements Interface
```

---

## 1️⃣ Class `extends` Class

A class uses `extends` to inherit from another class.

```java
class Animal {

    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog barks");
    }
}
```

Now `Dog` inherits from `Animal`.

```text
Animal
   ↑
   │ extends
   │
  Dog
```

So:

```java
Dog d = new Dog();

d.eat();    // inherited
d.bark();   // Dog's own method
```

### Rule

```text
Class ──extends──> Class
```

---

# 2️⃣ Interface `extends` Interface

An interface can extend another interface using `extends`.

```java
interface Animal {

    void eat();
}

interface Dog extends Animal {

    void bark();
}
```

Now `Dog` inherits the contract of `Animal`.

```text
Animal
   ↑
   │ extends
   │
  Dog
```

A class implementing `Dog` must implement the inherited methods as well:

```java
class Puppy implements Dog {

    public void eat() {
        System.out.println("Puppy eats");
    }

    public void bark() {
        System.out.println("Puppy barks");
    }
}
```

### Rule

```text
Interface ──extends──> Interface
```

---

# 3️⃣ Class `implements` Interface

A class uses `implements` when it follows an interface contract.

```java
interface Animal {

    void eat();
}
```

A class implements it:

```java
class Dog implements Animal {

    public void eat() {
        System.out.println("Dog eats");
    }
}
```

Diagram:

```text
Animal
(interface)
    ↑
    │ implements
    │
   Dog
 (class)
```

### Rule

```text
Class ──implements──> Interface
```

---

# ⭐ All Three Together

```java
class Animal {

    void eat() {
        System.out.println("Animal eats");
    }
}

interface Pet {

    void play();
}

class Dog extends Animal implements Pet {

    public void play() {
        System.out.println("Dog plays");
    }
}
```

Here `Dog`:

```text
             Animal
                ↑
                │ extends
                │
               Dog
                │
                │ implements
                ↓
               Pet
            (interface)
```

So the same class can:

```java
class Dog extends Animal implements Pet
```

That means:

* `Dog` **inherits** from the class `Animal`
* `Dog` **implements** the contract of `Pet`

---

# 🧠 Easy Comparison

| Relationship          | Keyword      | Example                        |
| --------------------- | ------------ | ------------------------------ |
| Class → Class         | `extends`    | `class Dog extends Animal`     |
| Interface → Interface | `extends`    | `interface Dog extends Animal` |
| Class → Interface     | `implements` | `class Dog implements Animal`  |

---

# 🔥 Multiple Interfaces

A class can implement multiple interfaces:

```java
interface Camera {
    void click();
}

interface MusicPlayer {
    void play();
}

class Mobile implements Camera, MusicPlayer {

    public void click() {
        System.out.println("Taking photo");
    }

    public void play() {
        System.out.println("Playing music");
    }
}
```

So:

```text
Camera ───────┐
              ↓
          Mobile
              ↑
MusicPlayer ──┘
```

This is one way Java supports **multiple inheritance of type**.

### Remember this one line:

```text
Class     → extends    → Class
Interface → extends    → Interface
Class     → implements → Interface
```
