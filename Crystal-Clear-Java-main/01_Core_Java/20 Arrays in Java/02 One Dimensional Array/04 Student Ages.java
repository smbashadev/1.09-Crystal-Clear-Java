## 🧒 One-Dimensional Integer Array — Student Ages

Suppose we have the ages of **5 students**:

```text
18, 19, 20, 18, 21
```

Instead of creating five separate variables, we can store all ages in **one integer array**.

---

### 1️⃣ Create the Integer Array

```java
int[] ages = new int[5];
```

This creates an array with **5 spaces**.

```text
Index:   0    1    2    3    4
        ┌────┬────┬────┬────┬────┐
ages →  │    │    │    │    │    │
        └────┴────┴────┴────┴────┘
```

---

### 2️⃣ Store the Values

```java
ages[0] = 18;
ages[1] = 19;
ages[2] = 20;
ages[3] = 18;
ages[4] = 21;
```

Now:

```text
Index:   0    1    2    3    4
        ┌────┬────┬────┬────┬────┐
ages →  │ 18 │ 19 │ 20 │ 18 │ 21 │
        └────┴────┴────┴────┴────┘
```

---

### 3️⃣ Print the Values

```java
System.out.println(ages[0]);
System.out.println(ages[1]);
System.out.println(ages[2]);
System.out.println(ages[3]);
System.out.println(ages[4]);
```

Output:

```text
18
19
20
18
21
```

---

## ✅ Complete Program

```java
class StudentAges {

    public static void main(String[] args) {

        // Array creation
        int[] ages = new int[5];

        // Store values
        ages[0] = 18;
        ages[1] = 19;
        ages[2] = 20;
        ages[3] = 18;
        ages[4] = 21;

        // Print values
        System.out.println(ages[0]);
        System.out.println(ages[1]);
        System.out.println(ages[2]);
        System.out.println(ages[3]);
        System.out.println(ages[4]);
    }
}
```

### ⭐ Easier Version

We can create and initialize the array in one line:

```java
int[] ages = {18, 19, 20, 18, 21};
```

Then print using a `for` loop:

```java
for (int i = 0; i < ages.length; i++) {
    System.out.println(ages[i]);
}
```

### 🧠 Remember

> **Integer array → stores multiple `int` values.**

```text
Create → Store → Print

int[] ages = new int[5];
       ↓
18  19  20  18  21
       ↓
   Print values
```

And the indexes are always:

```text
0 → 1 → 2 → 3 → 4
```

for an array containing 5 elements.
