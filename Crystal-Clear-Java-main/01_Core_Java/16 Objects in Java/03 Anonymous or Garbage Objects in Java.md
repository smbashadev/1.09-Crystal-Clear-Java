## 🧒 Anonymous / Garbage Objects in Java

An **anonymous object** is an object that is created **without storing its reference in a reference variable**.

```text
Object created
     ↓
No reference variable
     ↓
Anonymous Object
```

---

# 1️⃣ Object Without Reference Variable

Normally, we create an object like this:

```java
Student s = new Student();
```

Here:

```text
s ─────────→ Student Object
             ↑
       Reference exists
```

But we can create an object without a reference variable:

```java
new Student();
```

Here:

```text
Student Object
      ↑
   no reference
```

This is called an **anonymous object**.

### Example

```java
class Student {
    void study() {
        System.out.println("Student is studying");
    }

    public static void main(String[] args) {
        new Student().study();
    }
}
```

The object is created and immediately used to call `study()`.

There is **no reference variable** such as `Student s`.

---

# 2️⃣ What Happens to an Anonymous Object?

Consider:

```java
new Student();
```

The object is created, but we don't keep its reference.

```text
new Student()
     ↓
 Student Object
     ↓
No reference
     ↓
Eventually eligible for Garbage Collection
```

If an object can no longer be reached through any live reference, it becomes **eligible for garbage collection**.

---

# 3️⃣ Garbage Object

A **garbage object** is an object that is **no longer reachable by the program**.

Example:

```java
Student s = new Student();

s = null;
```

Initially:

```text
s ─────→ Student Object
```

After:

```java
s = null;
```

we have:

```text
s ─────→ null

Student Object
      ↑
   no reference
```

The object is now **eligible for garbage collection**.

### Important:

It is better to say:

> **Eligible for garbage collection**

rather than:

> ❌ Garbage Collector immediately deletes it.

Java does **not guarantee exactly when** garbage collection will happen.

---

# 4️⃣ Garbage Collection

**Garbage Collection (GC)** is the JVM's automatic process of reclaiming memory occupied by objects that are no longer reachable.

Think of it like cleaning your room 🧹.

```text
Objects you still use
        ↓
      Keep

Objects nobody can reach
        ↓
      Garbage
        ↓
   GC can reclaim memory
```

---

# 5️⃣ Garbage Collector Thread

The **Garbage Collector** runs as part of the JVM's runtime and uses one or more JVM-managed threads to perform garbage collection.

Simple idea:

```text
JVM
 │
 ├── Your Java Program
 │
 └── Garbage Collector
          ↓
   Finds unreachable objects
          ↓
   Reclaims their memory
```

You don't normally have to manually free Java objects like you do with `free()` in C.

---

# 🧠 Anonymous Object vs Garbage Object

| Anonymous Object                     | Garbage Object                             |
| ------------------------------------ | ------------------------------------------ |
| Created without a reference variable | No longer reachable                        |
| Example: `new Student();`            | Example: object after `s = null`           |
| May still be immediately usable      | Cannot be normally accessed by the program |
| May become eligible for GC           | Eligible for GC if unreachable             |

⚠️ **Important:** An anonymous object is **not automatically garbage**. If it is used immediately, it can still be perfectly reachable during that expression.

---

# 🔑 Memory Trick

```text
Anonymous Object
      ↓
No reference variable
      ↓
Object may become unreachable
      ↓
Eligible for Garbage Collection
      ↓
GC may reclaim memory
```

### ⭐ Interview Answer

> **An anonymous object is an object created without assigning its reference to a reference variable. An object becomes eligible for garbage collection when it is no longer reachable from the program. The JVM's Garbage Collector automatically reclaims memory from eligible objects; the exact time of collection is not guaranteed.**
