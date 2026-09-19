# 🧒 Encapsulation in Java

**Encapsulation** is one of the most important concepts in **Object-Oriented Programming (OOP)**.

The easiest way to remember it is:

> 🧠 **Encapsulation = Binding data and the methods that work on that data together, while controlling access to the data.**

---

# 1. What Is Encapsulation?

The word **encapsulation** can be understood as:

> **Wrapping or putting things together inside a single unit.**

In Java, that unit is usually a **class**.

For example, imagine a **Student**.

A student has data:

```text
Name
Age
Marks
```

And the student can perform actions:

```text
Study()
WriteExam()
DisplayMarks()
```

We put the data and the methods together inside one class:

```java
class Student {

    String name;
    int age;
    int marks;

    void study() {
        System.out.println("Student is studying");
    }

    void displayMarks() {
        System.out.println(marks);
    }
}
```

Here:

```text
Student class
     │
     ├── Data members
     │     ├── name
     │     ├── age
     │     └── marks
     │
     └── Member methods
           ├── study()
           └── displayMarks()
```

This **binding of data members and member functions together** is encapsulation.

---

# 2. Encapsulation Is an OOP Pillar

Encapsulation is one of the major pillars of **Object-Oriented Programming**.

The commonly discussed four pillars are:

```text
        OOP
         │
   ┌─────┼─────┬─────┐
   ↓     ↓     ↓     ↓
Encap-  Inher- Poly- Abstraction
sulation itance morphism
```

So remember:

> **Encapsulation is an OOP pillar.**

---

# 3. Why Do We Need Encapsulation?

One major reason is **security**.

Imagine a bank account.

It has:

```text
balance
```

You don't want everyone to directly change it.

Bad situation:

```java
account.balance = -50000;
```

That would allow outside code to change important data directly.

Instead, we can protect the data and provide controlled methods to work with it.

---

# 4. Encapsulation and Security 🔐

For example:

```java
class BankAccount {

    private double balance;

    public void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
        }
    }

    public double getBalance() {

        return balance;
    }
}
```

Here:

```java
private double balance;
```

means outside code cannot directly access `balance`.

Instead:

```java
account.deposit(1000);
```

is used to modify it.

And:

```java
account.getBalance();
```

is used to read it.

So the class controls **how its data is accessed and changed**.

---

# 5. Think About a Capsule 💊

The word **encapsulation** is easy to remember if you imagine a capsule.

A capsule contains things **inside** it.

Similarly:

```text
             CLASS
        ┌───────────────┐
        │               │
        │ Data          │
        │     +         │
        │ Methods       │
        │               │
        └───────────────┘
```

The class acts like a container.

That's why we use the idea:

> **Encapsulation = wrapping data and methods together.**

---

# 6. Binding Data + Methods

Your key point is:

> **Binding data members and member functions**

Let's understand the words.

### Data member

A variable declared inside a class:

```java
int age;
String name;
```

### Member function

In Java, we usually call these **methods**:

```java
void display() {
}
```

So:

```text
Data members
     +
Member methods
     ↓
Encapsulation
```

Example:

```java
class Student {

    String name;       // Data member
    int age;           // Data member

    void display() {   // Member method
        System.out.println(name);
        System.out.println(age);
    }
}
```

The data and methods are bound together inside `Student`.

---

# 7. Encapsulation ≠ Just `private`

This is an important interview point.

Many beginners memorize:

> "Encapsulation means making variables private."

That's **incomplete**.

`private` is an important mechanism used to **achieve data hiding/access control**, but the broader idea of encapsulation is the **bundling of data and the methods that operate on that data into a class**, with controlled access where appropriate.

A common Java implementation is:

```java
private data
      +
public methods
      ↓
controlled access
```

---

# 8. Simple Real-Life Example 🚗

Think about a car.

Inside the car there are many things:

```text
Engine
Fuel system
Battery
Transmission
```

You don't directly operate every internal component.

Instead, you use controls:

```text
Steering
Brake
Accelerator
```

The internal details are kept behind an interface.

Similarly, a Java class can keep important data controlled and provide methods for safe operations.

---

# ⭐ Golden Rule

Remember this definition:

> **Encapsulation is an OOP principle in which data members and the methods that operate on that data are bundled together inside a class, with access to the data controlled to improve security and maintainability.**

### 🧠 Super-easy memory trick

```text
ENCAPSULATION
      ↓
   BUNDLE
      ↓
DATA + METHODS
      ↓
   CLASS
      ↓
CONTROLLED ACCESS
      ↓
   SECURITY
```

### One-line interview answer:

> **Encapsulation is the OOP mechanism of binding data members and member functions together inside a class and controlling access to the data.**
