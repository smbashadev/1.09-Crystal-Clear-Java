# 🧒 Interface Implementation

An interface defines a **common contract**, and a class uses the `implements` keyword to follow that contract.

The important pattern is:

```java
class ClassName implements InterfaceName {
    // implementation
}
```

---

## 1. `implements` Keyword

Suppose we create a `Calculator` interface:

```java
interface Calculator {

    void add();

    void subtract();
}
```

This interface says:

> "Any class that implements me must provide `add()` and `subtract()`."

A class implements it using:

```java
class BasicCalculator implements Calculator {

    public void add() {
        System.out.println("Basic addition");
    }

    public void subtract() {
        System.out.println("Basic subtraction");
    }
}
```

So:

```text
Calculator
    ↓
  contract
    ↓
BasicCalculator
    ↓
implements
```

---

# 2. Multiple Implementing Classes

The **same interface** can be implemented by multiple classes.

For example:

```text
                    Calculator
                        │
             ┌──────────┼──────────┐
             ↓          ↓          ↓
       BasicCalculator  ScientificCalculator
                                  AdvancedCalculator
```

Each class follows the same interface but can provide a **different implementation**.

---

# 3. Calculator Example

Let's define:

```java
interface Calculator {

    void add();

    void subtract();
}
```

### Basic Calculator

```java
class BasicCalculator implements Calculator {

    public void add() {
        System.out.println("Basic Calculator: Addition");
    }

    public void subtract() {
        System.out.println("Basic Calculator: Subtraction");
    }
}
```

### Scientific Calculator

```java
class ScientificCalculator implements Calculator {

    public void add() {
        System.out.println("Scientific Calculator: Addition");
    }

    public void subtract() {
        System.out.println("Scientific Calculator: Subtraction");
    }
}
```

Both classes follow the same contract:

```text
Calculator
 ├── add()
 └── subtract()
```

But they can implement the operations differently.

---

# 4. Complete Program

```java
interface Calculator {

    void add();

    void subtract();
}

class BasicCalculator implements Calculator {

    @Override
    public void add() {
        System.out.println("Basic Calculator: Addition");
    }

    @Override
    public void subtract() {
        System.out.println("Basic Calculator: Subtraction");
    }
}

class ScientificCalculator implements Calculator {

    @Override
    public void add() {
        System.out.println("Scientific Calculator: Addition");
    }

    @Override
    public void subtract() {
        System.out.println("Scientific Calculator: Subtraction");
    }
}

class Demo {

    public static void main(String[] args) {

        Calculator c;

        c = new BasicCalculator();

        c.add();
        c.subtract();

        c = new ScientificCalculator();

        c.add();
        c.subtract();
    }
}
```

### Output

```text
Basic Calculator: Addition
Basic Calculator: Subtraction
Scientific Calculator: Addition
Scientific Calculator: Subtraction
```

---

# 5. Different Implementations ⭐

Notice that the interface contains:

```java
void add();
void subtract();
```

It doesn't specify the implementation.

So:

```text
Calculator
      ↓
   add()
   subtract()
      ↓
 ┌────┴────────────────┐
 ↓                     ↓
BasicCalculator   ScientificCalculator
 ↓                     ↓
Implementation 1    Implementation 2
```

The **same method contract** can have **different implementations**.

---

# 6. Interface Reference + Multiple Implementations

This is also an example of **runtime polymorphism**:

```java
Calculator c;

c = new BasicCalculator();
c.add();

c = new ScientificCalculator();
c.add();
```

The reference type remains:

```java
Calculator c;
```

But the actual object changes:

```text
Calculator c
     ↓
BasicCalculator
     ↓
Basic implementation


Calculator c
     ↓
ScientificCalculator
     ↓
Scientific implementation
```

---

# 🧠 Easy Memory Trick

```text
interface
    ↓
Defines WHAT
    ↓
implements
    ↓
Class provides HOW
```

And:

```text
One Interface
      ↓
Multiple Classes
      ↓
Different Implementations
```

### 🔥 Interview Answer

> **A class implements an interface using the `implements` keyword. Multiple classes can implement the same interface, and each implementing class can provide its own implementation of the interface methods. This provides standardization, flexibility, and supports runtime polymorphism.**
