# 🧒 Non-Primitive Data Types in Java

### 🔹 What are Non-Primitive Data Types?

**Non-primitive data types are types that refer to objects or other data structures rather than directly representing a simple value like `int` or `boolean`.**

They are commonly called **reference types** in Java.

Think of it like this:

```text
Primitive → 📦 contains a simple value
Reference → 🏷️ contains a reference to an object
```

---

# 1️⃣ Reference Types

Examples of reference types include:

```text
Class
Array
String
Enum
Interface
```

When you create an object, a variable of reference type can hold a **reference to that object**.

Example:

```java
String name = "Basha";
```

Think:

```text
name
 ↓
reference
 ↓
" Basha " object
```

---

# 2️⃣ Address / Reference

Your notes say:

> **Address/reference**

For beginner understanding, you can think of a reference as something that **points to or identifies where an object is located in memory**.

Example:

```java
Student s = new Student();
```

Conceptually:

```text
        s
        ↓
   reference
        ↓
┌─────────────────┐
│ Student object  │
│                 │
└─────────────────┘
```

### ⚠️ Important

In Java, it's better to say **reference** rather than **memory address**.

Java does **not** give programmers direct access to object memory addresses like C/C++ pointers.

So:

> ❌ Java reference = raw memory address

is not technically correct.

Better:

> ✅ A reference variable refers to an object managed by the JVM.

---

# 3️⃣ Memory Location

When an object is created:

```java
Student s = new Student();
```

the JVM allocates memory for the object.

Conceptually:

```text
RAM
┌──────────────────────┐
│ Student Object       │
│ name = "Basha"       │
│ age = 26             │
└──────────────────────┘
          ↑
          │
       reference
          │
          s
```

The variable `s` lets your program access that object.

---

# 4️⃣ Classes

A **class** is a blueprint for creating objects.

Example:

```java
class Student {
    String name;
    int age;
}
```

Create an object:

```java
Student s = new Student();
```

Conceptually:

```text
Student class
     ↓
   new
     ↓
Student object
```

Here:

```text
Student → reference type
s       → reference variable
```

---

# 5️⃣ Arrays

An **array** stores multiple values of the same type.

Example:

```java
int[] numbers = {10, 20, 30};
```

Conceptually:

```text
numbers
   ↓
┌────┬────┬────┐
│ 10 │ 20 │ 30 │
└────┴────┴────┘
```

`numbers` is a **reference variable** referring to the array object.

So:

```text
int → primitive
int[] → reference type
```

---

# 6️⃣ Enum

An **enum** is used when you have a fixed set of named values.

Example:

```java
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY
}
```

You can use it:

```java
Day today = Day.MONDAY;
```

Here:

```text
Day → enum type
today → reference variable
Day.MONDAY → enum constant
```

Enums are **reference types** in Java.

---

# 7️⃣ String

`String` is used to represent text.

Example:

```java
String name = "Basha";
```

Unlike `int` or `boolean`, `String` is **not a primitive data type**.

It is a **class/reference type**.

```text
String
   ↓
object
   ↓
"Basha"
```

That's why:

```java
String name = "Basha";
```

uses a reference-type variable.

---

# 🧒 Real-Life Analogy

Imagine a library.

### Primitive

You have a small card containing the actual information:

```text
📦 age → 26
```

### Reference type

You have a library card that tells you **which book/object to access**:

```text
🏷️ student
     ↓
📚 Student object
```

The reference helps you access the object.

---

# 📊 Primitive vs Non-Primitive

| Feature             | Primitive                        | Non-Primitive / Reference             |
| ------------------- | -------------------------------- | ------------------------------------- |
| Stores              | Simple value                     | Reference to an object/data structure |
| Examples            | `int`, `byte`, `char`, `boolean` | `String`, arrays, classes, enums      |
| Object?             | Not an object                    | Usually refers to an object           |
| Can be `null`?      | ❌                                | ✅                                     |
| User-defined types? | ❌                                | ✅ Classes/enums can be user-defined   |
| Memory model        | Value directly represented       | Variable holds a reference            |

### ⭐ `null` Example

Reference variables can contain `null`:

```java
String name = null;
```

This means:

> `name` currently doesn't refer to a String object.

But:

```java
int age = null;  // ❌
```

is not allowed because `int` is primitive.

---

# 🔄 Simple Diagram

```text
           Java Data Types
                 │
        ┌────────┴────────┐
        ↓                 ↓
   Primitive         Reference Types
        │                 │
        ↓                 ├── Classes
   int, byte,            ├── Arrays
   short, long,          ├── String
   float, double,        └── Enum
   char, boolean
```

---

## 🎯 Interview Answer

> **Non-primitive data types in Java are reference types that allow variables to refer to objects or data structures. Examples include classes, arrays, strings, and enums. A reference variable does not provide direct access to a raw memory address; instead, it refers to an object managed by the JVM.**

### 🧠 Easy Memory Trick

> **Primitive = simple value** 📦
> **Reference = refers to an object** 🏷️

```text
int x = 10;
     ↓
  simple value

String s = "Java";
       ↓
   reference
       ↓
    object
```

**Remember:**

> **Classes + Arrays + Strings + Enums → Reference Types**
