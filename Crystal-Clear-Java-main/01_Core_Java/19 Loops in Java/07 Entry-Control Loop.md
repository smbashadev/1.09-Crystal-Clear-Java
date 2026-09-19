## 🧒 Entry-Control Loop

An **entry-control loop** is a loop where the **condition is checked before the loop body executes**.

In simple words:

> 🚪 **Before entering the loop, Java checks the condition.**

If the condition is `true` → enter and execute the body.

If the condition is `false` → don't enter the body.

---

# 1️⃣ Which Loops Are Entry-Controlled?

Two major Java loops are entry-control loops:

1. **`for` loop**
2. **`while` loop**

```text
Entry-Control Loops
       │
       ├── for
       └── while
```

---

# 2️⃣ `for` Loop

Example:

```java
int i = 1;

for (; i <= 5; i++) {
    System.out.println(i);
}
```

Java checks:

```text
i <= 5 ?
   ↓
 TRUE → Enter loop → Execute body
 FALSE → Don't enter
```

For example, if:

```java
int i = 10;
```

then:

```text
10 <= 5 ?
    ↓
  FALSE
    ↓
Don't execute body
```

So nothing is printed.

---

# 3️⃣ `while` Loop

Example:

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

Java first checks:

```text
i <= 5 ?
   ↓
 TRUE
   ↓
Enter loop
   ↓
Execute body
```

If:

```java
int i = 10;
```

then:

```text
10 <= 5 ?
    ↓
  FALSE
    ↓
Don't enter loop
```

---

# 4️⃣ Why "Entry-Control"?

Think about a **building entrance** 🚪.

Before you enter:

```text
             Door
              ↓
       ┌─────────────┐
       │ Check       │
       │ Condition   │
       └──────┬──────┘
              ↓
        Is it TRUE?
         /       \
       YES        NO
        ↓          ↓
     Enter       Stay out
     loop
```

That's why it's called:

> **Entry-control loop**

The condition controls whether you can **enter** the loop body.

---

# 5️⃣ Important Example

### `while`

```java
int i = 10;

while (i < 5) {
    System.out.println("Hello");
}
```

Condition:

```text
10 < 5 → FALSE
```

Output:

```text
Nothing
```

The body executes **zero times**.

---

### `for`

```java
for (int i = 10; i < 5; i++) {
    System.out.println("Hello");
}
```

Again:

```text
10 < 5 → FALSE
```

Output:

```text
Nothing
```

The body executes **zero times**.

---

# 🧠 Compare With `do-while`

This is the important distinction:

| Loop       | Type          | Condition   |
| ---------- | ------------- | ----------- |
| `for`      | Entry-control | Before body |
| `while`    | Entry-control | Before body |
| `do-while` | Exit-control  | After body  |

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

# 🔑 Memory Trick

> **Entry-Control = Check at the entrance 🚪**

```text
for       → Check first
while     → Check first
do-while  → Execute first
```

### ⭐ Interview Answer

> **An entry-control loop is a loop in which the condition is checked before the loop body is executed. Java's `for` and `while` loops are entry-controlled loops. If the condition is false initially, their bodies execute zero times.**
