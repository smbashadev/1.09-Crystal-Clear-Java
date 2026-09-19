# 🧒 Basic Calculator Program in Java

A **calculator program** simply takes two numbers, performs four basic mathematical operations, and displays the results.

The four operations are:

```text
➕ Addition
➖ Subtraction
✖️ Multiplication
➗ Division
```

---

# 1️⃣ Pseudocode

### What is Pseudocode?

**Pseudocode is a simple, human-readable plan of a program before writing actual Java code.**

For our calculator:

```text
START

Declare Calculator class

Define main method

Store first number
Store second number

Add the two numbers
Subtract the two numbers
Multiply the two numbers
Divide the two numbers

Print addition result
Print subtraction result
Print multiplication result
Print division result

END
```

Think of pseudocode as a **recipe** before cooking.

---

# 2️⃣ Declare Calculator Class

We create a class called `Calculator`.

```java
class Calculator {
    
}
```

Think of a **class as a container** where we put our Java program.

```text
Calculator
└── Java program
```

---

# 3️⃣ Define `main()`

Java starts executing a normal standalone application from the `main()` method.

```java
class Calculator {
    public static void main(String[] args) {
        
    }
}
```

Think:

> **`main()` = Starting point of the program ▶️**

---

# 4️⃣ Store Two Numbers

We use `int` variables to store two whole numbers.

```java
int num1 = 20;
int num2 = 10;
```

Now:

```text
num1 → 20
num2 → 10
```

Think of variables as **boxes**:

```text
┌─────────┐
│ num1 20 │
└─────────┘

┌─────────┐
│ num2 10 │
└─────────┘
```

---

# 5️⃣ Addition

Use `+`.

```java
int addition = num1 + num2;
```

Calculation:

```text
20 + 10 = 30
```

So:

```text
addition → 30
```

---

# 6️⃣ Subtraction

Use `-`.

```java
int subtraction = num1 - num2;
```

Calculation:

```text
20 - 10 = 10
```

---

# 7️⃣ Multiplication

Use `*`.

```java
int multiplication = num1 * num2;
```

Calculation:

```text
20 × 10 = 200
```

---

# 8️⃣ Division

Use `/`.

```java
int division = num1 / num2;
```

Calculation:

```text
20 / 10 = 2
```

Because both variables are `int`, this performs **integer division**.

For example:

```java
int result = 5 / 2;
```

gives:

```text
2
```

not `2.5`.

---

# 9️⃣ Print All Four Results

We use `System.out.println()`.

```java
System.out.println("Addition = " + addition);
System.out.println("Subtraction = " + subtraction);
System.out.println("Multiplication = " + multiplication);
System.out.println("Division = " + division);
```

---

# 🔥 Complete Program

```java
class Calculator {

    public static void main(String[] args) {

        // Store two numbers
        int num1 = 20;
        int num2 = 10;

        // Perform operations
        int addition = num1 + num2;
        int subtraction = num1 - num2;
        int multiplication = num1 * num2;
        int division = num1 / num2;

        // Print results
        System.out.println("Addition = " + addition);
        System.out.println("Subtraction = " + subtraction);
        System.out.println("Multiplication = " + multiplication);
        System.out.println("Division = " + division);
    }
}
```

### Output

```text
Addition = 30
Subtraction = 10
Multiplication = 200
Division = 2
```

---

# 🔄 Complete Program Flow

```text
             Calculator
                 ↓
              main()
                 ↓
        Store two numbers
          ↙            ↘
      num1 = 20      num2 = 10
          ↓              ↓
          └──────┬───────┘
                 ↓
       ┌─────────┼─────────┐
       ↓         ↓         ↓
    Addition  Subtraction  Multiplication
       ↓         ↓         ↓
      30         10        200
                 │
                 ↓
              Division
                 ↓
                 2
                 ↓
              println()
                 ↓
               Output
```

---

## 🧠 Easy Memory Trick

Remember the order:

> **Class → main → Store → Calculate → Print**

And the four operators:

```text
+  → Addition
-  → Subtraction
*  → Multiplication
/  → Division
```

### 🎯 Interview Answer

> **A basic calculator program declares a class and a `main()` method, stores two numbers in variables, performs addition, subtraction, multiplication, and division using arithmetic operators, and prints all four results.**
