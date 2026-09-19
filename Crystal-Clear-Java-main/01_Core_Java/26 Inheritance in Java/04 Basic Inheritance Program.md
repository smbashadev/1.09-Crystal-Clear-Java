# 🧒 Basic Inheritance Program

Let's understand inheritance using a very simple example:

* **Player** → Parent class
* **Cricketer** → Child class
* `Player` contains variables and a method.
* `Cricketer` inherits them.

The main idea is:

> **A Cricketer is a Player, so the Cricketer can reuse the properties and behaviors of Player.**

---

## 1. Create the Parent Class — `Player`

```java
class Player {

    String name = "Basha";
    int age = 26;

    void play() {
        System.out.println("Player is playing");
    }
}
```

Here:

```text
Player
 ├── name     → variable
 ├── age      → variable
 └── play()   → method
```

`Player` is the **parent class**.

---

# 2. Create the Child Class — `Cricketer`

Now create:

```java
class Cricketer extends Player {

    void bat() {
        System.out.println("Cricketer is batting");
    }
}
```

The important word is:

```java
extends
```

So:

```java
class Cricketer extends Player
```

means:

> **Cricketer inherits from Player.**

---

# 3. Complete Program

```java
class Player {

    String name = "Basha";
    int age = 26;

    void play() {
        System.out.println("Player is playing");
    }
}

class Cricketer extends Player {

    void bat() {
        System.out.println("Cricketer is batting");
    }
}

class Demo {

    public static void main(String[] args) {

        Cricketer c = new Cricketer();

        System.out.println(c.name);
        System.out.println(c.age);

        c.play();

        c.bat();
    }
}
```

### Output

```text
Basha
26
Player is playing
Cricketer is batting
```

---

# 4. Where Did `name` Come From?

We created the object:

```java
Cricketer c = new Cricketer();
```

Then:

```java
System.out.println(c.name);
```

But `name` is **not declared inside `Cricketer`**.

It is declared in:

```java
class Player {

    String name = "Basha";
}
```

Because:

```java
class Cricketer extends Player
```

`Cricketer` inherits the accessible `name` variable.

So:

```text
Player
  │
  └── name
       ↓
   inherited by
       ↓
Cricketer
```

---

# 5. Where Did `age` Come From?

Same idea.

`age` belongs to `Player`:

```java
int age = 26;
```

But the `Cricketer` object can access it:

```java
System.out.println(c.age);
```

because it is inherited.

```text
Player
 ├── name
 └── age
      ↓
   inherited
      ↓
Cricketer
```

---

# 6. Where Did `play()` Come From?

We call:

```java
c.play();
```

But `play()` is declared in `Player`:

```java
void play() {
    System.out.println("Player is playing");
}
```

The `Cricketer` class inherits this method.

Therefore:

```text
Player
   │
   └── play()
        ↓
    inherited
        ↓
   Cricketer object
        ↓
     c.play()
```

---

# 7. What Belongs to Cricketer?

`Cricketer` has its own method:

```java
void bat() {
    System.out.println("Cricketer is batting");
}
```

So the Cricketer effectively has access to:

```text
Cricketer
 ├── name     ← inherited
 ├── age      ← inherited
 ├── play()   ← inherited
 └── bat()    ← own method
```

---

# 🧠 8. Easy Diagram

```text
                 Player
              Parent Class
                   │
        ┌──────────┴──────────┐
        │                     │
     Variables              Method
        │                     │
   name, age                play()
        │                     │
        └──────────┬──────────┘
                   ↓
              Cricketer
              Child Class
                   │
             Own method
                   ↓
                bat()
```

---

# 9. What Is Being Reused?

The parent has:

```java
String name;
int age;

void play()
```

The child gets access to these inherited members.

Therefore, we don't have to write them again inside `Cricketer`.

Without inheritance, we might have written:

```java
class Cricketer {

    String name;
    int age;

    void play() {
        System.out.println("Player is playing");
    }

    void bat() {
        System.out.println("Cricketer is batting");
    }
}
```

That repeats the common Player functionality.

With inheritance:

```java
class Cricketer extends Player
```

we can reuse it.

---

# ⭐ Important Concept

Inheritance does **not** mean that we copy the source code from `Player` and paste it into `Cricketer`.

Instead, Java establishes an inheritance relationship:

```text
Player
   ↓
Cricketer
```

and a `Cricketer` object can access inherited members according to Java's access rules.

---

# 🧒 Real-Life Example

Think about this:

```text
Player
 ├── Name
 ├── Age
 └── Play

Cricketer
 └── Bat
```

A cricketer **is a player**.

So the cricketer can have the common characteristics of a player:

```text
Name
Age
Play
```

and additionally:

```text
Bat
```

That's why:

> **Cricketer IS-A Player.**

---

# 🔥 Remember Forever

```text
Parent = Player
Child  = Cricketer

Player
  ↓ extends
Cricketer
```

### Parent:

```text
Player
 ├── name
 ├── age
 └── play()
```

### Child:

```text
Cricketer
 ├── name     ← inherited
 ├── age      ← inherited
 ├── play()   ← inherited
 └── bat()    ← own
```

### Interview Answer

> **In basic inheritance, a child class extends a parent class and can access the parent's accessible variables and methods. For example, `Cricketer extends Player`, so a Cricketer can reuse Player's variables such as `name` and `age`, and methods such as `play()`, while also having its own method such as `bat()`.**
