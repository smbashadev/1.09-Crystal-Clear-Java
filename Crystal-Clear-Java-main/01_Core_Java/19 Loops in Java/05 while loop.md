## 🧒 `while` Loop in Java

A **`while` loop** is used to **repeat a task as long as a condition is `true`**.

Think of it like:

> **"While this condition is true, keep doing the task."**

---

# 1️⃣ Syntax 1 — Initialization + Condition + Task + Updation

The common structure is:

```java
initialization;

while (condition) {
    task;
    updation;
}
```

### Example

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

Here:

```text
int i = 1       → Initialization
i <= 5          → Condition
println(i)      → Task
i++             → Updation
```

### Output

```text
1
2
3
4
5
```

---

# 2️⃣ How Syntax 1 Works

Java follows this order:

```text
Initialization
      ↓
Condition
      ↓
   TRUE?
   /   \
 YES    NO
  ↓      ↓
 Task    STOP
  ↓
Updation
  ↓
Condition again
```

For our example:

```text
i = 1
 ↓
1 <= 5 → TRUE
 ↓
Print 1
 ↓
i++ → 2
 ↓
2 <= 5 → TRUE
 ↓
Print 2
 ↓
...
 ↓
5 <= 5 → TRUE
 ↓
Print 5
 ↓
i++ → 6
 ↓
6 <= 5 → FALSE
 ↓
STOP
```

---

# 3️⃣ Syntax 2 — Only Condition + Task

Sometimes initialization and updation can happen **somewhere else**.

Syntax:

```java
while (condition) {
    task;
}
```

Example:

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

Although the syntax of the `while` statement itself contains only:

```text
Condition
   ↓
Task
```

the variable setup and update still have to happen somewhere if the loop is supposed to progress.

---

# 4️⃣ Why Is Updation Important?

Look at this:

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
}
```

🚨 Problem!

`i` never changes.

So:

```text
i = 1
 ↓
1 <= 5 → TRUE
 ↓
Print 1
 ↓
i is still 1
 ↓
1 <= 5 → TRUE
 ↓
Print 1
 ↓
Again...
```

This creates an **infinite loop**.

So normally we need:

```java
i++;
```

to change the value.

---

# 5️⃣ `while` vs `for`

### `for` loop

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Initialization, condition, and updation are written together.

```text
for
 ↓
Initialization
 ↓
Condition
 ↓
Task
 ↓
Updation
```

### `while` loop

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

They are separated:

```text
Initialization
      ↓
while
      ↓
Condition
      ↓
Task
      ↓
Updation
```

---

# 🧠 Real-World Example

Imagine:

> "While the fan is switched on, keep rotating."

```text
Fan ON?
  ↓
YES
  ↓
Rotate
  ↓
Check again
  ↓
Fan ON?
  ↓
YES → Rotate
  ↓
...
  ↓
NO
  ↓
Stop
```

That's the basic idea of a `while` loop.

---

# 🔑 Memory Trick

Remember:

> **`while` = Check first, then do.**

```text
Condition
    ↓
 TRUE
    ↓
  Task
    ↓
Update/change
    ↓
Condition again
```

### ⭐ Interview Answer

> **A `while` loop is an iterative statement that repeatedly executes a block of code as long as its condition is true. The condition is checked before every iteration, so if the condition is false initially, the loop body executes zero times.**
