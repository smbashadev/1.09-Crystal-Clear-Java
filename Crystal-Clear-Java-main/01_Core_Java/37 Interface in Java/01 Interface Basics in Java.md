# 🧒 Interface Basics in Java

An **interface** is a Java construct used to define a **standard set of rules/contracts** that implementing classes must follow.

Your three key points are:

```text
Interface
   ↓
Multiple Inheritance
   ↓
SRS → Standardisation of Code
```

---

## 1. What is an Interface?

Think of an interface as a **rule book**.

For example, suppose we define:

```java
interface SecurityForce {

    void attack();

    void defend();
}
```

The interface says:

> "Any class that implements me must provide `attack()` and `defend()`."

A class can implement it:

```java
class Army implements SecurityForce {

    public void attack() {
        System.out.println("Army attacks");
    }

    public void defend() {
        System.out.println("Army defends");
    }
}
```

So:

```text
SecurityForce
      ↓
   Rules
  ┌────────┐
  │ attack │
  │ defend │
  └────────┘
      ↓
     Army
      ↓
Provides implementation
```

---

# 2. Interface and Multiple Inheritance ⭐

Java **does not support multiple inheritance through classes**.

This is not allowed:

```java
class Child extends Parent1, Parent2 {   // ❌
}
```

The reason is potential **ambiguity**, especially when both parent classes contain the same method.

But Java provides interfaces as a way to achieve **multiple inheritance of type/contract**.

Example:

```java
interface Camera {

    void click();
}

interface MusicPlayer {

    void playMusic();
}
```

One class can implement both:

```java
class Mobile implements Camera, MusicPlayer {

    public void click() {
        System.out.println("Taking photo");
    }

    public void playMusic() {
        System.out.println("Playing music");
    }
}
```

So:

```text
       Camera          MusicPlayer
          │                │
          │                │
          └───────┬────────┘
                  ↓
               Mobile
```

This is one of the major uses of interfaces.

---

# 3. SRS — Service Requirement Specification

In your notes, **SRS** can be understood as:

> **Service Requirement Specification**

The idea is that an interface can specify the **services/requirements** that a class should provide.

For example:

```java
interface ATM {

    void withdraw();

    void deposit();

    void checkBalance();
}
```

The interface specifies the required services:

```text
ATM
 │
 ├── withdraw()
 ├── deposit()
 └── checkBalance()
```

The implementing class decides **how** these services are performed.

```java
class SBIATM implements ATM {

    public void withdraw() {
        System.out.println("Withdrawal service");
    }

    public void deposit() {
        System.out.println("Deposit service");
    }

    public void checkBalance() {
        System.out.println("Balance checking service");
    }
}
```

So:

```text
Interface
   ↓
Specifies WHAT services are required
   ↓
Implementing class
   ↓
Defines HOW services are performed
```

---

# 4. Standardisation of Code

This is another important purpose.

Suppose we have:

```text
Army
Navy
AirForce
```

We want all of them to provide:

```text
attack()
defend()
```

We can create a common interface:

```java
interface SecurityForce {

    void attack();

    void defend();
}
```

Now:

```java
class Army implements SecurityForce {
    
    public void attack() {
        System.out.println("Army attack");
    }

    public void defend() {
        System.out.println("Army defend");
    }
}
```

```java
class Navy implements SecurityForce {
    
    public void attack() {
        System.out.println("Navy attack");
    }

    public void defend() {
        System.out.println("Navy defend");
    }
}
```

```java
class AirForce implements SecurityForce {
    
    public void attack() {
        System.out.println("AirForce attack");
    }

    public void defend() {
        System.out.println("AirForce defend");
    }
}
```

Every implementing class follows the same standard:

```text
SecurityForce
      │
      ├── attack()
      └── defend()
            ↓
 ┌──────────┼──────────┐
 ↓          ↓          ↓
Army       Navy     AirForce
```

That's **standardisation**.

---

# 🧠 Easy Real-Life Example

Think of a **USB standard**.

Different companies can manufacture devices, but if they follow the same USB specification, compatible devices can work together.

Similarly, an interface establishes a common **contract/standard**.

```text
Interface
    ↓
Common rules
    ↓
Different classes
    ↓
Different implementations
```

---

# ⭐ Interface vs Class

| Interface                                  | Class                                                 |
| ------------------------------------------ | ----------------------------------------------------- |
| Defines a contract                         | Provides implementation                               |
| Can be implemented by classes              | Can be extended by classes                            |
| Supports multiple interface implementation | Java classes don't support multiple class inheritance |
| Used for standardisation                   | Used to model/implement behavior and state            |

---

# 🔥 Remember This

```text
INTERFACE
    ↓
Contract / Rules
    ↓
WHAT should be provided
    ↓
Implementing class
    ↓
HOW it should be provided
```

And:

```text
One class
   ↓
implements Interface1, Interface2
   ↓
Multiple inheritance of type
```

### Interview Answer

> **An interface in Java is used to define a common contract or standard that implementing classes must follow. It helps achieve multiple inheritance of type because a class can implement multiple interfaces. Interfaces are also useful for standardising code by specifying common services or requirements while allowing each implementing class to provide its own implementation.**
