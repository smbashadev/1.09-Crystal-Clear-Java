# 🧒 Inheriting an Abstract Class

When a **concrete child class** extends an abstract class, Java gives us **two options**.

Suppose the parent class has two abstract methods:

```java
abstract class SecurityForce {

    abstract void attack();

    abstract void defend();
}
```

Now:

```java
class Army extends SecurityForce {

}
```

❌ This is not valid because `Army` has inherited two abstract methods but has not dealt with them.

The child has **two choices**.

---

# 1️⃣ Option 1 — Override All Abstract Methods

The child can provide implementations for **all** abstract methods.

```java
class Army extends SecurityForce {

    @Override
    void attack() {

        System.out.println("Army attacks");
    }

    @Override
    void defend() {

        System.out.println("Army defends");
    }
}
```

Now `Army` is a normal/concrete class.

Therefore, we can create its object:

```java
Army a = new Army();
```

### Flow

```text
SecurityForce
   │
   ├── abstract attack()
   └── abstract defend()
          ↓
        Army
   ├── attack() ✅
   └── defend() ✅
```

---

# 2️⃣ Option 2 — Declare the Child Class `abstract`

The child does **not** have to implement all abstract methods immediately.

Instead, it can also be declared `abstract`.

```java
abstract class Army extends SecurityForce {

}
```

This is valid.

The responsibility of implementing the abstract methods can be passed to a further concrete child.

```java
class IndianArmy extends Army {

    @Override
    void attack() {

        System.out.println("Army attacks");
    }

    @Override
    void defend() {

        System.out.println("Army defends");
    }
}
```

Hierarchy:

```text id="u5t4qm"
SecurityForce
   │
   ├── abstract attack()
   └── abstract defend()
          │
          ↓
     abstract Army
          │
          ↓
     IndianArmy
          │
          ├── attack() ✅
          └── defend() ✅
```

---

# ⭐ Complete Program

```java
abstract class SecurityForce {

    abstract void attack();

    abstract void defend();
}

// Option 2: Child is also abstract
abstract class Army extends SecurityForce {

}

// Concrete child provides implementations
class IndianArmy extends Army {

    @Override
    void attack() {
        System.out.println("Indian Army attacks");
    }

    @Override
    void defend() {
        System.out.println("Indian Army defends");
    }
}

class Demo {

    public static void main(String[] args) {

        IndianArmy army = new IndianArmy();

        army.attack();
        army.defend();
    }
}
```

### Output

```text
Indian Army attacks
Indian Army defends
```

---

# 🧠 Two Options — Easy Memory Trick

Whenever a class extends an abstract class:

```text
        Abstract Parent
               ↓
          Child Class
          ↙       ↘
         ↓         ↓
   Implement     Declare
   all methods   child abstract
```

### Option 1

```java
class Child extends Parent {
    
    // Override all abstract methods
}
```

➡️ Child becomes **concrete**.

### Option 2

```java
abstract class Child extends Parent {
    
}
```

➡️ Child remains **abstract**.

---

# 🔥 Interview Answer

> **When a class inherits an abstract class, it has two options: either override and implement all inherited abstract methods, or declare the child class itself as abstract. If the child is declared abstract, it can leave the abstract methods unimplemented and a further concrete subclass can implement them.**
