# 🧒 Four Types of Methods in Java

Methods can be classified based on **two questions**:

1. **Does the method return a value?**
2. **Does the method receive input?**

So we get **4 combinations**:

```text
                         METHOD
                            │
              ┌─────────────┴─────────────┐
              │                           │
         No Return                     Return
              │                           │
       ┌──────┴──────┐             ┌──────┴──────┐
       │             │             │             │
    No Args       Arguments     No Args      Arguments
       │             │             │             │
     TYPE 1        TYPE 2       TYPE 3        TYPE 4
```

---

# 🟢 Type 1: No Return Type + No Arguments

### Meaning

> The method **does not take input** and **does not return a value**.

Syntax:

```java
void methodName() {
    // statements
}
```

Example:

```java
static void greet() {
    System.out.println("Hello Java");
}
```

Calling:

```java
greet();
```

Flow:

```text
No Input
   ↓
greet()
   ↓
Print Hello Java
   ↓
No Return
```

### 🧠 Remember

```text
Nothing IN → Nothing OUT
```

---

# 🟡 Type 2: No Return Type + Arguments

### Meaning

> The method **takes input**, but **does not return a value**.

Syntax:

```java
void methodName(dataType parameter) {
    // statements
}
```

Example:

```java
static void greet(String name) {
    System.out.println("Hello " + name);
}
```

Calling:

```java
greet("Basha");
```

Flow:

```text
"Basha"
   ↓
greet(name)
   ↓
Print Hello Basha
   ↓
No Return
```

Here:

* `String name` → parameter
* `"Basha"` → argument

### 🧠 Remember

```text
Input IN → Nothing OUT
```

---

# 🔵 Type 3: Return Type + No Arguments

### Meaning

> The method **does not take input**, but **returns a value**.

Syntax:

```java
returnType methodName() {
    return value;
}
```

Example:

```java
static int getNumber() {
    return 100;
}
```

Calling:

```java
int result = getNumber();
```

Flow:

```text
No Input
   ↓
getNumber()
   ↓
100
   ↓
Return
   ↓
result = 100
```

### 🧠 Remember

```text
Nothing IN → Value OUT
```

---

# 🔴 Type 4: Return Type + Arguments

### Meaning

> The method **takes input** and **returns a value**.

This is one of the most commonly used forms.

Syntax:

```java
returnType methodName(parameters) {
    // statements
    return value;
}
```

Example:

```java
static int add(int a, int b) {

    int sum = a + b;

    return sum;
}
```

Calling:

```java
int result = add(10, 20);
```

Flow:

```text
10 ──→ a
20 ──→ b
       ↓
     a + b
       ↓
      30
       ↓
    return
       ↓
result = 30
```

### 🧠 Remember

```text
Input IN → Value OUT
```

---

# 📊 All Four Together

| Type       | Arguments/Input | Return Value/Output | Example                   |
| ---------- | --------------- | ------------------- | ------------------------- |
| **Type 1** | ❌ No            | ❌ No                | `void greet()`            |
| **Type 2** | ✅ Yes           | ❌ No                | `void greet(String name)` |
| **Type 3** | ❌ No            | ✅ Yes               | `int getNumber()`         |
| **Type 4** | ✅ Yes           | ✅ Yes               | `int add(int a, int b)`   |

---

# 🍜 Real-World Analogy

Imagine ordering food.

### Type 1

**No input → No return**

```text
Press "Prepare Maggi"
        ↓
Maggi gets prepared
        ↓
No value returned to you
```

### Type 2

**Input → No return**

```text
Give ingredients
       ↓
Prepare Maggi
       ↓
No returned value
```

### Type 3

**No input → Return**

```text
Ask: "What is today's special?"
       ↓
Restaurant gives answer
       ↓
Special dish
```

### Type 4

**Input → Return**

```text
Give 2 numbers
     ↓
Calculate sum
     ↓
Return result
```

---

# 🧠 Ultimate Memory Trick

Remember:

```text
             ARGUMENTS
             ↓       ↓
           NO       YES
            │         │
NO RETURN → TYPE 1   TYPE 2
RETURN    → TYPE 3   TYPE 4
```

Or even simpler:

```text
TYPE 1 → Nothing IN  → Nothing OUT
TYPE 2 → Something IN → Nothing OUT
TYPE 3 → Nothing IN  → Something OUT
TYPE 4 → Something IN → Something OUT
```

### ⭐ One-line interview answer

> **Based on arguments and return values, Java methods can be classified into four common forms: no return/no arguments, no return/arguments, return/no arguments, and return/arguments.**
