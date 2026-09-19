## 🧒 Loops in Java

A **loop** is used when we want Java to **repeat the same task multiple times**.

Think about telling a robot:

> "Keep doing this until I tell you to stop." 🤖

---

# 1️⃣ What is a Loop?

A loop is an **iterative statement**.

**Iterative** simply means:

> **Doing something repeatedly.**

For example, printing numbers from 1 to 5:

Without a loop:

```java
System.out.println(1);
System.out.println(2);
System.out.println(3);
System.out.println(4);
System.out.println(5);
```

This works, but there is **duplicate/redundant code**.

With a loop:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Much shorter! 😊

---

# 2️⃣ Why Do We Use Loops?

The main purpose is:

> **To avoid writing the same code again and again.**

Imagine printing `"Hello"` 100 times.

Without a loop:

```text
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
...
100 times 😫
```

With a loop:

```java
for (int i = 1; i <= 100; i++) {
    System.out.println("Hello");
}
```

One small piece of code does the job 100 times.

---

# 3️⃣ Real-World Example

Imagine you have 5 students and want to greet every student.

Without a loop:

```text
Greet Student 1
Greet Student 2
Greet Student 3
Greet Student 4
Greet Student 5
```

A loop says:

```text
For each student
     ↓
   Greet
     ↓
Next student
     ↓
   Greet
```

---

# 4️⃣ Simple Loop Example

```java
class Demo {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello");
        }
    }
}
```

Output:

```text
Hello
Hello
Hello
Hello
Hello
```

The same statement executes **5 times**.

---

# 5️⃣ How the Loop Works

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Hello");
}
```

Think of it as:

```text
Start
  ↓
i = 1
  ↓
Is i <= 5?
  ↓ YES
Print Hello
  ↓
i++
  ↓
Is i <= 5?
  ↓ YES
Print Hello
  ↓
...
  ↓
i = 6
  ↓
Is 6 <= 5?
  ↓ NO
Stop
```

---

# 6️⃣ Without Loop vs With Loop

### ❌ Without Loop

```java
System.out.println("Java");
System.out.println("Java");
System.out.println("Java");
System.out.println("Java");
System.out.println("Java");
```

There is **duplicate code**.

### ✅ With Loop

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Java");
}
```

The repeated task is written only once.

---

# 🧠 Types of Loops in Java

Java mainly provides three looping statements:

```text
Loops
  │
  ├── for loop
  ├── while loop
  └── do-while loop
```

There is also an enhanced `for` loop, commonly called the **for-each loop**, for iterating over arrays and collections.

---

# 🔑 Memory Trick

Remember:

> **Loop = Repeat a task**

And:

> **Loop → Repetition → Less duplicate code → Less redundant code**

```text
Repeated Task
     ↓
   LOOP
     ↓
Write code once
     ↓
Execute multiple times
```

### ⭐ Interview Answer

> **A loop is an iterative statement used to repeatedly execute a block of code while a specified condition is satisfied. Loops help reduce redundant or duplicate code and are useful when a task needs to be performed multiple times.**
