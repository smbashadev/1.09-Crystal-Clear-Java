## 🧒 Non-Parameterized Constructor

A **non-parameterized constructor** is a constructor that **does not have any parameters**.

In simple words:

> **No input values are given to the constructor.**

---

# 1️⃣ Constructor Without Parameters

Look at this:

```java id="7m8q2c"
class Student {

    String name;
    int age;

    Student() {
        name = "Basha";
        age = 26;
    }
}
```

Here:

```text id="q4v8ka"
Student()
   ↑
No parameters
```

Therefore, it is a **non-parameterized constructor**.

---

# 2️⃣ Complete Program

```java id="k5n2xp"
class Student {

    String name;
    int age;

    // Non-parameterized constructor
    Student() {
        name = "Basha";
        age = 26;
    }

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println("Name = " + s.name);
        System.out.println("Age = " + s.age);
    }
}
```

### Output

```text id="w9c4mz"
Name = Basha
Age = 26
```

---

# 3️⃣ How It Works

When we write:

```java id="r6k3ya"
Student s = new Student();
```

Java creates the object and invokes:

```java id="b2q8vp"
Student()
```

The constructor then initializes:

```text id="z5m7xc"
name = "Basha"
age  = 26
```

So:

```text id="g4p9ka"
new Student()
      ↓
Student()
      ↓
No parameters
      ↓
Initialize object
      ↓
name = Basha
age = 26
```

---

# 4️⃣ Compare With Parameterized Constructor

### Non-Parameterized

```java id="p8c2mn"
Student() {
    name = "Basha";
    age = 26;
}
```

Object creation:

```java id="d7v5qx"
Student s = new Student();
```

**No values supplied.**

---

### Parameterized

```java id="h3k9wa"
Student(String name, int age) {
    this.name = name;
    this.age = age;
}
```

Object creation:

```java id="y6m2vp"
Student s = new Student("Basha", 26);
```

**Values supplied.**

---

# 🧠 Easy Analogy

Imagine ordering a student record.

### Non-parameterized

You say:

> "Create a student using the standard/default details."

```text id="q9x4mb"
new Student()
      ↓
Standard initialization
```

### Parameterized

You say:

> "Create a student with these specific details."

```text id="c7m5zn"
new Student("Basha", 26)
          ↓
     Specific values
```

---

# ⚠️ Small but Important Point

**Non-parameterized** simply means:

> The constructor has **zero parameters**.

It does **not necessarily mean** that the constructor must use Java's default values.

For example:

```java id="v2k8qa"
Student() {
    name = "Basha";
    age = 26;
}
```

is still non-parameterized even though it assigns specific values.

---

# 🔑 Memory Trick

```text id="f5n8kp"
Non-Parameterized
        ↓
     Student()
        ↓
   0 parameters
        ↓
new Student()
```

> **Non-Parameterized Constructor = Constructor without parameters.**

### ⭐ Interview Answer

> **A non-parameterized constructor is a constructor that does not accept any parameters. It can be used to initialize an object with predefined values or perform setup when the object is created.**
