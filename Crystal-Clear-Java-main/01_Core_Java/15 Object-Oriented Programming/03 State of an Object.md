# 🧒 State of an Object

In OOP, **State** means:

> **The data or properties that describe what an object currently has or what it is like.**

In simple words:

```text
State = Properties / Attributes = What an object has
```

---

# 🎓 Student State

Imagine a student object.

A student has:

```text
Student
 ├── Name
 ├── Age
 ├── Gender
 ├── Roll Number
 ├── Marks
 └── Type
```

These are the student's **properties/attributes**, so together they represent the **state** of the Student object.

For example:

```text
Name       = Basha
Age        = 26
Gender     = Male
Roll Number = 101
Marks      = 85
Type       = Student
```

So:

```text
Student State
      ↓
Name + Age + Gender + Roll Number + Marks + Type
```

---

# 🌀 Fan State

A fan also has its own state.

```text
Fan
 ├── Color
 ├── Price
 ├── Speed
 ├── Brand
 └── Type
```

For example:

```text
Color = White
Price = ₹2,500
Speed = 3
Brand = XYZ
Type  = Ceiling Fan
```

Together, these describe the **current state of the fan**.

---

# 🔄 Why "Current State"?

State can **change**.

For example, a fan:

```text
Before:
Speed = 1

       ↓ Increase speed

After:
Speed = 3
```

The fan's state has changed.

Similarly, a student's marks can change:

```text
Before:
Marks = 70

       ↓ Exam

After:
Marks = 85
```

So the **state of an object is its current values**.

---

# 🧠 State vs Object

Think about this:

```text
Object = Student
State  = Name, Age, Roll Number, Marks, etc.
```

```text
Object = Fan
State  = Color, Price, Speed, Brand, Type
```

### 🔑 Easy Memory Trick

> **State = What an object HAS.**

```text
OBJECT
   ↓
What does it have?
   ↓
Properties / Attributes
   ↓
STATE
```

### ⭐ Interview Answer

> **State of an object refers to the values of its properties or attributes at a particular point in time.**

For example:

```text
Student → name, age, roll number, marks
Fan     → color, price, speed, brand
```

These values together represent the **state of the object**.
