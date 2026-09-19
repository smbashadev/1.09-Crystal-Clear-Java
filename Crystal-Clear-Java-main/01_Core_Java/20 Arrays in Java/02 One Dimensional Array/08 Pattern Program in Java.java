## 🧒 Pattern Program in Java ⭐

A **pattern program** means using Java to print symbols, numbers, or characters in a particular **shape or arrangement**.

For example:

```text
*
**
***
****
*****
```

To create patterns like this, we commonly use **nested loops**.

---

# 1️⃣ What Is a Nested Loop?

A **nested loop** means:

> 🔁 **One loop inside another loop.**

Example:

```java
for (...) {

    for (...) {
        // task
    }

}
```

Think of it like:

* **Outer loop** → controls the **rows**
* **Inner loop** → controls what happens **inside each row**

---

# 2️⃣ Simple Pattern

Let's print:

```text
*
**
***
****
*****
```

There are **5 rows**.

```text
Row 1 → *
Row 2 → **
Row 3 → ***
Row 4 → ****
Row 5 → *****
```

The number of stars increases by one in every row.

---

# 3️⃣ Complete Program

```java
class Pattern {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
```

### Output

```text
*
**
***
****
*****
```

---

# 4️⃣ Understanding the Outer Loop

```java
for (int i = 1; i <= 5; i++)
```

The outer loop controls the **rows**.

```text
i = 1 → Row 1
i = 2 → Row 2
i = 3 → Row 3
i = 4 → Row 4
i = 5 → Row 5
```

So:

> **Outer loop = number of rows**

---

# 5️⃣ Understanding the Inner Loop

```java
for (int j = 1; j <= i; j++)
```

The inner loop controls the **number of stars in each row**.

For:

```text
i = 1 → 1 star
i = 2 → 2 stars
i = 3 → 3 stars
i = 4 → 4 stars
i = 5 → 5 stars
```

So:

> **Inner loop = number of items printed in each row**

---

# 6️⃣ How the Loops Work Together

For row 1:

```text
i = 1
 ↓
j = 1
 ↓
*
```

For row 2:

```text
i = 2
 ↓
j = 1 → *
j = 2 → *
 ↓
**
```

For row 3:

```text
i = 3
 ↓
j = 1 → *
j = 2 → *
j = 3 → *
 ↓
***
```

And so on.

---

# 7️⃣ Why `print()` and `println()`?

### `System.out.print("*")`

Keeps printing on the **same line**.

```text
***
```

### `System.out.println()`

Moves to the **next line**.

That's why we write:

```java
System.out.println();
```

after the inner loop finishes.

```text
Inner loop
   ↓
Print stars in one row
   ↓
println()
   ↓
Go to next row
```

---

# 8️⃣ Another Example — Square Pattern

If we want:

```text
*****
*****
*****
*****
*****
```

Both loops can run 5 times:

```java
class Pattern {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 5; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
```

Output:

```text
*****
*****
*****
*****
*****
```

Here:

```text
Outer loop → 5 rows
Inner loop → 5 stars per row
```

---

# 🧠 Real-World Analogy

Imagine a classroom with **5 rows**, and each row has some chairs.

```text
Row 1 → ⭐
Row 2 → ⭐⭐
Row 3 → ⭐⭐⭐
Row 4 → ⭐⭐⭐⭐
Row 5 → ⭐⭐⭐⭐⭐
```

The **outer loop** moves from row to row.

The **inner loop** places items inside each row.

```text
Outer loop
    ↓
 Row 1 → Inner loop
    ↓
 Row 2 → Inner loop
    ↓
 Row 3 → Inner loop
    ↓
 ...
```

---

# 🔑 Memory Trick

For pattern programs:

> ⭐ **Outer loop → Rows**

> ⭐ **Inner loop → Columns/items**

```text
        Outer Loop
             ↓
          ROW 1
       ↙  ↙  ↙
    Inner Loop
       ↓
    * * * *

             ↓
          ROW 2
       ↙  ↙  ↙
    Inner Loop
       ↓
    * * * *
```

### ⭐ Interview Answer

> **A pattern program prints characters, numbers, or symbols in a specific arrangement. Nested loops are commonly used, where the outer loop controls the rows and the inner loop controls the elements printed within each row.**
