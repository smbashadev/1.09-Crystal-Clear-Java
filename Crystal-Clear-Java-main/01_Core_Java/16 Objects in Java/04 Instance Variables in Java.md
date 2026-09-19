## 🧒 Instance Variables in Java

**Instance variables** are variables declared **inside a class but outside methods, constructors, and blocks**. They represent the **state of an object**.

```java
class Student {
    String name;   // Instance variable
    int age;       // Instance variable
}
```

Think of them as **information stored inside each object**.

---

# 1️⃣ What is an Instance Variable?

Look at this:

```java
class Student {
    String name;
    int age;
}
```

Here:

```text
Student class
│
├── name  → Instance variable
└── age   → Instance variable
```

When objects are created:

```java
Student s1 = new Student();
Student s2 = new Student();
```

Each object has its **own instance variables**.

```text
s1 → Student Object
     name
     age

s2 → Student Object
     name
     age
```

So `s1` and `s2` can have different values.

---

# 2️⃣ Default Values

One important feature of instance variables:

> **Java automatically gives instance variables default values when an object is created.**

You don't have to initialize them yourself.

Example:

```java
class Student {
    String name;
    int age;
    double marks;
    boolean passed;
    
    public static void main(String[] args) {
        Student s = new Student();

        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.marks);
        System.out.println(s.passed);
    }
}
```

Output:

```text
null
0
0.0
false
```

---

# 3️⃣ Default Value Depends on Data Type

Different data types get different default values.

| Data Type       | Default Value |
| --------------- | ------------- |
| `byte`          | `0`           |
| `short`         | `0`           |
| `int`           | `0`           |
| `long`          | `0L`          |
| `float`         | `0.0f`        |
| `double`        | `0.0d`        |
| `char`          | `'\u0000'`    |
| `boolean`       | `false`       |
| Reference types | `null`        |

### Easy examples

```java
class Demo {
    int age;          // 0
    double salary;    // 0.0
    boolean active;   // false
    char grade;       // '\u0000'
    String name;      // null
}
```

---

# 4️⃣ Why Does Java Give Default Values?

Think of creating a new **Student object**.

```java
Student s = new Student();
```

Java creates the object and initializes its instance fields with default values.

```text
new Student()
      ↓
Student Object
      ↓
┌─────────────────┐
│ name  = null     │
│ age   = 0        │
│ marks = 0.0      │
│ passed = false   │
└─────────────────┘
```

Later, you can assign actual values:

```java
s.name = "Basha";
s.age = 26;
s.marks = 85.5;
s.passed = true;
```

Now:

```text
┌─────────────────┐
│ name   = Basha   │
│ age    = 26      │
│ marks  = 85.5    │
│ passed = true     │
└─────────────────┘
```

---

# ⚠️ Important: Instance Variable vs Local Variable

Don't confuse this:

```java
class Demo {
    int age;  // Instance variable

    void show() {
        int marks;  // Local variable
    }
}
```

`age` gets a default value automatically.

But `marks` **does not** get a default value because it is a local variable.

```java
int marks;
System.out.println(marks); // ❌ Compile-time error
```

So remember:

```text
Instance Variable → Gets default value
Local Variable    → Must be initialized before use
```

---

# 🔑 Memory Trick

> **Instance Variable = Class + Outside Method + Object State + Default Value**

And:

> **Default value depends on the data type.**

```text
int      → 0
double   → 0.0
boolean  → false
char     → '\u0000'
Object   → null
```

### ⭐ Interview Answer

> **An instance variable is a variable declared inside a class but outside methods, constructors, and blocks. Each object generally has its own copy of instance variables, and Java automatically assigns default values to them based on their data types.**
