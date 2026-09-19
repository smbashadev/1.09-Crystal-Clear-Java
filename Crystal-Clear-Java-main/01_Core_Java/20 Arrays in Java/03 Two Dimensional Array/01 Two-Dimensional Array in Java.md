## 🧒 Two-Dimensional Array in Java

A **Two-Dimensional Array (2D array)** is like a **table** or **matrix**.

It has:

* **Rows** → horizontal lines
* **Columns** → vertical positions
* **Elements** → values stored inside
* **Indexes** → positions of those values

Think of an Excel sheet:

```text
        Column
          ↓
       0   1   2
     ┌───┬───┬───┐
Row 0│10 │20 │30 │
     ├───┼───┼───┤
Row 1│40 │50 │60 │
     ├───┼───┼───┤
Row 2│70 │80 │90 │
     └───┴───┴───┘
```

---

# 1️⃣ Rows

A **row** is a horizontal collection of elements.

Example:

```text
10  20  30   ← Row 0

40  50  60   ← Row 1

70  80  90   ← Row 2
```

There are **3 rows**.

---

# 2️⃣ Columns

A **column** is a vertical collection of elements.

```text
10  20  30
40  50  60
70  80  90
↑   ↑   ↑
0   1   2
```

There are **3 columns**.

---

# 3️⃣ Creating a 2D Array

Syntax:

```java
int[][] numbers = new int[3][3];
```

This means:

```text
3 rows × 3 columns
```

Conceptually:

```text
        Col 0  Col 1  Col 2
       ┌──────┬──────┬──────┐
Row 0  │      │      │      │
       ├──────┼──────┼──────┤
Row 1  │      │      │      │
       ├──────┼──────┼──────┤
Row 2  │      │      │      │
       └──────┴──────┴──────┘
```

---

# 4️⃣ Why "Nested Arrays"?

Java's 2D arrays can be understood as an **array of arrays**.

That's why we write:

```java
int[][]
```

Think:

```text
2D Array
   ↓
Array of rows
   ↓
Each row is another array
```

Conceptually:

```text
numbers
   ↓
┌──────────────┐
│ Row 0 → [10,20,30]
│ Row 1 → [40,50,60]
│ Row 2 → [70,80,90]
└──────────────┘
```

This is why Java's 2D arrays are often described as **nested arrays**.

---

# 5️⃣ Assigning Values

```java
int[][] numbers = new int[3][3];

numbers[0][0] = 10;
numbers[0][1] = 20;
numbers[0][2] = 30;

numbers[1][0] = 40;
numbers[1][1] = 50;
numbers[1][2] = 60;

numbers[2][0] = 70;
numbers[2][1] = 80;
numbers[2][2] = 90;
```

Now:

```text
       Col 0  Col 1  Col 2
       ┌─────┬─────┬─────┐
Row 0  │ 10  │ 20  │ 30  │
       ├─────┼─────┼─────┤
Row 1  │ 40  │ 50  │ 60  │
       ├─────┼─────┼─────┤
Row 2  │ 70  │ 80  │ 90  │
       └─────┴─────┴─────┘
```

Notice the two indexes:

```java
numbers[1][2]
```

means:

```text
[1] → Row 1
[2] → Column 2
```

So the answer is:

```text
60
```

---

# 6️⃣ Traversal of a 2D Array

**Traversal** means:

> 🔍 Visiting every element one by one.

Because there are **rows and columns**, we normally use **nested loops**.

```java
for (int i = 0; i < numbers.length; i++) {

    for (int j = 0; j < numbers[i].length; j++) {

        System.out.print(numbers[i][j] + " ");
    }

    System.out.println();
}
```

Here:

```text
Outer loop → Rows
Inner loop → Columns
```

---

# 7️⃣ Complete Program

```java
class TwoDArray {

    public static void main(String[] args) {

        int[][] numbers = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        // Traversal
        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }

            System.out.println();
        }
    }
}
```

### Output

```text
10 20 30
40 50 60
70 80 90
```

---

# 8️⃣ How Traversal Works

The outer loop selects a row:

```text
i = 0 → Row 0
i = 1 → Row 1
i = 2 → Row 2
```

The inner loop moves through the columns.

For row 0:

```text
numbers[0][0] → 10
numbers[0][1] → 20
numbers[0][2] → 30
```

Then row 1:

```text
numbers[1][0] → 40
numbers[1][1] → 50
numbers[1][2] → 60
```

Then row 2:

```text
numbers[2][0] → 70
numbers[2][1] → 80
numbers[2][2] → 90
```

---

# 🧠 Easy Real-World Analogy

Think of a **classroom**.

```text
        Seats
       0   1   2
     ┌───┬───┬───┐
Row 0│ A │ B │ C │
     ├───┼───┼───┤
Row 1│ D │ E │ F │
     ├───┼───┼───┤
Row 2│ G │ H │ I │
     └───┴───┴───┘
```

The teacher checks:

```text
Row 0 → A → B → C
Row 1 → D → E → F
Row 2 → G → H → I
```

That's **2D array traversal**.

---

# 🔑 Memory Trick

Remember:

```text
2D Array
   ↓
Rows + Columns
   ↓
Array of Arrays
   ↓
Nested Loops
   ↓
Traversal
```

### Most important rule:

> **Outer loop → Rows**

> **Inner loop → Columns**

```text
for (rows) {
    for (columns) {
        access element;
    }
}
```

### ⭐ Interview Answer

> **A two-dimensional array in Java is an array of arrays used to represent data in rows and columns. Elements are accessed using two indexes: one for the row and one for the column. Nested loops are commonly used to traverse all elements of a 2D array.**
