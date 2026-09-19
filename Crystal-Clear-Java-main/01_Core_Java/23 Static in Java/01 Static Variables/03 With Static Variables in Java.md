# 🧒 With Static Variables in Java

Now let's see what happens when we use the **`static` keyword**.

We will continue with our `Circle` example.

---

## 1. Without `static`

Previously we had:

```java
class Circle {

    double radius;
    double pi = 3.14;
}
```

If we create three objects:

```java
Circle c1 = new Circle();
Circle c2 = new Circle();
Circle c3 = new Circle();
```

Conceptually:

```text
c1 → radius + pi
c2 → radius + pi
c3 → radius + pi
```

So every object has its **own copy** of `pi`.

But `pi` is common to all circles.

---

# 2. Using `static`

We change:

```java
double pi = 3.14;
```

to:

```java
static double pi = 3.14;
```

Complete class:

```java
class Circle {

    double radius;
    static double pi = 3.14;
}
```

Now `pi` is a **static variable**.

---

# 3. What Does `static` Mean?

For this example, think of `static` as:

> **"This variable belongs to the class and is shared by all objects."**

So:

```java
static double pi = 3.14;
```

means there is one common class-level `pi` that all `Circle` objects can use.

---

# 4. Single Common Variable

Suppose:

```java
Circle c1 = new Circle();
Circle c2 = new Circle();
Circle c3 = new Circle();
```

Conceptually, we now have:

```text
                 Circle class
                     │
                     ↓
                 static pi
                   3.14
                     ↑
          ┌──────────┼──────────┐
          │          │          │
         c1         c2         c3
       radius      radius      radius
         5           10         20
```

Notice the important difference:

```text
radius → each object has its own value
pi     → common static variable
```

---

# 5. Single Memory Allocation

For the simple mental model you're learning:

### Instance variable

```text
Object 1 → radius
Object 2 → radius
Object 3 → radius
```

Each object has its own instance data.

### Static variable

```text
One static pi
      ↓
Used by multiple objects
```

So we don't need a separate **per-object copy** of `pi`.

This is why `static` can improve memory efficiency when the data is genuinely common.

---

# 6. Complete Program

```java
class Circle {

    double radius;
    static double pi = 3.14;

    public static void main(String[] args) {

        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle();

        c1.radius = 5;
        c2.radius = 10;
        c3.radius = 15;

        System.out.println("Circle 1 Radius: " + c1.radius);
        System.out.println("Circle 2 Radius: " + c2.radius);
        System.out.println("Circle 3 Radius: " + c3.radius);

        System.out.println("Pi: " + Circle.pi);
    }
}
```

### Output

```text
Circle 1 Radius: 5.0
Circle 2 Radius: 10.0
Circle 3 Radius: 15.0
Pi: 3.14
```

---

# 7. Accessing a Static Variable

Because `pi` belongs to the class, the preferred way to access it is:

```java
Circle.pi
```

Think:

```text
Circle
  ↓
Class
  ↓
pi
```

You don't need to create a Circle object just to access the common `pi` value.

---

# 8. Changing the Static Variable

This is very important.

Suppose:

```java
Circle.pi = 3.14159;
```

Now the common static variable becomes:

```text
pi = 3.14159
```

All Circle objects that read `pi` see the updated value.

Conceptually:

```text
             static pi
              3.14159
                  ↑
        ┌─────────┼─────────┐
        ↑         ↑         ↑
       c1        c2        c3
```

That's the meaning of a **shared variable**.

---

# 🧠 Real-Life Example

Imagine a school has one school name:

```text
ABC School
```

There are 1,000 students.

The school name is common:

```text
Student 1 ──┐
Student 2 ──┤
Student 3 ──┼──→ ABC School
Student ... ─┤
Student 1000 ┘
```

You don't need a different school name conceptually for every student.

Similarly:

```text
Circle 1 ──┐
Circle 2 ──┤
Circle 3 ──┼──→ pi = 3.14
Circle ... ─┤
```

`static` represents that common class-level data.

---

# 🆚 Instance vs Static

|            | Instance Variable          | Static Variable                 |
| ---------- | -------------------------- | ------------------------------- |
| Keyword    | No `static`                | `static`                        |
| Belongs to | Object                     | Class                           |
| Copies     | One per object             | One common class-level variable |
| Example    | `radius`                   | `pi`                            |
| Values     | Can differ between objects | Common/shared value             |
| Access     | `c1.radius`                | `Circle.pi`                     |

---

# 🎯 Remember Forever

```text
class Circle
     │
     ├── radius
     │      ↓
     │   Instance
     │      ↓
     │   Each object gets its own value
     │
     └── static pi
            ↓
         Shared
            ↓
      One common class-level variable
```

### ⭐ Golden Rule

> **`static` means the variable is associated with the class rather than each individual object. A static variable provides one shared class-level variable that objects can access.**

For our example:

```java
double radius;          // individual
static double pi = 3.14; // common
```

**Radius changes from circle to circle. `pi` is common to all circles.**
