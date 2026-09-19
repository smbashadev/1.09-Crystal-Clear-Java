## 🧒 `for` Loop in Java

A **`for` loop** is used to **repeat a task multiple times**.

For example:

> "Print numbers from 1 to 5."

Instead of writing `println()` five times, we can use one `for` loop.

---

# 1️⃣ Three Main Parts of a `for` Loop

A `for` loop has three important parts:

```text
Initialization → Condition → Updation
```

### ① Initialization

Where do we start?

```java
int i = 1
```

This means:

> Start counting from `1`.

---

### ② Condition

How long should we continue?

```java
i <= 5
```

This means:

> Continue while `i` is less than or equal to `5`.

---

### ③ Updation

How should the value change?

```java
i++
```

This means:

> Increase `i` by 1 after every repetition.

---

# 2️⃣ `for` Loop Syntax

```java
for (initialization; condition; updation) {
    // repeated task
}
```

Example:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Here:

```text
int i = 1   → Initialization
i <= 5      → Condition
i++         → Updation
println(i)  → Repeated task
```

---

# 3️⃣ How It Works

Consider:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Java works like this:

```text
Initialization
     ↓
   i = 1
     ↓
Condition
 i <= 5 ?
     ↓ YES
Repeated task
 print i
     ↓
Updation
   i++
     ↓
Condition
 i <= 5 ?
     ↓ YES
Repeated task
 print i
     ↓
Updation
   i++
     ↓
...
     ↓
i = 6
     ↓
6 <= 5 ?
     ↓ NO
   STOP
```

---

# 4️⃣ Complete Example

```java
class Demo {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}
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

# 5️⃣ Understanding Each Part

### Initialization

```java
int i = 1;
```

`i` starts at `1`.

### Condition

```java
i <= 5
```

Java asks:

> "Is `i` still less than or equal to 5?"

If **yes**, execute the body.

If **no**, stop the loop.

### Repeated Task

```java
System.out.println(i);
```

This is executed repeatedly.

### Updation

```java
i++;
```

After each execution:

```text
1 → 2 → 3 → 4 → 5 → 6
```

When `i` becomes `6`, the condition becomes false.

---

# 6️⃣ Another Simple Example

Print `"Hello!"` three times:

```java
class Demo {

    public static void main(String[] args) {

        for (int i = 1; i <= 3; i++) {
            System.out.println("Hello!");
        }
    }
}
```

Output:

```text
Hello!
Hello!
Hello!
```

The repeated task is:

```java
System.out.println("Hello!");
```

---

# 🧠 Easy Real-World Example

Imagine climbing stairs:

```text
Start at stair 1
      ↓
Is stair <= 5?
      ↓ YES
Climb / perform task
      ↓
Go to next stair
      ↓
Check again
```

That's essentially how a `for` loop works.

---

# 🔑 Memory Trick

Remember:

> **I → C → U → T**

```text
I = Initialization
C = Condition
U = Updation
T = Task
```

Or simply:

> **Start → Check → Do → Update → Repeat**

### ⭐ Interview Answer

> **A `for` loop is an iterative statement used to repeatedly execute a block of code. It consists of initialization, a condition, and an updation expression. The condition is checked before each iteration, and the loop continues as long as the condition is true.**
