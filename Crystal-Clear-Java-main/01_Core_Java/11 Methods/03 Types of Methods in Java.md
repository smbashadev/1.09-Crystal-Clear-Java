## 🧒 Types of Methods in Java

Java methods are commonly divided into **two types**:

```text id="tq1j3e"
                 Methods
                    │
          ┌─────────┴─────────┐
          ↓                   ↓
   Pre-defined           User-defined
   / Built-in              Methods
      Methods
```

---

# 1️⃣ Pre-defined / Built-in Methods

These are **methods already provided by Java's libraries/classes**.

You don't have to write the method's implementation yourself. You simply **use/call** it.

### Example: `println()`

```java id="n2v7hc"
System.out.println("Hello");
```

`println()` is already provided by Java.

Another example:

```java id="y5z8ps"
int result = Math.max(10, 20);
```

`Math.max()` is also a library method.

Other common examples:

```text id="k9f3wq"
System.out.println()
Math.sqrt()
Math.max()
String.length()
Scanner.nextInt()
```

Think of built-in methods like **ready-made tools 🛠️**:

```text
Java gives you the tool
        ↓
You use the tool
        ↓
Task is performed
```

---

# 2️⃣ User-defined Methods

These are methods that **you create/write yourself** according to your program's requirements.

Example:

```java id="r4m7tc"
class Demo {

    static void greet() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {
        greet();
    }
}
```

Here:

```java id="8x2kqm"
static void greet()
```

is a **user-defined method** because **we created it**.

We decided that its specific task would be:

> Display `"Hello!"`

---

# 🍜 Real-World Analogy

Imagine cooking.

### Pre-defined method

Someone has already prepared a useful kitchen tool:

```text id="h3x8qm"
Ready-made tool
     ↓
Use it
     ↓
Task completed
```

Like Java's:

```java id="a1k7pv"
Math.sqrt(25)
```

### User-defined method

You create your own recipe:

```text id="z6m2rd"
Your recipe
   ↓
Your steps
   ↓
Your specific task
```

For example:

```java id="p8w4ks"
static void prepareMaggi() {
    // your steps
}
```

---

## 🔍 Main Difference

| Pre-defined / Built-in             | User-defined              |
| ---------------------------------- | ------------------------- |
| Already provided by Java libraries | Created by the programmer |
| Ready to use                       | Programmer writes it      |
| Example: `Math.sqrt()`             | Example: `calculateSum()` |
| Example: `println()`               | Example: `displayName()`  |
| We mainly call/use it              | We define and call it     |

### 🧠 Easy Memory Trick

```text id="j4q8sn"
PRE-DEFINED
    ↓
Java provides it
    ↓
We USE it

USER-DEFINED
    ↓
We create it
    ↓
We USE it
```

### 🔑 Interview Answer

> **Methods in Java are commonly classified into two types: pre-defined (built-in/library) methods, which are already provided by Java APIs, and user-defined methods, which are created by the programmer to perform specific tasks.**
