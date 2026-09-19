# 🧒 OOP — Object-Oriented Programming

**OOP** stands for:

> **Object-Oriented Programming**

It is a **programming approach** where we design programs around **objects**, similar to things we see in the real world.

---

## 1️⃣ Object-Oriented Programming

Break the word into three parts:

```text
Object → Real-world thing
Oriented → Centered around
Programming → Writing programs
```

So:

> **Object-Oriented Programming means designing a program around objects and their behavior.**

---

# 2️⃣ Programming Approach

An **approach** means a **way of solving a problem**.

For example, if we need to create a student management system, we can think about:

```text
Student
Teacher
Course
College
Marks
```

Instead of thinking only about a long list of instructions, OOP encourages us to model these as **objects/classes** with data and behavior.

---

# 3️⃣ Solving Real-World Problems

Imagine a **banking application**.

In the real world, we have:

```text
Customer
Account
Bank
Transaction
```

In an OOP program, we can represent these concepts using classes and objects.

```text id="m8k2qa"
Real World                  Java Program

Customer       ───────→     Customer object
Bank Account   ───────→     Account object
Transaction    ───────→     Transaction object
```

Each object can have:

* **Data** → what it has
* **Behavior** → what it can do

---

# 4️⃣ Real-World Entity as a Programming Object

Consider a **Student** 👨‍🎓.

A real student has information:

```text
Name
Age
Roll Number
Marks
```

And can perform actions:

```text
Study
Attend class
Write exam
Display details
```

In Java, we can model this:

```java id="f7q3wm"
class Student {

    String name;
    int age;

    void study() {
        System.out.println("Student is studying");
    }

    void attendClass() {
        System.out.println("Student is attending class");
    }
}
```

Now create an object:

```java id="q2m8xk"
Student s = new Student();
```

Think:

```text id="n6c4zp"
        Student
          ↓
    ┌─────────────┐
    │ name        │
    │ age         │
    │ study()     │
    │ attendClass()│
    └─────────────┘
          ↑
       Object
```

---

# 🍜 Another Easy Example

Think about a **Maggi packet**.

Real-world object:

```text
Maggi
 ├── Brand
 ├── Price
 ├── Weight
 └── Flavor
```

Actions:

```text
Cook
Open
Eat
```

In OOP, we could represent the concept as an object containing **data and behavior**.

---

# 🧠 Core Idea of OOP

```text
Real-world entity
       ↓
     Model
       ↓
     Class
       ↓
    Object
       ↓
Data + Behavior
```

For example:

```text
Real World Student
       ↓
class Student
       ↓
Student s = new Student()
       ↓
Student Object
```

---

## 🔑 Memory Trick

> **OOP = Think about the real world → identify entities → represent them as objects → give them data and behavior.**

### ⭐ Interview Answer

> **OOP (Object-Oriented Programming) is a programming approach that models a software system using objects that represent real-world entities. Objects combine data and behavior, helping us organize and solve complex problems in a structured and reusable way.**
