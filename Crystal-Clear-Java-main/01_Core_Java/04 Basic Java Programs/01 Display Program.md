# ☕ Java Display Program 

A **display program** simply means a Java program that **prints something on the screen**.

Java mainly gives us:

```java
System.out.print()
System.out.println()
```

Think of them as **two different ways of writing on a screen**.

---

# 1. `System.out.println()`

`println()` means:

> **Print something and then move to the next line.**

Example:

```java
class Demo {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Java");
    }
}
```

Output:

```text
Hello
Java
```

After printing `"Hello"`, `println()` moves the cursor to the **next line**.

Think:

```text
println("Hello")
        ↓
Hello
       ↓
   next line
```

---

# 2. `System.out.print()`

`print()` means:

> **Print something but stay on the same line.**

Example:

```java
class Demo {
    public static void main(String[] args) {
        System.out.print("Hello");
        System.out.print("Java");
    }
}
```

Output:

```text
HelloJava
```

The cursor does **not automatically move to the next line**.

---

# 3. Printing "Hello World" 🌍

The simplest display program:

```java
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

Output:

```text
Hello World
```

This is often called the **Hello World program**.

---

# 4. Printing Multiple Lines

You can use multiple `println()` statements:

```java
class Demo {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Welcome");
        System.out.println("to Java");
    }
}
```

Output:

```text
Hello
Welcome
to Java
```

You can also use `\n` inside one string:

```java
class Demo {
    public static void main(String[] args) {
        System.out.println("Hello\nWelcome\nto Java");
    }
}
```

Output:

```text
Hello
Welcome
to Java
```

---

# 5. `\n` — New Line ↵

`\n` is an **escape sequence** that represents a new line.

Example:

```java
System.out.print("Hello\nJava");
```

Output:

```text
Hello
Java
```

Think:

```text
\n
↓
"Go to the next line"
```

---

# 6. `\b` — Backspace ⬅️

`\b` represents a **backspace** character.

Example:

```java
System.out.print("AB\bC");
```

The `\b` moves the cursor back by one position. The exact visible result can depend on the console/environment because backspace is a control character.

Conceptually:

```text
A B
  ↑
\b moves back
```

A simple way to remember:

> **`\b` = backspace**

---

# 7. `\t` — Tab ↹

`\t` represents a **horizontal tab**.

Example:

```java
System.out.println("Name\tAge");
System.out.println("Basha\t26");
```

Output will look approximately like:

```text
Name    Age
Basha   26
```

The exact spacing depends on the tab stops of the output environment.

Think:

```text
\t
↓
TAB
```

---

# 8. Escape Sequences

An **escape sequence** is a special combination beginning with a backslash `\` that represents a special character or action.

Some commonly used Java escape sequences are:

| Escape Sequence | Meaning         |
| --------------- | --------------- |
| `\n`            | New line        |
| `\t`            | Horizontal tab  |
| `\b`            | Backspace       |
| `\r`            | Carriage return |
| `\\`            | Backslash `\`   |
| `\'`            | Single quote    |
| `\"`            | Double quote    |

### 🧠 Easy memory

```text
\n → New line
\t → Tab
\b → Backspace
\" → Double quote
\\ → Backslash
```

---

# 9. Printing Double Quotes `"`

Suppose you want the output:

```text
Hello "Java"
```

If you write:

```java
System.out.println("Hello "Java"");
```

❌ This is invalid because Java thinks the string ends before `Java`.

Instead, use:

```java
System.out.println("Hello \"Java\"");
```

Output:

```text
Hello "Java"
```

Why?

```text
\" 
 ↓
Print "
```

The backslash tells Java:

> **"Treat this quote as a character inside the string."**

---

# 10. `print()` vs `println()`

This is very important.

| `print()`                                     | `println()`                            |
| --------------------------------------------- | -------------------------------------- |
| Prints the value                              | Prints the value                       |
| Does **not** automatically move to a new line | Moves to a **new line** after printing |
| Next output continues on the same line        | Next output starts on the next line    |

### `print()` example

```java
System.out.print("Hello");
System.out.print("World");
```

Output:

```text
HelloWorld
```

### `println()` example

```java
System.out.println("Hello");
System.out.println("World");
```

Output:

```text
Hello
World
```

---

# 🧠 ELI5 Analogy

Imagine you're writing on paper.

### `print()`

You write:

```text
Hello
```

and **keep your pen on the same line**.

Then:

```text
Hello World
```

### `println()`

You write:

```text
Hello
```

then move your pen to the **next line**.

```text
Hello
World
```

So:

> **`print()` = Print and stay**
> **`println()` = Print and move to the next line**

---

# 🎯 One Complete Program

```java
class DisplayDemo {
    public static void main(String[] args) {

        System.out.println("Hello World");

        System.out.print("Hello ");
        System.out.print("Java");

        System.out.println();

        System.out.println("Name\tAge");
        System.out.println("Basha\t26");

        System.out.println("Hello\nJava");

        System.out.println("Hello \"Java\"");
    }
}
```

Possible output:

```text
Hello World
Hello Java
Name    Age
Basha   26
Hello
Java
Hello "Java"
```

---

# 🔥 Final Revision

```text
System.out.print()
       ↓
Print → Stay on same line

System.out.println()
       ↓
Print → Move to next line
```

And:

```text
\n  → New line
\t  → Tab
\b  → Backspace
\"  → Double quote
\\  → Backslash
```

### ⭐ Interview answer

> **`System.out.print()` displays the specified value without automatically moving to the next line, whereas `System.out.println()` displays the value and then moves the cursor to the next line. Escape sequences such as `\n`, `\t`, `\b`, and `\"` are used to represent special characters or formatting within strings.**
