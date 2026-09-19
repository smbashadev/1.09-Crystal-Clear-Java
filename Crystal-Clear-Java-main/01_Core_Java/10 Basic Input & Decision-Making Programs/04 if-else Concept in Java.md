## 🧒 `if-else` Concept in Java

`if-else` is used when a program needs to **make a decision**.

Think about a simple question:

> **"Is it raining?" ☔**

* If **YES** → Take an umbrella.
* If **NO** → Don't take an umbrella.

That's exactly what `if-else` does.

---

## 1️⃣ Expression inside `if`

Inside `if ( )`, we write a **condition/expression**.

Example:

```java
if (age >= 18)
```

Here:

```text id="p9zzb0"
age >= 18
```

is the **boolean expression**.

It asks:

> Is `age` greater than or equal to 18?

---

## 2️⃣ Boolean Result

The expression produces only one of two results:

```text id="4vpg4c"
true
false
```

For example, if:

```java
int age = 20;
```

then:

```text id="8p6q3n"
age >= 18
20 >= 18
   ↓
 true
```

If:

```java
int age = 15;
```

then:

```text id="9d7g44"
age >= 18
15 >= 18
   ↓
 false
```

---

## 3️⃣ `if` Block

If the condition is **true**, Java executes the `if` block.

```java id="q3m6gz"
if (age >= 18) {
    System.out.println("Eligible");
}
```

For `age = 20`:

```text id="h7q2kk"
age >= 18
    ↓
  true
    ↓
if block executes
    ↓
Eligible
```

---

## 4️⃣ `else` Block

If the condition is **false**, Java executes the `else` block.

```java id="jmb4zr"
if (age >= 18) {
    System.out.println("Eligible");
} else {
    System.out.println("Not Eligible");
}
```

For `age = 15`:

```text id="xv6v3e"
age >= 18
    ↓
  false
    ↓
else block executes
    ↓
Not Eligible
```

---

# 🔄 Complete Flow

```text id="m5l9tc"
        Expression
            ↓
     Boolean Result
        ↙       ↘
     TRUE      FALSE
       ↓          ↓
   if block    else block
       ↓          ↓
   Statement    Statement
```

---

## 💻 Simple Program

```java id="v5kw1r"
class IfElseDemo {
    public static void main(String[] args) {

        int age = 20;

        if (age >= 18) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }
}
```

Output:

```text id="b0c9eu"
Eligible to vote
```

---

## 🧠 Remember It Like a Question

```text id="3xk7ap"
if (QUESTION) {
    YES → do this
} else {
    NO → do that
}
```

For example:

```java id="g5h3k8"
if (marks >= 35) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

```text id="0d1p7r"
marks >= 35
     ↓
  Boolean
     ↓
 ┌───┴────┐
true     false
 ↓          ↓
Pass       Fail
```

### 🔑 Golden Rule

> **`if` checks a boolean condition. If it is `true`, the `if` block executes. If it is `false`, the `else` block executes.**
