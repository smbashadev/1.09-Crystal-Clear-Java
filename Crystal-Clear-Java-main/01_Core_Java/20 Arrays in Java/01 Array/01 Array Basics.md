## 🧒 Arrays in Java — Array Basics

An **array** is a way to store **many values of the same data type** in a single object.

Instead of creating many separate variables:

```java
int mark1 = 80;
int mark2 = 90;
int mark3 = 75;
int mark4 = 88;
int mark5 = 95;
```

we can use one array:

```java
int[] marks = {80, 90, 75, 88, 95};
```

Much easier! 😊

---

# 1️⃣ Array = Data Structure

An **array is a data structure**.

A data structure is simply:

> **A way of organizing and storing data so that we can work with it easily.**

For example:

```text
Marks
 ↓
┌────┬────┬────┬────┬────┐
│ 80 │ 90 │ 75 │ 88 │ 95 │
└────┴────┴────┴────┴────┘
```

All the values are stored together as one array.

---

# 2️⃣ Large Number of Homogeneous Data

**Homogeneous** means:

> **Same type.**

For example, this is valid:

```java
int[] marks = {80, 90, 75, 88, 95};
```

All elements are `int`.

```text
int
 ↓
80
90
75
88
95
```

But you cannot normally put unrelated primitive types into an `int[]`:

```java
int[] marks = {80, 90, 75.5};  // ❌
```

because `75.5` is a `double`.

---

# 3️⃣ Array Is an Object ⭐

This is very important in Java.

An array is treated as an **object**.

When you create:

```java
int[] marks = new int[5];
```

Java creates an array object.

Conceptually:

```text
marks
  ↓
┌──────────────────────┐
│   Array Object       │
│                      │
│  0   0   0   0   0   │
└──────────────────────┘
```

The variable `marks` holds a **reference to the array object**.

---

# 4️⃣ Array Uses Heap Memory

Array objects are allocated in the **heap**.

For example:

```java
int[] marks = new int[5];
```

Conceptually:

```text
Stack                     Heap
─────                     ────

marks ───────────────→  Array Object
                        ┌─────────────┐
                        │ 0  0  0  0  0│
                        └─────────────┘
```

The exact physical placement is JVM-implementation-dependent, but for learning Java memory, think:

> **Array object → Heap**

---

# 5️⃣ Elements

The individual values inside an array are called **elements**.

Example:

```java
int[] marks = {80, 90, 75, 88, 95};
```

Here:

```text
80 → Element
90 → Element
75 → Element
88 → Element
95 → Element
```

---

# 6️⃣ Index

An **index** tells Java the position of an element.

The most important rule:

> ⭐ **Array indexing starts from `0`.**

For:

```java
int[] marks = {80, 90, 75, 88, 95};
```

the positions are:

```text
Index:     0    1    2    3    4
           ↓    ↓    ↓    ↓    ↓
Value:    80   90   75   88   95
```

So:

```java
marks[0] → 80
marks[1] → 90
marks[2] → 75
marks[3] → 88
marks[4] → 95
```

---

# 7️⃣ Why Does Index Start at 0?

Think of the index as the **distance from the beginning**.

The first element is at distance `0`.

```text
Beginning
   ↓
┌────┬────┬────┬────┬────┐
│ 80 │ 90 │ 75 │ 88 │ 95 │
└────┴────┴────┴────┴────┘
  ↑
 index 0
```

Then:

```text
80 → index 0
90 → index 1
75 → index 2
88 → index 3
95 → index 4
```

---

# 8️⃣ Accessing an Element

Use:

```java
arrayName[index]
```

Example:

```java
int[] marks = {80, 90, 75, 88, 95};

System.out.println(marks[0]);
System.out.println(marks[3]);
```

Output:

```text
80
88
```

Because:

```text
marks[0] → 80
marks[3] → 88
```

---

# 9️⃣ Complete Example

```java
class Demo {

    public static void main(String[] args) {

        int[] marks = {80, 90, 75, 88, 95};

        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);
        System.out.println(marks[3]);
        System.out.println(marks[4]);
    }
}
```

Output:

```text
80
90
75
88
95
```

---

# 🔟 Array Size

If an array contains 5 elements:

```java
int[] marks = {80, 90, 75, 88, 95};
```

then:

```text
Size = 5
```

But the last index is:

```text
Size - 1
  ↓
5 - 1
  ↓
4
```

Therefore:

> **Last index = array length − 1**

```text
Size = 5
First index = 0
Last index = 4
```

---

# 🧠 Easy Real-World Analogy

Imagine a row of lockers. 🔐

```text
Locker
┌────┬────┬────┬────┬────┐
│ 80 │ 90 │ 75 │ 88 │ 95 │
└────┴────┴────┴────┴────┘
  0    1    2    3    4
```

Each locker has:

* a **position** → index
* a **value** → element

If you say:

> "Give me the value at position 2."

Java gives:

```java
marks[2]
```

Result:

```text
75
```

---

# 🔑 Memory Trick

Remember these five points:

```text
ARRAY
  ↓
Data Structure
  ↓
Same-type elements
  ↓
Array is an Object
  ↓
Object → Heap
  ↓
Index starts at 0
```

And:

> **First index = 0**

> **Last index = size − 1**

> **`array[index]` = access an element**

### ⭐ Interview Answer

> **An array in Java is an object and a data structure used to store multiple elements of the same type. The array object is generally allocated in heap memory, and its elements are accessed using indexes. Array indexing starts from 0, so for an array of size `n`, the valid indexes are `0` through `n-1`.**
