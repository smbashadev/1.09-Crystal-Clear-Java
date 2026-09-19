## 🧒 Exit-Control Loop

An **exit-control loop** is a loop where the **condition is checked after the loop body executes**.

In simple words:

> 🚪 **Java does the task first and checks whether to continue afterward.**

The **`do-while` loop** is an exit-control loop.

---

# 1️⃣ Which Loop Is Exit-Controlled?

Java has one basic exit-control loop:

```text
Exit-Control Loop
       ↓
   do-while
```

---

# 2️⃣ Basic Syntax

```java
initialization;

do {
    // task
} while (condition);
```

Notice the order:

```text
Initialization
      ↓
     do
      ↓
    Task
      ↓
  Condition
```

The **task comes before the condition check**.

---

# 3️⃣ Simple Example

```java
class Demo {

    public static void main(String[] args) {

        int i = 1;

        do {
            System.out.println(i);
            i++;
        } while (i <= 5);
    }
}
```

Output:

```text
1
2
3
4
5
```

---

# 4️⃣ Why Is It Called "Exit-Control"?

Think about a building. 🚪

An **entry-control** loop checks your permission **before entering**.

An **exit-control** loop lets you enter and do something first, then checks whether you should leave or continue.

```text
       ENTER
         ↓
       Do Task
         ↓
   Check Condition
      /       \
    TRUE      FALSE
     ↓          ↓
  Repeat       EXIT
```

The condition controls what happens at the **exit point**.

That's why we call it:

> **Exit-Control Loop**

---

# 5️⃣ Executes At Least Once ⭐

This is the most important point.

Consider:

```java
int i = 10;

do {
    System.out.println(i);
} while (i < 5);
```

The condition is:

```text
10 < 5
  ↓
FALSE
```

But the output is:

```text
10
```

Why?

Because Java executes the body **before checking the condition**.

```text
i = 10
   ↓
  do
   ↓
Print 10       ← Executes first
   ↓
i < 5?
   ↓
FALSE
   ↓
EXIT
```

Therefore:

> **A `do-while` loop executes its body at least once.**

---

# 6️⃣ Compare With Entry-Control Loops

### `while`

```java
int i = 10;

while (i < 5) {
    System.out.println(i);
}
```

Condition is checked first:

```text
10 < 5?
   ↓
FALSE
   ↓
Don't execute
```

Output:

```text
Nothing
```

### `do-while`

```java
int i = 10;

do {
    System.out.println(i);
} while (i < 5);
```

Body executes first:

```text
Print 10
   ↓
10 < 5?
   ↓
FALSE
   ↓
Stop
```

Output:

```text
10
```

---

# 7️⃣ Entry vs Exit Control

| Feature                   | Entry-Control  | Exit-Control |
| ------------------------- | -------------- | ------------ |
| Java loops                | `for`, `while` | `do-while`   |
| Condition checked         | Before body    | After body   |
| Body can execute 0 times? | ✅ Yes          | ❌ No         |
| Minimum executions        | 0              | **1**        |

### Visual

```text
ENTRY-CONTROL

Condition
    ↓
 TRUE?
  ↓
 Body
```

```text
EXIT-CONTROL

Body
  ↓
Condition
  ↓
 TRUE?
  ↓
Body again
```

---

# 🧠 Real-World Example

Imagine a restaurant menu. 🍕

You want to:

1. Show the menu.
2. Ask the user whether they want to order again.
3. If yes → show the menu again.
4. If no → exit.

The menu must be shown **at least once**.

That's a good use of `do-while`.

```text
Show Menu
    ↓
Ask: Continue?
    ↓
 YES → Show Menu again
    ↓
 NO
    ↓
 EXIT
```

---

# 🔑 Memory Trick

> **Exit-Control = Do first, check later.**

```text
do-while
    ↓
DO the task
    ↓
Check condition
    ↓
TRUE  → Repeat
FALSE → Exit
```

### ⭐ Interview Answer

> **An exit-control loop is a loop in which the condition is checked after executing the loop body. In Java, the `do-while` loop is an exit-control loop, so its body executes at least once even when the condition is initially false.**
