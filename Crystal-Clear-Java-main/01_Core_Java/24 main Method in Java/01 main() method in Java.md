# 🧒 `main()` Method in Java

The `main()` method is one of the **most important methods in a Java program**.

When you run a normal Java application, the JVM needs to know:

> **"Where should I start executing the program?"**

The standard `main()` method is the starting point the JVM looks for.

```java
public static void main(String[] args)
```

Let's understand **every single word** like you're learning it for the first time.

---

# 1. The Complete `main()` Method

```java
public static void main(String[] args) {
    
    System.out.println("Hello Java");
}
```

Break it into pieces:

```text
public
   ↓
static
   ↓
void
   ↓
main
   ↓
(String[] args)
   ↓
{ }
```

Each part has a purpose.

---

# 2. Why Is `main()` `public`?

```java
public static void main(String[] args)
```

`public` means:

> **The method can be accessed from outside the class.**

The JVM is responsible for starting the program.

The JVM doesn't have to be inside your class to invoke `main()`.

For example:

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Hello");
    }
}
```

The JVM finds the class and invokes its standard `main()` method.

### 🧠 Simple idea

```text
JVM
 ↓
Find class
 ↓
Find public main()
 ↓
Call main()
```

If `main()` isn't accessible as required, the JVM cannot start the application through that entry point.

---

# 3. Why Is `main()` `static`?

This is one of the most frequently asked interview questions.

Consider:

```java
static
```

A static method belongs to the **class**, not to a particular object.

Therefore, the JVM can invoke the standard `main()` method **without first creating an object of the class**.

Think:

### Non-static method

```java
class Demo {

    void display() {
        System.out.println("Hello");
    }
}
```

Normally:

```java
Demo d = new Demo();

d.display();
```

An object is needed to invoke it.

---

### Static `main()`

```java
public static void main(String[] args)
```

The JVM can invoke it without doing:

```java
Demo d = new Demo();
```

Think:

```text
JVM
 ↓
Class
 ↓
static main()
```

No object is required merely to invoke `main()`.

### 🧠 Remember

> **`main()` is static so the JVM can invoke the entry point without creating an object first.**

---

# 4. Why Is the Return Type `void`?

Look at:

```java
void
```

`void` means:

> **This method does not return a value.**

For example:

```java
int add() {
    return 10;
}
```

This method returns an `int`.

But:

```java
void display() {
    System.out.println("Hello");
}
```

doesn't return a value.

The same idea applies to `main()`:

```java
public static void main(String[] args)
```

The method performs the program's starting work, but it does not return a Java value to the JVM.

---

# 5. What Happens When `main()` Finishes?

Suppose:

```java
public static void main(String[] args) {

    System.out.println("Hello");
}
```

The JVM starts `main()`:

```text
JVM
 ↓
main()
 ↓
Hello
 ↓
main() finishes
```

When the main thread finishes and there are no other non-daemon threads keeping the application alive, the Java application terminates.

So don't think:

```text
void = JVM receives 0
```

That's incorrect.

Instead remember:

> **`void` means `main()` has no return value.**

---

# 6. Why Is `main` the Name?

```java
public static void main(String[] args)
                    ↑
                   main
```

`main` is the **method name**.

For a standard Java application launch, the JVM looks for the recognized `main` entry-point signature.

Think of `main()` as:

> **"Start the program from here."**

---

# 7. `main()` Is the Entry Point

An **entry point** is the place where execution of a program begins.

Imagine a building:

```text
                  BUILDING
                     │
                     ↓
                MAIN ENTRANCE
```

You enter through the main entrance.

Similarly:

```text
Java Program
     ↓
 main()
     ↓
Program execution
```

So:

> **`main()` is the standard entry point for launching a Java application.**

---

# 8. What Is `String[] args`?

Now we reach:

```java
String[] args
```

This is the parameter of `main()`.

Break it down:

```text
String
  ↓
Array of Strings
  ↓
args
```

So:

```java
String[] args
```

means:

> **`args` is an array that can hold String values.**

---

# 9. Why Is `args` an Array?

Because we can provide **multiple command-line arguments**.

For example:

```text
Java
Basha
20
Hyderabad
```

These can be received as strings inside:

```java
String[] args
```

Conceptually:

```text
args
 ↓
┌─────────────┐
│ "Java"      │ → args[0]
│ "Basha"     │ → args[1]
│ "20"        │ → args[2]
│ "Hyderabad" │ → args[3]
└─────────────┘
```

---

# 10. Command-Line Arguments

Command-line arguments are values supplied to the program when it is launched.

Example:

```text
java Demo Basha 25
```

The program receives:

```text
args[0] → "Basha"
args[1] → "25"
```

Notice that both are **Strings**.

Even:

```text
25
```

comes into `args` as:

```java
"25"
```

not as the integer:

```java
25
```

If you need an integer, you can convert it:

```java
int age = Integer.parseInt(args[1]);
```

---

# 11. Command-Line Argument Program

```java
class Demo {

