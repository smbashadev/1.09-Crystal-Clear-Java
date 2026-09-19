## 🧒 Constructor Output in One Line

Here, the idea is:

> **Use the constructor to initialize the object, then print all the object's data in one `println()` statement.**

---

# 1️⃣ Constructor Initialization

Suppose we have a `Student` class:

```java id="p7k2qm"
class Student {

    String name;
    int age;
    double marks;

    Student() {
        name = "Basha";
        age = 26;
        marks = 85.5;
    }
}
```

When we create:

```java id="z4m8vx"
Student s = new Student();
```

the constructor runs:

```text id="r8c3yn"
new Student()
      ↓
Student() constructor
      ↓
name  = "Basha"
age   = 26
marks = 85.5
```

---

# 2️⃣ One-Line Output

Now we can print all the data using **one `println()`**:

```java id="x6q9wa"
System.out.println(s.name + " " + s.age + " " + s.marks);
```

Output:

```text id="q2m7kc"
Basha 26 85.5
```

Only **one `println()` statement** is used.

---

# 3️⃣ Complete Program

```java id="j4n8vp"
class Student {

    String name;
    int age;
    double marks;

    // Constructor
    Student() {
        name = "Basha";
        age = 26;
        marks = 85.5;
    }

    public static void main(String[] args) {

        Student s = new Student();

        // One-line output
        System.out.println(s.name + " " + s.age + " " + s.marks);
    }
}
```

### Output

```text id="f8k3zm"
Basha 26 85.5
```

---

# 🧠 How Java Understands It

This:

```java id="c9v5rx"
s.name + " " + s.age + " " + s.marks
```

means:

```text id="d2q7mb"
s.name
  ↓
Basha

" "
  ↓
space

s.age
  ↓
26

" "
  ↓
space

s.marks
  ↓
85.5
```

Java combines them:

```text id="y6m4qa"
"Basha" + " " + 26 + " " + 85.5
                ↓
        "Basha 26 85.5"
```

Then `println()` prints that complete String.

---

# ⭐ With Labels

You can also make the one-line output easier to understand:

```java id="n7x2kp"
System.out.println("Name = " + s.name +
                   ", Age = " + s.age +
                   ", Marks = " + s.marks);
```

Output:

```text id="v3m8qa"
Name = Basha, Age = 26, Marks = 85.5
```

Still just **one `println()` statement**.

---

# 🔑 Memory Trick

```text id="c4y9wp"
Object Creation
      ↓
Constructor
      ↓
Initialization
      ↓
s.name, s.age, s.marks
      ↓
One println()
      ↓
One-line Output
```

> **Constructor initializes → reference accesses → `println()` prints.**
