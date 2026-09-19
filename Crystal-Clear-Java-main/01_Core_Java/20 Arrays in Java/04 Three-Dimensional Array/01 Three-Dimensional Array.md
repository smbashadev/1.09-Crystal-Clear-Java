## 🧒 Three-Dimensional Array

A **three-dimensional (3D) array** is like adding **one more level** to a 2D array.

Think about a school system:

```text
School → Classes → Students
```

These are our **three dimensions**.

---

## 1️⃣ Real-World Example

Imagine we have:

* **2 schools**
* Each school has **3 classes**
* Each class has **4 students**

We can represent this using a 3D array.

```text
3D Array
   ↓
Schools
   ↓
Classes
   ↓
Students
```

So:

```text
School → Class → Student
```

---

## 2️⃣ Why Three Dimensions?

A normal array has one dimension:

```text
Students
↓
[ A, B, C, D ]
```

A 2D array has two dimensions:

```text
Classes
   ↓
Students

[ A B C ]
[ D E F ]
```

A 3D array has three dimensions:

```text
Schools
   ↓
Classes
   ↓
Students
```

Think of it like **multiple tables stacked together**.

```text
School 0
┌──────────────┐
│ Class 0      │
│ Class 1      │
│ Class 2      │
└──────────────┘

School 1
┌──────────────┐
│ Class 0      │
│ Class 1      │
│ Class 2      │
└──────────────┘
```

---

# 3️⃣ Creating a 3D Array

Syntax:

```java
int[][][] students = new int[2][3][4];
```

This means:

```text
2 → Schools
3 → Classes in each school
4 → Students in each class
```

So:

```text
2 × 3 × 4 = 24 elements
```

---

# 4️⃣ Three Indexes

A 3D array needs **three indexes**:

```java
students[school][class][student]
```

For example:

```java
students[0][1][2]
```

means:

```text
School 0
   ↓
Class 1
   ↓
Student 2
```

---

# 5️⃣ Three Nested Loops

Because we have three dimensions, we commonly use **three nested loops**.

```java
for (int i = 0; i < students.length; i++) {

    for (int j = 0; j < students[i].length; j++) {

        for (int k = 0; k < students[i][j].length; k++) {

            System.out.println(students[i][j][k]);
        }
    }
}
```

Think:

```text
Outer loop
    ↓
Schools

Middle loop
    ↓
Classes

Inner loop
    ↓
Students
```

---

# 🧠 Easy Real-World Analogy

Think of a **school building**.

```text
School
  ↓
Classrooms
  ↓
Students
```

If there are multiple schools:

```text
School 0
 ├── Class 0
 │    ├── Student 0
 │    ├── Student 1
 │    └── Student 2
 │
 └── Class 1
      ├── Student 0
      ├── Student 1
      └── Student 2


School 1
 ├── Class 0
 │    ├── Student 0
 │    ├── Student 1
 │    └── Student 2
 │
 └── Class 1
      ├── Student 0
      ├── Student 1
      └── Student 2
```

That's the basic idea of a **3D array**.

---

# 🔑 Memory Trick

Remember:

```text
1D → Students
      ↓
   [Student]

2D → Classes → Students
      ↓
   [Students]
   [Students]

3D → Schools → Classes → Students
      ↓
   [ [Students] ]
   [ [Students] ]
```

### ⭐ Most Important

> **3D array = array of 2D arrays.**

> **Three dimensions → three indexes.**

> **Three dimensions are commonly traversed using three nested loops.**

```text
School
   ↓
Class
   ↓
Student
```

So for your example:

**Schools → Classes → Students = Three Dimensions.**
