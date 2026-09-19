# 🧒 Static Methods in Java

A **static method** is a method that belongs to the **class**, rather than to a particular object.

The easiest way to remember it is:

> **If a method does not need any particular object's data or behavior, it can often be made `static`.**

---

# 1. First Understand a Normal Method

Suppose we have a `Student` class:

```java
class Student {

    void study() {
        System.out.println("Student is studying");
    }
}
```

Here:

```java
void study()
```

is a **non-static method**.

To call it, we normally create an object:

```java
Student s = new Student();

s.study();
```

Think:

```text
Student class
      ↓
Create object
      ↓
Student s
      ↓
s.study()
```

---

# 2. Why Does a Non-Static Method Need an Object?

A non-static method can represent the **behavior of a particular object**.

For example:

```java
class Student {

    String name;

    void study() {
        System.out.println(name + " is studying");
    }
}
```

Now:

```java
Student s1 = new Student();
Student s2 = new Student();

s1.name = "Basha";
s2.name = "Ravi";

s1.study();
s2.study();
```

Output:

```text
Basha is studying
Ravi is studying
```

The method `study()` is connected to a particular Student object.

So we need:

```text
s1 → study()
s2 → study()
```

---

# 3. What Is a Static Method?

We can declare a method using:

```java
static
```

Example:

```java
class Demo {

    static void display() {
        System.out.println("Hello Java");
    }
}
```

Here:

```java
static void display()
```

is a **static method**.

It belongs to the class.

---

# 4. Calling a Static Method

The preferred way to call a static method is using the **class name**:

```java
Demo.display();
```

Notice something important:

We did **not** create an object.

```text
Demo
 ↓
display()
```

No:

```java
Demo d = new Demo();
```

is required just to call `display()`.

---

# 5. Complete Program

```java
class Demo {

    static void display() {
        System.out.println("Hello Java");
    }

    public static void main(String[] args) {

        Demo.display();
    }
}
```

### Output

```text
Hello Java
```

---

# 6. Understanding the Program

Look at:

```java
static void display()
```

The keyword:

```java
static
```

means the method is associated with the **class**.

Then:

```java
Demo.display();
```

means:

```text
Demo → class name
.
display() → static method
```

So:

```text
Class Name
     ↓
Demo.display()
```

---

# 7. No Object Creation

For a static method:

```java
Demo.display();
```

we don't need:

```java
Demo d = new Demo();
```

This is the major difference you're learning here.

### Non-static method

```java
Demo d = new Demo();
d.display();
```

### Static method

```java
Demo.display();
```

---

# 8. Simple Comparison

| Non-Static Method                        | Static Method                                       |
| ---------------------------------------- | --------------------------------------------------- |
| Belongs to an object                     | Belongs to the class                                |
| Normally requires an object to invoke it | Can be invoked without creating an object           |
| Called using object reference            | Commonly called using class name                    |
| `obj.method()`                           | `ClassName.method()`                                |
| Can represent object-specific behavior   | Useful for behavior not tied to a particular object |

---

# 9. Real-Life Example 🏫

Imagine a school.

A student can:

```text
Study
Write exam
Play
```

These actions can be associated with a **particular student**.

For example:

```text
Basha → study()
Ravi  → study()
```

So `study()` can be non-static.

---

Now imagine a method:

```text
displaySchoolRules()
```

The rules are not specific to one student.

You don't need to create:

```text
Basha object
```

just to display the school's general rules.

That type of class-level operation can be represented using a static method.

---

# 10. Static Method Example

```java
class School {

    static void displayRules() {
        System.out.println("Students must maintain discipline.");
    }

    public static void main(String[] args) {

        School.displayRules();
    }
}
```

Output:

```text
Students must maintain discipline.
```

No `School` object was created.

---

# 11. Why Use `static`?

Ask yourself:

> **Does this method need a particular object's data?**

### If YES

A non-static method may be appropriate.

Example:

```java
class Student {

    String name;

    void displayName() {
        System.out.println(name);
    }
}
```

We need a Student object because `name` belongs to that object.

```java
Student s = new Student();
s.name = "Basha";

s.displayName();
```

---

### If NO

A static method may be appropriate.

```java
class Calculator {

    static void showMessage() {
        System.out.println("Calculator is ready");
    }
}
```

Call:

```java
Calculator.showMessage();
```

No Calculator object is needed for this class-level operation.

---

# 12. Important Example — Calculator

Mathematical operations are a common example.

```java
class Calculator {

    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        int result = Calculator.add(10, 20);

        System.out.println(result);
    }
}
```

Output:

```text
30
```

Notice:

```java
Calculator.add(10, 20);
```

We didn't write:

```java
Calculator c = new Calculator();
```

because `add()` is static.

---

# 13. Why Doesn't `add()` Need an Object?

Look at:

```java
Calculator.add(10, 20);
```

The method only needs:

```text
10
20
```

to perform:

```text
10 + 20
```

It doesn't need information from a particular Calculator object.

So a static method is appropriate.

---

# 14. Static Method and Object Behavior

This is an important point from your topic.

A method that represents **object-specific behavior** generally works with an object.

Example:

```java
class Car {

    String brand;

    void displayBrand() {
        System.out.println(brand);
    }
}
```

Different objects can have different brands:

```text
Car 1 → Toyota
Car 2 → Honda
Car 3 → BMW
```

So:

```java
displayBrand()
```

is naturally object-related.

---

But:

```java
static void showCompanyName()
```

could represent information or behavior common to the class.

---

# 15. One Very Important Rule

A static method can be called without creating an object, **but that does not mean static methods can do everything without restrictions**.

For example:

```java
class Student {

    String name;

    static void display() {
        System.out.println(name); // Error
    }
}
```

Why?

Because `name` is an **instance variable**.

Which student's `name` should the static method use?

```text
Student 1 → Basha
Student 2 → Ravi
Student 3 → Kumar
```

There is no particular object associated with the static method call.

Therefore, a static context cannot directly access an instance variable.

---

# 🧠 Easy Way to Remember

Think about:

### Non-static

```text
OBJECT
  ↓
My data
  ↓
My behavior
```

Example:

```java
student.study();
```

### Static

```text
CLASS
  ↓
Common/class-level operation
  ↓
ClassName.method();
```

Example:

```java
Calculator.add(10, 20);
```

---

# 🎯 Golden Rule

> **A non-static method is associated with an object and is normally invoked through an object reference. A static method is associated with the class and can be invoked using the class name without creating an object.**

### Remember this pattern:

```java
// Non-static
ClassName obj = new ClassName();
obj.method();
```

```java
// Static
ClassName.method();
```

### 🧠 One-line memory trick

```text
NON-STATIC → Object → object.method()

STATIC     → Class  → ClassName.method()
```
