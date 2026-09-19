## 🧒 `else-if` Ladder in Java

An **`else-if` ladder** is used when we have **multiple conditions** and want Java to choose **one matching block**.

Think of it like checking marks from top to bottom:

```text
Marks?
  ↓
90–100 → Laptop
  ↓ no
80–89  → Smart Phone
  ↓ no
70–79  → Smart Watch
  ↓ no
60–69  → Bicycle
  ↓ no
Otherwise → Get Lost 😄
```

---

# 1️⃣ Why Do We Need `else-if`?

Suppose a student gets marks.

We want:

|    Marks | Prize          |
| -------: | -------------- |
|   90–100 | Laptop 💻      |
|    80–89 | Smart Phone 📱 |
|    70–79 | Smart Watch ⌚  |
|    60–69 | Bicycle 🚲     |
| Below 60 | Get Lost 😄    |

There are **multiple conditions**, so `else-if` is useful.

---

# 2️⃣ Basic Syntax

```java id="0c5d01"
if (condition1) {
    // code
}
else if (condition2) {
    // code
}
else if (condition3) {
    // code
}
else {
    // code
}
```

Java checks the conditions **from top to bottom**.

As soon as one condition is `true`, its block executes and the remaining ladder is skipped.

---

# 3️⃣ Complete Program

```java id="n0s8kg"
import java.util.Scanner;

class Prize {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your marks: ");
        int marks = sc.nextInt();

        if (marks >= 90 && marks <= 100) {
            System.out.println("You won a Laptop");
        }
        else if (marks >= 80 && marks < 90) {
            System.out.println("You won a Smart Phone");
        }
        else if (marks >= 70 && marks < 80) {
            System.out.println("You won a Smart Watch");
        }
        else if (marks >= 60 && marks < 70) {
            System.out.println("You won a Bicycle");
        }
        else {
            System.out.println("Get Lost!");
        }

        sc.close();
    }
}
```

---

# 4️⃣ Example: Marks = 95

Input:

```text id="9n0p0h"
Enter your marks: 95
```

Java checks:

```text id="0v7l1a"
95 >= 90 && 95 <= 100
          ↓
        TRUE
          ↓
      Laptop 💻
```

Output:

```text id="7m9g4r"
You won a Laptop
```

Java **doesn't check the remaining `else-if`s**.

---

# 5️⃣ Example: Marks = 85

```text id="4p5qk7"
95? → No

80–89?
   ↓
  YES
   ↓
Smart Phone 📱
```

Output:

```text id="3j8y1p"
You won a Smart Phone
```

---

# 6️⃣ Example: Marks = 75

```text id="1s7k5n"
90–100? → No
80–89?  → No
70–79?  → YES
             ↓
        Smart Watch ⌚
```

Output:

```text id="w0s3z8"
You won a Smart Watch
```

---

# 7️⃣ Example: Marks = 65

```text id="9r2v6m"
90–100? → No
80–89?  → No
70–79?  → No
60–69?  → YES
             ↓
          Bicycle 🚲
```

Output:

```text id="k5d1x4"
You won a Bicycle
```

---

# 8️⃣ Example: Marks = 50

None of the conditions are true:

```text id="8q4n2p"
90–100? → ❌
80–89?  → ❌
70–79?  → ❌
60–69?  → ❌
             ↓
          else
             ↓
       Get Lost! 😄
```

Output:

```text id="e6y3m9"
Get Lost!
```

---

# 9️⃣ Why Use `&&`?

For the first condition:

```java id="4w7x2m"
marks >= 90 && marks <= 100
```

`&&` means **AND**.

Both conditions must be true.

For example, marks = 95:

```text id="a1p8cq"
95 >= 90 → true
95 <= 100 → true

true && true
     ↓
   true
```

So Laptop is awarded.

---

# 🔟 Important Boundary Point

Your notes say:

```text
90–100 → Laptop
80–90  → Smart Phone
70–80  → Smart Watch
60–70  → Bicycle
```

Be careful with boundaries such as **90, 80, 70, and 60**.

A cleaner programming version is:

```text
90–100 → Laptop
80–89  → Smart Phone
70–79  → Smart Watch
60–69  → Bicycle
0–59   → Get Lost
```

Or, because the conditions are checked from top to bottom, we can simplify:

```java id="7w2m1c"
if (marks >= 90 && marks <= 100) {
    System.out.println("Laptop");
}
else if (marks >= 80) {
    System.out.println("Smart Phone");
}
else if (marks >= 70) {
    System.out.println("Smart Watch");
}
else if (marks >= 60) {
    System.out.println("Bicycle");
}
else {
    System.out.println("Get Lost!");
}
```

Here, if marks are `85`, Java already knows the `90` condition failed, so checking `marks >= 80` is enough.

---

# 🧠 Flow Diagram

```text id="1m8c6z"
             marks
               ↓
       ┌────────────────┐
       │ marks >= 90?   │
       └───────┬────────┘
          YES  │  NO
           ↓  │
       Laptop │
              ↓
       ┌────────────────┐
       │ marks >= 80?   │
       └───────┬────────┘
          YES  │  NO
           ↓  │
     Smart Phone
              ↓
       ┌────────────────┐
       │ marks >= 70?   │
       └───────┬────────┘
          YES  │  NO
           ↓  │
     Smart Watch
              ↓
       ┌────────────────┐
       │ marks >= 60?   │
       └───────┬────────┘
          YES  │  NO
           ↓  │
        Bicycle
              ↓
         Get Lost!
```

---

# 🔑 Memory Trick

> **`else-if` = Check multiple conditions one by one.**

Remember:

```text id="3k9v2x"
IF
 ↓
Check 1
 ↓ NO
ELSE IF
 ↓
Check 2
 ↓ NO
ELSE IF
 ↓
Check 3
 ↓ NO
ELSE
 ↓
Otherwise
```

### ⭐ Interview Answer

> **An `else-if` ladder is a decision-making structure used to check multiple conditions sequentially. Java evaluates the conditions from top to bottom and executes the first block whose condition is true. If none of the conditions is true, the final `else` block executes.**
