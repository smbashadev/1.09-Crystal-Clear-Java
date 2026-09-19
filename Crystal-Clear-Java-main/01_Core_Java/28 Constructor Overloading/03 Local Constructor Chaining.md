# 🧒 Local Constructor Chaining

**Local Constructor Chaining** means:

> 🧠 **One constructor calls another constructor inside the same class.**

The keyword used for this is:

```java
this();
```

So remember:

```text
Same Class
    ↓
Constructor
    ↓
calls another constructor
    ↓
this()
```

---

# 1. What Does `this()` Mean?

`this()` means:

> **"Call another constructor of the same class."**

For example:

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

Here:

```java
this();
```

inside:

```java
Student(String name)
```

calls:

```java
Student()
```

Both constructors belong to the **same class**.

---

# 2. Simple Flow

Look at this:

```text
Student(String name)
        ↓
      this()
        ↓
Student()
```

So the constructor is calling another constructor.

That's why it is called **constructor chaining**.

And because both constructors are in the **same class**, it is called:

> **Local Constructor Chaining**

---

# 3. Complete Program

```java
class Student {

    Student() {

        System.out.println("Student constructor");
    }

    Student(String name) {

        this();

        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {

        Student s = new Student("Basha");
    }
}
```

### Output

```text
Student constructor
Name: Basha
```

---

# 4. What Happened Step by Step?

We created:

```java
Student s = new Student("Basha");
```

Java chooses:

```java
Student(String name)
```

Then it sees:

```java
this();
```

So it calls:

```java
Student()
```

First:

```text
Student constructor
```

Then control comes back to:

```java
System.out.println("Name: " + name);
```

So:

```text
1️⃣ Student()
2️⃣ Student(String name)
```

---

# 5. Why Use `this()`?

Suppose both constructors need to perform some common work.

Without `this()`:

```java
class Student {

    Student() {
        System.out.println("Student object created");
    }

    Student(String name) {
        System.out.println("Student object created");
        System.out.println("Name: " + name);
    }
}
```

We repeated:

```text
Student object created
```

❌ Duplicate code.

With `this()`:

```java
class Student {

    Student() {
        System.out.println("Student object created");
    }

    Student(String name) {

        this();

        System.out.println("Name: " + name);
    }
}
```

Now the common code exists in only one constructor.

✅ **Code reusability**

---

# 6. Constructor Chaining with 3 Constructors

We can create a chain involving multiple constructors.

```java
class Student {

    Student() {

        System.out.println("0 parameter constructor");
    }

    Student(String name) {

        this();

        System.out.println("1 parameter constructor");
        System.out.println("Name: " + name);
    }

    Student(String name, int age) {

        this(name);

        System.out.println("2 parameter constructor");
        System.out.println("Age: " + age);
    }
}
```

Now:

```java
Student s = new Student("Basha", 26);
```

The flow is:

```text
Student(String, int)
        ↓
   this(name)
        ↓
Student(String)
        ↓
      this()
        ↓
Student()
```

Execution happens:

```text
0 parameter constructor
1 parameter constructor
Name: Basha
2 parameter constructor
Age: 26
```

---

# 7. Important Rule: `this()` Must Be First

If you use `this()`, it must be the **first statement** in the constructor.

✅ Correct:

```java
Student(String name) {

    this();

    System.out.println(name);
}
```

❌ Incorrect:

```java
Student(String name) {

    System.out.println(name);

    this();
}
```

The second version causes a **compile-time error**.

---

# 8. `this()` vs `super()`

This is very important for interviews.

### `this()`

Calls another constructor in the **same class**.

```text
Same class
    ↓
this()
```

### `super()`

Calls the constructor of the **immediate parent class**.

```text
Child
  ↓
super()
  ↓
Parent
```

### Easy comparison

| Keyword   | Calls               | Relationship |
| --------- | ------------------- | ------------ |
| `this()`  | Another constructor | Same class   |
| `super()` | Parent constructor  | Parent-child |

---

# ⭐ Remember Forever

```text
             Student
          /           \
   Student()       Student(String)
                       │
                     this()
                       ↓
                  Student()
```

### 🧠 Golden Rule

> **`this()` = call another constructor of the same class.**

### One-line formula:

```text
Constructor
     +
this()
     ↓
Another constructor
of the SAME class
```

### 🔥 Interview Answer

> **Local constructor chaining is the process of calling one constructor from another constructor within the same class. It is achieved using `this()`. The `this()` constructor invocation must be the first statement of the constructor.**
