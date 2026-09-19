## 🧒 Parameterized Constructor

A **parameterized constructor** is a constructor that **accepts parameters** when an object is created.

Think of it like ordering a car with details:

> "Give me a car with **this brand, this color, and this price**."

---

# 1️⃣ Constructor With Parameters

Normal/no-argument constructor:

```java
Student() {
}
```

No input.

Parameterized constructor:

```java
Student(String name, int age) {
}
```

It accepts input:

```text
String name → parameter
int age     → parameter
```

---

# 2️⃣ Complete Program

```java
class Student {

    String name;
    int age;

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        Student s = new Student("Basha", 26);

        System.out.println("Name = " + s.name);
        System.out.println("Age = " + s.age);
    }
}
```

### Output

```text
Name = Basha
Age = 26
```

---

# 3️⃣ How It Works

When you write:

```java
Student s = new Student("Basha", 26);
```

the values:

```text
"Basha" → name
26      → age
```

are passed to the constructor.

Then:

```java
this.name = name;
this.age = age;
```

stores them in the object's instance variables.

```text
             new Student("Basha", 26)
                       ↓
                Constructor
                       ↓
             ┌─────────────────┐
             │ Student Object  │
             │                 │
             │ name = Basha    │
             │ age  = 26       │
             └─────────────────┘
```

---

# 4️⃣ Why Use a Parameterized Constructor?

It allows us to create objects with **different initial values**.

```java
Student s1 = new Student("Basha", 26);
Student s2 = new Student("Rahul", 24);
Student s3 = new Student("John", 22);
```

Now:

```text
s1 → name=Basha, age=26
s2 → name=Rahul, age=24
s3 → name=John,  age=22
```

Same class, but **different object states**.

---

# 🔑 Memory Trick

> **Parameterized Constructor = Constructor + Parameters + Object Initialization**

```text
Input values
     ↓
Constructor
     ↓
Instance variables
     ↓
Initialized object
```

### ⭐ Interview Answer

> **A parameterized constructor is a constructor that accepts one or more parameters and uses the supplied values to initialize the newly created object's instance variables.**
