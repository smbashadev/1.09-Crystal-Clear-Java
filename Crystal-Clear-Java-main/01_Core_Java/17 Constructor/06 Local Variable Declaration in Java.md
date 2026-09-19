## 🧒 Local Variable Declaration in Java

A **local variable** is a variable declared **inside a method, constructor, or block**.

The most important rule is:

> 🚨 **A local variable must be initialized before you use it.**

---

# 1️⃣ Local Variable

Example:

```java
class Student {

    void study() {
        int marks = 85;   // Local variable
        System.out.println(marks);
    }
}
```

Here:

```text
study() method
    │
    └── marks → Local variable
```

`marks` belongs only to that particular method execution.

It cannot be directly accessed outside `study()`.

---

# 2️⃣ Instance Variable

Compare it with an instance variable:

```java
class Student {

    int age;              // Instance variable

    void study() {
        int marks = 85;   // Local variable
    }
}
```

```text
Student Class
│
├── age
│   └── Instance variable
│
└── study()
    └── marks
        └── Local variable
```

### Main difference

| Instance Variable                                  | Local Variable                       |
| -------------------------------------------------- | ------------------------------------ |
| Inside class, outside methods/constructors/blocks  | Inside method, constructor, or block |
| Belongs to an object                               | Belongs to a method/block execution  |
| Gets default value                                 | Does **not** get default value       |
| Can be used after automatic default initialization | Must be initialized before use       |

---

# 3️⃣ Instance Variable Gets Default Value

```java
class Student {

    int age;

    public static void main(String[] args) {
        Student s = new Student();

        System.out.println(s.age);
    }
}
```

Output:

```text
0
```

Why?

Because `age` is an **instance variable**.

Java automatically gives it:

```text
int → 0
```

---

# 4️⃣ Local Variable Needs Initialization

Now look at this:

```java
class Student {

    public static void main(String[] args) {

        int age;

        System.out.println(age);
    }
}
```

❌ This gives a **compile-time error**.

Why?

Because:

```text
age
 ↓
Local variable
 ↓
No value assigned
 ↓
Trying to use it
 ↓
❌ Compile-time error
```

Java does not automatically assign `0` to a local variable.

---

# 5️⃣ Fix the Problem

Initialize it before using it:

```java
class Student {

    public static void main(String[] args) {

        int age;

        age = 26;

        System.out.println(age);
    }
}
```

Output:

```text
26
```

Or initialize it during declaration:

```java
int age = 26;
```

---

# 6️⃣ Why Does Java Require Initialization?

Imagine you have a box:

```text
┌─────────────┐
│     ?       │
└─────────────┘
```

You haven't put anything inside.

Then you ask:

> "What is inside the box?"

Java says:

> "You haven't given this local variable a value yet!" 😄

So Java prevents you from accidentally using an unknown value.

---

# 7️⃣ Constructor Example

This is especially important with constructors.

```java
class Student {

    String name;   // Instance variable
    int age;       // Instance variable

    Student() {

        int marks; // Local variable

        name = "Basha";
        age = 26;

        System.out.println(name);
        System.out.println(age);

        // System.out.println(marks); // ❌ Error
    }
}
```

Here:

```text
name → Instance variable → default value available
age  → Instance variable → default value available

marks → Local variable → must be initialized
```

If you want to use `marks`:

```java
int marks;
marks = 85;

System.out.println(marks);
```

Now it works.

---

# 8️⃣ Very Important: Declaration vs Initialization

These are two different things.

### Declaration

```java
int age;
```

You're telling Java:

> "I want a local variable named `age` of type `int`."

### Initialization

```java
age = 26;
```

You're giving it its first value.

Together:

```java
int age = 26;
```

means:

```text
Declaration + Initialization
```

---

# 🧠 Complete Picture

```text
                 VARIABLE
                    │
          ┌─────────┴─────────┐
          ↓                   ↓
   Instance Variable     Local Variable
          │                   │
          ↓                   ↓
   Gets default value    No default value
                              │
                              ↓
                    Must initialize
                       before use
```

### 🔑 Memory Trick

> **Instance variable → Java gives default value.**

> **Local variable → You must give the value before use.**

```text
Instance → Default
Local    → Initialize
```

### ⭐ Interview Answer

> **A local variable is declared inside a method, constructor, or block. Unlike instance variables, local variables do not receive default values automatically. They must be definitely assigned a value before they are read; otherwise, the compiler reports an error such as "variable might not have been initialized."**
