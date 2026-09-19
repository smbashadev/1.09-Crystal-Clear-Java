# 🧒 Object Creation in Java

**Object creation** means creating an actual object from a class.

The most common way is by using the **`new` keyword**.

### Simple formula

```java
ClassName objectName = new ClassName();
```

For example:

```java
Student s = new Student();
```

---

# 1️⃣ `new` Keyword

The `new` keyword tells Java:

> **"Create a new object."**

Example:

```java
Student s = new Student();
```

Here:

```text id="w2p8k4"
new
 ↓
Create a new Student object
```

---

# 2️⃣ Class Name After `new`

Look at:

```java
Student s = new Student();
```

There are two `Student`s, but they have different roles:

```text id="c7m3x9"
Student s = new Student();
↑              ↑
Type            Class used for creation
```

The part after `new`:

```java
new Student()
```

means:

> Create an object based on the `Student` class.

---

# 3️⃣ Heap Memory

When an object is created, the JVM allocates memory for the object in the **heap**.

Think of the heap as a large area where objects are stored:

```text id="r8q5mz"
              JVM
               ↓
             HEAP
               ↓
       ┌───────────────┐
       │ Student       │
       │ name          │
       │ age           │
       │ marks         │
       └───────────────┘
```

⚠️ Beginner-friendly wording:

> **Objects are generally allocated in heap memory.**

The JVM's implementation can optimize object allocation internally, but the Java memory model treats objects as heap-managed data.

---

# 4️⃣ Memory Allocation

Suppose we have:

```java
class Student {
    String name;
    int age;
}
```

Now:

```java
Student s = new Student();
```

The JVM creates a Student object with storage for its instance state.

Conceptually:

```text id="m6v2qa"
new Student()
     ↓
Memory allocated
     ↓
Student object created
     ↓
name → default value
age  → default value
```

For instance variables:

```text
String name → null
int age     → 0
```

---

# 5️⃣ JVM Looks for the Class

When Java executes:

```java
new Student();
```

the runtime needs the `Student` class definition.

Conceptually:

```text id="p4x8kn"
new Student()
     ↓
JVM/runtime needs Student class
     ↓
Class loading/linking if required
     ↓
Object initialization
     ↓
Student object
```

The **Class Loader** is involved in making the required class definition available to the JVM.

---

# 6️⃣ Object Has State

Remember:

> **State = What the object has.**

Example:

```java
class Student {

    String name;
    int age;
    int marks;
}
```

After:

```java
Student s = new Student();

s.name = "Basha";
s.age = 26;
s.marks = 85;
```

The object has:

```text id="k9m4vz"
Student Object
 ├── name  = "Basha"
 ├── age   = 26
 └── marks = 85
```

That's its **state**.

---

# 7️⃣ Object Has Behavior

Behavior means:

> **What the object does.**

Add methods:

```java
class Student {

    String name;
    int age;
    int marks;

    void study() {
        System.out.println("Student is studying");
    }

    void writeExam() {
        System.out.println("Student is writing exam");
    }
}
```

Now the Student object has:

```text id="x7p2qm"
Student Object
     │
     ├── STATE
     │    ├── name
     │    ├── age
     │    └── marks
     │
     └── BEHAVIOR
          ├── study()
          └── writeExam()
```

---

# 🔄 Complete Object Creation Flow

```text id="q5n8wx"
class Student
      ↓
new Student()
      ↓
JVM/runtime uses Student class definition
      ↓
Object is created
      ↓
Memory is allocated for the object
      ↓
Object has STATE
      ↓
Object can use BEHAVIOR
```

Then:

```java
s.study();
```

means:

> **Tell this particular Student object to perform its `study()` behavior.**

---

# 🧠 Break Down This One Line

```java
Student s = new Student();
```

| Part        | Meaning                                  |
| ----------- | ---------------------------------------- |
| `Student`   | Reference type/class type                |
| `s`         | Reference variable                       |
| `=`         | Assigns the reference                    |
| `new`       | Requests creation of an object           |
| `Student()` | Creates/initializes a `Student` instance |

Conceptually:

```text id="a3k7mz"
              Student class
                   ↓
               new Student()
                   ↓
            Student object
             ↙          ↘
          STATE       BEHAVIOR
```

### 🔑 Ultimate Memory Trick

> **`new` → object creation → heap-managed object → state + behavior**

```text id="n6x2qp"
new ClassName()
      ↓
Create Object
      ↓
Object has
 ┌─────────────┐
 │ State       │ → instance variables
 │ Behavior    │ → instance methods
 └─────────────┘
```

### ⭐ Interview Answer

> **Object creation in Java is commonly performed using the `new` keyword. The JVM runtime creates an instance based on the class definition and allocates storage for the object's state. The object can then use its instance variables and instance methods.**
