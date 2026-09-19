## 🧒 Major Loops in Java

Java has **three major/basic loops**:

1. `for` loop
2. `while` loop
3. `do-while` loop

All three have the same basic purpose:

> 🔁 **Repeat a block of code multiple times.**

The main difference is **how and when they check the condition**.

---

# 1️⃣ `for` Loop

Use a `for` loop when you generally **know how many times** you want to repeat something.

### Example

Print `"Hello!"` 5 times:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Hello!");
}
```

Output:

```text
Hello!
Hello!
Hello!
Hello!
Hello!
```

### Think of it like:

> "Do this **5 times**."

```text
Start
 ↓
i = 1
 ↓
Check condition
 ↓
Execute
 ↓
Increment
 ↓
Check again
 ↓
...
 ↓
Stop
```

### 🔑 Memory Trick

> **`for` → Known number of repetitions**

---

# 2️⃣ `while` Loop

A `while` loop is useful when you want to **keep repeating as long as a condition is true**.

### Example

```java
int i = 1;

while (i <= 5) {
    System.out.println("Hello!");
    i++;
}
```

Output:

```text
Hello!
Hello!
Hello!
Hello!
Hello!
```

Think:

> **"While this condition is true, keep doing this."**

```text
Condition?
   ↓
 TRUE → Execute
   ↓
Condition?
   ↓
 TRUE → Execute
   ↓
...
   ↓
FALSE
   ↓
Stop
```

### 🔑 Memory Trick

> **`while` → Repeat while condition is true**

---

# 3️⃣ `do-while` Loop

The `do-while` loop is special because it **executes the code first and checks the condition afterward**.

### Example

```java
int i = 1;

do {
    System.out.println("Hello!");
    i++;
} while (i <= 5);
```

Output:

```text
Hello!
Hello!
Hello!
Hello!
Hello!
```

Think:

> **"Do it first, then ask whether I should do it again."**

```text
Execute
   ↓
Check condition
   ↓
TRUE → Execute again
   ↓
Check condition
   ↓
...
   ↓
FALSE
   ↓
Stop
```

---

# ⭐ Most Important Difference

Suppose the condition is **false from the beginning**.

### `while`

```java
int i = 10;

while (i < 5) {
    System.out.println("Hello!");
}
```

Output:

```text
Nothing
```

Why?

The condition is checked **before** execution.

```text
10 < 5?
  ↓
FALSE
  ↓
Don't execute
```

---

### `do-while`

```java
int i = 10;

do {
    System.out.println("Hello!");
} while (i < 5);
```

Output:

```text
Hello!
```

Why?

The code executes **once before the condition is checked**.

```text
Execute
  ↓
Hello!
  ↓
10 < 5?
  ↓
FALSE
  ↓
Stop
```

---

# 📊 Quick Comparison

| Loop       | Condition Check  | Minimum Executions |
| ---------- | ---------------- | -----------------: |
| `for`      | Before execution |                  0 |
| `while`    | Before execution |                  0 |
| `do-while` | After execution  |              **1** |

---

# 🧠 Real-World Analogy

Imagine eating food. 🍔

### `for`

> "Eat exactly 5 pieces."

```text
Eat → Eat → Eat → Eat → Eat → Stop
```

### `while`

> "While you're hungry, eat."

```text
Hungry?
 ↓ Yes
Eat
 ↓
Hungry?
 ↓ Yes
Eat
 ↓
Hungry?
 ↓ No
Stop
```

### `do-while`

> "Eat at least one piece, then check whether you're still hungry."

```text
Eat first
  ↓
Still hungry?
  ↓ Yes
Eat again
  ↓
Still hungry?
  ↓ No
Stop
```

---

# 🔑 Final Memory Trick

```text
FOR
 ↓
Usually known repetitions

WHILE
 ↓
Check first → then execute

DO-WHILE
 ↓
Execute first → then check
```

### One-line summary:

> **`for` and `while` may execute zero times, but `do-while` executes its body at least once.**
