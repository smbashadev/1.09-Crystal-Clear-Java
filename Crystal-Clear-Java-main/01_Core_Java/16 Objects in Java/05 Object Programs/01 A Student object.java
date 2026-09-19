## 🧒 A **Student object** is a real programming representation of a student.

A student object has:

* **State** → what the student **has**
* **Behavior** → what the student **does**

```text
             Student Object
                  │
          ┌───────┴───────┐
          ↓               ↓
        State          Behavior
      (HAS)             (DOES)
```

---

# 1️⃣ Student Object

First, create a `Student` class:

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

Now create a Student object:

```java
Student s = new Student();
```

Here:

```text
Student → Class
s       → Reference variable
new Student() → Student object
```

Conceptually:

```text
s
│
↓
┌─────────────────────────┐
│     Student Object      │
│                         │
│ name  = "Basha"         │
│ age   = 26              │
│ marks = 85              │
│                         │
│ study()                 │
│ writeExam()             │
└─────────────────────────┘
```

---

# 2️⃣ Student State

**State means what the Student object has.**

We represent state using **instance variables**.

```java
String name;
int age;
int marks;
```

For example:

```java
s.name = "Basha";
s.age = 26;
s.marks = 85;
```

Now the object's state is:

```text
Name  → Basha
Age   → 26
Marks → 85
```

So:

> **State = Properties / Attributes / Data of an object**

---

# 3️⃣ Student Behavior

**Behavior means what the Student object does.**

We commonly represent behavior using **methods**.

```java
void study() {
    System.out.println("Student is studying");
}

void writeExam() {
    System.out.println("Student is writing exam");
}
```

We can call them:

```java
s.study();
s.writeExam();
```

Output:

```text
Student is studying
Student is writing exam
```

So:

> **Behavior = Actions performed by an object**

---

# 4️⃣ Complete Program

```java
class Student {

    // State
    String name;
    int age;
    int marks;

    // Behavior
    void study() {
        System.out.println(name + " is studying");
    }

    void writeExam() {
        System.out.println(name + " is writing exam");
    }

    public static void main(String[] args) {

        Student s = new Student();

        // Giving values to state
        s.name = "Basha";
        s.age = 26;
        s.marks = 85;

        // Accessing state
        System.out.println("Name = " + s.name);
        System.out.println("Age = " + s.age);
        System.out.println("Marks = " + s.marks);

        // Calling behavior
        s.study();
        s.writeExam();
    }
}
```

### Output

```text
Name = Basha
Age = 26
Marks = 85
Basha is studying
Basha is writing exam
```

---

# 🧠 Real-World Connection

Think about a real student:

```text
              STUDENT
                 │
        ┌────────┴────────┐
        ↓                 ↓
      STATE            BEHAVIOR
      (HAS)             (DOES)
        │                 │
   ┌────┼────┐       ┌────┼──────┐
   ↓    ↓    ↓       ↓    ↓      ↓
 Name  Age Marks    Study Write  Attend
```

Java models this idea as:

```text
Real-world Student
       ↓
Java Student Object
       ↓
State + Behavior
       ↓
Instance Variables + Methods
```

---

# 🔑 Memory Trick

> **Object = State + Behavior**

For `Student`:

```text
Student Object
      │
      ├── State → name, age, marks
      │
      └── Behavior → study(), writeExam()
```

### ⭐ Interview Answer

> **A Student object is an instance of the Student class. It contains state represented by instance variables such as name, age, and marks, and behavior represented by methods such as study() and writeExam().**
