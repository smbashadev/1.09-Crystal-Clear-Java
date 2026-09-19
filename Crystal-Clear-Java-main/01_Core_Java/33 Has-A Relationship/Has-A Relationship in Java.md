# 🧒 Has-A Relationship in Java

**Has-A relationship** means:

> 🧠 **One object contains or uses another object.**

For example:

```text
Classroom HAS-A Board
```

A classroom is **not** a type of board. The classroom simply **has a board**.

---

# 1. Is-A vs Has-A

This is very important for interviews.

## Is-A Relationship

**Is-A** represents **inheritance**.

Example:

```text
Animal → Dog
```

A dog **is an animal**.

```java
class Animal {
}

class Dog extends Animal {
}
```

So:

```text
Dog IS-A Animal
```

Another example:

```text
Plane → FighterPlane
```

A fighter plane **is a plane**.

```text
FighterPlane IS-A Plane
```

---

## Has-A Relationship

**Has-A** represents a relationship where one class contains or uses another class's object.

Example:

```text
Classroom → Board
```

A classroom **has a board**.

```text
Classroom HAS-A Board
```

It is not:

```text
Classroom IS-A Board ❌
```

---

# 2. Easy Way to Identify Them 🧠

Ask yourself a question.

### "Is it a?"

```text
Dog is an Animal?
        ↓
YES
        ↓
IS-A
```

### "Does it have a?"

```text
Classroom has a Board?
        ↓
YES
        ↓
HAS-A
```

### Golden trick:

```text
"is a"  → IS-A → Inheritance
"has a" → HAS-A → Object relationship
```

---

# 3. Types of Has-A Relationship

There are two commonly discussed types:

```text
HAS-A
  │
  ├── Aggregation
  │
  └── Composition
```

The main difference is the **strength of the relationship**.

---

# 4. Aggregation — Loosely Bound

**Aggregation** represents a **weak/loose relationship** between objects.

The important idea is:

> The contained/aggregate object can exist independently of the object that uses it.

For example:

```text
RoboVan HAS-A Robo
```

Imagine a `RoboVan` uses a `Robo`.

```text
RoboVan
   │
   └──── uses ────→ Robo
```

If the `RoboVan` object is destroyed, the `Robo` object can still exist.

```text
RoboVan destroyed
       ↓
Robo can continue to exist
```

Therefore, the relationship is **loose**.

---

# 5. Aggregation Program

```java
class Robo {

    void work() {
        System.out.println("Robo is working");
    }
}

class RoboVan {

    Robo robo;

    RoboVan(Robo robo) {
        this.robo = robo;
    }

    void startRobo() {
        robo.work();
    }
}

class Demo {

    public static void main(String[] args) {

        Robo r = new Robo();

        RoboVan van = new RoboVan(r);

        van.startRobo();

        // RoboVan object can be removed,
        // but Robo object can still exist.
        van = null;

        r.work();
    }
}
```

### Output

```text
Robo is working
Robo is working
```

The important part is:

```java
Robo r = new Robo();

RoboVan van = new RoboVan(r);
```

The `Robo` object was created **independently**.

Then it was given to `RoboVan`.

So:

```text
Robo
  ↑
  │
RoboVan
```

The `Robo` can exist without the `RoboVan`.

### Therefore:

> **Aggregation = loosely coupled Has-A relationship.**

---

# 6. Composition — Tightly Bound

**Composition** represents a **strong/tight relationship**.

The important idea is:

> The contained object's lifecycle is strongly dependent on the containing object.

A simple example is:

```text
RoboVan HAS-A MotherBoard
```

Suppose the motherboard is created as part of the `RoboVan` itself.

```text
RoboVan
   │
   └── MotherBoard
```

The `RoboVan` creates and owns its `MotherBoard`.

```java
class MotherBoard {

    void start() {
        System.out.println("MotherBoard started");
    }
}

class RoboVan {

    private MotherBoard board;

    RoboVan() {
        board = new MotherBoard();
    }

    void startVan() {
        board.start();
        System.out.println("RoboVan started");
    }
}
```

Here the `MotherBoard` is created inside the `RoboVan` constructor.

---

# 7. Complete Composition Program

```java
class MotherBoard {

    void start() {
        System.out.println("MotherBoard started");
    }
}

class RoboVan {

    private MotherBoard board;

    RoboVan() {

        board = new MotherBoard();
    }

    void startVan() {

        board.start();

        System.out.println("RoboVan started");
    }
}

class Demo {

    public static void main(String[] args) {

        RoboVan van = new RoboVan();

        van.startVan();
    }
}
```

### Output

```text
MotherBoard started
RoboVan started
```

The important relationship is:

```text
RoboVan
   │
   └── HAS-A → MotherBoard
```

The `RoboVan` creates its `MotherBoard` as part of its construction.

This demonstrates the **strong ownership/lifecycle dependency** characteristic of composition.

---

# 8. Aggregation vs Composition ⭐

| Feature                                         | Aggregation        | Composition                          |
| ----------------------------------------------- | ------------------ | ------------------------------------ |
| Relationship                                    | HAS-A              | HAS-A                                |
| Binding                                         | Loose              | Tight                                |
| Ownership                                       | Weak               | Strong                               |
| Child/contained object can exist independently? | Yes                | Typically no                         |
| Object created independently?                   | Usually yes        | Typically created/owned by composite |
| Example                                         | `RoboVan` → `Robo` | `RoboVan` → `MotherBoard`            |

---

# 9. Very Easy Real-Life Example

### Aggregation 🧑‍💼

A company has employees:

```text
Company
   ↓
Employee
```

If the company closes, the employee can still exist and work somewhere else.

```text
Company destroyed
       ↓
Employee can exist
```

So this is a **loose relationship**.

---

### Composition 🏠

Think about a house and a room in a simplified ownership model:

```text
House
  ↓
Room
```

The room is treated as a component of that particular house.

```text
House
  ↓
Room
```

The component's lifecycle is strongly tied to the whole.

---

# 10. Your Three Examples

### Is-A

```text
Animal
   ↑
  Dog

Dog IS-A Animal
```

### Aggregation

```text
Robo
  ↑
  │
RoboVan

RoboVan HAS-A Robo
```

The `Robo` can exist independently.

### Composition

```text
RoboVan
   │
   └── MotherBoard

RoboVan HAS-A MotherBoard
```

The `MotherBoard` is treated as an owned component of the `RoboVan`.

---

# 🧠 Final Memory Trick

```text
IS-A
 ↓
Inheritance
 ↓
"Dog IS-A Animal"


HAS-A
 ↓
Object relationship
 ↓
"Classroom HAS-A Board"
```

Then:

```text
HAS-A
  │
  ├── Aggregation
  │      ↓
  │   Loose relationship
  │   Object can exist independently
  │
  └── Composition
         ↓
      Tight relationship
      Strong lifecycle dependency
```

### 🔥 Interview Answer

> **A Has-A relationship represents a relationship in which one class contains or uses an object of another class. It is commonly classified into aggregation, which is a weak/loose relationship where the contained object can exist independently, and composition, which is a strong relationship where the contained object's lifecycle is dependent on the containing object.**
