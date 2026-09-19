# 🧒`this()` Rules in Java

The `this()` keyword is used for **constructor chaining**.

> 🧠 **`this()` means: "Call another constructor of the same class."**

There are two important rules to remember.

---

## 1. `this()` Calls Another Constructor

Suppose we have:

```java
class Student {

    Student() {
        System.out.println("No-argument constructor");
    }

    Student(String name) {

        this();

        System.out.println("Name: " + name);
    }
}
```

When we create:

```java
Student s = new Student("Basha");
```

Java calls:

```text
Student(String)
      ↓
    this()
      ↓
Student()
```

So `this()` calls another constructor **within the same class**.

---

# 2. `this()` Must Be the First Statement

This is the most important rule. ⭐

### ✅ Correct

```java
Student(String name) {

    this();

    System.out.println("Name: " + name);
}
```

`this()` comes first.

---

### ❌ Incorrect

```java
Student(String name) {

    System.out.println("Name: " + name);

    this();
}
```

This produces a **compile-time error** because `this()` is not the first statement.

---

# 3. Why Must It Be First?

Think of it like this:

> "Before I do my own constructor work, I want another constructor to do its work."

So Java requires:

```text
this()
 ↓
Other constructor
 ↓
Come back
 ↓
Remaining statements
```

Not:

```text
My work
 ↓
this() ❌
```

---

# 4. Complete Example

```java
class Student {

    Student() {
        System.out.println("Constructor 1");
    }

    Student(String name) {

        this();

        System.out.println("Constructor 2");
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {

        Student s = new Student("Basha");
    }
}
```

### Output

```text
Constructor 1
Constructor 2
Name: Basha
```

---

# 🧠 Remember Forever

```text
this()
  ↓
Calls another constructor
  ↓
Same class
```

And:

```text
┌─────────────────────────┐
│ this() must be FIRST    │
│ statement in constructor│
└─────────────────────────┘
```

### ⭐ Golden Rule

> **`this()` → same-class constructor**

> **`this()` → must be the first statement**

### 🔥 Interview Answer

> **`this()` is used to call another constructor of the same class. It is used for local constructor chaining, and it must always be the first statement inside the constructor.**
