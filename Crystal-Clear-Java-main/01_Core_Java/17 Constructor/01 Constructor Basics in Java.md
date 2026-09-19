## 🧒 Constructor Basics in Java

A **constructor** is a special part of a class that runs when an object is created and is mainly used to **initialize the new object's state**.

Think of a constructor as the **setup process for a new object**. 🏗️

---

# 1️⃣ Constructor Name = Class Name

Suppose our class is:

```java id="m8q3ka"
class Student {
    
}
```

The constructor must have the **same name** as the class:

```java id="f4n7xp"
class Student {

    Student() {
        System.out.println("Student object created");
    }
}
```

Notice:

```text id="q2k8vm"
Class       → Student
Constructor → Student()
```

The names are exactly the same.

---

# 2️⃣ Constructor Initializes Instance Variables

Suppose we have:

```java id="p5t9cx"
class Student {
    String name;
    int age;

    Student() {
        name = "Basha";
        age = 26;
    }
}
```

When the object is created:

```java id="j6v3qn"
Student s = new Student();
```

the constructor runs and assigns values.

```text id="r7k2wp"
new Student()
      ↓
Constructor runs
      ↓
name = "Basha"
age  = 26
      ↓
Initialized Student Object
```

So the constructor can be used to **initialize instance variables**.

---

# 3️⃣ Constructor Is Called During Object Creation

Look at:

```java id="z4m8yp"
Student s = new Student();
```

The important part is:

```java id="3w9kva"
new Student()
```

When this executes:

1. Memory is allocated for the new object.
2. Instance variables receive their default values.
3. The constructor is invoked.
4. Constructor initialization code executes.
5. A reference to the object is returned.

Simplified:

```text id="q9r2mx"
new Student()
      ↓
Create object
      ↓
Constructor called
      ↓
Initialize object
      ↓
Reference returned
```

---

# 4️⃣ Constructor Is NOT a Method

This is an important interview point.

A constructor and method are different.

| Constructor                    | Method                      |
| ------------------------------ | --------------------------- |
| Initializes a new object       | Performs an operation/task  |
| Same name as class             | Can have any valid name     |
| No return type                 | Has a return type or `void` |
| Invoked during object creation | Usually explicitly called   |
| Cannot be inherited            | Methods can be inherited    |
| Not overridden                 | Can be overridden           |

Example:

```java id="e2h7pv"
class Student {

    // Constructor
    Student() {
        System.out.println("Constructor");
    }

    // Method
    void study() {
        System.out.println("Studying");
    }
}
```

---

# 5️⃣ Constructor Has NO Return Type

A constructor does **not have a return type**.

Correct:

```java id="q3w8zn"
Student() {
    System.out.println("Constructor");
}
```

Incorrect:

```java id="r6k2mx"
void Student() {
    System.out.println("This is a method, not a constructor");
}
```

Why?

Because adding `void` changes it into a **method**.

---

# 6️⃣ Not Even `void`

This is where beginners often get confused.

You might think:

```java id="t9v4qa"
void Student()
```

could be a constructor.

❌ No.

It is a method named `Student`.

### Constructor:

```java id="a7m3kp"
Student() {
}
```

### Method:

```java id="x5q8nr"
void Student() {
}
```

The `void` makes the second one a method.

---

# 7️⃣ Complete Example

```java id="c6p2ym"
class Student {

    String name;
    int age;

    // Constructor
    Student() {
        name = "Basha";
        age = 26;
    }

    // Method
    void study() {
        System.out.println(name + " is studying");
    }

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s.name);
        System.out.println(s.age);

        s.study();
    }
}
```

Output:

```text id="b3m7vx"
Basha
26
Basha is studying
```

Here:

```text id="j5r9qw"
Student s = new Student();
                 │
                 ↓
            Constructor
                 │
                 ↓
        name = "Basha"
        age  = 26
```

Then:

```java id="u4n8kc"
s.study();
```

calls the **method**.

---

# 🧠 Constructor vs Method — Super Simple

Think about buying a new car 🚗.

### Constructor

When the car is manufactured, it gets its initial setup:

```text id="m8x2qp"
Create Car
   ↓
Set initial color
Set initial model
Set initial price
```

### Method

After the car exists, you perform actions:

```text id="z7c4vn"
Car exists
   ↓
start()
drive()
brake()
stop()
```

So:

> **Constructor = Object setup**

> **Method = Object action**

---

# 🔑 Memory Trick

Remember these **5 points**:

```text id="v2k8mq"
CONSTRUCTOR

1. Same name as Class
2. Initializes Object
3. Called during Object Creation
4. Not a Method
5. No Return Type — not even void
```

### ⭐ Interview Answer

> **A constructor is a special construct in Java used to initialize a newly created object. Its name must be the same as the class name, it has no return type—not even `void`—and it is invoked as part of object creation. A constructor is different from a method.**
