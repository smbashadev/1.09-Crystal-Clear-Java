## 🧒 One-Dimensional Array

A **one-dimensional (1D) array** is like a **single row of boxes**.

Each box stores one value, and every box has an **index**.

For example, we want to store the names of 5 students:

```text
Index:    0        1        2        3        4
       ┌──────┬──────┬──────┬──────┬──────┐
       │ Basha│ Rahul│ Priya│ John │ Anu  │
       └──────┴──────┴──────┴──────┴──────┘
```

---

# 1️⃣ String Array

Because student names are text, we use a `String` array:

```java
String[] students;
```

This means:

> "I want a variable that can refer to an array of `String` values."

---

# 2️⃣ Array Declaration

```java
String[] students;
```

Here:

```text
String → type of elements
[]     → array
students → array reference variable
```

So we are **declaring** an array variable.

At this point, we haven't created the array object yet.

---

# 3️⃣ Array Creation

Use the `new` keyword:

```java
students = new String[5];
```

This creates an array capable of storing **5 String elements**.

Conceptually:

```text
students
   ↓
┌────────┬────────┬────────┬────────┬────────┐
│ null   │ null   │ null   │ null   │ null   │
└────────┴────────┴────────┴────────┴────────┘
    0        1        2        3        4
```

Because `String` is a reference type, the default value of each element is `null`.

---

# 4️⃣ Array Assignment

Now we put student names into the array:

```java
students[0] = "Basha";
students[1] = "Rahul";
students[2] = "Priya";
students[3] = "John";
students[4] = "Anu";
```

Now:

```text
Index:       0        1       2       3      4
          ┌──────┬───────┬───────┬──────┬─────┐
students  │Basha │ Rahul │ Priya │ John │ Anu │
          └──────┴───────┴───────┴──────┴─────┘
```

---

# 5️⃣ Array Access

To get a particular value, use its index.

```java
System.out.println(students[0]);
```

Output:

```text
Basha
```

Another example:

```java
System.out.println(students[3]);
```

Output:

```text
John
```

Remember:

```text
students[0] → Basha
students[1] → Rahul
students[2] → Priya
students[3] → John
students[4] → Anu
```

---

# 6️⃣ Complete Program

```java
class StudentArray {

    public static void main(String[] args) {

        // Array declaration
        String[] students;

        // Array creation
        students = new String[5];

        // Array assignment
        students[0] = "Basha";
        students[1] = "Rahul";
        students[2] = "Priya";
        students[3] = "John";
        students[4] = "Anu";

        // Array access
        System.out.println(students[0]);
        System.out.println(students[1]);
        System.out.println(students[2]);
        System.out.println(students[3]);
        System.out.println(students[4]);
    }
}
```

### Output

```text
Basha
Rahul
Priya
John
Anu
```

---

# 7️⃣ Four Important Steps

Your notes can be remembered as:

```text
1. Declaration
       ↓
String[] students;

2. Creation
       ↓
students = new String[5];

3. Assignment
       ↓
students[0] = "Basha";

4. Access
       ↓
System.out.println(students[0]);
```

---

# 🧠 Real-World Analogy

Imagine **5 seats in a row**:

```text
Seat:      0       1       2       3       4
         ┌─────┬─────┬─────┬─────┬─────┐
         │     │     │     │     │     │
         └─────┴─────┴─────┴─────┴─────┘
```

You create 5 seats:

```java
new String[5]
```

Then assign students:

```text
0 → Basha
1 → Rahul
2 → Priya
3 → John
4 → Anu
```

To find Priya:

```java
students[2]
```

---

# 🔑 Memory Trick

> **Declare → Create → Assign → Access**

```text
String[] students;
        ↓
students = new String[5];
        ↓
students[0] = "Basha";
        ↓
students[0]
```

And remember:

> ⭐ **1D array = one row of elements.**

> ⭐ **Index starts at 0.**

> ⭐ **For 5 elements, indexes are 0 to 4.**
