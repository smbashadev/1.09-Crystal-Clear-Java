## 🧒 Constructor Programs in Java

Let's understand the four things one by one:

1. **Normal / No-Argument Constructor**
2. **Parameterized Constructor**
3. **Constructor Initialization**
4. **Printing Object Data**

We'll use a simple `Student` example throughout.

---

# 1️⃣ Normal Constructor

A **normal constructor** here means a **no-argument constructor**—a constructor that doesn't receive parameters.

```java
Student() {
    // initialization
}
```

### Complete Program

```java
class Student {

    String name;
    int age;

    // No-argument constructor
    Student() {
        System.out.println("Constructor called");
    }

    public static void main(String[] args) {

        Student s = new Student();
    }
}
```

### Output

```text
Constructor called
```

### What happened?

```text
Student s = new Student();
              ↓
       Object is created
              ↓
      Student() runs
              ↓
   "Constructor called"
```

The constructor is automatically invoked when `new Student()` executes.

### 🔑 Remember

> **No-argument constructor = constructor with zero parameters.**

---

# 2️⃣ Parameterized Constructor

A **parameterized constructor** is a constructor that receives values through parameters.

Example:

```java
Student(String name, int age)
```

Here:

```text
String name → parameter
int age     → parameter
```

### Complete Program

```java
class Student {

    String name;
    int age;

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        Student s = new Student("Basha", 26);

        System.out.println(s.name);
        System.out.println(s.age);
    }
}
```

### Output

```text
Basha
26
```

### How it works

When we write:

```java
Student s = new Student("Basha", 26);
```

the values go into the constructor:

```text
"Basha" ─────→ name
26 ──────────→ age
```

Then:

```java
this.name = name;
this.age = age;
```

stores those values in the object's instance variables.

---

# 3️⃣ Constructor Initialization

**Initialization** means giving initial values to the object's instance variables.

Without initialization:

```java
class Student {
    String name;
    int age;
}
```

A newly created object initially has:

```text
name = null
age  = 0
```

We can initialize them using a constructor.

### Complete Program

```java
class Student {

    String name;
    int age;
    double marks;

    // Constructor initialization
    Student() {
        name = "Basha";
        age = 26;
        marks = 85.5;
    }

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println("Name = " + s.name);
        System.out.println("Age = " + s.age);
        System.out.println("Marks = " + s.marks);
    }
}
```

### Output

```text
Name = Basha
Age = 26
Marks = 85.5
```

### What happened?

```text
new Student()
      ↓
Student() constructor
      ↓
name = "Basha"
age = 26
marks = 85.5
      ↓
Initialized object
```

So:

> **Constructor initialization = assigning initial values to an object's instance variables when the object is created.**

---

# 4️⃣ Printing Object Data

After creating and initializing an object, we can access its instance variables through the reference variable and print them.

Example:

```java
System.out.println(s.name);
```

Here:

```text
s       → reference variable
.       → access operator
name    → instance variable
```

### Complete Program

```java
class Student {

    String name;
    int age;
    double marks;

    Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public static void main(String[] args) {

        Student s = new Student("Basha", 26, 85.5);

        // Printing object data
        System.out.println("Student Details");
        System.out.println("---------------");
        System.out.println("Name  = " + s.name);
        System.out.println("Age   = " + s.age);
        System.out.println("Marks = " + s.marks);
    }
}
```

### Output

```text
Student Details
---------------
Name  = Basha
Age   = 26
Marks = 85.5
```

---

# 🧠 Complete Flow

The entire process can be remembered like this:

```text
             Student Class
                   │
                   ↓
        new Student("Basha", 26, 85.5)
                   │
                   ↓
             Constructor
                   │
                   ↓
          Initialize object
                   │
          ┌────────┴────────┐
          ↓        ↓        ↓
        name      age      marks
       "Basha"     26       85.5
          │        │         │
          └────────┴─────────┘
                   ↓
              Object Data
                   ↓
               Print Data
```

---

# 🔄 Normal vs Parameterized Constructor

| Normal / No-Argument                    | Parameterized                                     |
| --------------------------------------- | ------------------------------------------------- |
| Takes no parameters                     | Takes one or more parameters                      |
| `Student()`                             | `Student(String name, int age)`                   |
| Can assign fixed/default initial values | Can assign values supplied during object creation |
| `new Student()`                         | `new Student("Basha", 26)`                        |

---

# 🔑 Four Important Memory Tricks

### 1. Normal Constructor

> **No input → constructor runs**

```java
Student()
```

### 2. Parameterized Constructor

> **Input values → constructor receives them**

```java
Student("Basha", 26)
```

### 3. Constructor Initialization

> **Constructor → gives initial values to object state**

```java
this.name = name;
```

### 4. Printing Object Data

> **Reference variable → `.` → instance variable**

```java
System.out.println(s.name);
```

---

## ⭐ Interview Answer

> **A no-argument constructor does not accept parameters and can be used to initialize an object with predefined initial values. A parameterized constructor accepts values during object creation and uses them to initialize the object's state. Constructor initialization means assigning initial values to instance variables when an object is created. After initialization, object data can be accessed through the reference variable using the dot (`.`) operator and printed.**
