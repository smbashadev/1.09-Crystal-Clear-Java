## 🧒 3D Array Scenario — Schools → Classes → Students

Let's imagine we have:

* 🏫 **2 schools**
* 📚 **2 classes in each school**
* 👨‍🎓 **3 students in each class**
* We want to **store and display student names**

This is a perfect example of a **3D array**.

---

## 1️⃣ Think of the Structure

Our structure is:

```text
School → Class → Student
```

So we need **3 indexes**:

```java
names[school][class][student]
```

For example:

```java
names[0][1][2]
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

# 2️⃣ Create the 3D Array

Because we have:

```text
2 schools
2 classes
3 students
```

we create:

```java
String[][][] names = new String[2][2][3];
```

Think of it as:

```text
2 × 2 × 3

School × Class × Student
```

Total spaces:

```text
2 × 2 × 3 = 12 students
```

---

# 3️⃣ Store Student Names

We can directly initialize the array:

```java
String[][][] names = {
    {
        {"Basha", "Rahul", "Priya"},
        {"John", "Anu", "Kiran"}
    },
    {
        {"Ravi", "Sita", "Arjun"},
        {"Neha", "Vijay", "Pooja"}
    }
};
```

Visual representation:

```text
🏫 School 0

Class 0 → Basha, Rahul, Priya
Class 1 → John, Anu, Kiran


🏫 School 1

Class 0 → Ravi, Sita, Arjun
Class 1 → Neha, Vijay, Pooja
```

---

# 4️⃣ Display All Names

We need **three nested loops**:

```java
for (int i = 0; i < names.length; i++) {

    for (int j = 0; j < names[i].length; j++) {

        for (int k = 0; k < names[i][j].length; k++) {

            System.out.println(names[i][j][k]);
        }
    }
}
```

Remember:

```text
Outer loop   → School
Middle loop  → Class
Inner loop   → Student
```

---

# 5️⃣ Complete Program

```java
class SchoolData {

    public static void main(String[] args) {

        String[][][] names = {
            {
                {"Basha", "Rahul", "Priya"},
                {"John", "Anu", "Kiran"}
            },
            {
                {"Ravi", "Sita", "Arjun"},
                {"Neha", "Vijay", "Pooja"}
            }
        };

        // Display student names
        for (int i = 0; i < names.length; i++) {

            System.out.println("School " + (i + 1));

            for (int j = 0; j < names[i].length; j++) {

                System.out.println("  Class " + (j + 1));

                for (int k = 0; k < names[i][j].length; k++) {

                    System.out.println(
                        "    Student " + (k + 1) + ": "
                        + names[i][j][k]
                    );
                }
            }
        }
    }
}
```

### Output

```text
School 1
  Class 1
    Student 1: Basha
    Student 2: Rahul
    Student 3: Priya
  Class 2
    Student 1: John
    Student 2: Anu
    Student 3: Kiran

School 2
  Class 1
    Student 1: Ravi
    Student 2: Sita
    Student 3: Arjun
  Class 2
    Student 1: Neha
    Student 2: Vijay
    Student 3: Pooja
```

---

# 6️⃣ Understanding the Indexes

Take:

```java
names[1][0][2]
```

Break it down:

```text
names[1]       → School 2
names[1][0]    → Class 1
names[1][0][2] → Student 3
```

So the result is:

```text
Arjun
```

Remember that **indexes start from 0**.

---

# 🧠 Easy Way to Remember

Think about a school hierarchy:

```text
🏫 School
   ↓
📚 Class
   ↓
👨‍🎓 Student
```

And in Java:

```text
names[i][j][k]
   ↓    ↓   ↓
School Class Student
```

The loops follow exactly the same hierarchy:

```java
for (school) {

    for (class) {

        for (student) {

            display name;

        }
    }
}
```

### 🔑 Final Memory Trick

> **3D Array = School → Class → Student**

> **3 indexes = `[school][class][student]`**

> **3 nested loops = School loop → Class loop → Student loop**

For this scenario:

**2 schools × 2 classes × 3 students = 12 student names.**
