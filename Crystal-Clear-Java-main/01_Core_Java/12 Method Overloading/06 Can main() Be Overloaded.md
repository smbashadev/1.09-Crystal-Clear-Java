## 🧒 Can `main()` Be Overloaded?

### ✅ Yes!

The `main()` method **can be overloaded**.

That means we can have multiple methods named `main()` in the same class, as long as their **parameter lists are different**.

---

# 1️⃣ Multiple `main()` Methods

Example:

```java
class Demo {

    public static void main(String[] args) {
        System.out.println("Original main()");
    }

    public static void main(int number) {
        System.out.println("main(int)");
    }

    public static void main(String name) {
        System.out.println("main(String)");
    }
}
```

Here we have:

```text
main(String[] args)  → one version
main(int number)     → another version
main(String name)    → another version
```

This is **method overloading**.

---

# 2️⃣ Which `main()` Does Java Start With?

When you run the application, the Java launcher looks for the standard entry-point method:

```java
public static void main(String[] args)
```

So:

```text id="x8k3qv"
Run Program
     ↓
Find main(String[] args)
     ↓
Start execution
```

---

# 3️⃣ Overloaded `main()` Methods Are NOT Starting Points

Consider:

```java
class Demo {

    public static void main(String[] args) {
        System.out.println("Starting main");

        main(10);
    }

    public static void main(int number) {
        System.out.println("Overloaded main");
    }
}
```

Output:

```text
Starting main
Overloaded main
```

What happened?

### Step 1

Java starts with:

```java
main(String[] args)
```

### Step 2

Inside it, **we explicitly call**:

```java
main(10);
```

### Step 3

Java finds the matching overloaded method:

```java
main(int number)
```

and executes it.

```text id="x5n9rm"
Java Launcher
      ↓
main(String[] args)     ← Starting point
      ↓
main(10)                ← Explicit call
      ↓
main(int number)        ← Overloaded method
```

---

# 🧠 Important Distinction

| Method                | Role                    |
| --------------------- | ----------------------- |
| `main(String[] args)` | Application entry point |
| `main(int number)`    | Overloaded method       |
| `main(String name)`   | Overloaded method       |
| `main(double value)`  | Overloaded method       |

The overloaded versions are **ordinary methods with the name `main`**. They don't automatically start the application.

---

## 🔑 Easy Memory Trick

```text id="q7m3xp"
Can main() be overloaded?
        ↓
       YES ✅

Multiple main methods?
        ↓
       YES ✅

Which one starts the program?
        ↓
main(String[] args) ✅

Other main() methods?
        ↓
Overloaded methods
        ↓
Must be called explicitly
```

### ⭐ Interview Answer

> **Yes, the `main()` method can be overloaded. We can define multiple `main()` methods with different parameter lists. However, the Java launcher starts the application using the standard `public static void main(String[] args)` entry point. Other overloaded `main()` methods are not automatically invoked; they must be called explicitly.**
