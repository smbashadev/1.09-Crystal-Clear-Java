# 🧒 State Representation in Java

**State representation** means:

> **How we represent the state (data/properties) of an object inside a Java class.**

The two important things here are:

```text
State
  ↓
Data types + Instance variables
```

---

## 1️⃣ Data Types

A **data type** tells Java what kind of data a variable can store.

Examples:

```java
String name;
int age;
double marks;
boolean passed;
```

Here:

```text
String  → text
int     → whole number
double  → decimal number
boolean → true / false
```

---

## 2️⃣ Instance Variables

When variables are declared **inside a class but outside methods**, they can represent the **state of each object**.

Example:

```java
class Student {

    String name;
    int age;
    double marks;
}
```

Here:

```text
name
age
marks
```

are **instance variables**.

They represent the **state of a Student object**.

---

## 🎓 Example

Create a Student object:

```java
Student s1 = new Student();

s1.name = "Basha";
s1.age = 26;
s1.marks = 85.5;
```

Now the object's state is:

```text
s1
 ├── name  = "Basha"
 ├── age   = 26
 └── marks = 85.5
```

Another object can have different state:

```java
Student s2 = new Student();

s2.name = "Ravi";
s2.age = 24;
s2.marks = 90.0;
```

So:

```text
       Student Class
            ↓
     ┌──────┴──────┐
     ↓             ↓
    s1             s2
     ↓             ↓
Basha, 26, 85.5  Ravi, 24, 90.0
```

Same class, but **each object has its own instance-variable values**.

---

## 🧠 Why "Instance" Variable?

An **instance** means an individual object.

```text
Student class
     ↓
 ┌───┴────┐
 ↓        ↓
s1       s2
 ↓        ↓
own      own
state    state
```

Therefore, instance variables store data associated with a **particular object instance**.

---

## 🔑 Easy Memory Trick

> **State → represented using instance variables → each instance has its own values.**

```text
CLASS
  ↓
Instance Variables
  ↓
Data Types + Variable Names
  ↓
Object's State
```

Example:

```java
class Fan {
    String color;
    int speed;
    double price;
}
```

Here:

```text
String color   → state
int speed      → state
double price   → state
```

### ⭐ Interview Answer

> **The state of an object is commonly represented in Java using instance variables declared in a class. Their data types define what kind of values the object can store, and each object generally has its own copy of those instance variables.**
