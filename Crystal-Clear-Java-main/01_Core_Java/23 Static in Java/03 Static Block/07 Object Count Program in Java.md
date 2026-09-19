# 🧒 Object Count Program in Java

This is a very important example for understanding **static variables + objects + static methods**.

The goal is simple:

> **Every time we create an object, increase a common `count` variable by 1.**

At the end, we can find out **how many objects were created**.

---

# 1. The Idea

Suppose we create:

```java
Demo d1 = new Demo();
Demo d2 = new Demo();
Demo d3 = new Demo();
```

We want:

```text
Object 1 → count = 1
Object 2 → count = 2
Object 3 → count = 3
```

We need one variable that is **common to all objects**.

So we use:

```java
static int count;
```

---

# 2. Why `count` Must Be Static

Imagine `count` was not static:

```java
int count;
```

Then every object would get its own `count`.

```text
Object 1 → count
Object 2 → count
Object 3 → count
```

They wouldn't maintain one common total.

But we need:

```text
             count
              ↓
              3
          ↙   ↓   ↘
       d1     d2    d3
```

Therefore:

```java
static int count;
```

is appropriate.

---

# 3. Using a Constructor to Count Objects

Every time an object is created, its constructor executes.

So we can increase the count inside the constructor:

```java
Demo() {
    count++;
}
```

Remember:

```text
new Demo()
    ↓
Constructor executes
    ↓
count increases
```

---

# 4. Complete Program

```java
class Demo {

    static int count = 0;

    Demo() {
        count++;
    }

    static void displayCount() {
        System.out.println("Number of objects created: " + count);
    }

    public static void main(String[] args) {

        Demo d1 = new Demo();
        Demo d2 = new Demo();
        Demo d3 = new Demo();

        Demo.displayCount();
    }
}
```

### Output

```text
Number of objects created: 3
```

---

# 5. How Does It Work?

Initially:

```text
count = 0
```

Then:

### First object

```java
Demo d1 = new Demo();
```

Constructor executes:

```java
count++;
```

Now:

```text
count = 1
```

---

### Second object

```java
Demo d2 = new Demo();
```

Constructor executes again:

```java
count++;
```

Now:

```text
count = 2
```

---

### Third object

```java
Demo d3 = new Demo();
```

Constructor executes again.

Now:

```text
count = 3
```

Finally:

```java
Demo.displayCount();
```

prints:

```text
Number of objects created: 3
```

---

# 6. Visualize It 🧠

```text
              static count
                  │
             count = 0
                  │
        ┌─────────┼─────────┐
        ↓         ↓         ↓
       d1        d2        d3
        │         │         │
     count++   count++   count++
        │         │         │
        ↓         ↓         ↓
        1         2         3
```

The **same static variable** is being updated.

---

# 7. Why Use a Static Method?

We have:

```java
static void displayCount()
```

because `count` itself is static.

We can call the method using the class name:

```java
Demo.displayCount();
```

No additional object is required just to display the common count.

Think:

```text
Demo
 ↓
static count
 ↓
static displayCount()
```

Everything here is class-level.

---

# 8. Static Variable + Static Method

We have:

```java
static int count = 0;
```

and:

```java
static void displayCount() {
    System.out.println(count);
}
```

Both are static.

So the static method can directly access the static variable:

```text
static method
     ↓
static count
     ↓
✅ Allowed
```

---

# 9. What Happens If We Create More Objects?

Suppose:

```java
Demo d1 = new Demo();
Demo d2 = new Demo();
Demo d3 = new Demo();
Demo d4 = new Demo();
Demo d5 = new Demo();
```

The count becomes:

```text
1
2
3
4
5
```

Then:

```java
Demo.displayCount();
```

Output:

```text
Number of objects created: 5
```

---

# 10. Real-Life Example 🏫

Imagine a school keeps track of how many students have registered.

Initially:

```text
Registered students = 0
```

A student registers:

```text
Student 1 → 1
```

Another:

```text
Student 2 → 2
```

Another:

```text
Student 3 → 3
```

The school needs **one common counter**, not a separate counter for every student.

That's exactly what the static `count` variable does.

---

# 11. Important Connection

This program combines several concepts you've already learned:

```text
                 Object Count Program
                         │
        ┌────────────────┼────────────────┐
        ↓                ↓                ↓
  Static variable    Constructor     Static method
        ↓                ↓                ↓
     count          count++         displayCount()
        │                │                │
        └────────────────┼────────────────┘
                         ↓
                Number of objects
```

---

# ⭐ Golden Rule

> **Use a static variable when you need one common value shared by all objects. To count objects, increment that static variable whenever the constructor executes.**

### 🧠 Remember this forever:

```text
Object created
      ↓
Constructor runs
      ↓
count++
      ↓
Common static count increases
      ↓
Static method displays count
```

### One-line formula:

```text
Number of objects created = number of constructor executions
```

For example:

```java
Demo d1 = new Demo();  // count = 1
Demo d2 = new Demo();  // count = 2
Demo d3 = new Demo();  // count = 3
```

So:

```text
3 objects → count = 3
```

**The key idea is: `static count` gives all objects one common counter.**
