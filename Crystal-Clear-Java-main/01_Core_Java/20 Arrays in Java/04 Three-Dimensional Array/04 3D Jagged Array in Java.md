## 🧒 3D Jagged Array in Java

A **jagged array** is an array where the inner arrays **do not have to be the same size**.

In a normal 3D array, you might have:

```text
2 Schools × 2 Classes × 3 Students
```

Every class has 3 students.

But in a **3D jagged array**, different schools/classes can have **different numbers of students**.

---

## 1️⃣ Normal 3D Array vs Jagged 3D Array

### Normal 3D array

```text
School 1
 ├── Class 1 → 3 students
 └── Class 2 → 3 students

School 2
 ├── Class 1 → 3 students
 └── Class 2 → 3 students
```

Every inner array has the same size.

### 3D Jagged Array

```text
School 1
 ├── Class 1 → 2 students
 └── Class 2 → 4 students

School 2
 ├── Class 1 → 3 students
 └── Class 2 → 1 student
```

Different classes can have different numbers of students. 😊

---

# 2️⃣ What Does "Jagged" Mean?

Think of a normal table:

```text
┌────┬────┬────┐
│    │    │    │
├────┼────┼────┤
│    │    │    │
├────┼────┼────┤
│    │    │    │
└────┴────┴────┘
```

Everything is equal.

A jagged structure looks more like:

```text
┌────┬────┐
│    │    │
└────┴────┘

┌────┬────┬────┬────┐
│    │    │    │    │
└────┴────┴────┴────┘

┌────┐
│    │
└────┘
```

The rows have **different lengths**.

---

# 3️⃣ 3D Jagged Array

A 3D jagged array can be thought of as:

```text
School
   ↓
Classes
   ↓
Students
```

But the number of students can vary:

```text
School 0
   ↓
 ┌───────────────┐
 │ Class 0 → 2   │
 │ Class 1 → 4   │
 └───────────────┘

School 1
   ↓
 ┌───────────────┐
 │ Class 0 → 3   │
 │ Class 1 → 1   │
 └───────────────┘
```

So there is **no single fixed student count** for every class.

---

# 4️⃣ Nested Array Creation

This is the important part.

We first create the outermost array:

```java
int[][][] arr = new int[2][][];
```

This means:

```text
2 schools
```

But we haven't yet decided the number of classes for each school.

---

## 5️⃣ Create Inner Arrays Separately

For School 1:

```java
arr[0] = new int[2][];
```

This means School 1 has:

```text
2 classes
```

For School 2:

```java
arr[1] = new int[2][];
```

This means School 2 also has:

```text
2 classes
```

Now we decide the number of students **separately for each class**.

```java
arr[0][0] = new int[2];
arr[0][1] = new int[4];

arr[1][0] = new int[3];
arr[1][1] = new int[1];
```

Now our structure is:

```text
School 0
 ├── Class 0 → 2 students
 └── Class 1 → 4 students

School 1
 ├── Class 0 → 3 students
 └── Class 1 → 1 student
```

That's a **3D jagged array**.

---

# 6️⃣ Complete Creation Program

```java
class Jagged3D {

    public static void main(String[] args) {

        // Create outer array
        int[][][] arr = new int[2][][];

        // Create classes for each school
        arr[0] = new int[2][];
        arr[1] = new int[2][];

        // Create different number of students
        arr[0][0] = new int[2];
        arr[0][1] = new int[4];

        arr[1][0] = new int[3];
        arr[1][1] = new int[1];

    }
}
```

---

# 7️⃣ Why Is It Called Nested Array Creation?

Because we create the arrays **level by level**.

```text
Step 1
   ↓
Create Schools
   ↓
int[][][] arr = new int[2][][];


Step 2
   ↓
Create Classes
   ↓
arr[0] = new int[2][];
arr[1] = new int[2][];


Step 3
   ↓
Create Students
   ↓
arr[0][0] = new int[2];
arr[0][1] = new int[4];
arr[1][0] = new int[3];
arr[1][1] = new int[1];
```

So:

> **Outer array → Inner array → Inner-most array**

---

# 8️⃣ Visualize the Structure

```text
arr
 │
 ├── School 0
 │    │
 │    ├── Class 0 → [ ][ ]
 │    │
 │    └── Class 1 → [ ][ ][ ][ ]
 │
 └── School 1
      │
      ├── Class 0 → [ ][ ][ ]
      │
      └── Class 1 → [ ]
```

Notice the different lengths:

```text
2 students
4 students
3 students
1 student
```

That's what makes it **jagged**.

---

# 9️⃣ Why Can't We Simply Write This?

```java
int[][][] arr = new int[2][2][];
```

Actually, **this is valid**.

It means:

```text
2 schools
   ↓
2 classes per school
   ↓
student count not fixed yet
```

Then:

```java
arr[0][0] = new int[2];
arr[0][1] = new int[4];

arr[1][0] = new int[3];
arr[1][1] = new int[1];
```

This is often a simpler way to create this particular jagged structure.

---

# 🧠 Easy Real-World Example

Imagine two schools.

### School 1

```text
Class A → 2 students
Class B → 4 students
```

### School 2

```text
Class A → 3 students
Class B → 1 student
```

There is no requirement that every class has the same number of students.

Therefore:

> ⭐ **Different inner-array sizes = Jagged Array**

---

# 🔑 Memory Trick

### Normal 3D array

```text
School → Class → Students
           ↓
     Same size everywhere
```

### 3D Jagged array

```text
School → Class → Students
           ↓
     Different sizes
```

Creation happens in levels:

```text
3D Jagged Array
      ↓
Create outer array
      ↓
Create class arrays
      ↓
Create student arrays
      ↓
Different sizes
```

### ⭐ Interview Answer

> **A three-dimensional jagged array in Java is a 3D array in which the inner arrays can have different lengths. It is created as nested arrays, allowing each school or class to contain a different number of elements.**
