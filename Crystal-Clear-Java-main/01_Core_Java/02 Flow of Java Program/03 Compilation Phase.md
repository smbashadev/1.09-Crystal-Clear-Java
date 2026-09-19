# ☕ Compilation Phase

The **compilation phase** is the stage where your **Java source code is converted into Java bytecode**.

The simple flow is:

```text
.java file
   ↓
Source Code
   ↓
Java Compiler (javac)
   ↓
Bytecode
   ↓
.class file
```

Let's understand each part.

---

## 1. `.java` File 📄

When you write a Java program, you save it with the **`.java` extension**.

Example:

```text
Hello.java
```

The `.java` file contains your **Java source code**.

---

## 2. Source Code 👨‍💻

The actual Java statements written by the programmer are called **source code**.

Example:

```java
class Hello {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

This is human-readable.

So:

```text
Hello.java
     ↓
Contains
     ↓
Java Source Code
```

---

## 3. Java Compiler — `javac` ⚙️

The **Java compiler** converts your source code into bytecode.

The compiler command is:

```text
javac
```

For example:

```bash
javac Hello.java
```

Think of `javac` as a **translator**:

```text
Java Source Code
       ↓
     javac
       ↓
    Bytecode
```

It also checks your source code for **compile-time errors**.

For example, if you make a syntax mistake:

```java
System.out.println("Hello"
```

the compiler reports an error instead of producing a valid class file.

---

# 4. Bytecode 🔢

If compilation is successful, the compiler generates **Java bytecode**.

This bytecode is stored in a `.class` file.

For example:

```text
Hello.java
    ↓
  javac
    ↓
Hello.class
```

The `.class` file contains the bytecode that the **JVM can execute**.

---

# 5. `.class` File 📦

The compiled bytecode is normally stored in a file ending with:

```text
.class
```

Example:

```text
Hello.class
```

Think of it as:

```text
.java  → What the programmer writes
.class → What the compiler produces
```

---

# 🔄 Complete Compilation Phase

Suppose you create:

```text
Hello.java
```

Inside it:

```java
class Hello {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

You compile it:

```bash
javac Hello.java
```

Then:

```text
┌──────────────────────┐
│     Hello.java       │
│                      │
│    Source Code       │
└──────────┬───────────┘
           │
           │ javac
           ↓
┌──────────────────────┐
│     Hello.class      │
│                      │
│      Bytecode        │
└──────────────────────┘
```

That's the **compilation phase**.

---

# 🧠 Very Important: Compilation ≠ Execution

Don't confuse these two phases.

### Compilation

```text
.java
  ↓
javac
  ↓
.class / Bytecode
```

### Execution

```text
.class / Bytecode
       ↓
      JVM
       ↓
Execution
```

Therefore:

> **The Java compiler converts source code into bytecode. The JVM executes that bytecode.**

---

# 🎯 One-Line Interview Answer

> **During the compilation phase, the Java compiler (`javac`) takes the source code from a `.java` file, checks it for compile-time errors, and converts it into platform-independent bytecode stored in a `.class` file.**

### 🔥 Remember

**`.java` → Source Code → `javac` → Bytecode → `.class` file**
