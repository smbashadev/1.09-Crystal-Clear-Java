## 🧒 3D Array with Loops and Scanner

Now let's make the **3D array dynamic**.

Instead of fixing:

* 2 schools
* 2 classes
* 3 students

we ask the **user** how many schools, classes, and students there are.

### Structure

```text
School
   ↓
 Class
   ↓
Student
   ↓
Name
```

So our array is:

```java
String[][][] names;
```

And we use **three nested loops**.

---

## 1️⃣ Complete Program

```java
import java.util.Scanner;

class SchoolData {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of schools
        System.out.print("Enter number of schools: ");
        int schools = sc.nextInt();

        // Number of classes
        System.out.print("Enter number of classes per school: ");
        int classes = sc.nextInt();

        // Number of students
        System.out.print("Enter number of students per class: ");
        int students = sc.nextInt();

        // Create 3D array
        String[][][] names = new String[schools][classes][students];

        // Input student names
        for (int i = 0; i < schools; i++) {

            System.out.println("School " + (i + 1));

            for (int j = 0; j < classes; j++) {

                System.out.println("  Class " + (j + 1));

                for (int k = 0; k < students; k++) {

                    System.out.print("    Enter student " + (k + 1) + " name: ");
                    names[i][j][k] = sc.next();
                }
            }
        }

        // Display student names
        System.out.println("\nStudent Names:");

        for (int i = 0; i < schools; i++) {

            System.out.println("School " + (i + 1));

            for (int j = 0; j < classes; j++) {

                System.out.println("  Class " + (j + 1));

                for (int k = 0; k < students; k++) {

                    System.out.println(
                        "    Student " + (k + 1) + ": "
                        + names[i][j][k]
                    );
                }
            }
        }

        sc.close();
    }
}
```

---

# 2️⃣ Sample Execution

Suppose the user enters:

```text
Enter number of schools: 2
Enter number of classes per school: 2
Enter number of students per class: 3
```

Then the program needs:

```text
2 schools
  ↓
2 classes each
  ↓
3 students each
```

So:

```text
2 × 2 × 3 = 12 names
```

The user enters:

```text
School 1
  Class 1
    Basha
    Rahul
    Priya

  Class 2
    John
    Anu
    Kiran

School 2
  Class 1
    Ravi
    Sita
    Arjun

  Class 2
    Neha
    Vijay
    Pooja
```

---

# 3️⃣ How the Array Looks

After storing the names:

```text
School 0
 ├── Class 0 → Basha, Rahul, Priya
 └── Class 1 → John, Anu, Kiran

School 1
 ├── Class 0 → Ravi, Sita, Arjun
 └── Class 1 → Neha, Vijay, Pooja
```

Remember:

```java
names[i][j][k]
```

means:

```text
   i       j        k
   ↓       ↓        ↓
School → Class → Student
```

---

# 4️⃣ Why Three Nested Loops?

Because we have **three dimensions**.

### Outer loop

```java
for (int i = 0; i < schools; i++)
```

Controls:

> 🏫 Schools

### Middle loop

```java
for (int j = 0; j < classes; j++)
```

Controls:

> 📚 Classes

### Inner loop

```java
for (int k = 0; k < students; k++)
```

Controls:

> 👨‍🎓 Students

So:

```text
Outer loop
    ↓
  School

    ↓
Middle loop
    ↓
  Class

    ↓
Inner loop
    ↓
  Student
```

---

# 5️⃣ Taking Input

This statement:

```java
names[i][j][k] = sc.next();
```

stores the student's name.

For example:

```java
names[0][0][0] = "Basha";
```

means:

```text
School 1
   ↓
Class 1
   ↓
Student 1
   ↓
Basha
```

Another:

```java
names[1][1][2] = "Pooja";
```

means:

```text
School 2
   ↓
Class 2
   ↓
Student 3
   ↓
Pooja
```

---

# 6️⃣ Displaying Names

We use the same three loops:

```java
for (int i = 0; i < schools; i++) {

    for (int j = 0; j < classes; j++) {

        for (int k = 0; k < students; k++) {

            System.out.println(names[i][j][k]);

        }
    }
}
```

This is called **3D array traversal**.

It visits every student:

```text
School 1
 → Class 1
   → Student 1
   → Student 2
   → Student 3
 → Class 2
   → Student 1
   → Student 2
   → Student 3

School 2
 → Class 1
   → Student 1
   → Student 2
   → Student 3
 → Class 2
   → Student 1
   → Student 2
   → Student 3
```

---

# 🧠 Complete Flow

```text
Scanner
   ↓
Number of Schools
   ↓
Number of Classes
   ↓
Number of Students
   ↓
Create 3D Array
   ↓
3 Nested Loops
   ↓
Input Names
   ↓
3 Nested Loops
   ↓
Display Names
```

## 🔑 Memory Trick

> **3D Array = School → Class → Student**

```java
String[][][] names;
```

> **3 indexes:**

```java
names[school][class][student]
```

> **3 nested loops:**

```text
Outer   → School
Middle  → Class
Inner   → Student
```

And the biggest idea:

> ⭐ **Scanner makes the number of schools, classes, and students decided by the user at runtime.**
