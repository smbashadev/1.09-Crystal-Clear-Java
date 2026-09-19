# 🧒 Default Constructor in Java

A **default constructor** is related to what happens when you **do not write any constructor** in your class.

The easiest rule to remember is:

> 🧠 **If you don't write any constructor, the Java compiler automatically provides a default constructor.**

---

# 1. No Constructor Defined

Suppose we write:

```java
class Student {

    int age;
    String name;
}
```

Look carefully.

We did **not** write any constructor.

There is no:

```java
Student() {
}
```

But Java still allows us to create an object:

```java
Student s = new Student();
```

Why?

Because the compiler automatically provides a **default constructor**.

Conceptually, the compiler provides something like:

```java
Student() {
}
```

So you can think:

```text
No constructor written
        ↓
Compiler provides default constructor
        ↓
new Student()
        ↓
Object created
```

---

# 2. What Does the Default Constructor Look Like?

Suppose you write:

```java
class Student {

    int age;
}
```

The compiler conceptually provides:

```java
class Student {

    int age;

    Student() {
    }
}
```

You didn't write the constructor.

The **compiler supplies it**.

---

# 3. Simple Program

```java
class Student {

    int age;
    String name;
}

class Demo {

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s.age);
        System.out.println(s.name);
    }
}
```

Output:

```text
0
null
```

Why?

Because the instance variables receive their normal default values:

```text
int     → 0
String  → null
```

The important point here is that:

```java
new Student();
```

can work even though we didn't write a constructor.

The compiler supplied the default constructor.

---

# 4. Programmer-Defined Constructor

Now let's write our own constructor:

```java
class Student {

    int age;

    Student() {

        System.out.println("Constructor executed");
    }
}
```

Now we have explicitly defined:

```java
Student()
```

So the compiler **does not additionally provide its automatic default constructor**.

When we write:

```java
Student s = new Student();
```

our constructor executes:

```text
Constructor executed
```

---

# 5. Very Important Rule ⭐

Remember this:

```text
No constructor written
        ↓
Compiler provides default constructor
        ↓
new Student() works
```

But:

```text
Constructor written by programmer
        ↓
Compiler does NOT provide the automatic default constructor
        ↓
Programmer's constructor is used
```

---

# 6. Example of the Difference

### Case 1 — No Constructor

```java
class Demo {

    int x;
}
```

Compiler conceptually provides:

```java
Demo() {
}
```

Therefore:

```java
Demo d = new Demo();
```

✅ Works.

---

### Case 2 — Programmer Defines Parameterized Constructor

```java
class Demo {

    int x;

    Demo(int x) {
        this.x = x;
    }
}
```

Now try:

```java
Demo d = new Demo();
```

❌ Compile-time error.

Why?

Because there is no:

```java
Demo()
```

constructor.

We only have:

```java
Demo(int x)
```

---

# 7. How to Fix It?

If we want both:

```java
new Demo()
```

and:

```java
new Demo(10)
```

we must explicitly provide both constructors:

```java
class Demo {

    int x;

    Demo() {
        System.out.println("No-argument constructor");
    }

    Demo(int x) {
        this.x = x;
        System.out.println("Parameterized constructor");
    }
}
```

Now both work:

```java
Demo d1 = new Demo();

Demo d2 = new Demo(10);
```

---

# 🧠 8. The Biggest Confusion

Don't confuse these two terms:

### Compiler-provided default constructor

```java
class Demo {
}
```

You don't write any constructor.

The compiler provides the no-argument constructor.

### Programmer-defined no-argument constructor

```java
class Demo {

    Demo() {
    }
}
```

Here **you** wrote the constructor.

It is a **no-argument constructor**, but it is programmer-defined.

So:

> **Every default constructor is a no-argument constructor, but not every no-argument constructor is the compiler-provided default constructor.**

---

# 📊 9. Difference

| Situation                         | Constructor                                                |
| --------------------------------- | ---------------------------------------------------------- |
| No constructor written            | Compiler provides default constructor                      |
| Programmer writes `Demo()`        | Programmer-defined no-argument constructor                 |
| Programmer writes `Demo(int x)`   | Parameterized constructor                                  |
| Programmer writes any constructor | Compiler doesn't automatically add the default constructor |

---

# ⭐ Golden Rule

### Remember these 3 lines:

```text
No constructor defined
        ↓
Compiler provides default constructor
```

```text
Programmer-defined constructor
        ↓
Automatic default constructor is not provided
```

```text
Need both?
        ↓
Define both explicitly
```

### 🔥 Interview Answer

> **If a class does not contain any constructor, the Java compiler provides a default constructor automatically. If the programmer defines any constructor, the compiler does not provide the automatic default constructor.**
