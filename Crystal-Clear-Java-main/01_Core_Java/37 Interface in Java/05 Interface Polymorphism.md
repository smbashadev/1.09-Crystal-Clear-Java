# 🧒 Interface Polymorphism

**Interface polymorphism** means:

> One **interface reference** can refer to objects of different implementing classes, and the same method call can produce different behavior.

We'll use your example:

```text
Trainer
   │
   ├── JavaTrainer
   └── MTTrainer
```

The common methods are:

```text
teach()
takeAttendance()
prepare()
```

---

## 1. Create the `Trainer` Interface

```java
interface Trainer {

    void teach();

    void takeAttendance();

    void prepare();
}
```

The interface defines the **common contract**.

It says every trainer should provide:

```text
teach()
takeAttendance()
prepare()
```

---

# 2. `JavaTrainer`

```java
class JavaTrainer implements Trainer {

    @Override
    public void teach() {
        System.out.println("Java Trainer teaches Java");
    }

    @Override
    public void takeAttendance() {
        System.out.println("Java Trainer takes attendance");
    }

    @Override
    public void prepare() {
        System.out.println("Java Trainer prepares Java lessons");
    }
}
```

---

# 3. `MTTrainer`

```java
class MTTrainer implements Trainer {

    @Override
    public void teach() {
        System.out.println("MT Trainer teaches Manual Testing");
    }

    @Override
    public void takeAttendance() {
        System.out.println("MT Trainer takes attendance");
    }

    @Override
    public void prepare() {
        System.out.println("MT Trainer prepares testing lessons");
    }
}
```

Both classes implement the same interface, but their implementations can be different.

---

# 4. Common Interface Reference ⭐

Now create **one common interface reference**:

```java
Trainer t;
```

It can refer to a `JavaTrainer` object:

```java
t = new JavaTrainer();
```

Or an `MTTrainer` object:

```java
t = new MTTrainer();
```

Diagram:

```text
                 Trainer
               (interface)
                    │
          ┌─────────┴─────────┐
          ↓                   ↓
    JavaTrainer           MTTrainer
          │                   │
          ↓                   ↓
       teach()             teach()
       attendance()        attendance()
       prepare()           prepare()
```

---

# 5. Same Reference, Different Objects

```java
Trainer t;

t = new JavaTrainer();
t.teach();

t = new MTTrainer();
t.teach();
```

Output:

```text
Java Trainer teaches Java
MT Trainer teaches Manual Testing
```

The reference is the same:

```java
Trainer t;
```

But the object changes.

Therefore, the implementation that executes changes.

That's **runtime polymorphism through an interface**.

---

# 6. Complete Program

```java
interface Trainer {

    void teach();

    void takeAttendance();

    void prepare();
}

class JavaTrainer implements Trainer {

    @Override
    public void teach() {
        System.out.println("Java Trainer teaches Java");
    }

    @Override
    public void takeAttendance() {
        System.out.println("Java Trainer takes attendance");
    }

    @Override
    public void prepare() {
        System.out.println("Java Trainer prepares Java lessons");
    }
}

class MTTrainer implements Trainer {

    @Override
    public void teach() {
        System.out.println("MT Trainer teaches Manual Testing");
    }

    @Override
    public void takeAttendance() {
        System.out.println("MT Trainer takes attendance");
    }

    @Override
    public void prepare() {
        System.out.println("MT Trainer prepares testing lessons");
    }
}

class Demo {

    public static void main(String[] args) {

        Trainer t;

        t = new JavaTrainer();

        t.teach();
        t.takeAttendance();
        t.prepare();

        System.out.println();

        t = new MTTrainer();

        t.teach();
        t.takeAttendance();
        t.prepare();
    }
}
```

### Output

```text
Java Trainer teaches Java
Java Trainer takes attendance
Java Trainer prepares Java lessons

MT Trainer teaches Manual Testing
MT Trainer takes attendance
MT Trainer prepares testing lessons
```

---

# 🧠 Where Is the Polymorphism?

The key line is:

```java
Trainer t;
```

This is an **interface reference**.

Then:

```java
t = new JavaTrainer();
```

and:

```java
t = new MTTrainer();
```

The same reference points to different implementing-class objects.

```text
Trainer t
    │
    ├────→ JavaTrainer
    │          ↓
    │       teach()
    │
    └────→ MTTrainer
               ↓
            teach()
```

The JVM decides at runtime which implementation should execute.

---

# ⭐ Why Is This Useful?

Suppose you have 100 different trainer classes.

Instead of writing separate code for every trainer, you can work with the common interface:

```java
Trainer t;
```

For example:

```java
void conductClass(Trainer t) {

    t.teach();
    t.takeAttendance();
    t.prepare();
}
```

Now:

```java
conductClass(new JavaTrainer());
conductClass(new MTTrainer());
```

The same method works with different trainer types.

This gives:

```text
Common Interface
       ↓
Common reference
       ↓
Different objects
       ↓
Different implementations
       ↓
Runtime Polymorphism
```

### 🔥 Interview Answer

> **Interface polymorphism occurs when an interface reference is used to refer to objects of different implementing classes. When an overridden interface method is called through the common interface reference, the implementation corresponding to the actual object is selected at runtime.**
