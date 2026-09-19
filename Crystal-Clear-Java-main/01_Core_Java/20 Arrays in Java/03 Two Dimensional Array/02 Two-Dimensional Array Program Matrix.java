## 🧒 Two-Dimensional Array Program — Matrix

A **matrix** is simply a collection of values arranged in **rows and columns**.

For example, a **2 × 3 matrix** has:

* 2 rows
* 3 columns
* 6 elements

```text
        Columns
          ↓
       0   1   2
     ┌───┬───┬───┐
Row 0│10 │20 │30 │
     ├───┼───┼───┤
Row 1│40 │50 │60 │
     └───┴───┴───┘
```

We can use **Scanner** to allow the user to enter all the matrix elements.

---

# 1️⃣ Complete Program

```java
import java.util.Scanner;

class Matrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get rows and columns
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();

        // Create 2D array
        int[][] matrix = new int[rows][columns];

        // Take user input
        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                matrix[i][j] = sc.nextInt();
            }
        }

        // Print matrix
        System.out.println("Matrix:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
```

---

# 2️⃣ Sample Execution

### Input

```text
Enter number of rows: 2
Enter number of columns: 3
Enter matrix elements:
10
20
30
40
50
60
```

The values are stored like this:

```text
       Column
       0   1   2
     ┌───┬───┬───┐
Row 0│10 │20 │30 │
     ├───┼───┼───┤
Row 1│40 │50 │60 │
     └───┴───┴───┘
```

### Output

```text
Matrix:
10 20 30
40 50 60
```

---

# 3️⃣ Why Do We Need Nested Loops?

A 2D array has **two dimensions**:

```text
Rows
 ↓
Columns
```

So we use two loops.

### Outer loop

```java
for (int i = 0; i < rows; i++)
```

Controls the **rows**.

### Inner loop

```java
for (int j = 0; j < columns; j++)
```

Controls the **columns**.

So:

```text
Outer loop
     ↓
   Row 0
     ↓
Inner loop → 10 20 30

Outer loop
     ↓
   Row 1
     ↓
Inner loop → 40 50 60
```

---

# 4️⃣ Understanding `matrix[i][j]`

This is the most important part:

```java
matrix[i][j]
```

Here:

```text
i → row index
j → column index
```

For example:

```java
matrix[0][1]
```

means:

```text
Row 0
Column 1
   ↓
  20
```

And:

```java
matrix[1][2]
```

means:

```text
Row 1
Column 2
   ↓
  60
```

---

# 5️⃣ Input Process

This code:

```java
for (int i = 0; i < rows; i++) {

    for (int j = 0; j < columns; j++) {

        matrix[i][j] = sc.nextInt();
    }
}
```

takes input **row by row**.

For a 2 × 3 matrix:

```text
i = 0
 ├── j = 0 → matrix[0][0]
 ├── j = 1 → matrix[0][1]
 └── j = 2 → matrix[0][2]

i = 1
 ├── j = 0 → matrix[1][0]
 ├── j = 1 → matrix[1][1]
 └── j = 2 → matrix[1][2]
```

---

# 6️⃣ Printing Process

The same nested-loop concept is used for printing:

```java
for (int i = 0; i < rows; i++) {

    for (int j = 0; j < columns; j++) {

        System.out.print(matrix[i][j] + " ");
    }

    System.out.println();
}
```

`print()` keeps values on the same row.

```java
System.out.println();
```

moves to the next row.

---

# 🧠 Complete Flow

```text
Scanner
   ↓
Ask rows
   ↓
Ask columns
   ↓
Create 2D array
   ↓
Nested loops
   ↓
Take user input
   ↓
Store matrix elements
   ↓
Nested loops
   ↓
Print matrix
```

---

# 🔑 Memory Trick

For a **2D matrix**:

> **Outer loop → Rows**

> **Inner loop → Columns**

> **`matrix[i][j]` → row + column**

```text
for (rows) {
    
    for (columns) {
        input / print element;
    }
    
}
```

### ⭐ Interview Answer

> **A matrix can be represented using a two-dimensional array in Java. We use `Scanner` to take the number of rows, columns, and elements from the user. Nested loops are used to input and traverse the matrix, where the outer loop handles rows and the inner loop handles columns.**
