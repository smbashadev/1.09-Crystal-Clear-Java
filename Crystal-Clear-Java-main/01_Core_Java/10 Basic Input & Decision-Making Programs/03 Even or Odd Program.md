## 🧒 Even or Odd Program

We want Java to check whether a number is **even or odd**.

For example:

```text
10 → Even
7  → Odd
```

We need 5 important things:

```text
Scanner → get number from user
%       → find remainder
if      → check condition
else    → handle false condition
boolean → condition is true/false
```

---

# 1️⃣ `Scanner` Input

We use `Scanner` to get a number from the user.

```java
Scanner sc = new Scanner(System.in);

int number = sc.nextInt();
```

If the user enters:

```text
10
```

then:

```text
number = 10
```

---

# 2️⃣ `%` Modulus Operator

`%` gives us the **remainder** after division.

Examples:

```text
10 % 2 = 0
11 % 2 = 1
12 % 2 = 0
13 % 2 = 1
```

For even/odd checking, we ask:

> **Does the number divide by 2 with remainder 0?**

```java
number % 2 == 0
```

---

# 3️⃣ Boolean Expression

This:

```java
number % 2 == 0
```

is a **boolean expression**.

Why?

Because its answer can only be:

```text
true
or
false
```

Example:

```text
number = 10

10 % 2 = 0
0 == 0
   ↓
 true
```

So `10` is even.

For `7`:

```text
7 % 2 = 1
1 == 0
   ↓
 false
```

So `7` is odd.

---

# 4️⃣ `if` and `else`

`if` means:

> **If the condition is true, do this.**

`else` means:

> **If the condition is false, do the other thing.**

```java
if (number % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

---

# 5️⃣ Complete Program

```java
import java.util.Scanner;

class EvenOdd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        sc.close();
    }
}
```

### Example 1

```text
Enter an integer: 20
Even
```

### Example 2

```text
Enter an integer: 15
Odd
```

---

# 🔍 Let's Follow the Program

Suppose the user enters:

```text
8
```

Java checks:

```text
8 % 2
 ↓
0
```

Then:

```text
0 == 0
 ↓
TRUE
```

Therefore:

```text
if → execute
 ↓
Even
```

### Flow

```text
User enters number
       ↓
    Scanner
       ↓
number % 2 == 0
       ↓
   ┌───┴───┐
 TRUE     FALSE
   ↓        ↓
 Even      Odd
```

---

# 🧠 Condition True vs Condition False

| Input | Condition `number % 2 == 0` | Result |
| ----: | :-------------------------: | ------ |
|    10 |            `true`           | Even   |
|     8 |            `true`           | Even   |
|     7 |           `false`           | Odd    |
|    15 |           `false`           | Odd    |

### 🔑 Easy Memory Trick

```text
Divide by 2
     ↓
Remainder 0 → Even
Remainder 1 → Odd
```

So remember:

> **Even → `% 2 == 0`**

```java
if (number % 2 == 0)
```

If the condition is **true → Even**.

If the condition is **false → Odd**.
