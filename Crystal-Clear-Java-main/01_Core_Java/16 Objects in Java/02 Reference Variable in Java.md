# 🧒 Reference Variable in Java

A **reference variable** is a variable that **refers to an object**.

Your notes say:

> **Stores object address**

For beginner understanding, that's okay, but technically Java uses a **reference**, not a directly accessible memory address/pointer.

### Simple idea:

```text id="d8k4qa"
Reference Variable
       ↓
   Refers to
       ↓
     Object
```

---

# 1️⃣ Example

```java id="w5m8px"
class Student {
    String name;
    int age;
}
```

Create an object:

```java id="p2q7nz"
Student s = new Student();
```

Here:

```text id="7x3mqa"
Student s
    ↓
Reference variable
```

and:

```text id="n9k4vz"
new Student()
    ↓
Object
```

Conceptually:

```text id="c6m2wp"
       s
       │
       │ reference
       ↓
┌───────────────┐
│ Student Object│
│ name          │
│ age           │
└───────────────┘
```

---

# 2️⃣ Same Type as Object

Usually, the reference variable's declared type is the **same class type** as the object:

```java id="r8v3km"
Student s = new Student();
```

Here:

```text id="q4m7xp"
Student → type
s       → reference variable
Student → object/class used for creation
```

So:

```text id="p5n9ka"
Student s = new Student();
```

means:

> `s` can refer to a `Student` object.

---

# 3️⃣ Access the Object

The reference variable lets us **access the object's members**.

For example:

```java id="x7k3mz"
class Student {
    String name;

    void study() {
        System.out.println("Studying");
    }
}
```

Create object:

```java id="m4q8vp"
Student s = new Student();
```

Set state:

```java id="z2n6ka"
s.name = "Basha";
```

Call behavior:

```java id="h8p3qx"
s.study();
```

The `.` operator is used to access the object's members through the reference.

```text id="w9m4kc"
       s
       ↓
Student Object
   ↓         ↓
 name      study()
   ↓         ↓
"Basha"   execute
```

---

# 🧠 Real-World Analogy

Imagine a **house** 🏠.

```text
House = Object
House address = Reference
```

The address helps you **locate/access the house**, but the address is not the house itself.

Similarly:

```text id="q6x2mv"
Reference variable
       ↓
   refers to
       ↓
     Object
```

---

# ⚠️ Important Correction

Don't say:

> ❌ "A Java reference variable stores the actual memory address."

Better interview wording:

> ✅ **"A reference variable holds a reference to an object."**

Java does not expose raw memory addresses like C/C++ pointers.

---

# 🔑 Memory Trick

```text id="k3p8qa"
Student s = new Student();
   │             │
   │             └── Object
   │
   └── Reference variable
```

Remember:

> **Reference variable → refers to object → used to access object members.**

### ⭐ Interview Answer

> **A reference variable is a variable that holds a reference to an object. It is used to access the object's instance variables and methods. For example, in `Student s = new Student();`, `s` is a reference variable referring to the newly created `Student` object.**