    public static void main(String[] args) {

        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}
```

Suppose you run:

```text
java Demo Basha Java
```

Then:

```text
args[0] → "Basha"
args[1] → "Java"
```

Output:

```text
Basha
Java
```

---

# 12. Why Does Index Start at `0`?

Because `args` is an array.

Java arrays start indexing at `0`.

So:

```text
First value  → args[0]
Second value → args[1]
Third value  → args[2]
```

Remember:

```text
0 → first
1 → second
2 → third
```

---

# 13. Valid Main Syntax — Way 1

```java
public static void main(String[] args)
```

This is the most commonly written form.

Meaning:

```text
public → accessible
static → no object required to invoke
void → no return value
main → entry-point method name
String[] → array of Strings
args → parameter name
```

---

# 14. Valid Main Syntax — Way 2

```java
public static void main(String args[])
```

This is also valid.

Compare:

```java
String[] args
```

and:

```java
String args[]
```

Both declare a String array.

So these are equivalent:

```java
String[] args
```

```java
String args[]
```

Therefore:

```java
public static void main(String args[])
```

is valid.

---

# 15. Valid Main Syntax — Way 3

```java
public static void main(String... args)
```

The `...` is called **varargs**.

It allows the method to receive a variable number of String arguments.

For the purpose of `main()`, this form is accepted as an entry point.

Think:

```java
String... args
```

as a String varargs parameter that can be treated as a String array inside the method.

---

# 16. Valid Main Syntax — Way 4

```java
static public void main(String[] args)
```

Notice:

```text
public static
```

became:

```text
static public
```

For these method modifiers, their order can be rearranged.

Therefore this is also valid:

```java
static public void main(String[] args)
```

The important modifiers are still there:

```text
static
public
```

---

# 17. Valid Main Syntax — Way 5

```java
final synchronized public static void main(String[] args)
```

This contains additional method modifiers:

```text
final
synchronized
public
static
```

The method can still have the recognized `main` entry-point form because these additional modifiers do not change the required parameter/return structure.

For learning purposes, the important thing is to recognize that the standard required pieces are still present:

```text
public
static
void
main
String[] args
```

---

# 18. Main Method Overloading

Now comes a very important interview question.

Can we overload `main()`?

### YES! Java allows you to define overloaded methods named `main`.

For example:

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Standard main");
    }

    public static void main(int args) {

        System.out.println("Integer main");
    }

    public static void main() {

        System.out.println("No-argument main");
    }
}
```

These are different methods because their parameter lists are different:

```text
main(String[])
main(int)
main()
```

This is called **method overloading**.

---

# 19. Which `main()` Does the JVM Start?

This is the important part.

Suppose we have:

```java
main(String[] args)
main(int args)
main()
```

The JVM starts with the recognized application entry-point form:

```java
public static void main(String[] args)
```

The other overloaded methods are **not automatically chosen as the application entry point**.

They can be called from your code if you explicitly invoke them.

---

# 20. Example of Overloaded `main()`

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Standard main");

        main();
        main(10);
    }

    public static void main() {

        System.out.println("No-argument main");
    }

    public static void main(int x) {

        System.out.println("Integer main");
    }
}
```

Output:

```text
Standard main
No-argument main
Integer main
```

Why?

The JVM starts:

```text
main(String[])
```

Then **your program** calls:

```text
main()
```

and:

```text
main(int)
```

---

# 🧠 Complete `main()` Map

```text
              main()
                │
     ┌──────────┼───────────┐
     ↓          ↓           ↓
   public     static       void
     ↓          ↓           ↓
 accessible   no object   no return
                │
                ↓
              main
                │
                ↓
          String[] args
                │
                ↓
       command-line arguments
```

---

# 📊 `main()` Components

| Component  | Meaning                                            |
| ---------- | -------------------------------------------------- |
| `public`   | Allows the JVM to access the method                |
| `static`   | JVM can invoke it without creating an object first |
| `void`     | No value is returned                               |
| `main`     | Standard entry-point method name                   |
| `String[]` | Array of String values                             |
| `args`     | Parameter name/reference to that array             |

---

# 🎯 Complete Execution Picture

When you launch:

```text
java Demo
```

Think:

```text
JVM
 ↓
Load/initialize Demo class
 ↓
Find recognized main entry point
 ↓
public static void main(String[] args)
 ↓
Invoke main()
 ↓
Your program executes
```

If command-line arguments are supplied:

```text
java Demo Basha Java
```

then:

```text
args[0] = "Basha"
args[1] = "Java"
```

---

# ⭐ Interview Memory

### Why `public`?

> **So the JVM can access the entry-point method from outside the class.**

### Why `static`?

> **So the JVM can invoke it without creating an object first.**

### Why `void`?

> **Because the `main()` method does not return a value.**

### Why `main`?

> **It is the standard method name recognized as the application entry point.**

### Why `String[] args`?

> **To receive command-line arguments as an array of Strings.**

### Can `main()` be overloaded?

> **Yes. But the JVM starts the recognized `main(String[] args)` entry point; overloaded versions execute only when explicitly called.**

---

# 🧠 Remember This Forever

```text
public
  ↓
JVM can access

static
  ↓
No object needed

void
  ↓
No return value

main
  ↓
Starting point

String[] args
  ↓
Command-line String array
```

### 🔥 One-line formula

> **`public static void main(String[] args)` = JVM-accessible + object-independent + no return value + standard entry point + String-array input.**
