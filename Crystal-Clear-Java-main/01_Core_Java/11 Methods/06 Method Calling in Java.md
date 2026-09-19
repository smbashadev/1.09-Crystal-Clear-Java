## 🧒 Method Calling in Java

**Method calling** means:

> **Telling Java to execute a particular method.**

For example:

```java
greet();
```

This means:

> "Java, execute the `greet()` method."

---

# 1️⃣ Explicit Method Call

**Explicit** means **we clearly write the method call ourselves**.

Example:

```java
class Demo {

    static void greet() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {

        greet();   // Explicit method call
    }
}
```

Here:

```java
greet();
```

is an **explicit method call** because **the programmer wrote it**.

### Flow

```text id="8q2m5x"
main()
  ↓
greet()
  ↓
"Hello!"
```

---

# 2️⃣ Special Case: `main()`

`main()` is different.

When we run a Java application, **we normally don't write a Java statement that calls `main()` first**.

The **JVM/Java launcher invokes the application's entry-point `main` method**.

For example:

```java
class Demo {

    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

When you run:

```text id="v8s2k4"
java Demo
```

the Java launcher starts the application and invokes:

```java
main(String[] args)
```

So conceptually:

```text id="j6p9qa"
Run Java Program
      ↓
Java Launcher / JVM startup
      ↓
main()
      ↓
Program statements
      ↓
Output
```

---

## 🔍 Why is `main()` special?

Because Java needs an **entry point** from which to start the application.

Think of a house 🏠:

```text id="x4m8cz"
House
  ↓
Main Door
```

`main()` is like the **main door**.

The Java launcher knows the expected entry-point signature:

```java
public static void main(String[] args)
```

and invokes it to start the program.

---

## 🧠 Explicit Call vs `main()`

| Method        | Who invokes it?                                         |
| ------------- | ------------------------------------------------------- |
| `greet()`     | Programmer explicitly calls it                          |
| `add()`       | Programmer explicitly calls it                          |
| `calculate()` | Programmer explicitly calls it                          |
| `main()`      | Java launcher invokes it as the application entry point |

### ⭐ Remember

```text id="t8q3nm"
Normal method
     ↓
Programmer calls it
     ↓
method executes

main()
     ↓
Java launcher invokes it
     ↓
Program starts
```

### 🔑 Interview Answer

> **Method calling means invoking a method for execution. User-defined methods are normally called explicitly by the programmer. The `main()` method is a special entry point that the Java launcher invokes when starting the application.**
