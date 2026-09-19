## 🧒 `do-while` Loop in Java

A **`do-while` loop** is used to repeat a task, but it has one special feature:

> ⭐ **The task executes at least once before the condition is checked.**

This is the biggest difference between `while` and `do-while`.

---

# 1️⃣ Basic Structure

The flow is:

```text
Initialization
      ↓
    do
      ↓
    Task
      ↓
  Condition
      ↓
   TRUE?
   /    \
 YES     NO
  ↓       ↓
Task     STOP
  ↓
Condition again
```

---

# 2️⃣ Syntax

```java id="v7p6tq"
initialization;

do {
    task;
} while (condition);
```

⚠️ Notice the **semicolon `;`** after the `while` condition.

```java id="q3m8xa"
while (condition);
```

The semicolon is required for a `do-while` statement.

---

# 3️⃣ Simple Example

Print numbers from 1 to 5:

```java id="z5k2wp"
class Demo {

    public static void main(String[] args) {

        int i = 1;              // Initialization

        do {
            System.out.println(i);  // Task
            i++;                    // Updation
        } while (i <= 5);        // Condition
    }
}
```

### Output

```text id="h8v4zn"
1
2
3
4
5
```

---

# 4️⃣ How It Works

Initially:

```java id="1j6qmv"
int i = 1;
```

### Step 1 — `do`

Java enters the `do` block.

```java id="6b3rpk"
do {
    System.out.println(i);
    i++;
}
```

### Step 2 — Task

Print:

```text id="y5x8qa"
1
```

Then:

```text id="p9c4wm"
i++
 ↓
i = 2
```

### Step 3 — Condition

Java checks:

```java id="2g7k1v"
i <= 5
```

Since:

```text id="a6m3zp"
2 <= 5 → TRUE
```

Java goes back to the `do` block.

This continues until:

```text id="s8k5yc"
i = 6

6 <= 5 → FALSE
```

Then the loop stops.

---

# 5️⃣ The Special Feature ⭐

Let's make the condition **false from the beginning**.

```java id="0d9f4b"
class Demo {

    public static void main(String[] args) {

        int i = 10;

        do {
            System.out.println(i);
        } while (i < 5);
    }
}
```

Condition:

```text id="9h2w7k"
10 < 5 → FALSE
```

You might think nothing will print.

But output is:

```text id="m4q8zs"
10
```

Why?

Because the `do` block executes **before** Java checks the condition.

```text id="2x7m9a"
Initialization
     ↓
    do
     ↓
   Task       ← Executes FIRST
     ↓
Condition
     ↓
 FALSE
     ↓
  STOP
```

---

# 6️⃣ Compare `while` and `do-while`

### `while`

```java id="v7m1qa"
int i = 10;

while (i < 5) {
    System.out.println(i);
}
```

Output:

```text id="9p4xkc"
Nothing
```

Because condition is checked first.

```text
Condition
   ↓
FALSE
   ↓
STOP
```

### `do-while`

```java id="f2z8mn"
int i = 10;

do {
    System.out.println(i);
} while (i < 5);
```

Output:

```text id="k6w3vp"
10
```

Because task executes first.

```text
Task
 ↓
10 printed
 ↓
Condition
 ↓
FALSE
 ↓
STOP
```

---

# 7️⃣ Real-World Example 🎮

Imagine a game menu.

You want to **show the menu at least once**, then ask whether the user wants to continue.

```text
Show Menu
    ↓
Ask: Continue?
    ↓
YES → Show Menu again
    ↓
Ask again
    ↓
NO → Stop
```

This is a perfect situation for `do-while`.

---

# 🧠 Easy Memory Trick

### `while`

> **Check → Do**

```text
Condition → Task
```

### `do-while`

> **Do → Check**

```text
Task → Condition
```

So remember:

```text
WHILE
   ↓
Check FIRST

DO-WHILE
   ↓
Do FIRST
```

---

# 🔑 Your Notes in One Picture

```text
Initialization
      ↓
     do
      ↓
    Task
      ↓
  Condition
      ↓
   TRUE?
   /   \
 YES    NO
  ↓      ↓
 Task   STOP
```

### ⭐ Interview Answer

> **A `do-while` loop is an iterative statement in which the loop body is executed first and the condition is checked afterward. Therefore, the body executes at least once, even if the condition is false initially.**
