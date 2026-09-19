## 🧒 One-Dimensional Array with Loops and Scanner

Here we combine **three things**:

* `Scanner` → gets input from the user
* Array → stores the values
* `for` loop → visits and prints every element

The useful part is that the **array size can be decided at runtime** based on user input.

---

## 1️⃣ Real-World Idea

Suppose we don't know how many student ages the user wants to enter.

The user says:

```text
How many students? 5
```

Java creates an array with 5 positions:

```text
Index:   0    1    2    3    4
        ┌────┬────┬────┬────┬────┐
        │    │    │    │    │    │
        └────┴────┴────┴────┴────┘
```

Then the user enters:

```text
18
19
20
18
21
```

The array stores them.

---

# 2️⃣ Complete Program

```java
import java.util.Scanner;

class StudentAges {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get array size from user
        System.out.print("Enter number of students: ");
        int size = sc.nextInt();

        // Create array
        int[] ages = new int[size];

        // Input elements
        System.out.println("Enter student ages:");

        for (int i = 0; i < ages.length; i++) {
            ages[i] = sc.nextInt();
        }

        // Print elements
        System.out.println("Student ages are:");

        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }

        sc.close();
    }
}
```

---

# 3️⃣ Example Execution

### Input

```text
Enter number of students: 5
Enter student ages:
18
19
20
18
21
```

### Output

```text
Student ages are:
18
19
20
18
21
```

---

# 4️⃣ How the Program Works

### Step 1 — Create `Scanner`

```java
Scanner sc = new Scanner(System.in);
```

`Scanner` allows us to **take input from the keyboard**.

---

### Step 2 — Get Array Size

```java
int size = sc.nextInt();
```

Suppose the user enters:

```text
5
```

Now:

```text
size = 5
```

---

### Step 3 — Create Array

```java
int[] ages = new int[size];
```

Since `size` is `5`:

```text
int[] ages = new int[5];
```

The array has 5 positions:

```text
Index:   0    1    2    3    4
        ┌────┬────┬────┬────┬────┐
ages →  │    │    │    │    │    │
        └────┴────┴────┴────┴────┘
```

---

# 5️⃣ Input Elements Using `for`

```java
for (int i = 0; i < ages.length; i++) {
    ages[i] = sc.nextInt();
}
```

Suppose the user enters:

```text
18
19
20
18
21
```

Java stores them:

```text
ages[0] = 18
ages[1] = 19
ages[2] = 20
ages[3] = 18
ages[4] = 21
```

---

# 6️⃣ What Is Array Traversal?

**Traversal** means:

> **Visiting each element of the array one by one.**

We use another `for` loop:

```java
for (int i = 0; i < ages.length; i++) {
    System.out.println(ages[i]);
}
```

The loop visits:

```text
ages[0] → 18
ages[1] → 19
ages[2] → 20
ages[3] → 18
ages[4] → 21
```

This is called **array traversal**.

---

# 7️⃣ Why `ages.length`?

```java
ages.length
```

gives the **number of elements/positions in the array**.

If:

```java
int[] ages = new int[5];
```

then:

```text
ages.length = 5
```

The indexes are:

```text
0  1  2  3  4
```

So we use:

```java
i < ages.length
```

not:

```java
i <= ages.length
```

because `ages[5]` does **not** exist.

---

# 🧠 Complete Flow

```text
Scanner
   ↓
Ask array size
   ↓
User enters 5
   ↓
Create int[5]
   ↓
for loop
   ↓
Input 5 elements
   ↓
Array stores elements
   ↓
for loop
   ↓
Traverse array
   ↓
Print elements
```

---

## 🔑 Remember

> **Scanner → Input → Array → Store → Loop → Traverse → Print**

And the four important pieces are:

```text
Scanner
  ↓
Gets input

Array
  ↓
Stores elements

for loop
  ↓
Repeats the operation

Traversal
  ↓
Visits every element
```

### ⭐ Interview Answer

> **An array with `Scanner` and loops allows us to take the array size and elements from the user at runtime. A `for` loop can be used to input each element and another `for` loop can traverse the array and print each element.**
