# 🧒 Access Specifier: `public`

An **access specifier** tells Java:

> **"Who is allowed to access this class, variable, method, or constructor?"**

Java has four access levels:

```text
public
protected
default
private
```

Let's start with **`public`**.

---

# 1. What Does `public` Mean?

`public` means:

> 🟢 **Anyone can access it, as long as they can access the containing class.**

It provides the **maximum visibility** among Java access levels.

Think of a public park:

```text
PUBLIC
  ↓
Everyone can enter
```

Similarly:

```text
public method
     ↓
Can be accessed from other classes/packages
```

---

# 2. Public = Maximum Visibility

Suppose we have:

```java id="j5z9pw"
public int amount = 1000;
```

Because `amount` is `public`, it can be accessed from other classes.

```text id="j3n5wq"
Class A
  │
  └── public amount
          ↓
       Class B
          ↓
       Can access
```

---

# 3. Example Program

### `Bank.java`

```java id="h6v9tm"
public class Bank {

    public int amount = 10000;

    public void displayAmount() {

        System.out.println("Amount = " + amount);
    }
}
```

Here both are public:

```java id="c1jv4h"
public int amount
public void displayAmount()
```

So another class can access them.

---

### `Demo.java`

```java id="h7k2pa"
class Demo {

    public static void main(String[] args) {

        Bank b = new Bank();

        System.out.println(b.amount);

        b.displayAmount();
    }
}
```

### Output

```text id="m9t8vf"
10000
Amount = 10000
```

---

# 4. Why Can `Demo` Access Them?

Because:

```java id="j8p3qz"
public int amount
```

is public.

And:

```java id="t4c2xk"
public void displayAmount()
```

is public.

Therefore another class can access them.

```text id="2z2c9r"
Bank
 ├── public amount
 └── public displayAmount()
          ↓
        Demo
          ↓
       ACCESS ✅
```

---

# 5. Public Across Packages

`public` is especially important when classes are in **different packages**.

For example:

```text id="q4z8y1"
Package A
   ↓
Bank.java

Package B
   ↓
Demo.java
```

A public member can be accessed from another package, provided the class itself is accessible and the normal import/package rules are satisfied.

Example:

```java id="r5q6hx"
package bank;

public class Bank {

    public int amount = 10000;
}
```

Another package:

```java id="n2x7vc"
package app;

import bank.Bank;

class Demo {

    public static void main(String[] args) {

        Bank b = new Bank();

        System.out.println(b.amount);
    }
}
```

Output:

```text id="y5q4jd"
10000
```

So `public` provides visibility **across packages**.

---

# 6. Public Class

A class itself can also be `public`.

```java id="2b7m9q"
public class Student {

}
```

A public class can be accessed from other packages.

One important Java rule:

> If a top-level class is declared `public`, its source file name must match the class name.

For example:

```java id="a1n8kf"
public class Student
```

should be in:

```text id="x9j2pd"
Student.java
```

---

# 7. Public Method

A method can be public:

```java id="3p4z6v"
public void display() {

    System.out.println("Hello");
}
```

Other accessible classes can call:

```java id="q2s8nw"
object.display();
```

---

# 8. Public Variable

A variable can also be public:

```java id="5d7w1m"
public int age = 25;
```

Another class can access it:

```java id="8f3k0a"
System.out.println(object.age);
```

However, in real-world object-oriented programming, directly exposing fields as `public` is generally discouraged when encapsulation is important. Private fields with controlled methods are often preferred.

---

# 🧠 Easy Real-Life Example

Imagine a **public notice board**:

```text id="0n7w4p"
Public Notice Board
        ↓
Anyone who has access to the building
        ↓
Can see the notice
```

Similarly:

```text id="8p5m2k"
public
  ↓
Maximum visibility
  ↓
Accessible from other classes/packages
```

---

# ⭐ Access Level Comparison

For visibility:

```text id="z8h4ka"
public     → Maximum
protected  → More restricted
default    → Package level
private    → Most restricted
```

So:

```text id="0g3x9q"
public
  ↑
  │ Maximum visibility
```

---

# 🔥 Remember Forever

### `public` means:

> **Maximum visibility.**

For a public member:

```text id="v1q9sm"
Same class       → ✅
Same package     → ✅
Different package → ✅
```

assuming the containing class and normal Java access requirements allow it.

### Interview Answer

> **`public` is an access specifier that provides the maximum visibility in Java. A public class/member can be accessed from other classes and, when the containing class is accessible, from different packages as well.**
